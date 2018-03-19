package com.digitalonus.pipelinegenerator.parser;

import java.util.List;

import com.digitalonus.pipelinegenerator.dto.ProjectDTO;
import com.digitalonus.pipelinegenerator.vo.ProjectVO;

public interface ProjectParser {
	ProjectDTO parseToDTO(ProjectVO projectVO);
	ProjectVO parseToVO(ProjectDTO projectDTO);
	List<ProjectVO> parseToVOList(List<ProjectDTO> projectsDTO);
}
