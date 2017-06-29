package com.tasklist.tests;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
import com.tasklist.model.Task;
import com.tasklist.services.contracts.UserService;
import com.tasklist.services.dto.UserDTO;
import com.tasklist.services.requestmodels.UserRegisterReqModel;
import com.tasklist.services.utils.DateUtils;

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
		// LOG.info(userDTO.toString());
	}

	@Test
	public void testUserServiceUpdate() {
		UserRegisterReqModel model = new UserRegisterReqModel();
		model.setLogin("hehe");
		model.setPassword("eksdeee");
		model.setConfirmPassword("eksdeee");
		userDTO = userService.createUser(model);
		LOG.info(userDTO.toString());
		userDTO.setLogin("Nazarpidor");
		ObjectId id = userDTO.getId();
		userService.updateUser(userDTO);
		UserDTO newUser = userService.getUserAsDTO(id);
		LOG.info(newUser.toString());
		LOG.info(userDTO.toString());
	}

	@Test
	public void testGetTasksForToday() {
		Task task = new Task("Lol", new GregorianCalendar(2017, 5, 15));
		LOG.info("date" + DateUtils.isToday(task.getStartDate()));
	}

	@Test
	public void testGetTasksForWeek() {
		Task task = new Task("Lol", new GregorianCalendar(2017, 5, 15));
		Task task2 = new Task("Lol", new GregorianCalendar(2017, 5, 21));
		Task task3 = new Task("Lol", new GregorianCalendar(2017, 5, 23));
		LOG.info("task1 + " + DateUtils.isWithinDaysFuture(task.getStartDate(), 6));
		LOG.info("task2 + " + DateUtils.isWithinDaysFuture(task2.getStartDate(), 6));
		LOG.info("task3 + " + DateUtils.isWithinDaysFuture(task3.getStartDate(), 6));
	}

}
