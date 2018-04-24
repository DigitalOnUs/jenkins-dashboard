package com.digitalonus.pipelinegenerator.controller;

import org.springframework.validation.BindingResult;

import com.digitalonus.pipelinegenerator.vo.InstanceDataVO;
import com.digitalonus.pipelinegenerator.vo.NewConnectionVO;

public interface ConnectionController {
	InstanceDataVO createConnection(String projectId, NewConnectionVO connectionVO, BindingResult bindingResult)
			throws InterruptedException;
}
