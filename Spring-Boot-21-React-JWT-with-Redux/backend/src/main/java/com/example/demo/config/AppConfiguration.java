package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties  // application.properties deki değerleri bu class a assign eder.
public class AppConfiguration {
	String uploadPath;
	String appJwtSecret;
}
