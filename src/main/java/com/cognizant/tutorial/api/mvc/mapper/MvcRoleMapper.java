package com.cognizant.tutorial.api.mvc.mapper;

import com.cognizant.tutorial.api.mvc.model.MvcRoleRequest;
import com.cognizant.tutorial.service.entity.Role;

import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface MvcRoleMapper {
    Role toRole(MvcRoleRequest mvcRoleRequest);

    Set<Role> toRoles(Set<MvcRoleRequest> mvcRoleRequests);
}
