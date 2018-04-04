package com.digitalonus.pipelinegenerator.parser.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.digitalonus.pipelinegenerator.dto.NewConnectionDTO;
import com.digitalonus.pipelinegenerator.dto.ProviderCredentialsDTO;
import com.digitalonus.pipelinegenerator.dto.ProviderDTO;
import com.digitalonus.pipelinegenerator.parser.ConnectionParser;
import com.digitalonus.pipelinegenerator.parser.InstanceServiceParser;
import com.digitalonus.pipelinegenerator.parser.ProviderParser;
import com.digitalonus.pipelinegenerator.vo.NewConnectionVO;
import com.digitalonus.pipelinegenerator.vo.ProviderCredentialsVO;
import com.digitalonus.pipelinegenerator.vo.ProviderVO;

@Component
public class ConnectionParserImpl implements ConnectionParser{

	@Override
	public NewConnectionDTO parseToDTO(NewConnectionVO connectionVO) {
		logger.info("PARSER: Starting parseToDTO method...");
		if(connectionVO == null)
			return null;
		NewConnectionDTO connectionDTO = new NewConnectionDTO();
		if(connectionVO.getCredentials() != null) {
			ProviderCredentialsDTO credentialsDTO = new ProviderCredentialsDTO();
			credentialsDTO.setAccessKey(connectionVO.getCredentials().getAccessKey());
			if(connectionVO.getCredentials().getProvider() != null){
				ProviderDTO dto = 
						this.providerParser.parseToDTO(connectionVO.getCredentials().getProvider());
				credentialsDTO.setProvider(dto);
			}
			credentialsDTO.setSecretKey(connectionVO.getCredentials().getSecretKey());
			connectionDTO.setCredentials(credentialsDTO);
		}
		
		if(connectionVO.getServices() != null && !connectionVO.getServices().isEmpty())
			connectionDTO.setServices(
					this.instanceServiceParser.parseToDTOList(connectionVO.getServices()));
		
		return connectionDTO;
	}
	
	@Override
	public NewConnectionVO parseToVO(NewConnectionDTO connectionDTO) {
		logger.info("PARSER: Starting parseToDTO method...");
		if(connectionDTO == null)
			return null;
		NewConnectionVO connectionVO = new NewConnectionVO();
		
		if(connectionDTO.getCredentials() != null) {
			ProviderCredentialsVO credentialsVO = new ProviderCredentialsVO();
			credentialsVO.setAccessKey(connectionDTO.getCredentials().getAccessKey());
			if(connectionDTO.getCredentials().getProvider() != null){
				ProviderVO vo = 
						this.providerParser.parseToVO(connectionDTO.getCredentials().getProvider());
				credentialsVO.setProvider(vo);
			}
			credentialsVO.setSecretKey(connectionVO.getCredentials().getSecretKey());
			connectionVO.setCredentials(credentialsVO);
		}
		
		if(connectionDTO.getServices() != null && !connectionDTO.getServices().isEmpty())
			connectionVO.setServices(
					this.instanceServiceParser.parseToVOList(connectionDTO.getServices()));
		
		return connectionVO;
	}

	private static final Logger logger = 
			Logger.getLogger(ConnectionParserImpl.class);
	
	@Autowired
	private ProviderParser providerParser;
	
	@Autowired
	private InstanceServiceParser instanceServiceParser;
}
