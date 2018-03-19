package com.digitalonus.pipelinegenerator.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.digitalonus.pipelinegenerator.dto.StepDTO;
import com.digitalonus.pipelinegenerator.parser.StepParser;
import com.digitalonus.pipelinegenerator.vo.StepVO;

@Component
public class StepParserImpl implements StepParser {

	@Override
	public StepVO parseToVO(StepDTO stepDTO) {
		if (stepDTO == null)
			return null;
		StepVO vo = new StepVO();
		vo.setId(stepDTO.getId().toString());
		vo.setName(stepDTO.getName());
		vo.setValue(stepDTO.getValue());
		return vo;
	}

	@Override
	public List<StepVO> parseToVOList(List<StepDTO> dtos) {
		List<StepVO> vos = new ArrayList<>();
		if (dtos == null || dtos.isEmpty())
			return vos;
		for (StepDTO dto : dtos) {
			StepVO vo = new StepVO();
			vo = this.parseToVO(dto);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public List<StepDTO> parseToDTOList(List<StepVO> vos) {
		List<StepDTO> dtos = new ArrayList<>();
		if(vos == null || vos.isEmpty())
			return dtos;
		for (StepVO vo : vos) {
			StepDTO dto = new StepDTO();
			dto = this.parseToDTO(vo);
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public StepDTO parseToDTO(StepVO vo) {
		if(vo == null)
			return null;
		StepDTO dto = new StepDTO();
		if(vo.getId() != null)
			dto.setId(new ObjectId(vo.getId()));
		dto.setName(vo.getName());
		dto.setValue(vo.getValue());
		return dto;
	}

}
