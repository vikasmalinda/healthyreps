package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Question;

// contracts 
public interface IQuestionDAO {
	
	public boolean insertQuestion(Question question); 
	public List<Question> getAllQuestion(); 
	public Question getQuestion(int questionID); 
}
