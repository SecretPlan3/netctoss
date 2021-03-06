package org.project.netctoss.beans;
 
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "t_userMonthlyCost")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class BillBean implements Serializable {
  
	private static final long serialVersionUID = -924609537236557091L;
  
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	// 账务账号月花费表ID，也就是账单ID
	private Long id;

	@Column(name = "year", length = 20)
	// 某年
	private String year;

	@Column(name = "month", length = 20)
	// 某月
	private String month;

	@Column(name = "cost")
	// 总费用
	private Double cost; 

	@Column(name = "pay_status")
	// 支付状态，0代表未支付，1代表已支付
	private Integer payStatus;
  
	@Column(name = "pay_method")
	// 支付方式
	private String payMethod;
 
	@Column(name = "pay_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")	//将时间格式转换成自定义格式,timezone设置时区
	// 支付时间
	private Date payTime;
 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_user_id")
	// 账务账号
	private UserBean user;


	public BillBean() {

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

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "BillBean [id=" + id + ", year=" + year + ", month=" + month + ", cost=" + cost + ", payStatus="
				+ payStatus + ", payMothod=" + payMethod + ", payTime=" + payTime + "]" + user;
	}

}
