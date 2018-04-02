package com.digitalonus.pipelinegenerator.controller;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.digitalonus.pipelinegenerator.vo.ProjectVO;

public interface ProjectController {
	ProjectVO createProject(ProjectVO projectVO, BindingResult bindingResult);
	List<ProjectVO> getAllProject();
	ProjectVO getProjectData(String projectId);
}
