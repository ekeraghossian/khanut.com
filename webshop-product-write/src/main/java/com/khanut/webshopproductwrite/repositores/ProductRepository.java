package com.khanut.webshopproductwrite.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khanut.webshopproductwrite.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
