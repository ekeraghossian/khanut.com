package com.khanut.webshopproductread.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import io.github.kaiso.relmongo.annotation.FetchType;

@Document(collection = "subcategories")
public class SubCategory implements Serializable{
	@Transient
    public static final String SEQUENCE_NAME = "subcategories_sequence";
	
	@Id
	private String id;
	@Indexed(unique=false)
	private String name;
	@io.github.kaiso.relmongo.annotation.ManyToOne(fetch=FetchType.EAGER)
	private Category category;

	public SubCategory() {
		super();
	}
	
	
	public SubCategory(String id, String name, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	

}
