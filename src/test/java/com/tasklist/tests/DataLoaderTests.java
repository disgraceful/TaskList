package com.tasklist.tests;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tasklist.dao.contracts.ProjectDAO;
import com.tasklist.dao.contracts.TaskDAO;
import com.tasklist.dao.contracts.UserDAO;
import com.tasklist.model.Project;
import com.tasklist.model.Task;
import com.tasklist.model.User;
import com.tasklist.services.dto.ProjectDTO;
import com.tasklist.services.dto.TaskDTO;
import com.tasklist.services.dto.UserDTO;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataLoaderTests {

	private Logger LOG = LogManager.getLogger(DataLoaderTests.class);
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private TaskDAO taskDAO;

	@Autowired
	private ProjectDAO projDAO;

	private User user;
	private UserDTO userDTO;

	private Task task;
	private TaskDTO taskDTO;

	private Project project;
	private ProjectDTO projectDTO;

	@Before
	public void init() {
		userDAO.deleteAll();
		projDAO.deleteAll();
		taskDAO.deleteAll();
		User user1 = new User("example@gmail.com", "pass123");

		Project project1 = new Project("Personal");
		Project project2 = new Project("Work");
		Project project3 = new Project("Shopping");
		Project project4 = new Project("Movies to watch");

		Task task1 = new Task("Wash my car!", new GregorianCalendar(2017, 5, 13));
		Task task2 = new Task("Call my mom!", new GregorianCalendar(2017, 5, 13));
		Task task3 = new Task("Kill myself!", new GregorianCalendar(2017, 5, 15));
		Task task4 = new Task("Run every morning!");
		Task task5 = new Task("Learn Spring MVC!", new GregorianCalendar(2017, 7, 28));
		Task task6 = new Task("Bee positive, bee yourself, bee happy!");
		Task task7 = new Task("Watch Guardians of the Galaxy vol. 2 (It's awesome!)");
		
		
		user1.addProject(project1);
		user1.addProject(project2);
		user1.addProject(project3);
		user1.addProject(project4);
		user1.setTasks(new ArrayList<Task>() {
			{
				add(task1);
				add(task2);
				add(task3);
				add(task4);
				add(task5);
				add(task6);
				add(task7);
			}
		});
		project1.addTask(task4);
		project1.addTask(task6);
		project3.addTask(task7);
		user = userDAO.save(user1);
		projDAO.save(project1);
		projDAO.save(project2);
		projDAO.save(project3);
		taskDAO.save(task1);
		taskDAO.save(task2);
		taskDAO.save(task3);
		taskDAO.save(task4);
		taskDAO.save(task5);
		taskDAO.save(task6);
		taskDAO.save(task7);

	}

	@Test
	public void testUser() {
		LOG.info("user " + user.toString());
		userDTO = mapper.map(user, UserDTO.class);
		LOG.info("dto " + userDTO.toString());
		user = mapper.map(userDTO, User.class);
		LOG.info("user " + user.toString());
	}

	
}
