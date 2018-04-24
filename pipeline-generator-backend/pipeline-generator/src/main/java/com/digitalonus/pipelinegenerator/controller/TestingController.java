package com.digitalonus.pipelinegenerator.controller;

import com.digitalonus.pipelinegenerator.vo.InstanceDataVO;
import com.digitalonus.pipelinegenerator.vo.TestingSetupVO;

public interface TestingController {
	InstanceDataVO createTestingSetup(String projectId, TestingSetupVO testingVO);
}
