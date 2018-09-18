package com.example.demo;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	
	@Test
	public void generateEncodedPassword() {
		
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		/*
			INSERT INTO USERS VALUES('user1','{noop}12345',TRUE);
		*/
		System.out.println("{bcrypt}"+passwordEncoder.encode("123"));
		//{bcrypt}$2a$10$feTx1gL5C6yElFL8YLqzS.IhvvPqj0.6NTIBo7ejrptxGMuOhs9XC
		/*
			INSERT INTO USERS VALUES('user2','{noop}secrett',TRUE);
		*/
		System.out.println("{bcrypt}"+passwordEncoder.encode("admin"));
		
		/*
			INSERT INTO USERS VALUES('celal','{noop}secret',TRUE);
		 */
		System.out.println("{bcrypt}"+passwordEncoder.encode("secret"));
		
		
		
	}

}
