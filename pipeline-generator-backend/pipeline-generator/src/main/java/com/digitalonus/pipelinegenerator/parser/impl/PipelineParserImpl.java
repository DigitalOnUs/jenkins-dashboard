package com.digitalonus.pipelinegenerator.parser.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalonus.pipelinegenerator.dto.PipelineDTO;
import com.digitalonus.pipelinegenerator.parser.PipelineParser;
import com.digitalonus.pipelinegenerator.parser.StepParser;
import com.digitalonus.pipelinegenerator.vo.PipelineVO;

@Component
public class PipelineParserImpl implements PipelineParser {

	@Override
	public PipelineVO parseToVO(PipelineDTO dto) {
		if(dto == null)
			return null;
		PipelineVO vo = new PipelineVO();
		vo.setId(dto.getId().toString());
		vo.setLanguage(dto.getLanguage());
		vo.setProjectId(dto.getProjectId().toString());
		vo.setSteps(this.stepParser.parseToVOList(dto.getSteps()));
		return vo;
	}

	@Override
	public PipelineDTO parseToDTO(PipelineVO vo) {
		if (vo == null)
			return null;
		PipelineDTO dto = new PipelineDTO();
		if (vo.getId() != null)
			dto.setId(new ObjectId(vo.getId()));
		dto.setLanguage(vo.getLanguage());
		dto.setSteps(this.stepParser.parseToDTOList(vo.getSteps()));
		return dto;
	}

	@Autowired
	private StepParser stepParser;
}
