package com.khanut.webshopproductwrite.repositores;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khanut.webshopproductwrite.entities.SubCategory;

@Repository
public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
	@Query(value= "select * from sub_category where category_id = ?1" , nativeQuery = true)
	List<SubCategory> findByCatId(Long catId);
	
}
