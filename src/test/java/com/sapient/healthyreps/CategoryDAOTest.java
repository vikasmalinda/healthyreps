package com.sapient.healthyreps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sapient.healthyreps.dao.CategoryDAO;
import com.sapient.healthyreps.dao.PermissionDAO;
import com.sapient.healthyreps.entity.Category;

public class CategoryDAOTest {
	CategoryDAO categoryDAO;
	PermissionDAO permissionDAO;

	@BeforeEach
	void initialize() {
		this.categoryDAO = new CategoryDAO();
		this.permissionDAO = new PermissionDAO();
	}

	@Test
	void CRUDTestPass() {
		// given
		Category category = new Category();
		category.setCategoryName("Sample test value");

		// Create Test

		boolean inserted = categoryDAO.insertCategory(category);

		assertTrue(inserted);

		// Read Test

		int id = permissionDAO.getLastID("category");
		System.out.println("id of the inserted : " + id);
		category = categoryDAO.getCategoryById(id);

		assertEquals(category.getCategoryName(), "Sample test value");

		// Update test

		category.setCategoryName("Updated test value");

		assertTrue(categoryDAO.updateCategory(category));

		// Delete test

		assertTrue(categoryDAO.removeCategory(id));

	}
}
