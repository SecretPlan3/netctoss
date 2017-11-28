package org.project.netctoss.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_userDaily")
public class ServiceDailyBean {
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private Long id;

	@Column(name = "date", length = 10)
	private String day;

	//在线时长
	@Column(name = "online_time", length = 10)
	private Long onlineTime;
	
	//累计时长
	@Column(name = "sumtime", length = 10)
	private Long sumTime;

	// 这个段时间的花费
	@Transient
	private Double cost;

	// 某业务账号
	@Transient
	private ServiceBean service;

	public ServiceDailyBean() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Long getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Long onlineTime) {
		this.onlineTime = onlineTime;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public ServiceBean getService() {
		return service;
	}

	public void setService(ServiceBean service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "ServiceDailyBean [id=" + id + ", day=" + day + ", onlineTime=" + onlineTime + ", cost=" + cost
				+ ", service=" + service + "]";
	}


}
