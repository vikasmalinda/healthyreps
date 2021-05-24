package com.sapient.healthyreps.entity;

public class Workout {

	private int workoutId;
	private int userId;
	private int day;
	private String time;
	private int sets;
	private int reps_per_set;
	private String description;

	public int getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps_per_set() {
		return reps_per_set;
	}

	public void setReps_per_set(int reps_per_set) {
		this.reps_per_set = reps_per_set;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Workout(int workoutId, int userId, int day, String time, int sets, int reps_per_set, String description) {
		super();
		this.workoutId = workoutId;
		this.userId = userId;
		this.day = day;
		this.time = time;
		this.sets = sets;
		this.reps_per_set = reps_per_set;
		this.description = description;
	}

	public Workout() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "user [workoutId=" + workoutId + ", userId=" + userId + ", day=" + day + ", time=" + time + ", sets="
				+ sets + ", reps_per_set=" + reps_per_set + ", description=" + description + "]";
	}

}
