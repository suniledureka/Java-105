package com.dassault.boot.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Bean
	public UserDetailsService manageUsers(){
		UserDetails user1 =  User.withUsername("admin")
					 .password(encoder.encode("1234"))
					 .roles("ADMIN")
					 .build();
		
		UserDetails user2 =  User.builder()
					 .username("sunil")
					 .password(encoder.encode("1234"))	
					 .roles("MANAGER")
					 .build();	

		UserDetails user3 =  User.builder()
					 .username("sanjay")
					 .password(encoder.encode("1234"))	
					 .roles("CLERK")
					 .build();		
		
		UserDetailsManager users = new InMemoryUserDetailsManager(user1, user2, user3);
		System.out.println(user1.getPassword());
		System.out.println(user2.getPassword());
	
		return new InMemoryUserDetailsManager(user1, user2, user3);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(request -> request.requestMatchers("/home","/care").permitAll()												
															.requestMatchers("/admin").hasRole("ADMIN")
															.requestMatchers("/manager").hasAnyRole("ADMIN","MANAGER")
															.requestMatchers("/clerk").hasAnyRole("ADMIN","MANAGER","CLERK")
															.anyRequest()
															.authenticated())

				   .csrf(csrf -> csrf.disable())
				   .httpBasic(Customizer.withDefaults())
				   .build();
	}	
}
