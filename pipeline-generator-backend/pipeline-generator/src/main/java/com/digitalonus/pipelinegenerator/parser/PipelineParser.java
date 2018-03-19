package com.digitalonus.pipelinegenerator.parser;

import com.digitalonus.pipelinegenerator.dto.PipelineDTO;
import com.digitalonus.pipelinegenerator.vo.PipelineVO;

public interface PipelineParser {
	PipelineDTO parseToDTO(PipelineVO vo);
	PipelineVO parseToVO(PipelineDTO dto);
}
