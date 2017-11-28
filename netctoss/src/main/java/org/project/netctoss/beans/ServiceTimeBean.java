package org.project.netctoss.beans;

import java.util.Date;

public class ServiceTimeBean {
		    private Long id;
			//登录时间
		    private Date loginTime;
			//登出时间
		    private Date logoutTime;
			//对应业务账号名
		    private String osName;
			//对应实验室ip
		    private String unxiHost;
			//在线时长
		    private Long onlineTime;
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
			public String getOsName() {
				return osName;
			}
			public void setOsName(String osName) {
				this.osName = osName;
			}
			public String getUnxiHost() {
				return unxiHost;
			}
			public void setUnxiHost(String unxiHost) {
				this.unxiHost = unxiHost;
			}
			public Long getOnlineTime() {
				return onlineTime;
			}
			public void setOnlineTime(Long onlineTime) {
				this.onlineTime = onlineTime;
			}
			@Override
			public String toString() {
				return "ServiceTimeBean [loginTime=" + loginTime + ", logoutTime=" + logoutTime + ", osName=" + osName
						+ ", unxiHost=" + unxiHost + ", onlineTime=" + onlineTime + "]";
			}
			 
}
