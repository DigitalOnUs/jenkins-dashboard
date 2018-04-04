package com.digitalonus.pipelinegenerator.parser;

import com.digitalonus.pipelinegenerator.dto.ProviderDTO;
import com.digitalonus.pipelinegenerator.vo.ProviderVO;

public interface ProviderParser {
	ProviderVO parseToVO(ProviderDTO dto);
	ProviderDTO parseToDTO(ProviderVO vo);
}
