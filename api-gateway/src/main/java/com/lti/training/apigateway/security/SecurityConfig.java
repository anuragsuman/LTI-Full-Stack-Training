package com.lti.training.apigateway.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	// to configure the credential repository
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// database : pre-defined schema
		// auth.jdbcAuthentication().dataSource(dataSource);
		
		
		// auth.ldapAuthentication();
		
		// custom schema
		auth.jdbcAuthentication().dataSource(dataSource)
			// 	for reading username and password (authentication)
			.usersByUsernameQuery("select username,password,enabled from users where username = ?")
			//	for reading roles (authorization)
			.authoritiesByUsernameQuery("select username,authority from authorities where username = ? ");
		
		// in-memorycredentials
		/*
		UserBuilder builder = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(builder.username("First").password("abc").roles("EMPLOYEE"))
			.withUser(builder.username("Second").password("abc").roles("MANAGER"))
			.withUser(builder.username("Third").password("abc").roles("ADMIN"));
			*/
		/*auth.inMemoryAuthentication()
			.withUser(User.withUsername("First").password("abc").roles("EMPLOYEE"))
			.withUser(User.withUsername("Second").password("abc").roles("MANAGER"))
			.withUser(User.withUsername("Third").password("abc").roles("ADMIN"));
			*/
	}
	
	// rules to access the resource 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors() // allow cross origins (spring security based)
		.and()	
			.csrf().disable() // for rest based security
			.authorizeRequests()  // returns an object used to configure the secured endpoints
				.antMatchers("/post-micro/post/add").hasRole("")
				.antMatchers(HttpMethod.DELETE).hasRole("Manager")
				.antMatchers("/post-micro/post/**").hasAnyRole("Manager","Admin")
				.antMatchers("/user-micro/user/**").permitAll()
		.and() // return http object
			.httpBasic();
	}
	
	// rules additional security ( JWT / OAuth )
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}
