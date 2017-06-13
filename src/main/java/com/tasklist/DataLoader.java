package com.tasklist;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.tasklist.dao.contracts.ProjectDAO;
import com.tasklist.dao.contracts.TaskDAO;
import com.tasklist.dao.contracts.UserDAO;
import com.tasklist.model.Project;
import com.tasklist.model.Task;
import com.tasklist.model.User;

@Component
public class DataLoader implements ApplicationRunner {
	private static final Logger LOG = LogManager.getLogger(DataLoader.class);

	private UserDAO userDAO;
	private ProjectDAO projDAO;
	private TaskDAO taskDAO;

	@Autowired
	public DataLoader(UserDAO userDAO, ProjectDAO projDAO, TaskDAO taskDAO) {
		this.userDAO = userDAO;
		this.projDAO = projDAO;
		this.taskDAO = taskDAO;
	}

	@Override
	public void run(ApplicationArguments args) {
		userDAO.deleteAll();
		projDAO.deleteAll();
		taskDAO.deleteAll();
		User user1 = new User("example@gmail.com", "pass123");
		User user2 = new User("developer@gmail.com", "pass123");

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
		userDAO.save(user1);
		userDAO.save(user2);
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
		taskDAO.save(task8);
		taskDAO.save(task9);
		taskDAO.save(task10);
	}
}
