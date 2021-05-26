package com.sapient.healthyreps.entity;


public class Question {
	private int question_id;
	private String title; 
	private String description; 
	private int votes;
	private String modified_at;
	private int category_id;
	private int user_id;
	private String image_link;
	private int reliability;
	
	public Question() {
		// throw exception here as there are no parameters for constructors passed for
		// the Question class.
	}

	public Question(int question_id, String title, String description, int votes, String modified_at, int category_id,
			int user_id, String image_link, int reliability) {
		super();
		this.question_id = question_id;
		this.title = title;
		this.description = description;
		this.votes = votes;
		this.modified_at = modified_at;
		this.category_id = category_id;
		this.user_id = user_id;
		this.image_link = image_link;
		this.reliability = reliability;
	}

	public int getquestionId() {
		return question_id;
	}

	public void setquestionId(int question_id) {
		this.question_id = question_id;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public String getModifiedAt() {
		return modified_at;
	}

	public void setModifiedAt(String modified_at) {
		this.modified_at = modified_at;
	}

	public int getCategoryID() {
		return category_id;
	}

	public void setCategoryID(int category_id) {
		this.category_id = category_id;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public String getImageLink() {
		return image_link;
	}

	public void setImageLink(String image_link) {
		this.image_link = image_link;
	}

	public int getReliability() {
		return reliability;
	}

	public void setReliability(int reliability) {
		this.reliability = reliability;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", title=" + title + ", description=" + description + ", votes="
				+ votes + ", modified_at=" + modified_at + ", category_id=" + category_id + ", user_id="
				+ user_id
				+ ", image_link=" + image_link + ", reliability=" + reliability + "]";
	}
	
	
	
}
