package org.project.netctoss.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="t_managerlog")
public class ManagerLogBean {
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private long id;
	
	@Column(name="login_time")
	private Date loginTime;//登陆时间
	
	@Column(name="logout_time")
	private Date logoutTime;//退出时间
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="fk_manager_id")
	private ManagerBean managerOperation;//操作者
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore	//忽略jackson使用延迟加载
	private List<ManagerOperationLogBean> operationLog;//在这时间段内该管理员所有的操作
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	public ManagerBean getManagerOperation() {
		return managerOperation;
	}
	public void setManagerOperation(ManagerBean managerOperation) {
		this.managerOperation = managerOperation;
	}
	public List<ManagerOperationLogBean> getOperationLog() {
		return operationLog;
	}
	public void setOperationLog(List<ManagerOperationLogBean> operationLog) {
		this.operationLog = operationLog;
	}
	
	//项目测试
	@Override
	public String toString() {
		return "ManagerLogBean [id=" + id + ", loginTime=" + loginTime + ", logoutTime=" + logoutTime
				+ ", managerOperation=" + managerOperation + ", operationLog=" + operationLog + "]";
	}
	
}
