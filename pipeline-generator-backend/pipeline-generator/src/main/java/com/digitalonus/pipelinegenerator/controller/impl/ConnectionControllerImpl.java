package com.digitalonus.pipelinegenerator.controller.impl;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalonus.pipelinegenerator.controller.ConnectionController;
import com.digitalonus.pipelinegenerator.dto.NewConnectionDTO;
import com.digitalonus.pipelinegenerator.parser.ConnectionParser;
import com.digitalonus.pipelinegenerator.service.ConnectionService;
import com.digitalonus.pipelinegenerator.vo.InstanceDataVO;
import com.digitalonus.pipelinegenerator.vo.NewConnectionVO;

@RestController
@CrossOrigin
@RequestMapping("provider")
public class ConnectionControllerImpl implements ConnectionController{

	@Override
	@PostMapping("/{projectId}/create-services-provider")
	public InstanceDataVO createConnection(@PathVariable("projectId")String projectId, 
			@RequestBody NewConnectionVO connectionVO, 
			BindingResult bindingResult) throws InterruptedException{
		
		logger.info("CTRL: Starting createConnection method...");
		
		if(bindingResult.hasErrors())
			throw new RuntimeException("Error in the request body...");
		
		if(logger.isTraceEnabled())
			logger.trace("- connectionVO: " + connectionVO);
		InstanceDataVO vo = new InstanceDataVO();
		NewConnectionDTO connectionDTO = 
				this.connectionParser.parseToDTO(connectionVO);
		String instanceIp = "";
		try {
			instanceIp = this.connectionService.createConnection(connectionDTO, projectId);
			vo.setInstanceIp(instanceIp);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return vo;
		
	}
	
	@Autowired
	private ConnectionParser connectionParser;
	
	@Autowired
	private ConnectionService connectionService;
	
	private static final Logger logger = Logger.getLogger(ConnectionControllerImpl.class);
	
}
