package com.digitalonus.pipelinegenerator.commons;

import com.google.gson.Gson;

public class GsonSingleton {
	private static Gson gson = null;

	public Gson getInstance() {
		if (GsonSingleton.gson == null)
			gson = new Gson();
		return GsonSingleton.gson;
	}
}
