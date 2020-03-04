package com.cognizant.tutorial.service.api;

import java.util.List;

import com.cognizant.tutorial.service.entity.User;

public interface UserService {

    User addUser(User user);

    User updateUser(User user);

    List<User> getUsers();

    User getUser(String username);
}
