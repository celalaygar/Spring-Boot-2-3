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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableWebSecurity
public class webConfigurationClass extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password("{noop}admin").roles("ADMIN").and()	
		.withUser("celal").password("{noop}celal").roles("USER").and()	
		.withUser("arda").password("{noop}arda").roles("EDITOR");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests()
          .antMatchers("/rest/customers/**","/rest/customer/**").hasRole("ADMIN")		
          .antMatchers("/customers/**").hasRole("USER")	
          .antMatchers("/rest/**","/customers/**").hasRole("EDITOR")
          .anyRequest().authenticated()					//any other request just need authentication
          .and().formLogin();							//enable form login
	}
}
