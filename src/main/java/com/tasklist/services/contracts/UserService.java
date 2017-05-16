package com.tasklist.services.contracts;

import java.util.List;

import org.bson.types.ObjectId;

import com.tasklist.model.User;

public interface UserService {
	User getUser(ObjectId id);
	User getUserByLogin(String login);
	List<User>getUsers();
	User createUser(User user);
	User updateUser(User user);
	void deleteUser(User user);
}
