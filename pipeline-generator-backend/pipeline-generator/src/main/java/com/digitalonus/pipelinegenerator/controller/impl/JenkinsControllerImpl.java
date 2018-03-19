package com.digitalonus.pipelinegenerator.controller.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalonus.pipelinegenerator.controller.JenkinsController;
import com.digitalonus.pipelinegenerator.dto.JenkinsStatusDTO;
import com.digitalonus.pipelinegenerator.dto.ProjectDTO;
import com.digitalonus.pipelinegenerator.service.JenkinsService;
import com.digitalonus.pipelinegenerator.service.ProjectService;
import com.digitalonus.pipelinegenerator.vo.JenkinsStatusVO;

@RestController
@RequestMapping("jenkins")
public class JenkinsControllerImpl implements JenkinsController {

	@Override
	@GetMapping("/{projectId}/status")
	public ResponseEntity<JenkinsStatusVO> getJenkinsStatus(
			@PathVariable("projectId") String projectId) {

		logger.info("CTRL: Starting getJenkinsStatus method...");
		if (projectId == null || projectId.isEmpty())
			throw new RuntimeException("The project id must be not null or empty");

		ProjectDTO dto = this.projectService.getProjectInfoWithId(projectId);
		
		if(dto == null)
			throw new RuntimeException("Project not found with id: " + projectId);
		
		JenkinsStatusDTO statusDTO = 
				this.jenkinsService.getJenkinsStatus(
						"http://54.85.215.129:8080/job/" + dto.getName().replace(" ", "%20"));
		
		JenkinsStatusVO vo = new JenkinsStatusVO();
		vo.setStatus(statusDTO.getStatus());
		vo.setMessage(statusDTO.getMessage());
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Access-Control-Allow-Origin", "*");
		ResponseEntity<JenkinsStatusVO> response = 
				new ResponseEntity<JenkinsStatusVO>(vo, responseHeaders, HttpStatus.OK);
		
		
		return response;
	}

	private static final Logger logger = Logger.getLogger(JenkinsControllerImpl.class);
	
	@Autowired
	private JenkinsService jenkinsService;
	
	@Autowired
	private ProjectService projectService;

}
