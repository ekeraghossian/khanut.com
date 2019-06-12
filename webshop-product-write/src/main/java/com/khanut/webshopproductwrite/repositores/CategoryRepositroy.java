package com.khanut.webshopproductwrite.repositores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khanut.webshopproductwrite.entities.Category;

@Repository
public interface CategoryRepositroy extends CrudRepository<Category, Long>{

}
