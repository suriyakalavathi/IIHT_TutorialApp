package com.cognizant.tutorial.service.impl;

import com.cognizant.tutorial.service.api.UserService;
import com.cognizant.tutorial.service.dao.UserRepository;
import com.cognizant.tutorial.service.entity.Role;
import com.cognizant.tutorial.service.entity.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Slf4j

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User addUser(User user) {
    //    log.debug("addUser: " + user.getName());

        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("User already exists");
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<Role>(Arrays.asList(new Role("USER"))));
        return userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
     //   log.debug("getUser for: " + username);

        Optional<User> optionalUser = userRepository.findByUsername(username);
        optionalUser.orElseThrow(() -> new RuntimeException("User not found!"));
        return optionalUser.get();
    }

    @Override
    @Transactional
    public User updateUser(User user) {
      //  log.debug("updateUser for: " + user.getUsername());

        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        optionalUser.orElseThrow(() -> new RuntimeException("User not found!"));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
