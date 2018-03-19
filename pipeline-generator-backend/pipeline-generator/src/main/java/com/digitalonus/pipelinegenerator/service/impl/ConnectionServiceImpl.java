package com.digitalonus.pipelinegenerator.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.KeyPair;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
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

		CreateSecurityGroupRequest securityGroup = new CreateSecurityGroupRequest();

		securityGroup.withGroupName(
				dto.getName()
					.replace(" ", "-") + "-security-group")
				.withDescription("Security group for " + dto.getName() + " project");

		AmazonEC2 amazonEC2 = this.createAmazonClient();
		amazonEC2.createSecurityGroup(securityGroup);

		CreateKeyPairRequest createKeyPairRequest = 
				new CreateKeyPairRequest()
					.withKeyName(dto.getName().replace(" ", "-"));

		CreateKeyPairResult createKeyPairResult = 
				amazonEC2.createKeyPair(createKeyPairRequest);

		KeyPair keyPair = new KeyPair();
		keyPair = createKeyPairResult.getKeyPair();
		String privateKey = keyPair.getKeyMaterial();
		
//		Charset charset = StandardCharsets.UTF_8;
//		Files.write(Paths.get("keyPairsFiles/" + dto.getName().replace(" ", "-") + ".pem"), 
//				privateKey.getBytes(charset));
		System.out.println(privateKey);
		RunInstancesRequest runInstancesRequest = new RunInstancesRequest();

		runInstancesRequest.withImageId("ami-824c4ee2")
				.withInstanceType("t2.micro")
				.withMinCount(1)
				.withMaxCount(1)
				.withKeyName(dto.getName().replace(" ", "-"))
				.withSecurityGroups(
						dto.getName().replace(" ", "-") + "-security-group");

		try {
			amazonEC2.runInstances(runInstancesRequest);
		} catch (Exception e) {
			logger.warn("Error at create the ec2 instance");
		}

	}

	private AmazonEC2 createAmazonClient() {

		BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJUOIVYY76Z7JZUVQ",
				"fVVfQsGhpAjryKgajxmNsdpstX3BRTD1L/x6f6jU");

		AWSCredentialsProvider provider = new AWSStaticCredentialsProvider(credentials);

		AmazonEC2 amazonEc2 = AmazonEC2ClientBuilder.standard().withCredentials(provider).withRegion(Regions.US_WEST_1)
				.build();

		return amazonEc2;
	}

	private static final Logger logger = Logger.getLogger(ConnectionServiceImpl.class);
	
	@Autowired
	private ProjectService projectService;
}
