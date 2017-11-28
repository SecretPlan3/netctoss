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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_user")
public class UserBean implements Serializable{
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "hibernate.identity", strategy = "identity")
	@GeneratedValue(generator = "hibernate.identity")
	private Long userId;
	
	@Column(name = "user_name", length = 20)
	private String userName;
	
	@Column(name = "login_name", length = 20)
	private String loginName;
	
	@Column(name = "password", length = 32)
	private String passWord;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "pause_date")
	private Date pauseDate;
	
	@Column(name = "close_dete")
	private Date closeDate;
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "idcard", length = 18)
	private String idcard;
	
	@Column(name = "tel", length = 11)
	private String tel;
	
	@Column(name = "tel", length = 50)
	private String address;
	
	@Column(name = "postcode", length = 10)
	private String postcode;
	
	@Column(name = "qq", length = 11)
	private String qq;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_role_id")
	private RoleBean roler;
	

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="user")
	private Set<ServiceBean> services;
	
	@Column(name = "balance", length = 11)
	private String balance;
	
	
	
	
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
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
	public Long getUserId() {
		return userId;
	}
	public Set<ServiceBean> getServices() {
		return services;
	}
	public void setServices(Set<ServiceBean> services) {
		this.services = services;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}


	
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName + ", loginName=" + loginName + ", passWord="
				+ passWord + ", status=" + status + ", createDate=" + createDate + ", pauseDate=" + pauseDate
				+ ", closeDate=" + closeDate + ", gender=" + gender + ", idcard=" + idcard + ", tel=" + tel
				+ ", address=" + address + ", postcode=" + postcode + ", qq=" + qq + ", roler=" + roler + ", services="
				+ services + ", balance=" + balance + "]";
	}
	public RoleBean getRoler() {
		return roler;
	}
	public void setRoler(RoleBean roler) {
		this.roler = roler;
	}
	
}
