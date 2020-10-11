package com.dpworld.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${user.oauth.user.username}")
    private String username;
    @Value("${user.oauth.user.password}")
    private String password;

	private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth .inMemoryAuthentication() .withUser(username)
		 .password(passwordEncoder().encode(password))
         //.password("dpworld")
		 .roles("USER");

    }

    // Secure the endpoins with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity http) throws Exception {

    	http.cors().disable().csrf().disable()
    	.authorizeRequests().antMatchers("/").permitAll();
    	
		/*
		 * http.requestMatchers() .antMatchers("/login", "/oauth/authorize") .and()
		 * .authorizeRequests() .anyRequest().authenticated() .and()
		 * .formLogin().permitAll();
		 */
    }
	
	  @Bean public BCryptPasswordEncoder passwordEncoder(){ return new
	  BCryptPasswordEncoder(); }
	 

}