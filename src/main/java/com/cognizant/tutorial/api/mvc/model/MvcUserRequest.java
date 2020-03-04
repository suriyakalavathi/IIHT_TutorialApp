package com.cognizant.tutorial.api.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
public class MvcUserRequest {

    @NotNull(message = "{MvcUserRequest.name.notnull}")
    private String name;

    @NotNull(message = "{MvcUserRequest.email.notnull}")
    private String email;

    @Size(min = 4, max = 10, message = "{MvcUserRequest.username.size}")
    private String username;

    @NotNull(message = "{MvcUserRequest.password.notnull}")
    private String password;

    @NotNull(message = "{MvcUserRequest.captcha.notnull}")
    private String captcha;

    private Set<MvcRoleRequest> roles;

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

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public Set<MvcRoleRequest> getRoles() {
		return roles;
	}

	public void setRoles(Set<MvcRoleRequest> roles) {
		this.roles = roles;
	}

	public void setRoles(HashSet<MvcRoleRequest> hashSet) {
		
		
	}
}
