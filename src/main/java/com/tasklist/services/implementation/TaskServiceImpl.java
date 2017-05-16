package com.tasklist.services.implementation;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.tasklist.model.Task;
import com.tasklist.services.contracts.TaskService;

public class TaskServiceImpl implements TaskService{

	@Override
	public Task getTaskById(ObjectId id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksByUserId(ObjectId userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTaskByCompletion(boolean completed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTaskByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		
	}

}
