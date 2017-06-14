package com.tasklist.services.contracts;

import java.util.List;

import org.bson.types.ObjectId;

import com.tasklist.model.User;
import com.tasklist.services.dto.UserDTO;
import com.tasklist.services.requestmodels.UserRegisterReqModel;

public interface UserService {
	UserDTO getUserAsDTO(ObjectId id);

	UserDTO getUserByLoginAsDTO(String login);

	UserDTO createUser(UserRegisterReqModel model);

	UserDTO updateUser(UserDTO user);

	void deleteUser(ObjectId id);

	List<User> getUsersAsPOJO();

	List<UserDTO> getUsersAsDTO();

	User getUserByLoginAsPOJO(String login);

	User getUserAsPOJO(ObjectId id);
}
