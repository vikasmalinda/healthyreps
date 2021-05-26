package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Answer;

// contracts 
public interface IAnswerDAO {
	
	public boolean insertAnswer(Answer answer); 
	public List<Answer> getAllAnswersByQuestionID(int question_id,String order); 
	public boolean deleteAnswer(int answer_id);
	public boolean deleteAnswersByQuestionID(int question_id);
	public boolean updateAnswerByAnswerID(Answer answer);
	public Answer getAnswerByAnswerID(int answer_id);
}
