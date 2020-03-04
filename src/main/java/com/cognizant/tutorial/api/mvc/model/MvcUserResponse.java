package com.cognizant.tutorial.api.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.cognizant.tutorial.api.rest.model.RoleResponse;

@Data @NoArgsConstructor @AllArgsConstructor
public class MvcUserResponse {
    private String name;
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
	public Set<RoleResponse> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleResponse> roles) {
		this.roles = roles;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String email;
    private String username;
    private String password;
    private Set<RoleResponse> roles;
	public Object getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
