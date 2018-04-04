package com.digitalonus.pipelinegenerator.vo;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class ProviderCredentialsVO {
	@NotNull
	@NotEmpty
	@NotBlank
	private ProviderVO provider;

	@NotNull
	@NotEmpty
	@NotBlank
	private String accessKey;

	@NotNull
	@NotEmpty
	@NotBlank
	private String secretKey;

	public ProviderVO getProvider() {
		return provider;
	}

	public void setProvider(ProviderVO provider) {
		this.provider = provider;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}
}
