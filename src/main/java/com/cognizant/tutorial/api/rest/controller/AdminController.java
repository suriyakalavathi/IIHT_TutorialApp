package com.cognizant.tutorial.api.rest.controller;

import com.cognizant.tutorial.api.rest.mapper.UserMapper;
import com.cognizant.tutorial.api.rest.model.UserResponse;
import com.cognizant.tutorial.service.api.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j

@RestController
@RequestMapping("/api/rest/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public List<UserResponse> getUsers() {
        return userMapper.toUserResponses(userService.getUsers());
    }
}
