package com.khanut.gateway.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khanut.gateway.entities.Customer;
import com.khanut.gateway.entities.Role;
import com.khanut.gateway.services.CustomerService;
import com.khanut.gateway.services.LoginService;
import com.khanut.gateway.services.RoleService;

@Controller
@RequestMapping("/api")
public class RegisterationController {
	 
	@Autowired
	private LoginService loginService;
	@Autowired
	CustomerService customerService;
	@Autowired
	RoleService roleService;
	
	@CrossOrigin("*")
    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> login(@RequestBody Customer customer) {
		Role role = new Role();
		role.setRole("customer");
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		customer.setRole(roles);
		roleService.saveRole(role);
		loginService.saveUser(customer);
        return new ResponseEntity<String>("customer created", HttpStatus.OK);
    }
}
