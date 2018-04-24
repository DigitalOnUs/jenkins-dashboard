package com.digitalonus.pipelinegenerator.service.impl;

import java.io.BufferedReader;
import java.io.File;
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

import com.digitalonus.pipelinegenerator.dto.ProjectDTO;
import com.digitalonus.pipelinegenerator.service.ProjectService;
import com.digitalonus.pipelinegenerator.service.TestingService;
import com.digitalonus.pipelinegenerator.vo.TestingSetupVO;

@Service
public class TestingServiceImpl implements TestingService {

	@Override
	public void createSetupTesting(String projectId, TestingSetupVO testingVO) {
		logger.info("SERVICE: Starting createSetupTesting method...");
		ProjectDTO dto = this.projectService.getProjectInfoWithId(projectId);
		if (dto == null)
			throw new RuntimeException("Project not found with id: " + projectId);

		try {
			List<String> services = new ArrayList<>();
			if (testingVO != null && testingVO.getServer().equals("selenium")) {
				services.add(
						"\"wget http://selenium-release.storage.googleapis.com/3.0/selenium-server-standalone-3.0.1.jar\"");
				services.add(
						"\"nohup java -jar selenium-server-standalone-3.0.1.jar > log.txt 2> errors.txt < /dev/null &\"");
			}
			if (testingVO != null && testingVO.getServices().size() > 0) {
				services.add("\"curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.33.8/install.sh | bash\"");
				services.add("\". ~/.nvm/nvm.sh\"");
				services.add("\"nvm install 6.11.5\"");
				services.add("\"npm install -g protractor\"");
				services.add("\"webdriver-manager update\"");
				services.add("\"webdriver-manager start\"");
				services.add("\"npm install -g protractor\"");
				services.add("\"webdriver-manager update\"");
				services.add("\"webdriver-manager start\"");
				testingVO.getServices().forEach(service -> {
					if (service != null) {
						switch (service) {
						case "jasmine":
							services.add("npm install -g jasmine");
							services.add("jasmine init");
							break;
						case "mocha":
							services.add("npm install --global mocha");
							break;
						}
					}
				});
			}
			String inline = "";
			if (services.isEmpty())
				inline = "\"dir\"";
			else
				inline = String.join(",", services);

			String projectName = dto.getId().toHexString();
			String resourcesPath = System.getProperty("user.dir") + File.separator + "resources";
			Charset charset = StandardCharsets.UTF_8;
			Path instancePath = Paths.get(resourcesPath + File.separator + "instance.tf");
			String content = new String(Files.readAllBytes(instancePath), charset);
			String finalContent = content.replace("var.KEY_PAIR_NAME", projectName + "_testing_key")
					.replace("var.SERVICES", inline).replace("var.ACCESS_KEY", "AKIAILKPTN37AA64CQEA")
					.replace("var.SECRET_KEY", "5DdxrsCCj1FBUm3eOR5L31w/n8CeTE0sruTafN6b")
					.replace("var.INSTANCE_NAME", projectName + "_testing_instance")
					.replace("var.PATH_TO_PUBLIC_KEY", projectName + "_testing_key.pub")
					.replace("var.INSTANCE_NAME", projectName + "_testing_instance")
					.replace("var.INSTANCE_USERNAME", "ec2-user")
					.replace("var.PATH_TO_PRIVATE_KEY", projectName + "_testing_key");
			Files.write(Paths.get(
					instancePath.getParent().getParent().toString() + File.separator + projectName + "_testing.tf"),
					finalContent.getBytes(charset));
			String command = "sudo cp resources/execute.bash " + projectName + "_testing.bash && sudo chmod 777 "
					+ projectName + "_testing.bash && ssh-keygen -f " + projectName + "_testing_key -q -N \"\" && ./"
					+ projectName + "_testing.bash ";
			String[] parameters = new String[3];
			System.out.println(command);
			parameters[0] = "/bin/bash";
			parameters[1] = "-c";
			parameters[2] = command;
			Process p = Runtime.getRuntime().exec(parameters);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			p.waitFor();
			p.destroy();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}

	}

	private static final Logger logger = Logger.getLogger(TestingServiceImpl.class);

	@Autowired
	private ProjectService projectService;
}
