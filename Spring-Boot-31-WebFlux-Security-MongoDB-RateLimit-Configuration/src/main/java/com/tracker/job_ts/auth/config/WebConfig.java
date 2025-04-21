package com.tracker.job_ts.auth.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Tüm URL'leri kapsar
                .allowedOriginPatterns("*") // Herhangi bir origin'den gelen istekleri kabul eder
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")  // Tüm HTTP metodlarını kabul eder
                .allowedHeaders("*")  // Herhangi bir başlık (header) kabul eder
                .allowCredentials(true); // Kimlik doğrulama bilgilerini kabul eder
    }
}
