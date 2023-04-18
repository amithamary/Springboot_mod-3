package com.ust.EmployeeSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprication")
@Configuration
public class EmpConfig extends WebSecurityConfigurerAdapter {
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.inMemoryAuthentication().withUser("blesson").password("password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("john").password("password1").roles("USER");
	}
	
//	protected void configure (HttpSecurity http)throws Exception{
//		http.cors().disable();
//		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//	}
//	
	protected void configure (HttpSecurity http)throws Exception{
		http.cors().disable();
		http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN")
		.anyRequest().fullyAuthenticated().and().httpBasic();
	}
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	

}
