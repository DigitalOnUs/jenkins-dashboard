package com.digitalonus.pipelinegenerator.service;

import com.digitalonus.pipelinegenerator.vo.TestingSetupVO;

public interface TestingService {
	String createSetupTesting(String projectId, TestingSetupVO testingVO);
}
