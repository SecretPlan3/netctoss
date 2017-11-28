package org.project.netctoss.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Date day;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_servicemonthly_id")
	//这些天的月份
	private ServiceMonthlyBean serviceMonthly;
	
	public ServiceDailyBean() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
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

	public Long getSumTime() {
		return sumTime;
	}

	public void setSumTime(Long sumTime) {
		this.sumTime = sumTime;
	}

	public ServiceMonthlyBean getServiceMonthly() {
		return serviceMonthly;
	}

	public void setServiceMonthly(ServiceMonthlyBean serviceMonthly) {
		this.serviceMonthly = serviceMonthly;
	}

	@Override
	public String toString() {
		return "ServiceDailyBean [id=" + id + ", day=" + day + ", onlineTime=" + onlineTime + ", cost=" + cost
				+ ", service=" + service + "]";
	}


}
