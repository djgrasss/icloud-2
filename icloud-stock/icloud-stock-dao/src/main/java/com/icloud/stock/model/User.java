package com.icloud.stock.model;

// Generated 2014-5-6 20:23:52 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer id;
	private String userName;
	private String userPassword;
	private String userTel;
	private String userEmail;
	private String userComing;
	private String userSex;
	private Date createTime;
	private Date lastUpdateTime;
	private Set userAccesses = new HashSet(0);

	public User() {
	}

	public User(String userName, String userPassword, String userTel,
			String userEmail, String userComing, String userSex,
			Date createTime, Date lastUpdateTime, Set userAccesses) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userComing = userComing;
		this.userSex = userSex;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
		this.userAccesses = userAccesses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserComing() {
		return this.userComing;
	}

	public void setUserComing(String userComing) {
		this.userComing = userComing;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Set getUserAccesses() {
		return this.userAccesses;
	}

	public void setUserAccesses(Set userAccesses) {
		this.userAccesses = userAccesses;
	}

}
