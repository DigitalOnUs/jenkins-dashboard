package com.digitalonus.pipelinegenerator.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

@Document
public class Pipeline {
	@Id
	private ObjectId id;
	private String language;
	@DBRef
	private List<Step> steps;
	@DBRef
	private Project project;

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

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}
	
	
}
