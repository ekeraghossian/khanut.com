package com.khanut.gateway.components;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khanut.gateway.entities.Customer;
import com.khanut.gateway.entities.Role;
import com.khanut.gateway.repositories.RoleRepository;
import com.khanut.gateway.services.LoginService;
import com.khanut.gateway.services.RoleService;

@Component
public class CustomerInit {
	@Autowired
	LoginService loginService;
	@Autowired
	RoleService roleService;
	
	@PostConstruct
	public void initializeACustomer() {
		System.out.println("Initialaizing customer 1");
		Customer customer = new Customer();
		customer.setEmail("eee@hotmail.com");
		customer.setPassword("mypass");
		Role role = new Role();
		role.setRole("customer");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		roleService.saveRole(role);
		customer.setRole(roles);
		loginService.saveUser(customer);
		
		System.out.println("Initialaizing supplier 1");
		Customer supplier = new Customer();
		supplier.setEmail("eskandar@hotmail.com");
		supplier.setPassword("mypass");
		Role role2 = new Role();
		role2.setRole("supplier");
		Set<Role> roles2 = new HashSet<>();
		roles2.add(role2);
		roleService.saveRole(role2);
		supplier.setRole(roles2);
		loginService.saveUser(supplier);
	}
}
