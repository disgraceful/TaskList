package com.tasklist.services.exceptions;

import org.springframework.http.HttpStatus;

public class TaskListGenericException extends RuntimeException {
	private HttpStatus code;
	private String message;

	public TaskListGenericException() {
		super();
	}

	public TaskListGenericException(HttpStatus code, String message) {
		super(message);
		this.code = code;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
