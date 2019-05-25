package com.khanut.webshopproductread.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.khanut.webshopproductread.repositories.CategoryRepository;
import com.khanut.webshopproductread.repositories.ProductRepository;
import com.khanut.webshopproductread.repositories.SubCategoryRepository;
import com.khanut.webshopproductwrite.entities.Category;
import com.khanut.webshopproductwrite.entities.Product;
import com.khanut.webshopproductwrite.entities.SubCategory;

@Component
public class ProductListener {
	@Autowired
	ProductRepository productRepo;
	
	@JmsListener(destination = "addProduct.queue")
	public void addProdcutFromSupplier(Product product) {
		//productRepo.save(product);
		Category existingCat = product.getCategory();
		SubCategory existingSub = product.getSubCategory();
		com.khanut.webshopproductread.documents.Category cat = new com.khanut.webshopproductread.documents.Category();
		cat.setId(Long.toString(existingCat.getId()));
		cat.setName(existingCat.getName());
		com.khanut.webshopproductread.documents.SubCategory sub = new com.khanut.webshopproductread.documents.SubCategory();
		sub.setId(Long.toString(existingSub.getId()));
		sub.setCategory(cat);
		sub.setName(existingSub.getName());
		com.khanut.webshopproductread.documents.Product pro = new com.khanut.webshopproductread.documents.Product();
		pro.setId(Long.toString(product.getId()));
		pro.setName(product.getName());
		pro.setImagePath(product.getImagePath());
		pro.setCategory(cat);
		pro.setSubCategory(sub);
		productRepo.save(pro);
	}
	
}
