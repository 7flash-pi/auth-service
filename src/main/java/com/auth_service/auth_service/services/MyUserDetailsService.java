package com.auth_service.auth_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth_service.auth_service.repositories.userRegisterRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private  userRegisterRepository userRegisterRepository;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Example: Replace this logic with actual user retrieval from database or other source
        return null;
    }
}
