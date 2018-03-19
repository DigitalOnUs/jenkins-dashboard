package com.digitalonus.pipelinegenerator.parser;

import java.util.List;

import com.digitalonus.pipelinegenerator.dto.StepDTO;
import com.digitalonus.pipelinegenerator.vo.StepVO;

public interface StepParser {
	StepVO parseToVO(StepDTO stepDTO);
	List<StepVO> parseToVOList(List<StepDTO> dtos);
	List<StepDTO> parseToDTOList(List<StepVO> vos);
	StepDTO parseToDTO(StepVO vo);
}
