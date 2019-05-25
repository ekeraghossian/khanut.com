package com.khanut.webshopproductwrite.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;	
	@ManyToOne
    @JoinColumn
	private Category category;
	@ManyToOne
    @JoinColumn
	private SubCategory subCategory;
	private String imagePath;
	
	public Product() {
		
	}
	
	public Product(String name, Category category, SubCategory subCategory, String imagePath) {
		super();
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.imagePath = imagePath;
	}

	public Product(Long id, String name, Category category, SubCategory subCategory, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.imagePath = imagePath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", subCategory=" + subCategory
				+ ", imagePath=" + imagePath + "]";
	}
}
	
