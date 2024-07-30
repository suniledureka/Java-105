package com.dassault.boot.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to State Bank of India";
	}

	@GetMapping("/admin")
	public String adminPage() {
		return "This page is for Administrators";
	}

	@GetMapping("/manager")
	public String managerPage() {
		return "This page is for Managers";
	}

	@GetMapping("/clerk")
	public String clerkPage() {
		return "This page is for Clerks";
	}

	@GetMapping("/customer")
	public String customerPage() {
		return "This page is for Customers";
	}

	@GetMapping("/care")
	public String customerCarePage() {
		return "Contact State Bank of India";
	}
}

