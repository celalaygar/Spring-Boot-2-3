package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CarDetails {

	@Column(name="details")
	private String Details;

	
	public CarDetails() {
		super();
	}

	public CarDetails(String details) {
		super();
		Details = details;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}
	
	
}
