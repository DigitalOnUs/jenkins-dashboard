package com.digitalonus.pipelinegenerator.vo;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class JenkinsLogLineVO {
	private Integer lineNumber;
	private String message;

	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}

}
