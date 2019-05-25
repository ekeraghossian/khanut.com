package com.khanut.webshopproductread.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khanut.webshopproductread.documents.SubCategory;
import com.khanut.webshopproductread.repositories.SubCategoryRepository;

@RestController
public class SubCategoryController {
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@CrossOrigin("*")
	@RequestMapping("/subcategoriesId")
	List<SubCategory> getSubcategoriesByCatId(@RequestParam("id") String id) {
		return subCategoryRepository.findAll();
	}
}
