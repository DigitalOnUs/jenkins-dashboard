package com.digitalonus.pipelinegenerator.controller.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalonus.pipelinegenerator.commons.YamlStructure;
import com.digitalonus.pipelinegenerator.controller.PipelineController;
import com.digitalonus.pipelinegenerator.dto.PipelineDTO;
import com.digitalonus.pipelinegenerator.parser.PipelineParser;
import com.digitalonus.pipelinegenerator.service.PipelineService;
import com.digitalonus.pipelinegenerator.service.ProjectService;
import com.digitalonus.pipelinegenerator.vo.PipelineVO;
import com.digitalonus.pipelinegenerator.vo.StepVO;
import com.esotericsoftware.yamlbeans.YamlConfig;
import com.esotericsoftware.yamlbeans.YamlWriter;

@RestController
@RequestMapping("pipeline")
@CrossOrigin()
public class PipelineControllerImpl implements PipelineController {

	@Override
	@GetMapping("/{id}")
	public PipelineVO getPipelineProjectId(@PathVariable("id") String projectId) {
		logger.info("CTRL: Starting getPipelineWithId method...");
		if (projectId == null || projectId == "")
			throw new RuntimeException("The id of the pipeline is mandatory");
		PipelineDTO dto = this.pipelineService.findWithProjectId(projectId);
		PipelineVO pipelineVO = new PipelineVO();
		pipelineVO = this.pipelineParser.parseToVO(dto);
		return pipelineVO;
	}

	@Override
	@PostMapping("/{projectId}")
	public PipelineVO createPipeline(@PathVariable("projectId") String projectId, @RequestBody PipelineVO pipelineVO,
			BindingResult bindingResult) throws IOException {
		logger.info("Starting method createPipeline...");
		if (bindingResult.hasErrors())
			throw new RuntimeException("Error at the request body:");
		try {
			PipelineDTO dto = this.pipelineParser.parseToDTO(pipelineVO);
			dto.setProjectId(new ObjectId(projectId));
			dto = this.pipelineService.createPipeline(dto);
			pipelineVO.setProjectId(dto.getProjectId().toString());
			this.createPipelineFile(pipelineVO);
			pipelineVO = this.pipelineParser.parseToVO(dto);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

		return pipelineVO;
	}

	private void createPipelineFile(PipelineVO pipelineVO) throws IOException, InterruptedException {
		logger.info("Creating the pipeline file...");
		String pathUrl = PipelineControllerImpl.filesPathUri + "pipeline-" + new Date().getTime() + ".yaml";

		/*
		 * Declaring the YamlWriter with the configuration to generate the yaml file
		 */
		YamlWriter writer = new YamlWriter(new FileWriter(pathUrl), this.removeYamlTags());

		ArrayList<Map<String, YamlStructure>> finalYaml = new ArrayList<>();

		Map<String, YamlStructure> finalStructure = new HashMap<>();
		finalStructure.put("job", this.createYamlStructure(pipelineVO));
		finalYaml.add(finalStructure);
		writer.write(finalYaml);
		writer.close();

		/*
		 * Replacing the name of the property value to default
		 */
		Charset charset = StandardCharsets.UTF_8;
		String content = new String(Files.readAllBytes(Paths.get(pathUrl)), charset);
		content = content.replace("value:", "default:");
		content = content.replace("!tagDefinition", "");
		Files.write(Paths.get(pathUrl), content.getBytes(charset));
		Process process = Runtime.getRuntime().exec("jenkins-jobs update " + pathUrl);
		process.waitFor();
		process.destroy();
	}

	/**
	 * Method to build the YamlStructure working at jenkins
	 * 
	 * @param pipeline
	 * @return
	 */
	private YamlStructure createYamlStructure(PipelineVO pipeline) {
		logger.info("Creating the Yaml Structure");
		YamlStructure structure = new YamlStructure();
		structure.setName(this.projectService.getProjectInfoWithId(pipeline.getProjectId()).getName());
		ArrayList<Map<String, YamlStructure.ParameterItem>> parameters = new ArrayList<>();
		StepVO vo = new StepVO();
		vo.setName("Project Id");
		vo.setValue(pipeline.getProjectId());
		pipeline.getSteps().add(vo);
		pipeline.getSteps().forEach(step -> {
			Map<String, YamlStructure.ParameterItem> parameter = new HashMap<>();
			YamlStructure.ParameterItem item = new YamlStructure.ParameterItem();
			item.setName(step.getName());
			item.setValue(step.getValue());
			parameter.put("string", item);
			parameters.add(parameter);
		});
		structure.setParameters(parameters);
		return structure;
	}

	/**
	 * Method to remove the Yaml Tags to avoid jenkins errors
	 * 
	 * @return
	 */
	private YamlConfig removeYamlTags() {
		logger.info("Removing the Yaml Tags");
		YamlConfig yamlConfig = new YamlConfig();
		yamlConfig.setClassTag("tagDefinition", YamlStructure.class);
		yamlConfig.setClassTag("tagDefinition", YamlStructure.ParameterItem.class);
		return yamlConfig;
	}

	private static final Logger logger = Logger.getLogger(PipelineControllerImpl.class);

	private static final String filesPathUri = "yamlFiles/pipelines/";

	@Autowired
	private PipelineService pipelineService;
	@Autowired
	private PipelineParser pipelineParser;
	@Autowired
	private ProjectService projectService;
}
