package com.khanut.gateway.services;

import com.khanut.gateway.entities.Customer;

public interface LoginService {
	
	String login(String username, String password);
    
	Customer saveUser(Customer user);

    boolean logout(String token);

    Boolean isValidToken(String token);

    String createNewToken(String token);
}
