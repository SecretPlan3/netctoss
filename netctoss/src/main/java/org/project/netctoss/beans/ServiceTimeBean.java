package org.project.netctoss.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_service_time")
public class ServiceTimeBean {
	@Id
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private Long id; 
	// 登录时间
	@Column(name="login_time")
	private Date loginTime;
	// 登出时间
	@Column(name="logout_time")
	private Date logoutTime;
	// 对应业务账号名
	@Column(name="os_username")
	private String osName;
	// 对应实验室ip
	@Column(name="unix_host")
	private String unxiHost;
	// 在线时长
	@Column(name="online_time")
	private Long onlineTime;
	//本月总使用时长
	@Column(name="sumtime")
	private Long sumTime;
	//业务账号详细花费!
	@OneToOne(fetch=FetchType.LAZY,mappedBy="serviceTime")
	@JsonIgnore	//忽略jackson使用延迟加载
	private ServiceDetailCostBean serviceDetailCost;

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

	public String getOsName() {
		return osName;
	}

	public void setOsName(String osName) {
		this.osName = osName;
	}

	public String getUnxiHost() {
		return unxiHost;
	}

	public void setUnxiHost(String unxiHost) {
		this.unxiHost = unxiHost;
	}

	public Long getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Long onlineTime) {
		this.onlineTime = onlineTime;
	}

	@Override
	public String toString() {
		return "ServiceTimeBean [loginTime=" + loginTime + ", logoutTime=" + logoutTime + ", osName=" + osName
				+ ", unxiHost=" + unxiHost + ", onlineTime=" + onlineTime + "]";
	}

}
