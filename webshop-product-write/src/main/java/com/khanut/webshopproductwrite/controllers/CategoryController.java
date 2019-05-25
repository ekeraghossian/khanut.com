package com.khanut.webshopproductwrite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khanut.webshopproductwrite.entities.Category;
import com.khanut.webshopproductwrite.services.CategoryService;

@RestController
//@RequestMapping("/supplier")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@CrossOrigin("*")
	@GetMapping("/categories")
	public Iterable<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
}
