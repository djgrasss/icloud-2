package com.icloud.stock.model;

// Generated 2014-5-24 17:00:25 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * StockDivinePrice generated by hbm2java
 */
public class StockDivinePrice implements java.io.Serializable {

	private Integer id;
	private Integer stockId;
	private String stockCode;
	private Double preLow;
	private Double preHigh;
	private Double resultLow;
	private Double resultHigh;
	private Date preDateTime;
	private Date createTime;
	private Integer userId;
	private String userName;
	private String userComment;

	public StockDivinePrice() {
	}

	public StockDivinePrice(Integer stockId, String stockCode, Double preLow,
			Double preHigh, Double resultLow, Double resultHigh,
			Date preDateTime, Date createTime, Integer userId, String userName,
			String userComment) {
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.preLow = preLow;
		this.preHigh = preHigh;
		this.resultLow = resultLow;
		this.resultHigh = resultHigh;
		this.preDateTime = preDateTime;
		this.createTime = createTime;
		this.userId = userId;
		this.userName = userName;
		this.userComment = userComment;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public Double getPreLow() {
		return this.preLow;
	}

	public void setPreLow(Double preLow) {
		this.preLow = preLow;
	}

	public Double getPreHigh() {
		return this.preHigh;
	}

	public void setPreHigh(Double preHigh) {
		this.preHigh = preHigh;
	}

	public Double getResultLow() {
		return this.resultLow;
	}

	public void setResultLow(Double resultLow) {
		this.resultLow = resultLow;
	}

	public Double getResultHigh() {
		return this.resultHigh;
	}

	public void setResultHigh(Double resultHigh) {
		this.resultHigh = resultHigh;
	}

	public Date getPreDateTime() {
		return this.preDateTime;
	}

	public void setPreDateTime(Date preDateTime) {
		this.preDateTime = preDateTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserComment() {
		return this.userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

}
