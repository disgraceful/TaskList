package com.tasklist.services.contracts;

import java.util.List;

import org.bson.types.ObjectId;

import com.tasklist.services.dto.UserDTO;
import com.tasklist.services.requestmodels.UserRegisterReqModel;

public interface UserService {
	UserDTO getUser(ObjectId id);
	UserDTO getUserByLogin(String login);
	List<UserDTO>getUsers();
	UserDTO createUser(UserRegisterReqModel model);
	UserDTO updateUser(UserDTO user);
	void deleteUser(ObjectId id);
	
}
