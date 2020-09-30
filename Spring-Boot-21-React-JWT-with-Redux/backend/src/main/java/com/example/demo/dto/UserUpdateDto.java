package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.demo.model.User;
import com.example.demo.model.annotation.UniqueData;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
	private Long id;
	@NotEmpty
	@NotNull
	private String username;
	
	private String name;
	
	private String surname;

	@NotEmpty
	@NotNull
	@Size(min = 5, max = 200)
	private String email;
	
	private Date bornDate;
	
	//@ProfileImage
	private String image;

//	public UserUpdateDto(User user) {
//		this.id=user.getId();
//		this.username=user.getUsername();
//		this.name=user.getName();
//		this.surname=user.getSurname();
//		this.email=user.getEmail();
//		this.bornDate=user.getBornDate();
//		this.image=user.getImage();
//	}
}
