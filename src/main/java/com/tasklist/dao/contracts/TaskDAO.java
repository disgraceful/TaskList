package com.tasklist.dao.contracts;

import java.util.Calendar;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasklist.model.Task;
import com.tasklist.model.User;

public interface TaskDAO extends MongoRepository<Task, ObjectId> {
	List<Task> findTaskByUser(User user);
	List<Task> findTaskByStartDate(Calendar date);
	List<Task> findTaskByIsCompleted(boolean isCompleted);
}
