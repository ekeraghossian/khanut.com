package com.khanut.gateway.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khanut.gateway.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
