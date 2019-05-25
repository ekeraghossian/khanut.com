package com.khanut.gateway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khanut.gateway.entities.Role;
import com.khanut.gateway.repositories.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepo;
	
	public void saveRole(Role role) {
		roleRepo.save(role);
	}
}
