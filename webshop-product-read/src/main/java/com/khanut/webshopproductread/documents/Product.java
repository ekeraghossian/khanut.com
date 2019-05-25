package com.khanut.webshopproductread.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import io.github.kaiso.relmongo.annotation.FetchType;


@Document(collection = "products")
public class Product implements Serializable {
	@Transient
    public static final String SEQUENCE_NAME = "products_sequence";
	
	@Id
	private String id;
	@Indexed(unique=false)
	private String name;	
	@io.github.kaiso.relmongo.annotation.ManyToOne(fetch=FetchType.EAGER)
	private Category category;
	@io.github.kaiso.relmongo.annotation.ManyToOne(fetch=FetchType.EAGER)
	private SubCategory subCategory;
	
	private String imagePath;
	
	public Product() {
		
	}
	
	public Product(String id, String name, Category category, SubCategory subCategory, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.imagePath = imagePath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	
}
	
	

/*package com.khanut.webshopproductread.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	private String id;
	private String name;
	
	public Product() {
		super();
	}

	public Product(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}
	
	
}*/
