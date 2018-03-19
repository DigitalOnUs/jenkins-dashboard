package com.digitalonus.pipelinegenerator.service;

import com.digitalonus.pipelinegenerator.dto.JenkinsStatusDTO;

public interface JenkinsService {
	JenkinsStatusDTO getJenkinsStatus(String url);
}
