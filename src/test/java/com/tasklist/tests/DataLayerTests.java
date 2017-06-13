package com.tasklist.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tasklist.dao.contracts.TaskDAO;
import com.tasklist.dao.contracts.UserDAO;
import com.tasklist.model.Task;
import com.tasklist.model.User;

@RunWith(SpringRunner.class)
@DataMongoTest
public class DataLayerTests {

	@Autowired
	private TaskDAO taskDAO;

	@Autowired
	private UserDAO userDAO;

	@Test
	public void testTaskDAO() {
		taskDAO.deleteAll();
		userDAO.deleteAll();
		Task task1 = new Task("Do stuff 1");
		task1.setTaskDescription("I have to do a very important stuff!");
		Task task2 = new Task("Do stuff 2");
		task1.setTaskDescription("I have to do a very important stuff!");
		Task task3 = new Task("Do stuff 3");
		task1.setTaskDescription("I have to do a very important stuff!");

		User user = new User("lol", "xd");
		task1.setUser(user);
		task1.setCompleted(true);
		task1.setStartDate(new GregorianCalendar(2015,0,31));
		List<Task> tasks = new ArrayList<Task>() {
			{
				add(task1);
				add(task2);
				add(task3);
			}
		};
		userDAO.save(user);
		taskDAO.save(tasks);
		tasks = taskDAO.findAll();
		tasks.forEach(e -> System.out.println(e.toString()));
		List<Task>userTasks =taskDAO.findTaskByStartDate(new GregorianCalendar(2015,0,31));
		userTasks.forEach(e -> System.out.println(e.toString()));
	}
	
	
}

