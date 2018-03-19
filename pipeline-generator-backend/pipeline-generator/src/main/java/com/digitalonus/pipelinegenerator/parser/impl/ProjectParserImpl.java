package com.digitalonus.pipelinegenerator.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalonus.pipelinegenerator.dto.ProjectDTO;
import com.digitalonus.pipelinegenerator.parser.ProjectParser;
import com.digitalonus.pipelinegenerator.parser.StepParser;
import com.digitalonus.pipelinegenerator.vo.ProjectVO;

@Component
public class ProjectParserImpl implements ProjectParser {

	@Override
	public ProjectVO parseToVO(ProjectDTO projectDTO) {
		if (projectDTO == null)
			return null;
		ProjectVO projectVO = new ProjectVO();
		projectVO.setId(projectDTO.getId().toString());
		projectVO.setName(projectDTO.getName());
		projectVO.setSteps(this.stepParser.parseToVOList(projectDTO.getSteps()));
		return projectVO;
	}

	@Override
	public ProjectDTO parseToDTO(ProjectVO projectVO) {
		logger.info("PARSER: Starting parseToDTO method...");

		if (projectVO == null)
			return null;

		ProjectDTO projectDTO = new ProjectDTO();
		if (projectVO.getId() != null)
			projectDTO.setId(new ObjectId(projectVO.getId()));
		projectDTO.setName(projectVO.getName());
		return projectDTO;
	}

	@Override
	public List<ProjectVO> parseToVOList(List<ProjectDTO> projectsDTO) {
		List<ProjectVO> projectsVO = new ArrayList<>();
		for (ProjectDTO dto : projectsDTO) {
			ProjectVO vo = new ProjectVO();
			vo = this.parseToVO(dto);
			projectsVO.add(vo);
		}
		return projectsVO;
	}

	private static final Logger logger = Logger.getLogger(ProjectParserImpl.class);

	@Autowired
	private StepParser stepParser;

}
