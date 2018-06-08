package com.javaegitimleri.app.web;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

	
	@Test
	public void generateEncodedPassword() {
		
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		/*
			INSERT INTO USERS VALUES('user1','{noop}12345',TRUE);
		*/
		System.out.println("{bcrypt}"+passwordEncoder.encode("12345"));
		
		/*
			INSERT INTO USERS VALUES('user2','{noop}secrett',TRUE);
		*/
		System.out.println("{bcrypt}"+passwordEncoder.encode("secrett"));
		
		/*
			INSERT INTO USERS VALUES('celal','{noop}secret',TRUE);
		 */
		System.out.println("{bcrypt}"+passwordEncoder.encode("secret"));
		
		
		
	}
	
	
}
