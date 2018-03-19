package com.digitalonus.pipelinegenerator.parser.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.digitalonus.pipelinegenerator.dto.NewConnectionDTO;
import com.digitalonus.pipelinegenerator.parser.ConnectionParser;
import com.digitalonus.pipelinegenerator.vo.NewConnectionVO;

@Component
public class ConnectionParserImpl implements ConnectionParser{

	@Override
	public NewConnectionDTO parseToDTO(NewConnectionVO connectionVO) {
		logger.info("PARSER: Starting parseToDTO method...");
		if(connectionVO == null)
			return null;
		NewConnectionDTO connectionDTO = new NewConnectionDTO();
		connectionDTO.setAccessKey(connectionVO.getAccessKey());
		connectionDTO.setProvider(connectionVO.getProvider());
		connectionDTO.setSecretKey(connectionVO.getSecretKey());
		return connectionDTO;
	}
	
	@Override
	public NewConnectionVO parseToVO(NewConnectionDTO connectionDTO) {
		logger.info("PARSER: Starting parseToDTO method...");
		if(connectionDTO == null)
			return null;
		NewConnectionVO connectionVO = new NewConnectionVO();
		connectionVO.setAccessKey(connectionDTO.getAccessKey());
		connectionVO.setProvider(connectionDTO.getProvider());
		connectionVO.setSecretKey(connectionDTO.getSecretKey());
		return connectionVO;
	}



	private static final Logger logger = 
			Logger.getLogger(ConnectionParserImpl.class);
	
}
