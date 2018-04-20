package com.digitalonus.pipelinegenerator.service;

import com.digitalonus.pipelinegenerator.vo.TestingSetupVO;

public interface TestingService {
	void createSetupTesting(String projectId, TestingSetupVO testingVO);
}
