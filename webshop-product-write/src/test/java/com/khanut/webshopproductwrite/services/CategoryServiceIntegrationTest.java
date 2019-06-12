package com.khanut.webshopproductwrite.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.khanut.webshopproductwrite.entities.Category;
import com.khanut.webshopproductwrite.repositores.CategoryRepositroy;

@RunWith(SpringRunner.class)
public class CategoryServiceIntegrationTest {

	@TestConfiguration
    static class CategoryServiceTestContextConfiguration {
  
        @Bean
        public CategoryService categoryService() {
            return new CategoryService();
        }
    }
	
	@Autowired
    private CategoryService categoryService;
 
    @MockBean
    private CategoryRepositroy categoryRepository;
    
    Iterable<Category> expected;
	
    @Before
    public void setUp() {
    	Category electronics = new Category("Electronics");
		Category books = new Category("Books");
		Category outdoor = new Category("Outdoor");
		
		List<Category> list = new ArrayList<>();
		list.add(electronics);
		list.add(books);
		list.add(outdoor);
		expected = list;
     
        Mockito.when(categoryRepository.findAll())
          .thenReturn(expected);
    }
	@Test
	public void whenAllCategoriesCalled() {
		Iterable<Category> found = categoryService.getAllCategories();
		
		assertEquals(expected, found);
	}

}
