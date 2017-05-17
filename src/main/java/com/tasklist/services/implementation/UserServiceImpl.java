package com.tasklist.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasklist.dao.contracts.UserDAO;
import com.tasklist.model.User;
import com.tasklist.services.contracts.UserService;
import com.tasklist.services.dto.UserDTO;
import com.tasklist.services.requestmodels.UserRegisterReqModel;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDTO getUser(ObjectId id) {
		return mapper.map(userDAO.findOne(id), UserDTO.class);
	}

	@Override
	public UserDTO getUserByLogin(String login) {
		return mapper.map(userDAO.findUserByLogin(login), UserDTO.class);
	}

	@Override
	public List<UserDTO> getUsers() {
		return userDAO.findAll().stream().map(f -> mapper.map(f, UserDTO.class)).collect(Collectors.toList());
	}

	@Override
	public UserDTO createUser(UserRegisterReqModel model) {
		if (validateReqMoedl(model)) {
			User user = new User(model.getLogin(), model.getPassword());
			return mapper.map(userDAO.save(user), UserDTO.class);
		}
		return new UserDTO();
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		User userToUpdate = userDAO.findOne(user.getId());
		userToUpdate.setLogin(user.getLogin());
		return mapper.map(userDAO.save(userToUpdate), UserDTO.class);
	}

	@Override
	public void deleteUser(ObjectId id) {
		userDAO.delete(id);
	}

	private boolean validateReqMoedl(UserRegisterReqModel model) {
		if (model.getLogin().isEmpty() || model.getLogin() == null) {
			return false;
		}
		return model.getConfirmPassword().trim().equals(model.getPassword().trim());
	}
}
