package com.khanut.customer.webshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Column
	private String name;
	@Column
	private String lastName;
	@Column(unique=true)
	private String email;
	@Column
	private String password;
	
	public Customer() {
		super();
	}

	public Customer(Long customerId, String name, String lastName, String email, String password) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
