package org.project.netctoss.beans;

import java.util.Set;

public class ServiceYearlyBean {
	
	private Long id;
	
	private String year;
	
	private Long onlineTime;
	
	//某业务账号
	private ServiceBean service;
	
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
