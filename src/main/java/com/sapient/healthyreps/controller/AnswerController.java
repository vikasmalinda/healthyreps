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

	@GetMapping("/answers/{id}")
	public Answer getAnswerbyID(@PathVariable int id) {

		return answerDAO.getAnswerByAnswerID(id);

	}
}