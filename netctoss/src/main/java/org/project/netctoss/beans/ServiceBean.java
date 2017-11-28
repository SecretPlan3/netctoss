package org.project.netctoss.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="t_service")
public class ServiceBean {
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	  private String id;
	
	@Column(name="unix_host",length=15)
	  private String unixHost;
	
	@Column(name="os_username",length=20)
	  private String osName;
	@Column(name="password",length=32)
	  private String osPassword;
	@Column(name="status")
	  private Integer status;
	@Column(name="create_date")
	  private Date createDate;
	@Column(name="pause_date")
	  private Date pauseDate;
	@Column(name="close_date")
	  private Date closeDate;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="fk_user_id")
	  private UserBean user;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="fk_cost_id")
	private CostBean cost;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="service")
	private Set<ServiceDetailCostBean>  serviceDetailCostSet;
	
	public String getUnixHost() {
		return unixHost;
	}
	public void setUnixHost(String unixHost) {
		this.unixHost = unixHost;
	}
	public String getOsName() {
		return osName;
	}
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public String getOsPassword() {
		return osPassword;
	}
	public void setOsPassword(String osPassword) {
		this.osPassword = osPassword;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getPauseDate() {
		return pauseDate;
	}
	public void setPauseDate(Date pauseDate) {
		this.pauseDate = pauseDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public CostBean getCost() {
		return cost;
	}
	public void setCost(CostBean cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "ServiceBean [unixHost=" + unixHost + ", osName=" + osName + ", osPassword=" + osPassword + ", status="
				+ status + ", createDate=" + createDate + ", pauseDate=" + pauseDate + ", closeDate=" + closeDate + "]";
	}
	  
}
