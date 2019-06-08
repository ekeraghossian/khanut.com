package com.khanut.customer.webshop.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khanut.customer.webshop.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
