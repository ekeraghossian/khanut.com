package com.khanut.webshopproductwrite.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khanut.webshopproductwrite.entities.Category;
import com.khanut.webshopproductwrite.entities.Product;
import com.khanut.webshopproductwrite.entities.SubCategory;
import com.khanut.webshopproductwrite.repositores.CategoryRepositroy;
import com.khanut.webshopproductwrite.repositores.ProductRepository;
import com.khanut.webshopproductwrite.repositores.SubCategoryRepository;

@Component
public class DataInit {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepositroy categoryRepository;
	@Autowired
	SubCategoryRepository subCategoryRepository;

	@PostConstruct
	public void initProduct() {
		productRepository.deleteAll();
		categoryRepository.deleteAll();
		subCategoryRepository.deleteAll();
		Category electronics = new Category("Electronics");
		Category books = new Category("Books");
		Category outdoor = new Category("Outdoor");
		
		categoryRepository.save(electronics);
		categoryRepository.save(books);
		categoryRepository.save(outdoor);
		SubCategory tv = new SubCategory("TV", electronics);
		SubCategory mobiles = new SubCategory("Mobile Phones", electronics);
		SubCategory gameConsoles = new SubCategory("Game Consoles", electronics);
		SubCategory fantasyBooks = new SubCategory("Fantasy", books);
		SubCategory thrillBooks = new SubCategory("Thrill", books);
		
		subCategoryRepository.save(tv);
		subCategoryRepository.save(mobiles);
		subCategoryRepository.save(gameConsoles);
		subCategoryRepository.save(fantasyBooks);
		subCategoryRepository.save(thrillBooks);
		
		Product porduct1 = new Product("Samsung smart 4000", electronics, tv, "./assets/2.jpg");
		Product porduct2 = new Product("Fire and ice", books, thrillBooks, "./assets/1.jpg");
		Product porduct3 = new Product("Sony Bravia 40", electronics, tv, "./assets/2.jpg");
		
		productRepository.save(porduct1);
		productRepository.save(porduct2);
		productRepository.save(porduct3);
	}
}
