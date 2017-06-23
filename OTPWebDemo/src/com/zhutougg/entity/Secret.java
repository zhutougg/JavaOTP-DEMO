package com.zhutougg.entity;

import java.util.Date;

public class Secret {

	private int id;
	private String username;
	private String email;
	private String mobile;
	private String seckey;
	private int userStatus;
	private Date loginTime;
	private Date createTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSeckey() {
		return seckey;
	}
	public void setSeckey(String seckey) {
		this.seckey = seckey;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Secret [id=" + id + ", username=" + username + ", email="
				+ email + ", mobile=" + mobile + ", seckey=" + seckey
				+ ", userStatus=" + userStatus + ", loginTime=" + loginTime
				+ ", createtime=" + createTime + "]";
	}
	public Secret() {
		super();
	}
}
