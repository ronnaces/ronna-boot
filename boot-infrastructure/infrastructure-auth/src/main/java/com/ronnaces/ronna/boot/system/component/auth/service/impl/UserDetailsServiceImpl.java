package com.ronnaces.ronna.boot.system.component.auth.service.impl;

import com.ronnaces.ronna.boot.system.component.auth.model.AuthUser;
import com.ronnaces.ronna.boot.system.modules.user.entity.SystemUser;
import com.ronnaces.ronna.boot.system.modules.user.mapper.SystemUserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final SystemUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser user = userMapper.findByUsername(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("login user: %s not existence", username));
        }

        if (Boolean.TRUE.equals(user.getWhetherDelete())) {
            throw new AccessDeniedException(String.format("sorry, your account: %s have deleted", username));
        }

//        switch (UserState.match(user.getState())) {
//            case NORMAL:
//                break;
//            case LOCKED:
//                throw new AccessDeniedException(String.format("sorry, your account: %s have locked", username));
//            case DISABLED:
//                throw new AccessDeniedException(String.format("sorry, your account: %s have disabled", username));
//            default:
//                break;
//        }

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        List<String> roleList = userMapper.findAllRoleCodeById(user.getId());
        roleList.forEach(role -> {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            authorities.add(authority);
        });
//        if (authorities.size() == 0) {
//            throw new AccessDeniedException(String.format("sorry, your account: %s has no authorities and will be treated as not found", username));
//        }
        return new AuthUser(user.getUsername(), user.getPassword(), authorities);
    }

/*    @Override
    public UserDetails loadUserByPhone(String phone) throws UsernameNotFoundException {
        SystemUser user = userMapper.findByPhone(phone);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException(String.format("login user: %s not existence", phone));
        }

        if (Boolean.TRUE.equals(user.getWhetherDelete())) {
            throw new AccessDeniedException(String.format("sorry, your account: %s have deleted", phone));
        }

        switch (UserState.match(user.getState())) {
            case NORMAL:
                break;
            case LOCKED:
                throw new AccessDeniedException(String.format("sorry, your account: %s have locked", phone));
            case DISABLED:
                throw new AccessDeniedException(String.format("sorry, your account: %s have disabled", phone));
            default:
                break;
        }

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        List<String> roleList = userMapper.findAllRoleCodeById(user.getId());
        roleList.forEach(role -> {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
            authorities.add(authority);
        });
        if (authorities.size() == 0) {
            throw new AccessDeniedException(String.format("sorry, your account: %s has no authorities and will be treated as not found", phone));
        }
        return new AuthUser(user.getPhone(), user.getPassword(), authorities);
    }*/
}
