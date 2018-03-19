package com.digitalonus.pipelinegenerator.service;

import java.io.IOException;

import com.digitalonus.pipelinegenerator.dto.NewConnectionDTO;

public interface ConnectionService {
	void createConnection(NewConnectionDTO connectionDTO, String projectId) throws IOException;
}
