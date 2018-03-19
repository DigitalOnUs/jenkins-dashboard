package com.digitalonus.pipelinegenerator.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

@Document
public class Step {

	@Id
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

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}

}
