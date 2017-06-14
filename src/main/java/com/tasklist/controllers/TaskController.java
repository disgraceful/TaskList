package com.tasklist.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tasklist.services.contracts.TaskService;
import com.tasklist.services.contracts.UserService;
import com.tasklist.services.dto.TaskDTO;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/tasks/{id}/user")
	public List<TaskDTO>getTasksByUserId(@PathVariable ObjectId id){
		return taskService.getTasksByUserId(id);
	}
}
