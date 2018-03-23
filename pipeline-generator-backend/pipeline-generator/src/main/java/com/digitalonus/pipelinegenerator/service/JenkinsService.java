package com.digitalonus.pipelinegenerator.service;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.digitalonus.pipelinegenerator.dto.JenkinsStatusDTO;
import com.digitalonus.pipelinegenerator.vo.JenkinsLogLineVO;

public interface JenkinsService {
	JenkinsStatusDTO getJenkinsStatus(String url);
	void executeJenkinsJob(String url) throws ClientProtocolException, IOException;
	List<JenkinsLogLineVO> getJenkinsLogs(String url) throws ClientProtocolException, IOException;
}
