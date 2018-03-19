package com.digitalonus.pipelinegenerator.persistance;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.digitalonus.pipelinegenerator.entity.Pipeline;
import com.digitalonus.pipelinegenerator.entity.Project;

public interface PipelineDAO extends MongoRepository<Pipeline, String>{
	Pipeline findOneByProject(Project project);
}
