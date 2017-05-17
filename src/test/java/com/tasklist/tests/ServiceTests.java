package com.tasklist.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tasklist.dao.contracts.UserDAO;
import com.tasklist.services.contracts.UserService;
import com.tasklist.services.dto.UserDTO;
import com.tasklist.services.requestmodels.UserRegisterReqModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

	private Logger LOG = LogManager.getLogger(MapperTests.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserDAO userDAO;

	private UserDTO userDTO;

	@Before
	public void init() {
		userDAO.deleteAll();
	}

	@Test
	public void testUserServiceCreate() {
		UserRegisterReqModel model = new UserRegisterReqModel();
		model.setLogin("hehe");
		model.setPassword("eksdeee");
		model.setConfirmPassword("eksdeee");
		userDTO = userService.createUser(model);
		//LOG.info(userDTO.toString());
	}

	@Test
	public void testUserServiceUpdate(){
		UserRegisterReqModel model = new UserRegisterReqModel();
		model.setLogin("hehe");
		model.setPassword("eksdeee");
		model.setConfirmPassword("eksdeee");
		userDTO = userService.createUser(model);
		LOG.info(userDTO.toString());
		userDTO.setLogin("Nazarpidor");
		ObjectId id = userDTO.getId();
		userService.updateUser(userDTO);
		UserDTO newUser = userService.getUser(id);
		LOG.info(newUser.toString());
		LOG.info(userDTO.toString());
		LOG.info(userService.getUsers().size());
	}

}
