package com.tasklist.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Task {

	@Id
	private ObjectId id;
	private String name;
	private Calendar startDate;
	private boolean isCompleted;
	@DBRef
	private User user;
	@DBRef
	private Project project;

	public Task() {// NOSONAR

	}

	public Task(String name, GregorianCalendar start) {
		this.name = name;
		this.startDate = start;
	}

	public Task(String name) {
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

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Date getTaskTime() {
		return startDate.getTime();
	}

	public void setTaskTime(Date date) {
		startDate.setTime(date);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Id " + id + " name " + name + " startDate " + startDate.getTime()
				+ " isCompleted " + isCompleted;// + " user "+ user.getId();
	}

}
