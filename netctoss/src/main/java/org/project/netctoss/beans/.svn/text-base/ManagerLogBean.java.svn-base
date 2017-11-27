package org.project.netctoss.beans;

import java.util.Date;
import java.util.List;

public class ManagerLogBean {
	private long id;
	private Date loginTime;//登陆时间
	private Date logoutTime;//退出时间
	private ManagerBean managerOperation;//操作者
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
