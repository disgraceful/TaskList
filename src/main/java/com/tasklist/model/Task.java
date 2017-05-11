package com.tasklist.model;

import java.util.Date;

public class Task {
	private long id;
	private String name;
	private String taskDescription;
	private Date start;
	private boolean isCompleted;
	
	public Task(){//NOSONAR
		
	}
	
	public Task(String name,Date start){
		this.name = name;
		this.start = start;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
}
