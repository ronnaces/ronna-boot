package com.ronnaces.ronna.boot.system.component.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface PhoneUserDetailsService extends UserDetailsService {

    UserDetails loadUserByPhone(String username) throws UsernameNotFoundException;
}