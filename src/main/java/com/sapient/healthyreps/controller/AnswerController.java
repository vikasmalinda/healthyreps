package com.sapient.healthyreps.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.healthyreps.dao.AnswerDAO;
import com.sapient.healthyreps.dao.PermissionDAO;
import com.sapient.healthyreps.entity.Answer;
import com.sapient.healthyreps.exception.InvalidID;

@RestController

public class AnswerController {

	@Autowired
	AnswerDAO answerDAO;
	PermissionDAO permissionDAO;

	@PostMapping("question/{qid}/answer")
	public boolean insertAnswer(@RequestBody Answer answer, @PathVariable int qid) {
		try {
			permissionDAO.isIDPresent(qid, "question");
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return false;
		}

		return answerDAO.insertAnswer(answer);
	}

	@GetMapping("question/{qid}/answer/{aid}")
	public Answer getAnswerbyID(HttpServlet response, @PathVariable int aid) {

		try {
			permissionDAO.isIDPresent(aid, "answer");
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return null;
		}

		return answerDAO.getAnswerByAnswerID(aid);

	}

	@GetMapping("question/{qid}/answer/order/{ord}")
	public List<Answer> getAllAnswersByQuestionID(@PathVariable int qid, @PathVariable String ord) {

		try {
			permissionDAO.isIDPresent(qid, "question");
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return null;
		}

		return answerDAO.getAllAnswersByQuestionID(qid, ord);

	}

	@PutMapping("question/{qid}/answer/{aid}")
	public boolean updateAnswer(@RequestBody Answer answer, @PathVariable int aid) {

		try {
			permissionDAO.isIDPresent(aid, "answer");
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return false;
		}

		return answerDAO.updateAnswerByAnswerID(answer);

	}

	@DeleteMapping("question/{qid}/answer/{aid}")
	public boolean deleteAnswerByAnswerId(@PathVariable int aid) {
		try {
			permissionDAO.isIDPresent(aid, "answer");
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return false;
		}
		return answerDAO.deleteAnswer(aid);
	}
}