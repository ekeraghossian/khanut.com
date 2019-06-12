package com.khanut.webshopproductread.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khanut.webshopproductread.documents.Category;
import com.khanut.webshopproductread.documents.Product;
import com.khanut.webshopproductread.documents.SubCategory;
import com.khanut.webshopproductread.repositories.CategoryRepository;
import com.khanut.webshopproductread.repositories.ProductRepository;
import com.khanut.webshopproductread.repositories.SubCategoryRepository;

@Component
public class DataInit {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubCategoryRepository subCategoryRepository;
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	
	@PostConstruct
	public void initProduct() {
		Category electronics = new Category(sequenceGenerator.generateSequence(Category.SEQUENCE_NAME), "Electronics");
		Category books = new Category(sequenceGenerator.generateSequence(Category.SEQUENCE_NAME), "Books");
		Category outdoor = new Category(sequenceGenerator.generateSequence(Category.SEQUENCE_NAME), "Outdoor");
		categoryRepository.deleteAll();
		categoryRepository.insert(electronics);
		categoryRepository.insert(books);
		categoryRepository.insert(outdoor);
		SubCategory tv = new SubCategory(sequenceGenerator.generateSequence(SubCategory.SEQUENCE_NAME), "TV", electronics);
		SubCategory mobiles = new SubCategory(sequenceGenerator.generateSequence(SubCategory.SEQUENCE_NAME), "Mobile Phones", electronics);
		SubCategory gameConsoles = new SubCategory(sequenceGenerator.generateSequence(SubCategory.SEQUENCE_NAME), "Game Consoles", electronics);
		SubCategory fantasyBooks = new SubCategory(sequenceGenerator.generateSequence(SubCategory.SEQUENCE_NAME), "Fantasy", books);
		SubCategory thrillBooks = new SubCategory(sequenceGenerator.generateSequence(SubCategory.SEQUENCE_NAME), "Thrill", books);
		subCategoryRepository.deleteAll();
		subCategoryRepository.insert(tv);
		subCategoryRepository.insert(mobiles);
		subCategoryRepository.insert(gameConsoles);
		subCategoryRepository.insert(fantasyBooks);
		subCategoryRepository.insert(thrillBooks);
		
		Product porduct1 = new Product(sequenceGenerator.generateSequence(Product.SEQUENCE_NAME), "Samsung smart 4000", electronics, tv, "./assets/2.jpg");
		Product porduct2 = new Product(sequenceGenerator.generateSequence(Product.SEQUENCE_NAME), "Fire and ice", books, thrillBooks, "./assets/fireandice.jpg");
		Product porduct3 = new Product(sequenceGenerator.generateSequence(Product.SEQUENCE_NAME), "Sony Bravia 40", electronics, tv, "./assets/sony.jpg");
		productRepository.deleteAll();
		productRepository.insert(porduct1);
		productRepository.insert(porduct2);
		productRepository.insert(porduct3);
		
	}
}
