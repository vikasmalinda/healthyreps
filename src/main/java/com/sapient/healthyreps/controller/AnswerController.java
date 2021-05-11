package com.sapient.healthyreps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.healthyreps.dao.AnswerDAO;
import com.sapient.healthyreps.entity.Answer;

@RestController

public class AnswerController {

	@Autowired
	AnswerDAO answerDAO;

//	@GetMapping
//	public String health() {
//		return "Welcome to healthyreps blog and QnA Homepage!";
//	}

	
	@PostMapping("question/{qid}/answers")
	public boolean postAnswer(@RequestBody Answer answer )
	{
		 return  answerDAO.insertAnswer(answer);
	}
	@GetMapping("question/{qid}/answers/{id}")
	public Answer getAnswerbyID(@PathVariable int id) {

		return answerDAO.getAnswerByAnswerID(id);

	}
	@GetMapping("question/{qid}/answers")
	public List<Answer> getAllAnswersByQuestionID(@PathVariable int qid) {

		return answerDAO.getAllAnswersASC(qid);

	}
	
	@PutMapping("question/{qid}/answers/{id}")
	public boolean updateAnswer(@RequestBody Answer answer) {
		
		return answerDAO.updateAnswerByAnswerID(answer);
		
	}
	
	@DeleteMapping("question/{qid}/answers/{id}")
	public boolean deleteAnswerByAnswerId(@PathVariable int id) {
		return answerDAO.deleteAnswer(id);
	}
	
	
}