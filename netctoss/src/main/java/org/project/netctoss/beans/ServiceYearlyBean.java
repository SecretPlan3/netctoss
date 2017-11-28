package org.project.netctoss.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_serviceYearly")
public class ServiceYearlyBean {
	 
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private Long id;
	
	@Column(name = "year", length = 10)
	private String year;
	 
	@Column(name = "online_time")
	private Long onlineTime;
	
	@Column(name = "cost")
	private Double cost;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_service_id")
	//这一年中的所有业务账号
	private ServiceBean service;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="serviceYearly")
	//这一年中的所有月
	private Set<ServiceMonthlyBean> serviceMonthly;

	
	
	
	public ServiceYearlyBean() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public Set<ServiceMonthlyBean> getServiceMonthly() {
		return serviceMonthly;
	}

	public void setServiceMonthly(Set<ServiceMonthlyBean> serviceMonthly) {
		this.serviceMonthly = serviceMonthly;
	}

	@Override
	public String toString() {
		return "ServiceYearlyBean [id=" + id + ", year=" + year + ", onlineTime=" + onlineTime + "]";
	}
	
	
}
