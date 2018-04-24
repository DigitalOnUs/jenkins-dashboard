package com.digitalonus.pipelinegenerator.dto;

import java.util.List;

import org.bson.types.ObjectId;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class ProjectDTO {
	private ObjectId id;
	private String name;
	private List<StepDTO> steps;
	private String userEmail;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
