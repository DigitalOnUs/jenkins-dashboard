package com.digitalonus.pipelinegenerator.controller.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalonus.pipelinegenerator.controller.TestingController;
import com.digitalonus.pipelinegenerator.service.TestingService;
import com.digitalonus.pipelinegenerator.vo.TestingSetupVO;

@RestController
@RequestMapping("testing")
@CrossOrigin()
public class TestingControllerImpl implements TestingController {

	@Override
	@PostMapping("/{projectId}/create-setup")
	public void createTestingSetup(
			@PathVariable("projectId")String projectId, 
			@RequestBody TestingSetupVO testingVO) {
		logger.info("CTRL: Starting createTestingSetup method...");
		if(testingVO == null)
			throw new RuntimeException("Error, the request body must not be null");
		
		this.testingService.createSetupTesting(projectId, testingVO);
		
	}
	
	private static final Logger logger = Logger.getLogger(TestingControllerImpl.class);

	@Autowired
	private TestingService testingService;
}
