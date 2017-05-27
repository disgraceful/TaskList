package com.tasklist.services.contracts;

import java.util.List;

import org.bson.types.ObjectId;

import com.tasklist.model.Project;
import com.tasklist.services.dto.ProjectDTO;
import com.tasklist.services.requestmodels.ProjectCreateReqModel;

public interface ProjectService {
	ProjectDTO getProjectByIdAsDTO(ObjectId id);
	List<ProjectDTO> getAllProjectsAsDTO();
	List<ProjectDTO> getProjectByUserIdAsDTO(ObjectId userId);
	ProjectDTO createProject(ProjectCreateReqModel model);
	ProjectDTO updateProject(ProjectDTO dto);
	void deleteProjectDTO(ProjectDTO dto);
	Project getProjectByIdAsPOJO(ObjectId id);
	List<Project> getAllProjectsAsPOJO();
	List<Project> getProjectByUserIdAsPOJO(ObjectId userId);

}
