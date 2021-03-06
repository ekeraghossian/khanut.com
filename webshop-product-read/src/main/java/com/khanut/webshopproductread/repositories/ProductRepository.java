package com.khanut.webshopproductread.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.khanut.webshopproductread.documents.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
