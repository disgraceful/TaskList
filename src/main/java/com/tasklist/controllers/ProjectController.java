package com.tasklist.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tasklist.services.contracts.TaskService;

public class ProjectController {
	private static final Logger LOG = LogManager.getLogger(ProjectController.class);

	@Autowired
	private TaskService taskService;
	
	@GetMapping("/proj/{id}/tasks")
	public ResponseEntity<?> getTasksByProjectId(@PathVariable String id) {
		LOG.info("id"+ id);
		return new ResponseEntity<>(taskService.getTaskByProjectId(new ObjectId(id)), HttpStatus.OK);
	}
}
