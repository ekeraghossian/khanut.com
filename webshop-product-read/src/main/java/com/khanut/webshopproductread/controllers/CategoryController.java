package com.khanut.webshopproductread.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khanut.webshopproductread.documents.Category;
import com.khanut.webshopproductread.repositories.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@CrossOrigin("*")
	@RequestMapping("/categories")
	List<Category> getcategories() {
		return categoryRepository.findAll();
	}
}
