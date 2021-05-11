package com.sapient.healthyreps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.healthyreps.dao.AnswerDAO;
import com.sapient.healthyreps.dao.CategoryDAO;
import com.sapient.healthyreps.entity.Answer;
import com.sapient.healthyreps.entity.Category;
import com.sapient.healthyreps.exception.InvalidID;

@RestController
public class CategoryController {

	@Autowired
	CategoryDAO cat;

	@GetMapping("/category/{id}")
	public String getCategoryFromID(@PathVariable int id) {
		try {
			cat.checkID(id);
		} catch (InvalidID e) {
			e.printStackTrace();
			return "Invalid Cat ID";
		}
		return cat.getCategoryById(id).getCategoryName();
	}

	@GetMapping("/category")
	public List<Category> getAllCategories() {
		List<Category> list = cat.getAllCategory();
		return list;
	}

	@PostMapping("/category")
	public String insertCategory(@RequestBody Category Cat) {
		String res = "";
		res = cat.insertCategory(Cat) ? "Inserted" : "Not Inserted";
		return res;
	}

	@DeleteMapping("/category/{id}")
	public String deleteCategory(@PathVariable int id) {
		try {
			cat.checkID(id);
		} catch (InvalidID e) {
			e.printStackTrace();
			return "Invalid Cat ID";
		}
		String res;
		res = cat.removeCategory(id) ? "Removed" : "Not Removed";
		return res;
	}

	@PutMapping("/category")
	public String updateCategory(@RequestBody Category category) {
		try {
			cat.checkID(category.getCategoryID());
		} catch (InvalidID e) {
			e.printStackTrace();
			return "Invalid Cat ID";// redirect in future
		}
		String res;
		res = cat.updateCategory(category) ? "Updated" : "Not Updated";
		return res;
	}

	@GetMapping("/*")
	public String handleError() {
		return "Error !!!";
	}

}

//public class AnswerController {
//
//	@Autowired
//	AnswerDAO answerDAO;
//
//	@GetMapping
//	public String health() {
//		return "Welcome to healthyreps blog and QnA Homepage!";
//	}
//
//	@GetMapping("/answers/{id}")
//	public Answer getAnswerbyID(@PathVariable int id) {
//
//		System.out.println("In function");
//
////		return "Hello World";
//		return answerDAO.getAnswerByAnswerID(id);
//
//	}
//}