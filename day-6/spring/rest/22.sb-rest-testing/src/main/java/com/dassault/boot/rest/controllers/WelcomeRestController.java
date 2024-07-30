package com.dassault.boot.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dassault.boot.rest.services.WelcomeService;

@RestController
public class WelcomeRestController {
	@Autowired
	private WelcomeService service;
	
	@GetMapping(path = "/welcome")
	public ResponseEntity<String> showWelcomeMessage(){
		String msg = service.generateWelcomeMessage();		
		return ResponseEntity.ok(msg);
	}
}
