package com.digitalonus.pipelinegenerator.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalonus.pipelinegenerator.controller.ProjectController;
import com.digitalonus.pipelinegenerator.dto.ProjectDTO;
import com.digitalonus.pipelinegenerator.parser.ProjectParser;
import com.digitalonus.pipelinegenerator.service.ProjectService;
import com.digitalonus.pipelinegenerator.vo.ProjectVO;

@RestController
@RequestMapping("project")
@CrossOrigin
public class ProjectControllerImpl implements ProjectController {

	@Override
	@PostMapping
	public ProjectVO createProject(@RequestBody ProjectVO projectVO, BindingResult bindingResult) {

		logger.info("Starting createProject method...");

		if (bindingResult.hasErrors())
			throw new RuntimeException("Error at the request body: " + bindingResult.getFieldError());

		ProjectDTO projectDTO = this.projectParser.parseToDTO(projectVO);
		projectDTO = this.projectService.createProject(projectDTO);
		projectVO = this.projectParser.parseToVO(projectDTO);

		return projectVO;
	}

	@Override
	@GetMapping
	public List<ProjectVO> getAllProject(
			@RequestParam("userEmail")String userEmail) {
		logger.info("CTRL: Starting getAllProject method...");
		List<ProjectVO> projectsVO = new ArrayList<>();
		List<ProjectDTO> projectsDTO = this.projectService.getProjectsWithEmail(userEmail);
		projectsVO = this.projectParser.parseToVOList(projectsDTO);
		return projectsVO;
	}

	@GetMapping("/{projectId}")
	@Override
	public ProjectVO getProjectData(
			@PathVariable("projectId") String projectId) {
		logger.info("CTRL: Starting getProjectData method...");
		
		if(projectId == null || projectId.isEmpty())
			throw new RuntimeException("The project id must not be null or empty");
		
		ProjectDTO projectDTO = this.projectService.getProjectInfoWithId(projectId);
			
		if(projectDTO == null)
			throw new RuntimeException("Project not found with id: " + projectId);
		
		ProjectVO projectVO = this.projectParser.parseToVO(projectDTO);
		
		return projectVO;
	}

	private static final Logger logger = 
			Logger.getLogger(ProjectControllerImpl.class);

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectParser projectParser;
}
