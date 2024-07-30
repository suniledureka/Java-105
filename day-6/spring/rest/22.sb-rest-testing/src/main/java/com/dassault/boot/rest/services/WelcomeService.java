package com.dassault.boot.rest.services;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	public String generateWelcomeMessage() {
		return "Welcome to Dassault Systems";
	};		
}
