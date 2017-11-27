package org.project.netctoss.beans;

import java.util.Set;

public class ServiceMonthlyBean {

	private Long id;

	private String month;

	private Long onlineTime;

	// 这个月的花费
	private Double cost;

	// 某业务账号
	private ServiceBean service;

	// 这个月的所有天
	private Set<ServiceDailyBean> serviceDaily;

	
	
	public ServiceMonthlyBean() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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

	public Set<ServiceDailyBean> getServiceDaily() {
		return serviceDaily;
	}

	public void setServiceDaily(Set<ServiceDailyBean> serviceDaily) {
		this.serviceDaily = serviceDaily;
	}

	@Override
	public String toString() {
		return "ServiceMonthlyBean [id=" + id + ", month=" + month + ", onlineTime=" + onlineTime + ", cost=" + cost
				+ "]";
	}

}
