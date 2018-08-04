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

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	
	// @JsonIgnore
	// @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, fetch =
	// FetchType.EAGER)
	// private Details details;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Book> books;

	public Customer() {
	}

	public Customer(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
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
	//
	// public Details getDetails() {
	// return details;
	// }
	//
	// public void setDetails(Details details) {
	// this.details = details;
	// }

	public String toString() {

		String info = "Customer: name = " + this.name + " email = " + this.email + " " + this.books.toString()
				+ "<br> ";

		return info;
	}

}
