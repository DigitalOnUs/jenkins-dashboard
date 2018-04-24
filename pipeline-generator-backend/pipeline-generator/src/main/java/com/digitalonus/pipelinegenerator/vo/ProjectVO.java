package com.digitalonus.pipelinegenerator.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class ProjectVO {

	private String id;
	@NotNull
	@NotBlank
	@NotEmpty
	private String name;
	private List<StepVO> steps;
	private String userEmail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StepVO> getSteps() {
		return steps;
	}

	public void setSteps(List<StepVO> steps) {
		this.steps = steps;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}

}
