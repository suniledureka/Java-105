package com.dassault.boot.security.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurations {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf->csrf.disable());
		http.authorizeHttpRequests(request -> request.requestMatchers("/h2-console/**")
														.permitAll()
														.anyRequest()
														.authenticated());
		
		http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));
		
		http.httpBasic(Customizer.withDefaults());
		//http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));			
				
		return http.build();
	}	
	
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabase ds = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
				.build();
		
		return ds;
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		var admin = User.builder().username("admin")
						.password(encoder.encode("1234"))
						.roles("ADMIN", "USER") 
						.build();
		
		var user =  User.withUsername("sunil")
				.password("1234")
				.passwordEncoder(pwd -> encoder.encode(pwd))				
				.roles("USER") 
				.build();
		
		UserDetailsManager users =  new JdbcUserDetailsManager(dataSource());
		users.createUser(admin);
		users.createUser(user);
		
		return users;
	}
}
