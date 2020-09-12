package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class UserDto {
	private Long id;
	
	private String username;
	
	private String name;
	
	private String surname;

	private String email;

	private String password;
	
	private String repeatPassword;
	
	private Date bornDate;

	public String getFullName() {
		return this.name+" "+this.surname;
	}
	
}
