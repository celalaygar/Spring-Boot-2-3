package com.javaegitimleri.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(value=PersonelProperties.class)
@ServletComponentScan
public class PersonelApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(PersonelApplication.class, args);
	}
}
