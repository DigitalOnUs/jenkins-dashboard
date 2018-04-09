package com.digitalonus.pipelinegenerator.service;

import java.io.IOException;

import com.digitalonus.pipelinegenerator.dto.NewConnectionDTO;
import com.digitalonus.pipelinegenerator.vo.NewConnectionVO;

public interface ConnectionService {
	void createConnection(NewConnectionDTO connectionDTO, String projectId) throws IOException, InterruptedException;
}
