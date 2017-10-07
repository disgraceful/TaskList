package com.tasklist.tests;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tasklist.dao.contracts.ProjectDAO;
import com.tasklist.dao.contracts.TaskDAO;
import com.tasklist.dao.contracts.UserDAO;
import com.tasklist.model.Project;
import com.tasklist.model.Task;
import com.tasklist.model.User;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ObjectRelationsTest {
	@Autowired
	private TaskDAO taskDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private ProjectDAO projectDAO;

	@Before
	public void before() {
		taskDAO.deleteAll();
		userDAO.deleteAll();
		projectDAO.deleteAll();
	}

	@Test
	public void testRelationships() {
		User user = new User();
		Task task = new Task();
		Project proj = new Project();
		System.out.println(user.getId());
		ObjectId taskId = taskDAO.save(task).getId();
		ObjectId id1 = userDAO.save(user).getId();
		user.addTask(task);
		ObjectId id2 = userDAO.save(user).getId();
		System.out.println(userDAO.findOne(id2).getTasks().size());
		Task t1 = taskDAO.findOne(taskId);
		System.out.println(t1.getUser().getId());
		
		//userDAO.findOne(id).getTasks().forEach(e -> System.out.println(e.getId()));
		//userDAO.findOne(id).getTasks().forEach(e -> System.out.println(e.getUser().getId()));

	}
}
