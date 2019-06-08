package com.khanut.customer.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khanut.customer.webshop.entities.Customer;
import com.khanut.customer.webshop.repositories.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepo;
	
	public void createNewCustomer(Customer newCustomer) {
		customerRepo.save(newCustomer);
	}
}
