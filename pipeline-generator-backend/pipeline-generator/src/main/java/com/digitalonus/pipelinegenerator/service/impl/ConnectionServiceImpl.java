package com.digitalonus.pipelinegenerator.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalonus.pipelinegenerator.dto.NewConnectionDTO;
import com.digitalonus.pipelinegenerator.dto.ProjectDTO;
import com.digitalonus.pipelinegenerator.service.ConnectionService;
import com.digitalonus.pipelinegenerator.service.ProjectService;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Override
	public void createConnection(NewConnectionDTO connectionDTO, String projectId)
			throws IOException, InterruptedException {
		logger.info("SERVICE: Starting createConnection method...");
		if (connectionDTO == null)
			throw new RuntimeException("The connectionDTO must not be null");

		ProjectDTO dto = this.projectService.getProjectInfoWithId(projectId);
		System.out.println(System.getProperty("user.dir") + File.separator + "resources");

		if (dto != null) {
			List<String> services = new ArrayList<>();

			connectionDTO.getServices().forEach(service -> {
				if (service != null && service.getEnabled()) {
					switch (service.getName()) {
					case "Jenkins":
						services.add(
								"\"wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo\"");
						services.add("\"rpm --import http://pkg.jenkins-ci.org/redhat-stable/jenkins-ci.org.key\"");
						services.add("\"yum install jenkins\"");
						services.add("\"service jenkins start\"");
						services.add("\"chkconfig jenkins on\"");
						break;
					case "Gerrit":
						services.add("\"wget https://gerrit-releases.storage.googleapis.com/gerrit-2.12.2.war\"");
						services.add(
								"\"java -jar gerrit-2.12.2.war init --batch -d ~/gerrit_test --install-plugin download-commands\"");
					}
				}
			});
			String inline = "";
			if(services.isEmpty())
				inline = "\"dir\"";
			else 
				inline = String.join(",", services);
			
			String projectName = dto.getId().toHexString();
			String resourcesPath = System.getProperty("user.dir") + File.separator + "resources";
			Charset charset = StandardCharsets.UTF_8;
			Path instancePath = Paths.get(resourcesPath + File.separator + "instance.tf");
			String content = new String(Files.readAllBytes(instancePath), charset);
			String finalContent = content.replace("var.KEY_PAIR_NAME", projectName + "_key")
					.replace("var.SERVICES", inline)
					.replace("var.ACCESS_KEY", connectionDTO.getCredentials().getAccessKey())
					.replace("var.SECRET_KEY", connectionDTO.getCredentials().getSecretKey())
					.replace("var.INSTANCE_NAME", projectName + "_instance")
					.replace("var.PATH_TO_PUBLIC_KEY", projectName + "_key.pub")
					.replace("var.INSTANCE_NAME", projectName + "_instance").replace("var.INSTANCE_USERNAME", "ubuntu")
					.replace("var.PATH_TO_PRIVATE_KEY", projectName + "_key");
			Files.write(
					Paths.get(instancePath.getParent().getParent().toString() + File.separator + projectName + ".tf"),
					finalContent.getBytes(charset));
			 String command = "sudo cp resources/execute.bash " + projectName + ".bash && sudo chmod 777 " + projectName
			 + ".bash && ssh-keygen -f " + projectName + "_key -q -N \"\" && ./" +
			 projectName + ".bash ";
			 String[] parameters = new String[3];
			 System.out.println(command);
			 parameters[0] = "/bin/bash";
			 parameters[1] = "-c";
			 parameters[2] = command;
			 Process p = Runtime.getRuntime().exec(parameters);
			 BufferedReader reader = new BufferedReader(new
			 InputStreamReader(p.getInputStream()));
			 String line = reader.readLine();
			 while (line != null) {
			 System.out.println(line);
			 line = reader.readLine();
			 }
			 p.waitFor();
			 p.destroy();
		}

	}

	private static final Logger logger = Logger.getLogger(ConnectionServiceImpl.class);

	@Autowired
	private ProjectService projectService;
}
