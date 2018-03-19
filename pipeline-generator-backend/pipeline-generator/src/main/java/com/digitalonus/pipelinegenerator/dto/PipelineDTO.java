package com.digitalonus.pipelinegenerator.dto;

import java.util.List;

import org.bson.types.ObjectId;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class PipelineDTO {

	private ObjectId id;
	private String language;
	private List<StepDTO> steps;
	private ObjectId projectId;

	public ObjectId getProjectId() {
		return projectId;
	}

	public void setProjectId(ObjectId projectId) {
		this.projectId = projectId;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<StepDTO> getSteps() {
		return steps;
	}

	public void setSteps(List<StepDTO> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}

}
