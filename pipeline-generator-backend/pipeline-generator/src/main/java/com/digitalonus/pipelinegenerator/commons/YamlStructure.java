package com.digitalonus.pipelinegenerator.commons;

import java.util.List;
import java.util.Map;

public class YamlStructure {

	private String name;
	private List<Map<String, ParameterItem>> parameters;
	private List<BuilderItem> builders;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Map<String, ParameterItem>> getParameters() {
		return parameters;
	}

	public void setParameters(List<Map<String, ParameterItem>> parameters) {
		this.parameters = parameters;
	}

	public List<BuilderItem> getBuilders() {
		return builders;
	}

	public void setBuilders(List<BuilderItem> builders) {
		this.builders = builders;
	}

	public static class ParameterItem {

		private String type;
		private String name;
		private String value;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
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

	public static class BuilderItem {
		private String type;
		private String value;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}
}
