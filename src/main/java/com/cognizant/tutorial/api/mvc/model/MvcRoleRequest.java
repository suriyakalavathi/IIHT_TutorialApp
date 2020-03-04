package com.cognizant.tutorial.api.mvc.model;

public class MvcRoleRequest {
	private String role;

    public MvcRoleRequest(String user) {
    	setRole(user);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
