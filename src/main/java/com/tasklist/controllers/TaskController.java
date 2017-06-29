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
	private static final Logger LOG = LogManager.getLogger(TaskServiceImpl.class);

	@Autowired
	private TaskService taskService;

	@GetMapping("/tasks/today")
	public ResponseEntity<?>getTasksToday(){
//		String json = "<ul class='mycontent'>";
//		for(TaskDTO task :taskService.getTasksForToday()){
//			json+="<li><a style='padding: 15px;'>"+task.getName()+"</a><div id='icon_con' class='icon_container'><a style='padding: 0px; display: inline-block'><i class='material-icons right'>mode_edit</i></a><a style='padding: 0px; display: inline-block'><i class='material-icons right'>delete</i></a></div></li>";
//		}
//		json+="</ul>";
		return new ResponseEntity<>(taskService.getTasksForToday(),HttpStatus.OK);
	}

	@GetMapping("/tasks/week")
	public ResponseEntity<?> getTasksThisWeek() {
		return new ResponseEntity<>(taskService.getTasksForWeek(), HttpStatus.OK);
	}

	@GetMapping("/tasks/proj/{id}")
	public ResponseEntity<?> getTasksByProjectId(@PathVariable String id) {
		return new ResponseEntity<>(taskService.getTaskByProjectId(new ObjectId(id)), HttpStatus.OK);
	}

}
