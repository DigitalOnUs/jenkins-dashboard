package com.digitalonus.pipelinegenerator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalonus.pipelinegenerator.dto.PipelineDTO;
import com.digitalonus.pipelinegenerator.dto.StepDTO;
import com.digitalonus.pipelinegenerator.entity.Pipeline;
import com.digitalonus.pipelinegenerator.entity.Project;
import com.digitalonus.pipelinegenerator.entity.Step;
import com.digitalonus.pipelinegenerator.persistance.PipelineDAO;
import com.digitalonus.pipelinegenerator.persistance.ProjectDAO;
import com.digitalonus.pipelinegenerator.persistance.StepDAO;
import com.digitalonus.pipelinegenerator.service.PipelineService;

@Service
public class PipelineServiceImpl implements PipelineService {

	@Override
	public PipelineDTO findWithProjectId(String pipelineId) {
		logger.info("SERVICE: Starting findWithId method...");
		if(pipelineId == null || pipelineId == "")
			throw new RuntimeException("The pipeline id must not be null or empty");
		PipelineDTO dto = new PipelineDTO();
		Project project = this.projectDAO.findOne(pipelineId);
		Pipeline pipeline = this.pipelineDAO.findOneByProject(project);
		if(pipeline == null)
			return null;
		dto.setId(pipeline.getId());
		dto.setLanguage(pipeline.getLanguage());
		dto.setProjectId(new ObjectId(pipeline.getProject().getId()));
		List<StepDTO> dtos = new ArrayList<>();
		pipeline.getSteps().forEach(step -> {
			StepDTO stepDTO = new StepDTO();
			stepDTO.setId(step.getId());
			stepDTO.setName(step.getName());
			stepDTO.setValue(step.getValue());
			dtos.add(stepDTO);
		});
		dto.setSteps(dtos);
		return dto;
	}
	@Override
	public PipelineDTO createPipeline(PipelineDTO dto) {
		logger.info("SERVICE: Starting create pipeline method...");
		if(dto == null)
			throw new RuntimeException("The pipeline must not be null");
		Project project = this.projectDAO.findOne(dto.getProjectId());
		if(project == null)
			throw new RuntimeException(
					"Project not found with id: " + dto.getProjectId().toString());
		Pipeline pipeline = new Pipeline();
		pipeline.setId(dto.getId());
		pipeline.setLanguage(dto.getLanguage());
		pipeline.setProject(project);
		List<Step> steps = new ArrayList<>();
		dto.getSteps().forEach(stepDTO -> {
			Step step = new Step();
			step.setId(stepDTO.getId() !=null ? stepDTO.getId() : new ObjectId());
			step.setName(stepDTO.getName());
			step.setValue(stepDTO.getValue());
			steps.add(step);
			this.stepDAO.save(step);
		});
		pipeline.setSteps(steps);
		pipeline = this.pipelineDAO.save(pipeline);
		dto.setId(pipeline.getId());
		dto.setLanguage(pipeline.getLanguage());
		dto.setProjectId(new ObjectId(pipeline.getProject().getId()));
		List<StepDTO> dtos = new ArrayList<>();
		pipeline.getSteps().forEach(step -> {
			StepDTO stepDTO = new StepDTO();
			stepDTO.setId(step.getId());
			stepDTO.setName(step.getName());
			stepDTO.setValue(step.getValue());
			dtos.add(stepDTO);
		});
		dto.setSteps(dtos);
		return dto;
	}

	private static final Logger logger = Logger.getLogger(PipelineServiceImpl.class);

	@Autowired
	private PipelineDAO pipelineDAO;
	@Autowired
	private ProjectDAO projectDAO;
	@Autowired
	private StepDAO stepDAO;
}
