package com.khanut.customer.webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khanut.customer.webshop.entities.Customer;
import com.khanut.customer.webshop.services.CustomerService;

@RestController
public class customerContoller {
	@Autowired
	CustomerService customerService;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	ResponseEntity<Void> createNewCustomer(@RequestBody Customer newCustomer) {
		customerService.createNewCustomer(newCustomer);
		
		return ResponseEntity.ok(null);
	}
}
