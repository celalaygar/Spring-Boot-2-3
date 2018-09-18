package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class webConfigurationClass extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("{noop}admin").roles("ADMIN","USER").and()
		.withUser("fatihf").password("{noop}1234").roles("ADMIN").and()		
		.withUser("celal").password("{noop}0606").roles("USER").and()		
		.withUser("aygar").password("{noop}aygar").roles("EDITOR").and()		
		.withUser("arda").password("{noop}1905").roles("EDITOR","USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests()
          .antMatchers("/customers").hasRole("USER")	//USER role can access /customers
          .antMatchers("/rest/**").hasRole("ADMIN")		//ADMIN role can access /rest/**
          .antMatchers("/rest/**","/customers").hasRole("EDITOR")	//EDITOR role can access /admin/** , /customers
          .anyRequest().authenticated()					//any other request just need authentication
          .and().formLogin();							//enable form login
	}
}
