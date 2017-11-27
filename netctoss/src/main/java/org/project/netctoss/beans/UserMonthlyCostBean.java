package org.project.netctoss.beans;

import java.util.Date;

public class UserMonthlyCostBean {
	
	// 用户月花费表ID，也就是账单ID
	private Long id;

	// 某年
	private String year;
	
	// 某月
	private String month;
	
	// 总费用
	private Double cost;

	// 支付状态，0代表未支付，1代表已支付
	private Integer payStatus;

	// 支付方式
	private String payMothod;

	// 支付时间
	private Date payTime;
	
	// 账务账号
	private UserBean user;

	

	public UserMonthlyCostBean() {
		
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayMothod() {
		return payMothod;
	}

	public void setPayMothod(String payMothod) {
		this.payMothod = payMothod;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	@Override
	public String toString() {
		return "UserMonthlyCostBean [id=" + id + ", year=" + year + ", month=" + month + ", cost=" + cost
				+ ", payStatus=" + payStatus + ", payMothod=" + payMothod + ", payTime=" + payTime + "]";
	}
	

	
}
