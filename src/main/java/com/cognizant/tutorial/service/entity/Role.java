package com.cognizant.tutorial.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Role {
    @Id
    @GeneratedValue(generator = "tutorialSeqGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="tutorialSeqGen",sequenceName="role_seq", allocationSize=1)
    @Column(name = "role_id")
    private Long id;

    @Column(nullable = false)
    private String role;
    public Role() {
      
    }

    public Role(String role) {
        this.role = role;
    }

	public String getRole() {
		return role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
