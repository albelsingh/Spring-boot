package com.telusko.securityapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;


@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	//Static user login
	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * 
	 * List<UserDetails> users=new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("albel").password(
	 * "12345").roles("USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(users); }
	 */
	
	//Login through DB
	/*
	 * @Autowired private UserDetailsService userDetailsService;
	 * 
	 * @Bean public AuthenticationProvider authProvider() {
	 * 
	 * DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
	 * provider.setUserDetailsService(userDetailsService);
	 * provider.setPasswordEncoder(new BCryptPasswordEncoder()); return provider;
	 * 
	 * }
	 */
	
	//Login through Google page
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated();
		
	}
	

	

}
