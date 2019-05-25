package com.khanut.gateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.khanut.gateway.entities.Customer;
import com.khanut.gateway.entities.KhanutUserDetails;
import com.khanut.gateway.entities.Role;
import com.khanut.gateway.exceptions.CustomException;
import com.khanut.gateway.repositories.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService{
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = customerRepo.findByEmail(email);
		if (customer == null || customer.getRole() == null || customer.getRole().isEmpty()) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        String [] authorities = new String[customer.getRole().size()];
        int count=0;
        for (Role role : customer.getRole()) {
            //NOTE: normally we dont need to add "ROLE_" prefix. Spring does automatically for us.
            //Since we are using custom token using JWT we should add ROLE_ prefix
            authorities[count] = "ROLE_"+role.getRole();
            count++;
        }
        KhanutUserDetails userDetails = new KhanutUserDetails(customer.getEmail(),customer.getPassword(),customer.getActive(),
        		customer.isLocked(), customer.isExpired(),customer.isEnabled(),authorities);
        return userDetails;
    }
	
}
