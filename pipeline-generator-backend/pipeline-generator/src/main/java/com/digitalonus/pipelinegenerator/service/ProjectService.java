package com.digitalonus.pipelinegenerator.service;

import java.util.List;

import com.digitalonus.pipelinegenerator.dto.ProjectDTO;

public interface ProjectService {
	ProjectDTO createProject(ProjectDTO projectDTO);
	List<ProjectDTO> getProjectsWithEmail(String userEmail);
	ProjectDTO getProjectInfoWithId(String projectId);
}
