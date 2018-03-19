package com.digitalonus.pipelinegenerator.parser;

import com.digitalonus.pipelinegenerator.dto.NewConnectionDTO;
import com.digitalonus.pipelinegenerator.vo.NewConnectionVO;

public interface ConnectionParser {
	NewConnectionDTO parseToDTO(NewConnectionVO connectionVO);
	NewConnectionVO parseToVO(NewConnectionDTO connectionDTO);
}
