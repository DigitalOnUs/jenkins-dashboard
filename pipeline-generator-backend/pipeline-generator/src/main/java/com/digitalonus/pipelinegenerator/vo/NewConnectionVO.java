package com.digitalonus.pipelinegenerator.vo;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class NewConnectionVO {

	@NotNull
	@NotEmpty
	private List<InstanceServiceVO> services;
	
	@NotNull
	private ProviderCredentialsVO credentials;

	public ProviderCredentialsVO getCredentials() {
		return credentials;
	}

	public void setCredentials(ProviderCredentialsVO credentials) {
		this.credentials = credentials;
	}

	public List<InstanceServiceVO> getServices() {
		return services;
	}

	public void setServices(List<InstanceServiceVO> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}

}
