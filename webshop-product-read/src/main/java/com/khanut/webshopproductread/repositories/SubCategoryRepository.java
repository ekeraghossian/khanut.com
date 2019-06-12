package com.khanut.webshopproductread.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.khanut.webshopproductread.documents.SubCategory;

public interface SubCategoryRepository extends MongoRepository<SubCategory, String>{
	@Query("{ 'category._id' : ?0 }")
	List<SubCategory> findByCatId(String id);
}
