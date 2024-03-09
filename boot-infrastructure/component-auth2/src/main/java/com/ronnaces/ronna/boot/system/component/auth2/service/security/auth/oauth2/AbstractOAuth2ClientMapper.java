package com.ronnaces.ronna.boot.system.component.auth2.service.security.auth.oauth2;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thingsboard.common.util.JacksonUtil;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.*;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.IdBased;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2Registration;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.oauth2.OAuth2User;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.service.entitiy.tenant.TbTenantService;
import org.thingsboard.server.service.entitiy.user.TbUserService;
import org.thingsboard.server.service.install.InstallScripts;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.model.UserPrincipal;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public abstract class AbstractOAuth2ClientMapper {
    private static final int DASHBOARDS_REQUEST_LIMIT = 10;
    private final Lock userCreationLock = new ReentrantLock();
    @Autowired
    protected TbTenantProfileCache tenantProfileCache;
    @Autowired
    protected TbClusterService tbClusterService;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private TenantService tenantService;
    @Autowired
    private TbTenantService tbTenantService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private DashboardService dashboardService;
    @Autowired
    private InstallScripts installScripts;
    @Autowired
    private TbUserService tbUserService;
    @Value("${edges.enabled}")
    @Getter
    private boolean edgesEnabled;

    protected SecurityUser getOrCreateSecurityUserFromOAuth2User(OAuth2User oauth2User, OAuth2Registration registration) {

        OAuth2MapperConfig config = registration.getMapperConfig();

        UserPrincipal principal = new UserPrincipal(UserPrincipal.Type.USER_NAME, oauth2User.getEmail());

        User user = userService.findUserByEmail(TenantId.SYS_TENANT_ID, oauth2User.getEmail());

        if (user == null && !config.isAllowUserCreation()) {
            throw new UsernameNotFoundException("User not found: " + oauth2User.getEmail());
        }

        if (user == null) {
            userCreationLock.lock();
            try {
                user = userService.findUserByEmail(TenantId.SYS_TENANT_ID, oauth2User.getEmail());
                if (user == null) {
                    user = new User();
                    if (oauth2User.getCustomerId() == null && StringUtils.isEmpty(oauth2User.getCustomerName())) {
                        user.setAuthority(Authority.TENANT_ADMIN);
                    } else {
                        user.setAuthority(Authority.CUSTOMER_USER);
                    }
                    TenantId tenantId = oauth2User.getTenantId() != null ?
                            oauth2User.getTenantId() : getTenantId(oauth2User.getTenantName());
                    user.setTenantId(tenantId);
                    CustomerId customerId = oauth2User.getCustomerId() != null ?
                            oauth2User.getCustomerId() : getCustomerId(user.getTenantId(), oauth2User.getCustomerName());
                    user.setCustomerId(customerId);
                    user.setEmail(oauth2User.getEmail());
                    user.setFirstName(oauth2User.getFirstName());
                    user.setLastName(oauth2User.getLastName());

                    ObjectNode additionalInfo = JacksonUtil.newObjectNode();

                    if (!StringUtils.isEmpty(oauth2User.getDefaultDashboardName())) {
                        Optional<DashboardId> dashboardIdOpt =
                                user.getAuthority() == Authority.TENANT_ADMIN ?
                                        getDashboardId(tenantId, oauth2User.getDefaultDashboardName())
                                        : getDashboardId(tenantId, customerId, oauth2User.getDefaultDashboardName());
                        if (dashboardIdOpt.isPresent()) {
                            additionalInfo.put("defaultDashboardFullscreen", oauth2User.isAlwaysFullScreen());
                            additionalInfo.put("defaultDashboardId", dashboardIdOpt.get().getId().toString());
                        }
                    }

                    if (registration.getAdditionalInfo() != null &&
                            registration.getAdditionalInfo().has("providerName")) {
                        additionalInfo.put("authProviderName", registration.getAdditionalInfo().get("providerName").asText());
                    }

                    user.setAdditionalInfo(additionalInfo);

                    user = tbUserService.save(tenantId, customerId, user, false, null, null);
                    if (config.isActivateUser()) {
                        UserCredentials userCredentials = userService.findUserCredentialsByUserId(user.getTenantId(), user.getId());
                        userService.activateUserCredentials(user.getTenantId(), userCredentials.getActivateToken(), passwordEncoder.encode(""));
                    }
                }
            } catch (Exception e) {
                log.error("Can't get or create security user from oauth2 user", e);
                throw new RuntimeException("Can't get or create security user from oauth2 user", e);
            } finally {
                userCreationLock.unlock();
            }
        }

        try {
            SecurityUser securityUser = new SecurityUser(user, true, principal);
            return (SecurityUser) new UsernamePasswordAuthenticationToken(securityUser, null, securityUser.getAuthorities()).getPrincipal();
        } catch (Exception e) {
            log.error("Can't get or create security user from oauth2 user", e);
            throw new RuntimeException("Can't get or create security user from oauth2 user", e);
        }
    }

    private TenantId getTenantId(String tenantName) throws Exception {
        List<Tenant> tenants = tenantService.findTenants(new PageLink(1, 0, tenantName)).getData();
        Tenant tenant;
        if (tenants == null || tenants.isEmpty()) {
            tenant = new Tenant();
            tenant.setTitle(tenantName);
            tenant = tbTenantService.save(tenant);
        } else {
            tenant = tenants.get(0);
        }
        return tenant.getTenantId();
    }

    private CustomerId getCustomerId(TenantId tenantId, String customerName) {
        if (StringUtils.isEmpty(customerName)) {
            return null;
        }
        Optional<Customer> customerOpt = customerService.findCustomerByTenantIdAndTitle(tenantId, customerName);
        if (customerOpt.isPresent()) {
            return customerOpt.get().getId();
        } else {
            Customer customer = new Customer();
            customer.setTenantId(tenantId);
            customer.setTitle(customerName);
            return customerService.saveCustomer(customer).getId();
        }
    }

    private Optional<DashboardId> getDashboardId(TenantId tenantId, String dashboardName) {
        return Optional.ofNullable(dashboardService.findFirstDashboardInfoByTenantIdAndName(tenantId, dashboardName)).map(IdBased::getId);
    }

    private Optional<DashboardId> getDashboardId(TenantId tenantId, CustomerId customerId, String dashboardName) {
        PageData<DashboardInfo> dashboardsPage;
        PageLink pageLink = null;
        do {
            pageLink = pageLink == null ? new PageLink(DASHBOARDS_REQUEST_LIMIT) : pageLink.nextPageLink();
            dashboardsPage = dashboardService.findDashboardsByTenantIdAndCustomerId(tenantId, customerId, pageLink);
            Optional<DashboardInfo> dashboardInfoOpt = dashboardsPage.getData().stream()
                    .filter(dashboardInfo -> dashboardName.equals(dashboardInfo.getName()))
                    .findAny();
            if (dashboardInfoOpt.isPresent()) {
                return dashboardInfoOpt.map(DashboardInfo::getId);
            }
        } while (dashboardsPage.hasNext());
        return Optional.empty();
    }
}
