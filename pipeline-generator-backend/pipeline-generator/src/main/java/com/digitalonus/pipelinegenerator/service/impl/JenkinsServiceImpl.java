package com.digitalonus.pipelinegenerator.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.digitalonus.pipelinegenerator.dto.JenkinsStatusDTO;
import com.digitalonus.pipelinegenerator.service.JenkinsService;
import com.digitalonus.pipelinegenerator.vo.JenkinsLogLineVO;

@Service
public class JenkinsServiceImpl implements JenkinsService {

	@Override
	public JenkinsStatusDTO getJenkinsStatus(String url) {
		logger.info("SERVICE: Starting getJenkinsStatus method...");
		
		if(url == null || url.isEmpty())
			throw new RuntimeException("The url must be not null or empty");
		
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
	
	@Override
	public void executeJenkinsJob(String url) throws ClientProtocolException, IOException {
		logger.info("SERVICE: Starting executeJenkinsJob method");
		
		if(url == null || url.isEmpty())
			throw new RuntimeException("The url must be not null or empty");
		
		HttpClient client = HttpClientBuilder.create().build();
		
		HttpPost request = new HttpPost(url + "/buildWithParameters");
		request.setHeader("Authorization", "Basic YWRtaW46NTUzOWFlOTMzZmFkNGE2NGFiNDlmOGE2NTRiYjhhMjE=");
		request.setHeader("Access-Control-Allow-Origin", "*");
		request.setHeader("Jenkins-Crumb", "d1a6f7d99d29ee0dd779259c696f02fb");
		client.execute(request);
	}

	@Override
	public List<JenkinsLogLineVO> getJenkinsLogs(String url) throws ClientProtocolException, IOException {
		logger.info("SERVICE: Starting getJenkinsLogs method...");
		
		if(url == null || url.isEmpty())
			throw new RuntimeException("The url must be not null or empty");
		
		HttpClient client = HttpClientBuilder.create().build();
		
		HttpGet request = new HttpGet(url + "/lastBuild/api/json");
		request.setHeader("Authorization", "Basic YWRtaW46NTUzOWFlOTMzZmFkNGE2NGFiNDlmOGE2NTRiYjhhMjE=");
		request.setHeader("Access-Control-Allow-Origin", "*");
		
		HttpResponse response = client.execute(request);
		List<JenkinsLogLineVO> logs = new ArrayList<>();
		if(response.getStatusLine().getStatusCode() == 200) {
			InputStream in = response.getEntity().getContent();
			String body = IOUtils.toString(in, "UTF-8");
			JenkinsLogLineVO firstLine = new JenkinsLogLineVO();
			firstLine.setLineNumber(0);
			firstLine.setMessage("Lanzada por el usuario admin");
			logs.add(firstLine);
			try {
				JSONObject json = new JSONObject(body);
				JSONObject changes = json.getJSONArray("changeSets").getJSONObject(0);
				JSONArray items = changes.getJSONArray("items");
				int index;
				for(index = 0; index < items.length(); index++) {
					JenkinsLogLineVO line = new JenkinsLogLineVO();
					JSONObject obj = items.getJSONObject(index);
					line.setLineNumber(index + 1);
					line.setMessage(obj.getString("msg"));
					logs.add(line);
				}
				JSONObject actions = json.getJSONArray("actions").getJSONObject(0);
				JSONObject cause = actions.getJSONArray("causes").getJSONObject(0);
				JenkinsLogLineVO line = new JenkinsLogLineVO();
				line.setLineNumber(index + 1);
				line.setMessage(cause.getString("shortDescription"));
				logs.add(line);
				
			} catch (JSONException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return logs;
	}

	private static final Logger logger = 
			Logger.getLogger(JenkinsServiceImpl.class);

}
