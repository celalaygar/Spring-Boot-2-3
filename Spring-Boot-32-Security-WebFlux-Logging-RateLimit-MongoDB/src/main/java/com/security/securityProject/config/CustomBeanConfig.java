package com.security.securityProject.config;

import com.security.securityProject.service.AuthenticationManager;
import com.security.securityProject.service.SecurityContextRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class CustomBeanConfig {

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http,
//                                                         AuthenticationManager authenticationManager,
//                                                         SecurityContextRepository securityContextRepository) {
//        return http
//                .csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .authenticationManager(authenticationManager)
//                .securityContextRepository(securityContextRepository)
//                .authorizeExchange(exchanges -> exchanges
//                        .pathMatchers("/public/**").permitAll()
//                        .anyExchange().authenticated()
//                )
//                .build();
//    }

}