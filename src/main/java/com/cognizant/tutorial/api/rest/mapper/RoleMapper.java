package com.cognizant.tutorial.api.rest.mapper;

import com.cognizant.tutorial.api.rest.model.RoleRequest;
import com.cognizant.tutorial.api.rest.model.RoleResponse;
import com.cognizant.tutorial.service.entity.Role;

import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleRequest roleRequest);

    RoleResponse toRoleResponse(Role role);

    Set<Role> toRoles(Set<RoleRequest> roleRequests);

    Set<RoleResponse> toRoleResponses(Set<Role> roles);
}
