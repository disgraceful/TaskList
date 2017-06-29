package com.tasklist.services.dto;

import java.util.Calendar;
import java.util.Date;

import org.bson.types.ObjectId;

public class TaskDTO {
	private ObjectId id;
	private String name;
	private Calendar startDate;
	private boolean isCompleted;
	private ObjectId userId;

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

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Id " + id + " name " + name + " date " + startDate.getTime() + " completed "
				+ isCompleted + " userId " + userId;
	}
}
