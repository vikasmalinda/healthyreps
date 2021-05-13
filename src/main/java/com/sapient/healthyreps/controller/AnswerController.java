package com.sapient.healthyreps.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.sapient.healthyreps.exception.InvalidID;
import com.sapient.healthyreps.utils.DbConnect;

@RestController

public class AnswerController {

	@Autowired
	AnswerDAO answerDAO;



	@PostMapping("question/{qid}/answers")
	public boolean postAnswer(@RequestBody Answer answer ,@PathVariable int qid)
	{
		try {
			checkQuestionID(qid);
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return false;
		} 
		
		return  answerDAO.insertAnswer(answer);
	}
	@GetMapping("question/{qid}/answers/{id}")
     public Answer getAnswerbyID(@PathVariable int id) {

		try {
			checkID(id);
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return null;
		}
		
		
		return answerDAO.getAnswerByAnswerID(id);

	}
	@GetMapping("question/{qid}/answers/order/{ord}")
	public List<Answer> getAllAnswersByQuestionID(@PathVariable int qid,@PathVariable String ord) {

		try {
			checkQuestionID(qid);
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return null;
		} 
		
		
		return answerDAO.getAllAnswersByQuestionID(qid,ord);

	}
	
	
	
	@PutMapping("question/{qid}/answers/{id}")
	public boolean updateAnswer(@RequestBody Answer answer,@PathVariable int id) {
		
		try {
			checkID(id);
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return false;
		}
		
		return answerDAO.updateAnswerByAnswerID(answer);
		
	}
	
	@DeleteMapping("question/{qid}/answers/{id}")
	public boolean deleteAnswerByAnswerId(@PathVariable int id) {
		try {
			checkID(id);
		} catch (InvalidID e1) {
			e1.printStackTrace();
			return false;
		}
		
		
		
		return answerDAO.deleteAnswer(id);
	}
	
	
	
	private void checkID(int ID) throws InvalidID {
		String sqlForException = "SELECT AnswerID,Description,Votes,ModifiedAt,QuestionID,UserID,Reliability FROM answer WHERE AnswerID=?";
		try {
			PreparedStatement psException = DbConnect.getMySQLConn().prepareStatement(sqlForException);
			psException.setInt(1, ID);
			ResultSet rs = psException.executeQuery();
			if (!rs.next()) {
				throw new InvalidID("Answer");
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	private void checkQuestionID(int questionID) throws InvalidID {
		

		String sqlForException = "SELECT QuestionID,title,description,votes,modifiedAt,categoryID,userID,imageLink,reliability FROM question WHERE QuestionID=?";
		try {
			PreparedStatement psException = DbConnect.getMySQLConn().prepareStatement(sqlForException);
			psException.setInt(1, questionID);
			ResultSet rs = psException.executeQuery();
			if (!rs.next()) {
				throw new InvalidID("Question");
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

	}
	
	
}