package com.tasklist.tests;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tasklist.dao.contracts.TaskDAO;
import com.tasklist.model.Task;

@RunWith(SpringRunner.class)
@DataMongoTest
public class DataLayerTests {

	@Autowired
	private TaskDAO taskDAO;
	
	@Test
	public void testTaskDAO(){
		taskDAO.deleteAll();
		Task task = new Task("Do stuff",new Date());
		task.setTaskDescription("I have to do a very important stuff!");
		taskDAO.save(task);
		taskDAO.
		System.out.println(task.toString());
	}
}
