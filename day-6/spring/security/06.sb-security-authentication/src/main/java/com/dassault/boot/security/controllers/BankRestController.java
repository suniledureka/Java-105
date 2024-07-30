package com.dassault.boot.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to State Bank of India";
	}

	@GetMapping("/balance")
	public String balancePage() {
		return "This page shows customer's balance";
	}

	@GetMapping("/loan")
	public String loanPage() {
		return "This page shows customer's loan details (if any)";
	}

	@GetMapping("/statement")
	public String statementPage() {
		return "This page shows customer's bank statement";
	}

	@GetMapping("/care")
	public String customerCarePage() {
		return "Contact State Bank of India";
	}
}
