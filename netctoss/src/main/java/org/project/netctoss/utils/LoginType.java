package org.project.netctoss.utils;

public enum LoginType {
	USER("User"), MANAGER("Manager");

	private String type;

	private LoginType(String type) {
		this.type = type;
	};

	@Override
	public String toString() {
		return this.type.toString();
	}
}
