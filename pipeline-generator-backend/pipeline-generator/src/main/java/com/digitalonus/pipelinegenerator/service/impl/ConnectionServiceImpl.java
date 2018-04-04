package com.digitalonus.pipelinegenerator.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.digitalonus.pipelinegenerator.dto.NewConnectionDTO;
import com.digitalonus.pipelinegenerator.dto.ProjectDTO;
import com.digitalonus.pipelinegenerator.service.ConnectionService;
import com.digitalonus.pipelinegenerator.service.ProjectService;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Override
	public void createConnection(NewConnectionDTO connectionDTO, String projectId) throws IOException {
		logger.info("SERVICE: Starting createConnection method...");
		if (connectionDTO == null)
			throw new RuntimeException("The connectionDTO must not be null");
		
		ProjectDTO dto = this.projectService.getProjectInfoWithId(projectId);

//		Process process = Runtime.getRuntime().exec("terraform apply");
//		try {
//			process.waitFor();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		process.destroy();

	}

	private static final Logger logger = Logger.getLogger(ConnectionServiceImpl.class);
	
	@Autowired
	private ProjectService projectService;
}
