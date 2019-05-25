package com.khanut.gateway.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khanut.gateway.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	@Query(value = "select * from Customer where email = ?1", nativeQuery = true)
	Customer findByEmail(String email);
}
