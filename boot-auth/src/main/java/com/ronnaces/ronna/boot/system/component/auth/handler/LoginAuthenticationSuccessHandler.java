package com.ronnaces.ronna.boot.system.component.auth.handler;//package com.preciser.boot.system.component.handler;
//
//import com.alibaba.fastjson2.JSON;
//import com.preciser.loong.boot.system.component.bean.response.Login;
//import com.preciser.loong.boot.system.component.bean.response.UserInfo;
//import com.preciser.loong.boot.system.modules.user.entity.SystemUser;
//import com.preciser.loong.boot.system.modules.user.mapper.SystemUserMapper;
//import com.ronnaces.ronna.common.controller.R;//import com.preciser.loong.core.jwt.JJWTUtil;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.BeanUtils;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//
//@AllArgsConstructor
//@Component
//public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    private final SystemUserMapper userMapper;
//
//    // TODO 正式上线时按需调整
//    private static final long expire = 1000 * 60 * 60 * 1000L;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
//        String accessControlAllowOrigin = request.getHeader("Access-Control-Allow-Origin");
//        response.addHeader("Access-Control-Allow-Origin", accessControlAllowOrigin);
//        response.addHeader("Access-Control-Allow-Credentials", "true");
//        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
//
//        String username = authentication.getName();
//        SystemUser systemUser = Optional.ofNullable(userMapper.findByUsername(username)).orElseThrow(() -> new UsernameNotFoundException("当前用户不存在"));
////        String tenant = Optional.ofNullable(tenantMapper.findCodeByUsername(username)).orElseThrow(() -> new AccessDeniedException("当前租户不存在"));
//
//        UserInfo userInfo = new UserInfo();
//        BeanUtils.copyProperties(systemUser, userInfo);
//
//        Map<String, Object> claim = new HashMap<>();
//        claim.put("userinfo", JSON.toJSON(userInfo));
//
//        List<String> roles = userMapper.findAllRoleCodeById(systemUser.getId());
//
//
//        String accessToken = JJWTUtil.generate("00000", username, expire, claim);
//
//        Login login = new Login();
//        login.setExpires(LocalDateTime.now().plus(expire, ChronoUnit.MILLIS));
//        login.setUsername(username);
//        login.setRoles(roles);
//        login.setAccessToken(accessToken);
//        login.setRefreshToken(accessToken);
//
//        response.getWriter().println(JSON.toJSON(R.ok("登录成功", login)));
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.flushBuffer();
//    }
//}