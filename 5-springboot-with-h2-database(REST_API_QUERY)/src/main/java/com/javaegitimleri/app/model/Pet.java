package com.javaegitimleri.app.model;

import java.util.Date;

public class Pet {
	private Long id;
	private String firstname;
	private Date birthDate;
	
	private Personel personel;

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Personel getPersonel() {
		return personel;
	}

	public void setPersonel(Personel personel) {
		this.personel = personel;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", firstname=" + firstname + ", birthDate=" + birthDate + ", personel=" + personel
				+ "]";
	}
	
}
