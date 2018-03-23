package com.digitalonus.pipelinegenerator.controller;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.springframework.http.ResponseEntity;

import com.digitalonus.pipelinegenerator.vo.JenkinsLogLineVO;
import com.digitalonus.pipelinegenerator.vo.JenkinsStatusVO;

public interface JenkinsController {
	ResponseEntity<JenkinsStatusVO> getJenkinsStatus(String projectId);
	ResponseEntity<Object> buildJenkinsJob(String projectId);
	ResponseEntity<List<JenkinsLogLineVO>> getJenkinsLogs(String projectId) throws ClientProtocolException, IOException;
}

