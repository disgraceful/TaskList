package com.tasklist.dao.contracts;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasklist.model.User;

public interface UserDAO extends MongoRepository<User,ObjectId> {
	User findUserByLogin(String login);
}
