package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;import lombok.Setter;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
	
	private String username;
	private String password;

}
