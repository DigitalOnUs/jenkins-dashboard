package com.digitalonus.pipelinegenerator.controller;

import java.io.IOException;

import org.springframework.validation.BindingResult;

import com.digitalonus.pipelinegenerator.vo.PipelineVO;

public interface PipelineController {
	/**
	 * 
	 * @param pipelineId
	 * @return
	 */
	PipelineVO getPipelineProjectId(String pipelineId);

	/**
	 * 
	 * @param pipelineVO
	 */
	PipelineVO createPipeline(String projectId, 
			PipelineVO pipelineVO, 
			BindingResult bindingResult) throws IOException;
}
