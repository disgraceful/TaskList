package com.tasklist.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasklist.dao.contracts.UserDAO;
import com.tasklist.model.Project;
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
	@Transactional
	public UserDTO getUserAsDTO(ObjectId id) {
		User user = userDAO.findOne(id);
		LOG.info(user.toString());
		return mapper.map(user, UserDTO.class);
	}
	
	@Override
	@Transactional
	public User getUserAsPOJO(ObjectId id) {
		return userDAO.findOne(id);
	}

	@Override
	@Transactional
	public UserDTO getUserByLoginAsDTO(String login) {
		return mapper.map(userDAO.findUserByLogin(login), UserDTO.class);
	}
	
	@Override
	@Transactional
	public User getUserByLoginAsPOJO(String login) {
		return userDAO.findUserByLogin(login);
	}

	@Override
	@Transactional
	public List<UserDTO> getUsersAsDTO() {
		return userDAO.findAll().stream().map(f -> mapper.map(f, UserDTO.class)).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public List<User> getUsersAsPOJO() {
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public UserDTO createUser(UserRegisterReqModel model) {
		User user = new User(model.getLogin(), model.getPassword());
		user.addProject(new Project("Personal"));
		user.addProject(new Project("Work"));
		user.addProject(new Project("Shopping"));
		user.addProject(new Project("Movies to watch"));
		return mapper.map(userDAO.save(user), UserDTO.class);
	}
	
	@Override
	@Transactional
	public UserDTO updateUser(UserDTO user) {
		User userToUpdate = userDAO.findOne(user.getId());
		userToUpdate.setLogin(user.getLogin());
		return mapper.map(userDAO.save(userToUpdate), UserDTO.class);
	}

	@Override
	@Transactional
	public void deleteUser(ObjectId id) {
		userDAO.delete(id);
	}

}
