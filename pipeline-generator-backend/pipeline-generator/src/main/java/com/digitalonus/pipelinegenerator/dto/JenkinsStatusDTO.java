package com.digitalonus.pipelinegenerator.dto;

public class JenkinsStatusDTO {
	private String status;
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "JenkinsStatusVO [status=" + status + ", message=" + message + "]";
	}
}
