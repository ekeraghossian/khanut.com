package com.khanut.webshopproductread.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khanut.webshopproductread.documents.Product;
import com.khanut.webshopproductread.repositories.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@CrossOrigin("*")
	@RequestMapping("/products")
	List<Product> getproducts() {
		return productRepository.findAll();
	}
}
