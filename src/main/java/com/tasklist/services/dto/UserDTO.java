package com.tasklist.services.dto;

import org.bson.types.ObjectId;

public class UserDTO {
	private ObjectId id;
	private String login;
	
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
	
	@Override
	public String toString() {
		return "Id " + id + " login " + login;
	}
}
