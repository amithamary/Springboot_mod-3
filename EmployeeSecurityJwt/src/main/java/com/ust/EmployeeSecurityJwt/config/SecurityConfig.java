package com.ust.EmployeeSecurityJwt.config;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ust.EmployeeSecurityJwt.filter.Jwtfilter;
import com.ust.EmployeeSecurityJwt.services.UserServices;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserServices userDetailsService;
	@Autowired
	private Jwtfilter jwtFilter;
	
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	
	
	@Bean
	public PasswordEncoder passwordencoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean(name=BeanIds.AUTHENTICATION_MANAGER )
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	protected void configure(HttpSecurity http)throws Exception{
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/authenticate").permitAll().anyRequest().
        authenticated().and(). exceptionHandling().and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);;
    }
  
}








//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfiguration{
//@Autowired
//private UserServices userDetailsService;
//@Autowired
//private Jwtfilter jwtFilter;
//protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//	auth.userDetailsService(userDetailsService);
//}
//@SuppressWarnings("deprecation")
//@Bean
//public PasswordEncoder passwordEncoder() {
//	return NoOpPasswordEncoder.getInstance();
//}
//@Bean(name=BeanIds.AUTHENTICATION_MANAGER)
//public AuthenticationManager authenticationManagerBean() throws Exception{
//return super.authenticationManagerBean();
//}
//protected void configure(HttpSecurity http) throws Exception {
//http.csrf().disable();
// http.authorizeRequests().requestMatchers("/authentivcate").permitAll().anyRequest().
// authenticated().and().exceptionHandling().and().sessionManagement().
// sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
// }
//
//
//
//
//
//
//}
