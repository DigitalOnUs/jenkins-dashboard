package com.digitalonus.pipelinegenerator.vo;

import java.util.List;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class TestingSetupVO {
	private String server;
	private List<String> services;

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}
	
	

}
