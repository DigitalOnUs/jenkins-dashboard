package com.digitalonus.pipelinegenerator.vo;

import com.digitalonus.pipelinegenerator.commons.GsonSingleton;

public class InstanceDataVO {
	private String instanceIp;
	private String initialAdminPassword;

	public String getInstanceIp() {
		return instanceIp;
	}

	public void setInstanceIp(String instanceIp) {
		this.instanceIp = instanceIp;
	}

	public String getInitialAdminPassword() {
		return initialAdminPassword;
	}

	public void setInitialAdminPassword(String initialAdminPassword) {
		this.initialAdminPassword = initialAdminPassword;
	}

	@Override
	public String toString() {
		return new GsonSingleton().getInstance().toJson(this);
	}

}
