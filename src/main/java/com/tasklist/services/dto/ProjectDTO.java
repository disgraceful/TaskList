package com.tasklist.services.dto;

import org.bson.types.ObjectId;

public class ProjectDTO {
	private ObjectId id;
	private String name;
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

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Id " + id + " name " + name + " userId " + userId;
	}

}
