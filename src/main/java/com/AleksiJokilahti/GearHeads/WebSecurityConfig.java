package com.AleksiJokilahti.GearHeads;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.AleksiJokilahti.GearHeads.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	// UserDetailServices
	private UserDetailServiceImpl userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/css/**").permitAll()
			.and()
			.authorizeRequests().antMatchers("/h2-console/**").permitAll()
			.and()
			.csrf().ignoringAntMatchers("/h2-console/**")
			.and()
			.headers().frameOptions().sameOrigin()
			.and()
			.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			
			.formLogin()
				.defaultSuccessUrl("/", true)
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	// Adding Spring Security to use user entities in authentication
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		// Spring Security encrypts the password wit BCrypt
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
}

