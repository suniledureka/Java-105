package com.dassault.boot.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dassault.boot.rest.controllers.WelcomeRestController;
import com.dassault.boot.rest.services.WelcomeService;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private WelcomeService service;
	
	@Autowired
	private WelcomeRestController controller;
	
	@Test
	void contextLoads() {
		assertThat(service).isNotNull();
		assertThat(controller).isNotNull();
	}
}
