package com.digitalonus.pipelinegenerator.vo;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class InstanceServiceVO {
	private String id;
	private String name;
	private Boolean enabled;

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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}

	
}
