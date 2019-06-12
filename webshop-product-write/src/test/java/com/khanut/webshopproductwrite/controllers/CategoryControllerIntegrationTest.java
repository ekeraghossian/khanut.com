package com.khanut.webshopproductwrite.controllers;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.khanut.webshopproductwrite.entities.Category;
import com.khanut.webshopproductwrite.services.CategoryService;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerIntegrationTest {

	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private CategoryService categoryService;
	
	Iterable<Category> expected;
	
	@Test
	public void test() throws Exception{
		Category electronics = new Category("Electronics");
		Category books = new Category("Books");
		Category outdoor = new Category("Outdoor");
		
		List<Category> list = new ArrayList<>();
		list.add(electronics);
		list.add(books);
		list.add(outdoor);
		expected = list;
		
		given(categoryService.getAllCategories()).willReturn(expected);
		
		mvc.perform(get("/categories")
				.contentType(MediaType.APPLICATION_JSON))
	      		.andExpect(status().isOk())
	      		.andExpect(jsonPath("$", hasSize(3)))
	      		.andExpect(jsonPath("$[0].name", is(electronics.getName())));
	}

}
