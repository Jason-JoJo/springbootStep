package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

//	New Code
//
//	`1. auth.inMemoryAuthentication()
//	2.             .passwordEncoder(NoOpPasswordEncoder.getInstance())
//	3.         		.withUser("in28Minutes").password("dummy")`
//
//	Old Code
//
//	`1. auth.inMemoryAuthentication().withUser("in28Minutes").password("dummy")`
	
	
	//Creat user
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()			
			.withUser("jason").password("{noop}1234").roles("USER", "ADMIN");
			
	}
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
                .formLogin();
      
	}
}
