package com.tasklist.services.contracts;

import java.util.List;

import org.bson.types.ObjectId;

import com.tasklist.model.User;
import com.tasklist.services.dto.UserDTO;

public interface UserService {
	UserDTO getUser(ObjectId id);
	UserDTO getUserByLogin(String login);
	List<UserDTO>getUsers();
	UserDTO createUser(User user);
	UserDTO updateUser(User user);
	void deleteUser(User user);
}
