package com.digitalonus.pipelinegenerator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digitalonus.pipelinegenerator.dto.ProjectDTO;
import com.digitalonus.pipelinegenerator.entity.Project;
import com.digitalonus.pipelinegenerator.persistance.ProjectDAO;
import com.digitalonus.pipelinegenerator.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Override
	public ProjectDTO getProjectInfoWithId(String projectId) {
		logger.info("SERVICE: Starting getProjectInfoWithId method...");
		if(projectId == null || projectId.isEmpty())
			throw new RuntimeException("The project id must not be null or empty");
		
		Project project = this.projectDAO.findOne(projectId);
		
		if(project == null)
			throw new RuntimeException("Project not found with if: " + projectId);
		
		ProjectDTO dto = new ProjectDTO();
		
		dto.setId(new ObjectId(project.getId()));
		dto.setName(project.getName());
		return dto;
	}

	@Override
	public ProjectDTO createProject(ProjectDTO projectDTO) {
		logger.info("SERVICE: Starting createProject method...");
		if (projectDTO == null || projectDTO.getName().isEmpty())
			throw new RuntimeException("The project must have a name");
		projectDTO.setId(new ObjectId());
		Project project = new Project();
		project.setId(projectDTO.getId().toString());
		project.setName(projectDTO.getName());
		project.setUserEmail(projectDTO.getUserEmail());
		try {
			this.projectDAO.save(project);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return projectDTO;
	}

	@Override
	public List<ProjectDTO> getProjectsWithEmail(String userEmail) {
		List<ProjectDTO> projectsDTO = new ArrayList<>();
		List<Project> projects = this.projectDAO.findAllByUserEmail(userEmail);
		for(Project project : projects) {
			ProjectDTO dto = new ProjectDTO();
			dto.setId(new ObjectId(project.getId()));
			dto.setName(project.getName());
			dto.setUserEmail(project.getUserEmail());
			projectsDTO.add(dto);
		}
		return projectsDTO;
	}

	private static final Logger logger = Logger.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectDAO projectDAO;

}
