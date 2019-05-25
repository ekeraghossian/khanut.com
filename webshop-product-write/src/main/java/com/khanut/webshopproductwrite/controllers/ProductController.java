package com.khanut.webshopproductwrite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khanut.webshopproductwrite.entities.Product;
import com.khanut.webshopproductwrite.services.ProductService;

@RestController
//@RequestMapping("/supplier")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@CrossOrigin("*")
	@PostMapping("/add-product")
	public void addProduct(@RequestBody Product product) {
		System.out.println(product);
		productService.createProduct(product);
		
		jmsTemplate.convertAndSend("addProduct.queue", product);
	}
	
}
