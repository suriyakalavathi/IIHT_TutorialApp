package com.cognizant.tutorial.api.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cognizant.tutorial.api.rest.model.LoginRequest;
import com.cognizant.tutorial.api.rest.model.UserRequest;
import com.cognizant.tutorial.api.rest.model.UserResponse;
import com.cognizant.tutorial.service.entity.User;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {
    User toUser(UserRequest userRequest);

    User toUser(LoginRequest loginRequest);

    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponses(List<User> users);
}
