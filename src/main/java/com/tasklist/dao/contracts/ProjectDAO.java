package com.tasklist.dao.contracts;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasklist.model.Project;
import com.tasklist.model.User;

public interface ProjectDAO extends MongoRepository<Project,ObjectId>{
	List<Project>findProjectsByUser(User user);
}
