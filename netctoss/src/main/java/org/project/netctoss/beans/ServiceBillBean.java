package org.project.netctoss.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_service")
//业务账单bean ，单表一个业务的详细账单，包含年份详情bean(含有年份、年总时长、总花费)  其中有月份集合 (月份月总时长和月花费)   其中又有日期集合 （日份月总时长和日总花费）   
public class ServiceBillBean {

	// 业务账号
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="fk_service_id")
	private ServiceBean service;

	// 该业务账号的年Bean
	
	private ServiceYearlyBean serviceYear;


	public ServiceBillBean() {

	}

	public ServiceBean getService() {
		return service;
	}

	public void setService(ServiceBean service) {
		this.service = service;
	}

	public ServiceYearlyBean getServiceYear() {
		return serviceYear;
	}

	public void setServiceYear(ServiceYearlyBean serviceYear) {
		this.serviceYear = serviceYear;
	}

}
