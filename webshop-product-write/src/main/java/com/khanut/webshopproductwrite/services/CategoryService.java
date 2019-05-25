package com.khanut.webshopproductwrite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khanut.webshopproductwrite.entities.Category;
import com.khanut.webshopproductwrite.repositores.CategoryRepositroy;

@Service
public class CategoryService {
	@Autowired
	CategoryRepositroy categoryRepositroy;
	
	public Iterable<Category> getAllCategories() {
		return categoryRepositroy.findAll();
	}
}
