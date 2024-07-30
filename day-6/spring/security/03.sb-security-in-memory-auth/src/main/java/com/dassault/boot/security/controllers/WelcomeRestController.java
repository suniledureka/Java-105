package com.dassault.boot.security.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {
	
	@GetMapping(path = "/welcome")
	public ResponseEntity<String> showWelcomeMessage(){
		String msg = "Welcome to Dassault Systemes";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
