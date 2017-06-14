package com.tasklist.tests;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tasklist.dao.contracts.UserDAO;
import com.tasklist.model.User;
import com.tasklist.services.dto.UserDTO;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GetUserFromCookieTest {
	private static final Logger LOG = LogManager.getLogger(GetUserFromCookieTest.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private ModelMapper mapper;
	
	@Test
	public void test(){
		String var ="594127e77c2f250f5482193a";
		List<User> users = userDAO.findAll();
		User user = userDAO.findOne(new ObjectId(var));
		LOG.info(user.toString());
		mapper.map(user, UserDTO.class);
	}
}
