package com.dassault.boot.security.controllers;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSRFRestController {
	
	@GetMapping(path = "/csrf-token")
	public CsrfToken retrieveCsrfToken(CsrfToken token) {
		return token;
	}
}
