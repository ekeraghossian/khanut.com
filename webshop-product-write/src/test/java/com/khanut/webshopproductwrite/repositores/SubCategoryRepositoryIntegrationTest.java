package com.khanut.webshopproductwrite.repositores;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.khanut.webshopproductwrite.entities.Category;
import com.khanut.webshopproductwrite.entities.SubCategory;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SubCategoryRepositoryIntegrationTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private SubCategoryRepository repo;
	
	@Test
	public void whenFindByCatId() {
		Category electronics = new Category("Electronics");
		Category books = new Category("Books");
		Category outdoor = new Category("Outdoor");
		
		entityManager.persist(electronics);
		entityManager.persist(books);
		entityManager.persist(outdoor);
		entityManager.flush();
		
		SubCategory tv = new SubCategory("TV", electronics);
		SubCategory mobiles = new SubCategory("Mobile Phones", electronics);
		SubCategory gameConsoles = new SubCategory("Game Consoles", electronics);
		SubCategory fantasyBooks = new SubCategory("Fantasy", books);
		SubCategory thrillBooks = new SubCategory("Thrill", books);
		
		entityManager.persist(tv);
		entityManager.persist(mobiles);
		entityManager.persist(gameConsoles);
		entityManager.persist(fantasyBooks);
		entityManager.persist(thrillBooks);
	    entityManager.flush();
	    
	    List<SubCategory> found = repo.findByCatId(Long.valueOf("1"));
	    
	    List<SubCategory> expected = new ArrayList<>();
	    expected.add(tv);
	    expected.add(mobiles);
	    expected.add(gameConsoles);
	    
	    for(int i = 0; i < found.size(); i++) {
	    	assertEquals(found.get(i).getName()
	        ,expected.get(i).getName());
	    }
	}

}
