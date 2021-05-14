package com.sapient.healthyreps.interfaces;

import com.sapient.healthyreps.entity.Workout;

public interface IWorkoutDAO {
	public boolean insertWork(Workout workout);

	public boolean deleteWork(int user_id);

	public Workout getSetsReps(int user_id);

}
