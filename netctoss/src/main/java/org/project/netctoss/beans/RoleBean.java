package org.project.netctoss.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_role")
public class RoleBean implements Serializable{
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private Long id;
	
	@Column(name="name",length=20)
	private String name;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="roles")
	private List<PermissionBean> pers;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="theRole")
	private List<ManagerBean> managers;
	
	@Column(name="type",length=11)
	private String type;

	public RoleBean(){

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

	public List<PermissionBean> getPers() {
		return pers;
	}

	public void setPers(List<PermissionBean> pers) {
		this.pers = pers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	public List<ManagerBean> getManagers() {
		return managers;
	}

	public void setManagers(List<ManagerBean> managers) {
		this.managers = managers;
	}
	   public Set<String> getPermissionsName() {
	        Set<String> list = new HashSet<>();
	        List<PermissionBean> perlist = this.getPers();
	        for (PermissionBean per : perlist) {
	            list.add(per.getName());
	        }
	        return list;
	}

	@Override
	public String toString() {
		return "RoleBean [id=" + id + ", name=" + name + ", pers=" + pers + ", type=" + type + "]";
	}

	
}