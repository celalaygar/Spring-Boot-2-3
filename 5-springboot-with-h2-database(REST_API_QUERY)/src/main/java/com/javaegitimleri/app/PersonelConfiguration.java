package com.javaegitimleri.app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonelConfiguration {

	@Autowired
	private PersonelProperties personelProperties;
	
	@PostConstruct
	public void init() {
		System.out.println("Display owner with personel : "+personelProperties.isDisplayOwner());
	}
	
}
