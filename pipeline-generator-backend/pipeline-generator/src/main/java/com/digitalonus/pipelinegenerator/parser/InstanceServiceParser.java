package com.digitalonus.pipelinegenerator.parser;

import java.util.List;

import com.digitalonus.pipelinegenerator.dto.InstanceServiceDTO;
import com.digitalonus.pipelinegenerator.vo.InstanceServiceVO;

public interface InstanceServiceParser {
	InstanceServiceVO parseToVO(InstanceServiceDTO dto);
	InstanceServiceDTO parseToDTO(InstanceServiceDTO vo);
	List<InstanceServiceVO> parseToVOList(List<InstanceServiceDTO> dtos);
	List<InstanceServiceDTO> parseToDTOList(List<InstanceServiceVO> vos);
}
