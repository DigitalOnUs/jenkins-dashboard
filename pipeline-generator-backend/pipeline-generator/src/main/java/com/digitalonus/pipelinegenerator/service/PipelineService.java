package com.digitalonus.pipelinegenerator.service;

import com.digitalonus.pipelinegenerator.dto.PipelineDTO;

public interface PipelineService {
	PipelineDTO createPipeline(PipelineDTO dto);
	PipelineDTO findWithProjectId(String pipelineId);
}
