package com.tasklist.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private ObjectId id;

	@Indexed(unique = true)
	private String login;
	private String password;
	private List<Task> tasks = new ArrayList<>();
	private List<Project> projects = new ArrayList<>();

	public User() {
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void addTask(Task task) {
		if (!tasks.contains(task)) {
			tasks.add(task);
			task.setUser(this);
			
		}
	}

	public void deleteTask(Task task) {
		if (tasks.contains(task)) {
			tasks.remove(task);
			task.setUser(null);
		}
	}

	public void addProject(Project project) {
		if (!projects.contains(project)) {
			projects.add(project);
		}
	}

	public void deleteProject(Project project) {
		if (projects.contains(project)) {
			projects.remove(project);
		}
	}

	@Override
	public String toString() {
		return "Id " + id + " login " + login + " password " + password;
	}

}
