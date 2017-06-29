package com.tasklist.services.mapper;

import org.modelmapper.PropertyMap;

import com.tasklist.model.Project;
import com.tasklist.services.dto.ProjectDTO;

public class ProjectMapperMap extends PropertyMap<Project,ProjectDTO> {

	@Override
	protected void configure() {
		map().setTaskAmount(source.getTasks().size());
	}

}
