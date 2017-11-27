package org.project.netctoss.beans;

import java.util.List;

public class PermissionBean {


	private String description;
	private Long id;
	private String name;
	private List<RoleBean> roles;

	public PermissionBean(){

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoleBean> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleBean> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "PermissionBean [description=" + description + ", id=" + id + ", name=" + name + "]";
	}
	
	

}