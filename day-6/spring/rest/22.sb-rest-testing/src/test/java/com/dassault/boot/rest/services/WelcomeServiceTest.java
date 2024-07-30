package com.dassault.boot.rest.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WelcomeServiceTest {
	@Autowired
	private WelcomeService service;
	
	@Test
	void testGenerateWelcomeMessage() {
		String actual = service.generateWelcomeMessage();
		assertNotNull(actual);
	}

}
