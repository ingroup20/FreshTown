package com.cha104g1.freshtown.refunds.model;

import java.sql.Date;

public class RefundsVO implements java.io.Serializable {
	private Integer id;
	private Integer orderId; 
	private String refundState;
	private Integer refundDollar;
	private Date refundDate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getRefundState() {
		return refundState;
	}
	public void setRefundState(String refundState) {
		this.refundState = refundState;
	}
	public Integer getRefundDollar() {
		return refundDollar;
	}
	public void setRefundDollar(Integer refundDollar) {
		this.refundDollar = refundDollar;
	}
	public Date getRefundDate() {
		return refundDate;
	}
	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}
	
	
	
}
