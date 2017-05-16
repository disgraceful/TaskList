package com.tasklist.services.contracts;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.tasklist.model.Task;

public interface TaskService {
	Task getTaskById(ObjectId id);
	List<Task> getAllTasks();
	List<Task>getTasksByUserId(ObjectId userId);
	List<Task>getTaskByCompletion(boolean completed);
	List<Task>getTaskByDate(Date date);
	Task createTask(Task task);
	Task updateTask(Task task);
	void deleteTask(Task task);
	
}
