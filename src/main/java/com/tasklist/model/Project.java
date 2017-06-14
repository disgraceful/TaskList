package com.tasklist.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Project {
	@Id
	private ObjectId id;
	@Indexed(unique = true)
	private String name;
	private List<Task> tasks;
	@DBRef
	private User user;

	public Project() {
		tasks = new ArrayList<>(); 
	}

	public Project(String name) {
		this();
		this.name = name;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addTask(Task task) {
		if (!tasks.contains(task)) {
			tasks.add(task);
		}
	}

	public void deleteTask(Task task) {
		if (tasks.contains(task)) {
			tasks.remove(task);
		}

	}

	@Override
	public String toString() {
		return "Id " + id + " name " + name + " userId " + user.getId();
	}

}
