package com.cognizant.tutorial.api.rest.controller;

import com.cognizant.tutorial.api.rest.mapper.UserMapper;
import com.cognizant.tutorial.api.rest.model.UserRequest;
import com.cognizant.tutorial.api.rest.model.UserResponse;
import com.cognizant.tutorial.service.api.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j

@RestController
@RequestMapping("/api/rest/user")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{username}")
    @ResponseBody
    public UserResponse getUser(@PathVariable String username) {
        return userMapper.toUserResponse(userService.getUser(username));
    }

    @PutMapping("/update")
    @ResponseBody
    public UserResponse updateUser(@RequestBody UserRequest userRequest) {
        return userMapper.toUserResponse(userService.updateUser(userMapper.toUser(userRequest)));
    }
}
