package com.dassault.boot.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	//--- not mandatory if csrf does not need to be taken care ---
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		http.csrf(csrf -> csrf.disable());
		http.httpBasic(Customizer.withDefaults());
		SecurityFilterChain filterChain = http.build();
		return filterChain;
	}

	/*
	@Bean
	public UserDetailsService manageUsers(){
		UserDetails user1 =  User.withUsername("admin")
					 .password("{noop}1234")
					 .roles("ADMIN") //ROLE_ADMIN
					 .build();
		
		var user2 =  User.withUsername("sunil")
				 .password("{noop}1234")
				 .roles("MANAGER")
				 .build();	
		
		//UserDetailsManager users = new InMemoryUserDetailsManager(user1, user2);
		
		UserDetailsManager users = new InMemoryUserDetailsManager();
		users.createUser(user1);
		users.createUser(user2);
		
		return users;
	}
	*/
	

	@Bean
	public UserDetailsService manageUsers(){
		UserDetails user1 =  User.withUsername("admin")
					 .password(new BCryptPasswordEncoder().encode("1234"))
					 .roles("ADMIN") 
					 .build();
		
		var user2 =  User.withUsername("sunil")
					.password(getPasswordEncoder().encode("1234"))
					.roles("MANAGER")
					.build();	
		
		UserDetailsManager users = new InMemoryUserDetailsManager(user1, user2);
		System.out.println(user1.getPassword());
		return users;
	}	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
