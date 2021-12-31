package com.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Add our users for in-memory authentication
		UserBuilder lUserBuilder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(lUserBuilder.username("john").password("test123").roles("EMPLOYEE"))
		.withUser(lUserBuilder.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
		.withUser(lUserBuilder.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		 .antMatchers("/css/**").permitAll()
		 .antMatchers("/").hasRole("EMPLOYEE")
		 .antMatchers("/leaders/**").hasRole("MANAGER")
		 .antMatchers("/systems/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
		.and()
		.logout().permitAll(); // Adds Logout support
	}

}
