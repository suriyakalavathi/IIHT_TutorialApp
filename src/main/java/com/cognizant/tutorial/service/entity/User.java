package com.cognizant.tutorial.service.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "tutorialSeqGen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="tutorialSeqGen",sequenceName="user_seq", allocationSize=1)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

	public String getPassword() {
		return password;
	}
}
