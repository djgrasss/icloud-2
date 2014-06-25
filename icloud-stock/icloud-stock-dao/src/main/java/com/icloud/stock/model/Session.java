package com.icloud.stock.model;

// Generated 2014-6-26 2:01:31 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Session generated by hbm2java
 */
public class Session implements java.io.Serializable {

	private Integer id;
	private String sessionId;
	private Date createTime;
	private Integer sessionAccessType;
	private String sessionAccessDescription;
	private String sessionIp;
	private Integer userId;

	public Session() {
	}

	public Session(String sessionId, Date createTime,
			Integer sessionAccessType, String sessionAccessDescription,
			String sessionIp, Integer userId) {
		this.sessionId = sessionId;
		this.createTime = createTime;
		this.sessionAccessType = sessionAccessType;
		this.sessionAccessDescription = sessionAccessDescription;
		this.sessionIp = sessionIp;
		this.userId = userId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getSessionAccessType() {
		return this.sessionAccessType;
	}

	public void setSessionAccessType(Integer sessionAccessType) {
		this.sessionAccessType = sessionAccessType;
	}

	public String getSessionAccessDescription() {
		return this.sessionAccessDescription;
	}

	public void setSessionAccessDescription(String sessionAccessDescription) {
		this.sessionAccessDescription = sessionAccessDescription;
	}

	public String getSessionIp() {
		return this.sessionIp;
	}

	public void setSessionIp(String sessionIp) {
		this.sessionIp = sessionIp;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
