package com.sapient.healthyreps.interfaces;

import java.util.List;

import com.sapient.healthyreps.entity.Question;

// contracts 
public interface IQuestionDAO {

	public boolean insertQuestion(Question question);

	public List<Question> getAllQuestion();

	public int getquestionidoflastRow();

	public Question getquestionfromquestionId(int questionidsearch);

	public List<Question> getallquestionsfromuserId(int useridsearch);

	public List<Question> getallquestionsfromuseridbyvotesASC(int useridsearchasc, String ord);

//	public List<Question> getallquestionsfromuseridbyvotesDEC(int useridsearchdec);
//	public List<Question> getallquestionsfromuseridorderbyreputationASC(int useridsearchasc);  //sort by reputation asc
//	public List<Question> getallquestionsfromuseridorderbyreputationDEC(int useridsearchdec);  //sort by reputation des

	public List<Question> getallquestionsfromcategoryId(int categoryidsearch); // sort by time

	public List<Question> getallquestionsfromcategoryidorderbyvotesASC(int categoryidsearchasc, String ord); // sort by
																												// votes
	// ascending

//	public List<Question> getallquestionsfromcategoryidorderbyvotesDEC(int categoryidsearchdec); // sort by votes desc

	public List<Question> getallquestionsfromcategoryidorderbyreputationASC(int categoryidsearchasc, String ord); // sort
																													// by
	// reputation
	// asc

//	public List<Question> getallquestionsfromcategoryidorderbyreputationDEC(int categoryidsearchdec); // sort by
	// reputation
	// desc4

	public boolean deletequestionsfromquestionid(int questioniddel);

	public boolean updatequestionfromquestionid(Question question, int question_id);
}
