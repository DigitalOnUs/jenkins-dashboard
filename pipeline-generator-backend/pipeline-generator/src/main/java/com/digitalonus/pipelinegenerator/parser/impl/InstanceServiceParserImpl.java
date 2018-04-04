package com.digitalonus.pipelinegenerator.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.digitalonus.pipelinegenerator.dto.InstanceServiceDTO;
import com.digitalonus.pipelinegenerator.parser.InstanceServiceParser;
import com.digitalonus.pipelinegenerator.vo.InstanceServiceVO;

@Component
public class InstanceServiceParserImpl implements InstanceServiceParser {

	@Override
	public InstanceServiceVO parseToVO(InstanceServiceDTO dto) {
		logger.info("PARSER: Starting parseToVO method...");
		if (dto == null)
			return null;
		InstanceServiceVO vo = new InstanceServiceVO();
		vo.setId(dto.getId());
		vo.setName(dto.getName());
		vo.setEnabled(dto.getEnabled());
		return vo;
	}

	@Override
	public InstanceServiceDTO parseToDTO(InstanceServiceDTO vo) {
		logger.info("PARSER: Starting parseToDTO method...");
		if (vo == null)
			return null;
		InstanceServiceDTO dto = new InstanceServiceDTO();
		dto.setId(vo.getId());
		dto.setName(vo.getName());
		dto.setEnabled(vo.getEnabled());
		return dto;
	}

	@Override
	public List<InstanceServiceVO> parseToVOList(List<InstanceServiceDTO> dtos) {
		logger.info("PARSER: Starting parseToVOList method...");
		List<InstanceServiceVO> vos = new ArrayList<>();
		
		if (dtos != null || !dtos.isEmpty()) {
			dtos.forEach(dto -> {
				InstanceServiceVO vo = new InstanceServiceVO();
				vo.setId(dto.getId());
				vo.setName(dto.getName());
				vo.setEnabled(dto.getEnabled());
				vos.add(vo);
			});
		}
		return vos;
	}

	@Override
	public List<InstanceServiceDTO> parseToDTOList(List<InstanceServiceVO> vos) {
		logger.info("PARSER: Starting parseToDTOList method...");
		List<InstanceServiceDTO> dtos = new ArrayList<>();
		
		if (vos != null || !vos.isEmpty()) {
			vos.forEach(vo -> {
				InstanceServiceDTO dto = new InstanceServiceDTO();
				dto.setId(vo.getId());
				dto.setName(vo.getName());
				dto.setEnabled(vo.getEnabled());
				dtos.add(dto);
			});
		}
		return dtos;
	}

	private static final Logger logger = Logger.getLogger(InstanceServiceParserImpl.class);

}
