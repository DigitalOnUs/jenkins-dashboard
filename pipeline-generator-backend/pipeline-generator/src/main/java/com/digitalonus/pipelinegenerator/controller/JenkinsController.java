package com.digitalonus.pipelinegenerator.controller;

import org.springframework.http.ResponseEntity;

import com.digitalonus.pipelinegenerator.vo.JenkinsStatusVO;

public interface JenkinsController {
	ResponseEntity<JenkinsStatusVO> getJenkinsStatus(String projectId);
}
