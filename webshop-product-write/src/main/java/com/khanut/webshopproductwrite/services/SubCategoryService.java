package com.khanut.webshopproductwrite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khanut.webshopproductwrite.entities.SubCategory;
import com.khanut.webshopproductwrite.repositores.SubCategoryRepository;

@Service
public class SubCategoryService {
	@Autowired
	SubCategoryRepository subCategoryRepo;
	
	public List<SubCategory> getByCategoryId(Long id) {
		return subCategoryRepo.findByCatId(id);
	}
}
