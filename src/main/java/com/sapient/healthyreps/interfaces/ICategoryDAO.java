package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Category;
import com.sapient.healthyreps.exception.InvalidCategoryInputs;
import com.sapient.healthyreps.exception.InvalidID;

public interface ICategoryDAO {
	public boolean insertCategory(Category category) ;

	public List<Category> getAllCategory();

	public Category getCategoryById(int categoryId) ;

	public boolean removeCategory(int categoryID);

	public boolean updateCategory(Category category) ;
	
	public int getCategoryIDByCategoryName(String name) throws InvalidID;
	
	public void checkID(int ID) throws InvalidID;
	
	public void checkInputs(Category category) throws InvalidCategoryInputs;
}
