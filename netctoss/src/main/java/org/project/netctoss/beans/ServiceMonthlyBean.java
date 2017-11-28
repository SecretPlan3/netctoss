package org.project.netctoss.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_servicemonthly")
public class ServiceMonthlyBean {
 
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private Long id;

	@Column(name = "month", length = 10)
	private String month;

	@Column(name = "online_time")
	private Long onlineTime;

	@Column(name = "cost")
	// 这个月的花费
	private Double cost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_serviceyearly_id")
	private ServiceYearlyBean serviceYearly;

	@Transient
	// 某业务账号
	private ServiceBean service;

	@Transient
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
