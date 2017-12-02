package org.project.netctoss.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="t_cost")
public class CostBean {
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private long id;
	
	@Column(name="name",length=50)
	private String name;//资费名称
	
	@Column(name="cost_number")
	private String costNumber;//套餐编号
	
	@Column(name="type")
	private int type;//资费类型；分为三种：包月套餐/自助类型/计时套餐
	
	@Column(name="basic_time")
	private Integer basicTime;//基本时长
	
	@Column(name="basic_cost")
	private Double basicCost;//基本费用
	
	@Column(name="unit_cost")
	private Double unitCost;//单位费用
	
	@Column(name="status")
	private int status;//资费状态
	
	@Column(name="description",length=100)
	private String description;//资费说明
	
	@Column(name="create_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")	//将时间格式转换成自定义格式,timezone设置时区
	private Date createTime;//创建时间
	
	@Column(name="start_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")	//将时间格式转换成自定义格式,timezone设置时区
	private Date startTime;//开始时间
	
	@Column(name="close_time")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")	//将时间格式转换成自定义格式,timezone设置时区
	private Date closeTime;//关闭时间
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public Integer getBasicTime() {
		return basicTime;
	}
	public void setBasicTime(Integer basicTime) {
		this.basicTime = basicTime;
	}
	public Double getBasicCost() {
		return basicCost;
	}
	public void setBasicCost(Double basicCost) {
		this.basicCost = basicCost;
	}
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	public String getCostNumber() {
		return costNumber;
	}
	public void setCostNumber(String costNumber) {
		this.costNumber = costNumber;
	}
	//用于测试
	@Override
	public String toString() {
		return "CostBean [id=" + id + ", name=" + name + ", costNumber=" + costNumber + ", type=" + type
				+ ", basicTime=" + basicTime + ", basicCost=" + basicCost + ", unitCost=" + unitCost + ", status="
				+ status + ", description=" + description + ", createTime=" + createTime + ", startTime=" + startTime
				+ ", closeTime=" + closeTime + "]";
	}
}
