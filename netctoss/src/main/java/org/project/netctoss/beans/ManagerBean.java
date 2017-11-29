package org.project.netctoss.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="t_manager")
public class ManagerBean implements Serializable{
	
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private Long id;
	
	@Column(name="email",length=50)
	private String email;
	@Column(name="login_name",length=20)
	private String loginName;
	@Column(name="mag_name",length=20)
	private String magName;
	@Column(name="password",length=32)
	private String password;
	@Column(name="tel",length=11)
	private String tel;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "t_manager_role", joinColumns = @JoinColumn(name = "fk_manager_id"), 
	inverseJoinColumns = @JoinColumn(name = "fk_role_id"))
	@JsonIgnore	//忽略jackson使用延迟加载
	private Set<RoleBean> theRole;

	public ManagerBean(){

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMagName() {
		return magName;
	}

	public void setMagName(String magName) {
		this.magName = magName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	public Set<RoleBean> getTheRole() {
		return theRole;
	}

	public void setTheRole(Set<RoleBean> theRole) {
		this.theRole = theRole;
	}

	@Override
	public String toString() {
		return "ManagerBean [email=" + email + ", id=" + id + ", loginName=" + loginName + ", magName=" + magName
				+ ", password=" + password + ", tel=" + tel + ", theRole=" + theRole + "]";
	}

	
}