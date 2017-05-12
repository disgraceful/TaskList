package com.tasklist.dao.contracts;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasklist.model.User;

public interface UserDAO extends MongoRepository<User,Long> {
	User findUserByLogin(String login);
}
