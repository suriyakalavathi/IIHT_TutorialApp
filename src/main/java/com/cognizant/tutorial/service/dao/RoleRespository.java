package com.cognizant.tutorial.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.tutorial.service.entity.Role;

public interface RoleRespository extends JpaRepository<Role, Long> {
}
