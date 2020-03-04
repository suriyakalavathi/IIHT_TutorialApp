package com.cognizant.tutorial.api.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private String username;
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<RoleRequest> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleRequest> roles) {
		this.roles = roles;
	}
	private String password;
    private Set<RoleRequest> roles;
}
