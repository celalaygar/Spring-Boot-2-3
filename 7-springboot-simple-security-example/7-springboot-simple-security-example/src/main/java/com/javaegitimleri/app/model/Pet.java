package com.javaegitimleri.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name="p_pet")
public class Pet {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="petClinicSeqGen")
	@SequenceGenerator(name="petClinicSeqGen",sequenceName="petclinic_sequence")
	private Long id;
	
	@Column(name="first_name")	
	private String firstname;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@ManyToOne
	@JoinColumn(name="personel_id")
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
