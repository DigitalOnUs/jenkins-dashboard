package com.digitalonus.pipelinegenerator.dto;

import org.bson.types.ObjectId;

public class StepDTO {
	private ObjectId id;
	private String name;
	private String value;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
