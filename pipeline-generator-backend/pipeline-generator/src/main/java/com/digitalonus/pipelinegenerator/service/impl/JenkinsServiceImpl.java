package com.digitalonus.pipelinegenerator.service.impl;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.digitalonus.pipelinegenerator.dto.JenkinsStatusDTO;
import com.digitalonus.pipelinegenerator.service.JenkinsService;

@Service
public class JenkinsServiceImpl implements JenkinsService {

	@Override
	public JenkinsStatusDTO getJenkinsStatus(String url) {
		logger.info("SERVICE: Starting getJenkinsStatus method...");
		
		if(url == null || url.isEmpty())
			throw new RuntimeException("The url must be not null or empty");
		
		System.out.println(url);
		
		HttpClient client = HttpClientBuilder.create().build();

		JenkinsStatusDTO dto = new JenkinsStatusDTO();
		try {
			HttpGet request = new HttpGet(url + "/lastBuild/api/json");
			request.setHeader("Authorization", "Basic YWRtaW46NTUzOWFlOTMzZmFkNGE2NGFiNDlmOGE2NTRiYjhhMjE=");
			request.setHeader("Access-Control-Allow-Origin", "*");
			HttpResponse response = client.execute(request);
			if(response.getStatusLine().getStatusCode() != 404) {
				InputStream in = response.getEntity().getContent();
				String body = IOUtils.toString(in, "UTF-8");
				JSONObject json = new JSONObject(body);
				dto.setStatus(json.getString("result"));
				dto.setMessage("Actual Jenkins's status: " + dto.getStatus());
			} else {
				HttpGet notBuilded = new HttpGet(url + "/api/json");
				notBuilded.setHeader("Authorization", "Basic YWRtaW46NTUzOWFlOTMzZmFkNGE2NGFiNDlmOGE2NTRiYjhhMjE=");
				notBuilded.setHeader("Access-Control-Allow-Origin", "*");
				HttpResponse notBuildedResponse = client.execute(notBuilded);
				if(notBuildedResponse.getStatusLine().getStatusCode() == 200) {
					dto.setStatus("PENDING");
					dto.setMessage("Actual Jenkins's status: The job has never been executed");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return dto;
	}
	
	private static final Logger logger = 
			Logger.getLogger(JenkinsServiceImpl.class);

}
