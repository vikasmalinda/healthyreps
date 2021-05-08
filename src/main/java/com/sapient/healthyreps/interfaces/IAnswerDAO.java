package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Answer;


// contracts 
public interface IAnswerDAO {
	
	public boolean insertAnswer(Answer answer); 
	public List<Answer> getAllAnswersASC(int QuestionID); 
	public List<Answer> getAllAnswersDESC(int QuestionID); 
	public boolean deleteAnswer(int AnswerID);
	public boolean deleteAnswersByQuestionID(int QuestionID);
	public boolean updateAnswerByAnswerID(Answer answer);
	public int getLatestAnswerID();
	public Answer getAnswerByAnswerID(int AnswerID);
	
	
	
}
