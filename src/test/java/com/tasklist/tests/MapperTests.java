package com.tasklist.tests;

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
public class MapperTests {

	private Logger LOG = LogManager.getLogger(MapperTests.class);
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private TaskDAO taskDAO;

	@Autowired
	private ProjectDAO projectDAO;

	private User user;
	private UserDTO userDTO;

	private Task task;
	private TaskDTO taskDTO;

	private Project project;
	private ProjectDTO projectDTO;

	@Before
	public void init() {
		userDAO.deleteAll();
		user = new User("lol", "xd");
		task = new Task("LoL", new GregorianCalendar(2014, 3, 15));
		project = new Project("Luuuuuul");

		user.addTask(task);
		user.addProject(project);

		user = userDAO.save(user);
		project = projectDAO.save(project);
		task = taskDAO.save(task);
	}

	@Test
	public void testUserMapping() {
		LOG.info("user " + user.toString());
		userDTO = mapper.map(user, UserDTO.class);
		LOG.info("dto " + userDTO.toString());
		user = mapper.map(userDTO, User.class);
		LOG.info("user " + user.toString());
	}
	
	@Test
	public void testTaskMapping() {
		LOG.info("task " + task.toString());
		taskDTO = mapper.map(task, TaskDTO.class);
		taskDTO.setStartDate(task.getStartDate());
		LOG.info("dto " + taskDTO.toString());
		task = mapper.map(taskDTO, Task.class);
		task.setStartDate(taskDTO.getStartDate());
		LOG.info("task " + task.toString());
	}

	@Test
	public void testProjectMapping() {
		LOG.info("project " + project.toString());
		projectDTO = mapper.map(project, ProjectDTO.class);
		LOG.info("projectDTO " + projectDTO.toString());
		project = mapper.map(projectDTO, Project.class);
		LOG.info("project " + project.toString());
	}

}
