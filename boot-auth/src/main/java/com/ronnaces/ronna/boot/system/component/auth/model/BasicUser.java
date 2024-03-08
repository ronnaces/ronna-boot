package com.ronnaces.ronna.boot.system.component.auth.model;

import lombok.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicUser implements UserDetails, CredentialsContainer {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private static final Log logger = LogFactory.getLog(BasicUser.class);

    private String password;

    private String username;

    private Set<GrantedAuthority> authorities;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public BasicUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this(username, password, true, true, true, true, authorities);
    }

    public BasicUser(String username, String password, boolean enabled, boolean accountNonExpired,
                boolean credentialsNonExpired, boolean accountNonLocked,
                Collection<? extends GrantedAuthority> authorities) {
        Assert.isTrue(username != null && !"".equals(username) && password != null,
                "Cannot pass null or empty values to constructor");
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(new BasicUser.AuthorityComparator());
        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }
        return sortedAuthorities;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BasicUser user) {
            return this.username.equals(user.getUsername());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName()).append(" [");
        sb.append("Username=").append(this.username).append(", ");
        sb.append("Password=[PROTECTED], ");
        sb.append("Enabled=").append(this.enabled).append(", ");
        sb.append("AccountNonExpired=").append(this.accountNonExpired).append(", ");
        sb.append("CredentialsNonExpired=").append(this.credentialsNonExpired).append(", ");
        sb.append("AccountNonLocked=").append(this.accountNonLocked).append(", ");
        sb.append("Granted Authorities=").append(this.authorities).append("]");
        return sb.toString();
    }

    public static BasicUser.UserBuilder withUsername(String username) {
        return builder().username(username);
    }

    public static BasicUser.UserBuilder builder() {
        return new BasicUser.UserBuilder();
    }

    @Deprecated
    public static BasicUser.UserBuilder withDefaultPasswordEncoder() {
        logger.warn("BasicUser.withDefaultPasswordEncoder() is considered unsafe for production "
                + "and is only intended for sample applications.");
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return builder().passwordEncoder(encoder::encode);
    }

    public static BasicUser.UserBuilder withUserDetails(UserDetails userDetails) {
        // @formatter:off
        return withUsername(userDetails.getUsername())
                .password(userDetails.getPassword())
                .accountExpired(!userDetails.isAccountNonExpired())
                .accountLocked(!userDetails.isAccountNonLocked())
                .authorities(userDetails.getAuthorities())
                .credentialsExpired(!userDetails.isCredentialsNonExpired())
                .disabled(!userDetails.isEnabled());
        // @formatter:on
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {

        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        @Override
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to
            // the set. If the authority is null, it is a custom authority and should
            // precede others.
            if (g2.getAuthority() == null) {
                return -1;
            }
            if (g1.getAuthority() == null) {
                return 1;
            }
            return g1.getAuthority().compareTo(g2.getAuthority());
        }

    }

    public static final class UserBuilder {

        private String username;

        private String password;

        private List<GrantedAuthority> authorities = new ArrayList<>();

        private boolean accountExpired;

        private boolean accountLocked;

        private boolean credentialsExpired;

        private boolean disabled;

        private Function<String, String> passwordEncoder = (password) -> password;

        /**
         * Creates a new instance
         */
        private UserBuilder() {
        }

        /**
         * Populates the username. This attribute is required.
         *
         * @param username the username. Cannot be null.
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         */
        public BasicUser.UserBuilder username(String username) {
            Assert.notNull(username, "username cannot be null");
            this.username = username;
            return this;
        }

        /**
         * Populates the password. This attribute is required.
         *
         * @param password the password. Cannot be null.
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         */
        public BasicUser.UserBuilder password(String password) {
            Assert.notNull(password, "password cannot be null");
            this.password = password;
            return this;
        }

        /**
         * Encodes the current password (if non-null) and any future passwords supplied to
         * {@link #password(String)}.
         *
         * @param encoder the encoder to use
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         */
        public BasicUser.UserBuilder passwordEncoder(Function<String, String> encoder) {
            Assert.notNull(encoder, "encoder cannot be null");
            this.passwordEncoder = encoder;
            return this;
        }

        /**
         * Populates the roles. This method is a shortcut for calling
         * {@link #authorities(String...)}, but automatically prefixes each entry with
         * "ROLE_". This means the following:
         *
         * <code>
         * builder.roles("USER","ADMIN");
         * </code>
         * <p>
         * is equivalent to
         *
         * <code>
         * builder.authorities("ROLE_USER","ROLE_ADMIN");
         * </code>
         *
         * <p>
         * This attribute is required, but can also be populated with
         * {@link #authorities(String...)}.
         * </p>
         *
         * @param roles the roles for this user (i.e. USER, ADMIN, etc). Cannot be null,
         *              contain null values or start with "ROLE_"
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         */
        public BasicUser.UserBuilder roles(String... roles) {
            List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
            for (String role : roles) {
                Assert.isTrue(!role.startsWith("ROLE_"),
                        () -> role + " cannot start with ROLE_ (it is automatically added)");
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }
            return authorities(authorities);
        }

        /**
         * Populates the authorities. This attribute is required.
         *
         * @param authorities the authorities for this user. Cannot be null, or contain
         *                    null values
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         * @see #roles(String...)
         */
        public BasicUser.UserBuilder authorities(GrantedAuthority... authorities) {
            Assert.notNull(authorities, "authorities cannot be null");
            return authorities(Arrays.asList(authorities));
        }

        /**
         * Populates the authorities. This attribute is required.
         *
         * @param authorities the authorities for this user. Cannot be null, or contain
         *                    null values
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         * @see #roles(String...)
         */
        public BasicUser.UserBuilder authorities(Collection<? extends GrantedAuthority> authorities) {
            Assert.notNull(authorities, "authorities cannot be null");
            this.authorities = new ArrayList<>(authorities);
            return this;
        }

        /**
         * Populates the authorities. This attribute is required.
         *
         * @param authorities the authorities for this user (i.e. ROLE_USER, ROLE_ADMIN,
         *                    etc). Cannot be null, or contain null values
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         * @see #roles(String...)
         */
        public BasicUser.UserBuilder authorities(String... authorities) {
            Assert.notNull(authorities, "authorities cannot be null");
            return authorities(AuthorityUtils.createAuthorityList(authorities));
        }

        /**
         * Defines if the account is expired or not. Default is false.
         *
         * @param accountExpired true if the account is expired, false otherwise
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         */
        public BasicUser.UserBuilder accountExpired(boolean accountExpired) {
            this.accountExpired = accountExpired;
            return this;
        }

        /**
         * Defines if the account is locked or not. Default is false.
         *
         * @param accountLocked true if the account is locked, false otherwise
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         */
        public BasicUser.UserBuilder accountLocked(boolean accountLocked) {
            this.accountLocked = accountLocked;
            return this;
        }

        /**
         * Defines if the credentials are expired or not. Default is false.
         *
         * @param credentialsExpired true if the credentials are expired, false otherwise
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         */
        public BasicUser.UserBuilder credentialsExpired(boolean credentialsExpired) {
            this.credentialsExpired = credentialsExpired;
            return this;
        }

        /**
         * Defines if the account is disabled or not. Default is false.
         *
         * @param disabled true if the account is disabled, false otherwise
         * @return the {@link BasicUser.UserBuilder} for method chaining (i.e. to populate
         * additional attributes for this user)
         */
        public BasicUser.UserBuilder disabled(boolean disabled) {
            this.disabled = disabled;
            return this;
        }

        public UserDetails build() {
            String encodedPassword = this.passwordEncoder.apply(this.password);
            return new BasicUser(this.username, encodedPassword, !this.disabled, !this.accountExpired,
                    !this.credentialsExpired, !this.accountLocked, this.authorities);
        }

    }

}
