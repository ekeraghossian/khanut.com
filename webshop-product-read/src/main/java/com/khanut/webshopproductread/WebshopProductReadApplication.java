package com.khanut.webshopproductread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.github.kaiso.relmongo.config.EnableRelMongo;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.khanut.webshopproductread.repositories")
@EnableDiscoveryClient
@EnableRelMongo
public class WebshopProductReadApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebshopProductReadApplication.class, args);
	}
}
