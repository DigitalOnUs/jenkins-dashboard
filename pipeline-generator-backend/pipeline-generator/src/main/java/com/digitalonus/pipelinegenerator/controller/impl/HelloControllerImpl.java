package com.digitalonus.pipelinegenerator.controller.impl;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalonus.pipelinegenerator.controller.HelloController;
import com.digitalonus.pipelinegenerator.vo.UserVO;

@RestController
@RequestMapping("hello")
public class HelloControllerImpl implements HelloController {

	@RequestMapping("/world")
	public UserVO world(@RequestParam String name) {
		logger.info("Starting hello controller");
		return null;
	}

	private static final Logger logger = 
			Logger.getLogger(HelloController.class);
}
