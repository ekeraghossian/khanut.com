package com.khanut.gateway.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khanut.gateway.entities.JwtToken;

@Repository
public interface JwtTokenRepository extends CrudRepository<JwtToken, String> {

}
