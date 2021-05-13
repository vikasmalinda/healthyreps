package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Category;
import com.sapient.healthyreps.exception.InvalidId;

public interface ICategoryDAO {
	public boolean insertCategory(Category category);

	public List<Category> getAllCategory();

	public Category getCategoryById(int categoryId);

	public boolean removeCategory(int categoryID) ;

	public boolean updateCategory(Category category);
	
	public int getCategoryIDByCategoryName(String name);
}
