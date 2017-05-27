package com.tasklist.services.implementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasklist.dao.contracts.TaskDAO;
import com.tasklist.model.Task;
import com.tasklist.services.contracts.ProjectService;
import com.tasklist.services.contracts.TaskService;
import com.tasklist.services.dto.TaskDTO;
import com.tasklist.services.requestmodels.TaskCreateReqModel;

@Service
public class TaskServiceImpl implements TaskService {

	private static final Logger LOG = LogManager.getLogger(TaskServiceImpl.class);

	@Autowired
	private TaskDAO taskDAO;

	@Autowired
	private ProjectService projService;

	@Autowired
	private ModelMapper mapper;

	@Override
	@Transactional
	public TaskDTO getTaskById(ObjectId id) {
		return mapper.map(taskDAO.findOne(id), TaskDTO.class);
	}

	@Override
	@Transactional
	public List<TaskDTO> getAllTasks() {
		return taskDAO.findAll().stream().map(f -> mapper.map(f, TaskDTO.class)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<TaskDTO> getTasksByUserId(ObjectId userId) {
		return taskDAO.findAll().stream().filter(e -> e.getId().equals(userId)).map(f -> mapper.map(f, TaskDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<TaskDTO> getTaskByCompletion(boolean completed) {
		return taskDAO.findAll().stream().filter(e -> e.isCompleted() == completed)
				.map(f -> mapper.map(f, TaskDTO.class)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<TaskDTO> getTaskByDate(Date date) {
		return taskDAO.findAll().stream().filter(e -> e.getTaskTime().equals(date))
				.map(f -> mapper.map(f, TaskDTO.class)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<TaskDTO> getTaskByProjectId(ObjectId projId) {
		return projService.getProjectByIdAsPOJO(projId).getTasks().stream().map(f -> mapper.map(f, TaskDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public TaskDTO createTask(TaskCreateReqModel model) {
		// TODO validate
		Task task = new Task();
		return mapper.map(taskDAO.save(task), TaskDTO.class);
	}

	@Override
	@Transactional
	public TaskDTO updateTask(TaskDTO task) {
		Task taskToUpdate = taskDAO.findOne(task.getId());
		taskToUpdate.setCompleted(task.isCompleted());
		taskToUpdate.setName(task.getName());
		taskToUpdate.setStartDate(task.getStartDate());
		taskToUpdate.setTaskDescription(task.getTaskDescription());
		return mapper.map(taskToUpdate,TaskDTO.class);
	}

	@Override
	@Transactional
	public void deleteTask(ObjectId taskId) {
		taskDAO.delete(taskId);

	}
}
