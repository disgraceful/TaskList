package com.tasklist.services.contracts;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import com.tasklist.services.dto.TaskDTO;
import com.tasklist.services.requestmodels.TaskCreateReqModel;

public interface TaskService {
	TaskDTO getTaskById(ObjectId id);

	List<TaskDTO> getAllTasks();

	List<TaskDTO> getTasksByUserId(ObjectId userId);

	List<TaskDTO> getTaskByCompletion(boolean completed);

	List<TaskDTO> getTaskByDate(Date date);

	List<TaskDTO> getTaskByProjectId(ObjectId projId);

	TaskDTO createTask(TaskCreateReqModel model);

	TaskDTO updateTask(TaskDTO task);

	void deleteTask(ObjectId taskId);

}
