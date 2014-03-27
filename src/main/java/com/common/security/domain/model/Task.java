package com.common.security.domain.model;

public class Task extends PersistentObject {

	private String description;

	private String name;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
