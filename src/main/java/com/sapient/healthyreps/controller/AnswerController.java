package com.sapient.healthyreps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.healthyreps.dao.AnswerDAO;
import com.sapient.healthyreps.entity.Answer;

@RestController

public class AnswerController {

	@Autowired
	AnswerDAO answerDAO;

	@GetMapping
	public String health() {
		return "Welcome to healthyreps blog and QnA Homepage!";
	}

	@GetMapping("/answers/{id}")
	public Answer getAnswerbyID(@PathVariable int id) {

		System.out.println("In function");

//		return "Hello World";
		return answerDAO.getAnswerByAnswerID(id);

	}
}