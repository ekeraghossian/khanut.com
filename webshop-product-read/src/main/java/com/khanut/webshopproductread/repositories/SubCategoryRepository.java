package com.khanut.webshopproductread.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.khanut.webshopproductread.documents.SubCategory;

public interface SubCategoryRepository extends MongoRepository<SubCategory, String>{

}
