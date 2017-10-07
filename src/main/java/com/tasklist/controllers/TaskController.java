package com.tasklist.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tasklist.services.contracts.TaskService;
import com.tasklist.services.dto.TaskDTO;
import com.tasklist.services.implementation.TaskServiceImpl;

@RestController
public class TaskController {
	private static final Logger LOG = LogManager.getLogger(TaskController.class);

	@Autowired
	private TaskService taskService;

	@GetMapping("/tasks/today")
	public ResponseEntity<?>getTasksToday(){
		return new ResponseEntity<>(taskService.getTasksForToday(),HttpStatus.OK);
	}

	@GetMapping("/tasks/week")
	public ResponseEntity<?> getTasksThisWeek() {
		return new ResponseEntity<>(taskService.getTasksForWeek(), HttpStatus.OK);
	}
}
