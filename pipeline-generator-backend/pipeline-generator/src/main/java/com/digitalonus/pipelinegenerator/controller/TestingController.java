package com.digitalonus.pipelinegenerator.controller;

import com.digitalonus.pipelinegenerator.vo.TestingSetupVO;

public interface TestingController {
	void createTestingSetup(String projectId, TestingSetupVO testingVO);
}
