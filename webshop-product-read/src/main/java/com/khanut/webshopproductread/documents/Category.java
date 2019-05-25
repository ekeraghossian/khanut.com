package com.khanut.webshopproductread.documents;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
public class Category implements Serializable {
	@Transient
    public static final String SEQUENCE_NAME = "categories_sequence";
	
	@Id
	private String id;
	@Indexed(unique=false)
	private String name;
	
	public Category() {
		super();
	}
	
	
	public Category(String id, String name) {
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

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}



	
	
	
}
