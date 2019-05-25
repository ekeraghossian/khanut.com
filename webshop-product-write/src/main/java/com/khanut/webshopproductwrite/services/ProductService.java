package com.khanut.webshopproductwrite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import com.khanut.webshopproductwrite.entities.Product;
import com.khanut.webshopproductwrite.repositores.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	
	//@SendTo("addProduct.queue")
	public void createProduct(Product product) {
		productRepo.save(product);
		//return product;
	}
}
