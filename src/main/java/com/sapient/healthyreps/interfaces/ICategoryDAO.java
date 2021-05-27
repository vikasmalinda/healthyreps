package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Category;

public interface ICategoryDAO {
	public boolean insertCategory(Category category);

	public List<Category> getAllCategory();

	public Category getCategoryById(int category_id);

	public boolean removeCategory(int category_id);

	public boolean updateCategory(Category category);

}
