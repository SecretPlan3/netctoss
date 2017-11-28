package org.project.netctoss.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "t_service_time")
public class ServiceTimeBean {
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private Long id ;
	
	@Column(name = "login_time")
	private Date loginTime;
	
	@Column(name = "logout_time")
	private Date logoutTime;
	
	@Column(name = "online_time")
	private Long onlineTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	public Long getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Long onlineTime) {
		this.onlineTime = onlineTime;
	}

	@Override
	public String toString() {
		return "ServiceTimeBean [id=" + id + ", loginTime=" + loginTime + ", logoutTime=" + logoutTime + ", onlineTime="
				+ onlineTime + "]";
	}
	
	
	
}
