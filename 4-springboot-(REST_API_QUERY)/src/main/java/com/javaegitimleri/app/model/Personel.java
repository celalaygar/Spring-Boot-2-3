package com.javaegitimleri.app.model;

import java.util.HashSet;
import java.util.Set;

public class Personel {
	
	
	private Long id;
	private String firstname;
	private String lastname;
	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	@Override
	public String toString() {
		return "Personel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
}
