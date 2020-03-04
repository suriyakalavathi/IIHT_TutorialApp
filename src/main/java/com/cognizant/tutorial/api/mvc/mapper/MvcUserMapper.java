package com.cognizant.tutorial.api.mvc.mapper;

import com.cognizant.tutorial.api.mvc.model.MvcLoginRequest;
import com.cognizant.tutorial.api.mvc.model.MvcUserRequest;
import com.cognizant.tutorial.api.mvc.model.MvcUserResponse;
import com.cognizant.tutorial.service.entity.User;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MvcRoleMapper.class})
public interface MvcUserMapper {
    User toUser(MvcUserRequest mvcUserRequest);

    User toUser(MvcLoginRequest mvcLoginRequest);

    MvcUserResponse toUserResponse(User user);

}
