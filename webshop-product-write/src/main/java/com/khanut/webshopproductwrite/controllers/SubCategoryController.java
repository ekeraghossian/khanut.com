package com.khanut.webshopproductwrite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.khanut.webshopproductwrite.entities.SubCategory;
import com.khanut.webshopproductwrite.services.SubCategoryService;

@RestController
//@RequestMapping("/supplier")
public class SubCategoryController {
	@Autowired
	SubCategoryService subCategoryService;
	
	@CrossOrigin("*")
	@GetMapping("/subcategories/{catId}")
	public List<SubCategory> getSubCategoriesbyCatId(@PathVariable Long catId) {
		return subCategoryService.getByCategoryId(catId);
	}
}
