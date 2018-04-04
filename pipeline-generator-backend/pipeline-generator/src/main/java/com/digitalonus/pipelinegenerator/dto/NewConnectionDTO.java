package com.digitalonus.pipelinegenerator.dto;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class NewConnectionDTO {

	@NotNull
	@NotEmpty
	private List<InstanceServiceDTO> services;
	
	@NotNull
	private ProviderCredentialsDTO credentials;

	public ProviderCredentialsDTO getCredentials() {
		return credentials;
	}

	public void setCredentials(ProviderCredentialsDTO credentials) {
		this.credentials = credentials;
	}

	public List<InstanceServiceDTO> getServices() {
		return services;
	}

	public void setServices(List<InstanceServiceDTO> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}

}
