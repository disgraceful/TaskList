package com.tasklist.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tasklist.dao.contracts.ProjectDAO;
import com.tasklist.model.Project;
import com.tasklist.services.contracts.ProjectService;
import com.tasklist.services.contracts.UserService;
import com.tasklist.services.dto.ProjectDTO;
import com.tasklist.services.requestmodels.ProjectCreateReqModel;

@Service
public class ProjectServiceImpl implements ProjectService {

	private static final Logger LOG = LogManager.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper mapper;

	@Override
	@Transactional
	public ProjectDTO getProjectByIdAsDTO(ObjectId id) {
		return mapper.map(projectDAO.findOne(id), ProjectDTO.class);
	}

	@Override
	@Transactional
	public Project getProjectByIdAsPOJO(ObjectId id) {
		return projectDAO.findOne(id);
	}

	@Override
	@Transactional
	public List<ProjectDTO> getAllProjectsAsDTO() {
		return projectDAO.findAll().stream().map(f -> mapper.map(f, ProjectDTO.class)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public List<Project> getAllProjectsAsPOJO() {
		return projectDAO.findAll();
	}

	@Override
	public List<ProjectDTO> getProjectByUserIdAsDTO(ObjectId userId) {
		return userService.getUserAsPOJO(userId).getProjects().stream().map(f -> mapper.map(f, ProjectDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<Project> getProjectByUserIdAsPOJO(ObjectId userId) {
		return userService.getUserAsPOJO(userId).getProjects();
	}

	@Override
	public ProjectDTO createProject(ProjectCreateReqModel model) {
		// TODO validate
		Project project = new Project();
		return mapper.map(projectDAO.save(project), ProjectDTO.class);
	}

	@Override
	public ProjectDTO updateProject(ProjectDTO dto) {
		Project projToUpd = projectDAO.findOne(dto.getId());
		projToUpd.setName(dto.getName());
		return mapper.map(projectDAO.save(projToUpd), ProjectDTO.class);
	}

	@Override
	public void deleteProjectDTO(ProjectDTO dto) {
		projectDAO.delete(dto.getId());

	}

}
