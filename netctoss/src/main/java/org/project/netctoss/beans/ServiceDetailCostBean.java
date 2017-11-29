package org.project.netctoss.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_serviceDetailCost")
public class ServiceDetailCostBean {
	
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private Long id;
	
	@Column(name = "cost")
	private Double cost;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_service_time_id")
	@JsonIgnore	//忽略jackson使用延迟加载
	private ServiceTimeBean serviceTime;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cost_id")
	@JsonIgnore	//忽略jackson使用延迟加载
	private CostBean costbean;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_service_id")
	@JsonIgnore	//忽略jackson使用延迟加载
	private ServiceBean service;
	
	
	
	public ServiceDetailCostBean() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}


	public ServiceTimeBean getServiceTime() {
		return serviceTime;
	}


	public void setServiceTime(ServiceTimeBean serviceTime) {
		this.serviceTime = serviceTime;
	}


	public CostBean getCostbean() {
		return costbean;
	}


	public void setCostbean(CostBean costbean) {
		this.costbean = costbean;
	}


	public ServiceBean getService() {
		return service;
	}


	public void setService(ServiceBean service) {
		this.service = service;
	}


	@Override
	public String toString() {
		return "ServiceDailyCostBean [id=" + id + ", Cost=" + cost + "]";
	}
	
	
}
