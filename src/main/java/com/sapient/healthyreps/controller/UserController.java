package com.sapient.healthyreps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.healthyreps.dao.UserDAO;
import com.sapient.healthyreps.entity.User;

@RestController
public class UserController {

	@Autowired
	UserDAO userdao;

	@GetMapping
	public String health() {
		return "Welcome to healthyreps blog and QnA Homepage!";
	}

	@PostMapping("/users")
	public boolean insertUser(@RequestBody User user) {
		return userdao.insertUser(user);
	}

	@DeleteMapping("/users/{user_id}")
	public boolean deleteUser(@PathVariable int user_id) {
		return userdao.deleteUser(user_id);
	}

	@RequestMapping(value = "/users/{user_id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int user_id) {
		return userdao.getUser(user_id);

	}
}
