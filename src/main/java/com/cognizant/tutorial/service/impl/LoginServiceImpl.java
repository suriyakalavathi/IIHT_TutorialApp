package com.cognizant.tutorial.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.tutorial.service.api.LoginService;
import com.cognizant.tutorial.service.entity.User;
import com.cognizant.tutorial.service.security.UserDetailsImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    @Qualifier("UserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    public User authUser(User user) {
  //      log.debug("authUser for: " + user.getUsername());

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        if (bCryptPasswordEncoder.matches(user.getPassword(), userDetails.getPassword())) {
            return ((UserDetailsImpl) userDetails).getUser();
        }
        throw new RuntimeException("Password for " + user.getUsername() + " don't match!");
    }
}
