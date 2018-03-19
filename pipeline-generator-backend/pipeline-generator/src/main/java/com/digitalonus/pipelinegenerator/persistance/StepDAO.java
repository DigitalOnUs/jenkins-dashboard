package com.digitalonus.pipelinegenerator.persistance;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.digitalonus.pipelinegenerator.entity.Step;

public interface StepDAO extends MongoRepository<Step, String> {
	
}
