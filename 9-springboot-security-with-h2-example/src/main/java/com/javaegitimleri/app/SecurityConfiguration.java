package com.javaegitimleri.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled=true,jsr250Enabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService; 
	
	@Autowired
	private DataSource datasource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//you can write "/h2-console/**", in first bottom lıne
		http.authorizeRequests().antMatchers("/**/favicon.ico","/css/**","/js/**","/images/**","/webjars/**","/login.html").permitAll();
		
		//user yetkilendirme bölümü
		//only entry links called /rest/** anybody has ROLE_EDITOR and ROLE_ADMIN
		http.authorizeRequests().antMatchers("/rest/**").access("hasRole('EDITOR')");
		http.authorizeRequests().antMatchers("/actuator/**").access("hasRole('ADMIN')");
		
		
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/login.html?loginFailed=true");
		http.rememberMe().userDetailsService(userDetailsService);
		http.httpBasic();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(datasource);
		
		
	}
} 
