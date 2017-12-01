package org.project.netctoss.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="t_manageroperationlog")
public class ManagerOperationLogBean {
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private long id;
	
	@Column(name="operation_time")
	private Date operationTime;//操作时间
	
	@Column(name="type")
	private int type;//操作类型
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_manager_id")
	private ManagerBean operationManager;//操作管理人员
	
	@Column(name="address",length=50)
	private String address;//操作位置
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	public long getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ManagerBean getOperationManager() {
		return operationManager;
	}
	public void setOperationManager(ManagerBean operationManager) {
		this.operationManager = operationManager;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	//用于项目测试
	@Override
	public String toString() {
		return "ManagerOperationLogBean [id=" + id + ", operationTime=" + operationTime + ", type=" + type
				+ ", operationManager=" + operationManager + ", address=" + address + "]";
	}
}
