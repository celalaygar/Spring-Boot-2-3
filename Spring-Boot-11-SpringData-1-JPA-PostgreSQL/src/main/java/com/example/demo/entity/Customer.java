package com.example.demo.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	@JsonIgnore
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Details details;
	
	public Customer(){}
	
	public Customer(String name,String email){
		this.name = name;
		this.email = email;
	}
	

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

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public String toString(){
		String info = String.format("Customer: name = %s has a details with city = %s, "
				+ "country = %s, phone_number =%s", this.name, this.details.getCity(),this.details.getCountry(),this.details.getPhone_number());
		return info;
	}

}
