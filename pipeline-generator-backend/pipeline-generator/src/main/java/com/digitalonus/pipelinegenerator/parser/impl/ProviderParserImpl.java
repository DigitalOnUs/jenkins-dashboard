package com.digitalonus.pipelinegenerator.parser.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.digitalonus.pipelinegenerator.dto.ProviderDTO;
import com.digitalonus.pipelinegenerator.parser.ProviderParser;
import com.digitalonus.pipelinegenerator.vo.ProviderVO;

@Component
public class ProviderParserImpl implements ProviderParser{

	@Override
	public ProviderVO parseToVO(ProviderDTO dto) {
		logger.info("PARSER: Starting parseToVO method");
		if(dto == null)
			return null;
		
		ProviderVO vo = new ProviderVO();
		vo.setValue(dto.getValue());
		vo.setViewValue(dto.getViewValue());
		return vo;
	}
	
	@Override
	public ProviderDTO parseToDTO(ProviderVO vo) {
		logger.info("PARSER: Starting parseToDTO method");
		
		if(vo == null)
			return null;
		
		ProviderDTO dto = new ProviderDTO();
		dto.setValue(vo.getValue());
		dto.setViewValue(vo.getViewValue());
		return dto;
	}

	private static final Logger logger = 
			Logger.getLogger(ProviderParserImpl.class);
	
}
