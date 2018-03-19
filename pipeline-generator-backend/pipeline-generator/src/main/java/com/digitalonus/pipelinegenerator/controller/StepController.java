package com.digitalonus.pipelinegenerator.controller;

import java.util.List;

import com.digitalonus.pipelinegenerator.vo.StepVO;

public interface StepController {
	List<StepVO> addStepsToProject(String projectId);
}
