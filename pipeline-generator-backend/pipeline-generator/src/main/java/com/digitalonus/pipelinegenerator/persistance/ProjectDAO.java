package com.digitalonus.pipelinegenerator.persistance;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.digitalonus.pipelinegenerator.entity.Project;

public interface ProjectDAO extends MongoRepository<Project, Serializable>{
	Project findByName(String name);
}
