package com.khanut.webshopproductread.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.khanut.webshopproductread.documents.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
