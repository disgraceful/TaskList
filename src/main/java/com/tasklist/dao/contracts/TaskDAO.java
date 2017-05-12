package com.tasklist.dao.contracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasklist.model.Task;
import com.tasklist.model.User;

public interface TaskDAO extends MongoRepository<Task, Long> {
	List<Task> findByUser(User user);
	List<Task> findByDate(Date date);
	List<Task> findByCompletion(boolean isCompleted);
}
