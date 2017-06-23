package com.zhutougg.entity;

import java.util.Date;

public class Authlog {
	private int id;
	private String username;
	private String authStatus;
	private Date authTime;
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
	private int errorTimes;
	private String ipaddr;
	
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
	public Date getAuthTime() {
		return authTime;
	}
	public void setAuthTime(Date authTime) {
		this.authTime = authTime;
	}
	public int getErrorTimes() {
		return errorTimes;
	}
	public void setErrorTimes(int errorTimes) {
		this.errorTimes = errorTimes;
	}
	public String getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	public Authlog() {
		super();
	}
	@Override
	public String toString() {
		return "Authlog [id=" + id + ", username=" + username + ", authStatus="
				+ authStatus + ", authTime=" + authTime + ", errorTimes="
				+ errorTimes + ", ipaddr=" + ipaddr + "]";
	}
}
