package com.digitalonus.pipelinegenerator.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class PipelineVO {

	private String id;
	@NotNull
	@NotBlank
	@NotEmpty
	private String language;
	private List<StepVO> steps;
	private String projectId;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<StepVO> getSteps() {
		return steps;
	}

	public void setSteps(List<StepVO> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}

}
