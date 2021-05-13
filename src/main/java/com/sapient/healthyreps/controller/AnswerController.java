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

	@PostMapping("question/{qid}/answer")
	public boolean insertAnswer(@RequestBody Answer answer )
	{
		 return  answerDAO.insertAnswer(answer);
	}
	@GetMapping("question/{qid}/answer/{aid}")
     public Answer getAnswerbyID(@PathVariable int aid) {

		return answerDAO.getAnswerByAnswerID(aid);

	}
	
	@GetMapping("question/{qid}/answer/sortBy/{sortType}")
	public List<Answer> getAllAnswers(@PathVariable int qid,@PathVariable String sortType) {

		return answerDAO.getAllAnswers(qid,sortType);

	}
	
	@PutMapping("question/{qid}/answer/{aid}")
	public boolean updateAnswer(@RequestBody Answer answer) {
		
		return answerDAO.updateAnswerByAnswerID(answer);
		
	}
	
	@DeleteMapping("question/{qid}/answer/{aid}")
	public boolean deleteAnswerByAnswerId(@PathVariable int aid) {
		return answerDAO.deleteAnswer(aid);
	}
}