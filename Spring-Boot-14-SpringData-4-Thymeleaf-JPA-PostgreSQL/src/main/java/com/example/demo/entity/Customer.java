package com.example.demo.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email",nullable = false)
	private String email;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(name = "password",nullable = false)
	private String password;
	
    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CustomerRoles> roles;
    
	public Customer() {
		super();
	}

	public Customer(String email, String name, String password, boolean enabled) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Set<CustomerRoles> getRoles() {
		return roles;
	}

	public void setRoles(Set<CustomerRoles> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return this.id+" - "+this.name+" : "+this.email+" -- "+this.password+" "+this.roles.toString()+"<br/>";
	}
}
