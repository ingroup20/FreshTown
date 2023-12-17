package com.cha104g1.freshtown.orders.model;

import java.sql.Timestamp;

public class OrdersVO {
	private Integer orderId;
	private Integer orderState;
	private Timestamp orderTime;
	private Timestamp doneTime;
	private Timestamp finishTime;
	private Timestamp delayTime;
	private Integer customerId;
	private Integer totalPrice;
	private Integer storeId;
	private String delayDesc;
	private Integer comtVal;
	private String comtCont;
	private Timestamp comtTime;
	private Timestamp remitDate;
	private String remitState;
	private Timestamp payDate;
	private Integer payMethod;
	private Integer payState;
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public Timestamp getDoneTime() {
		return doneTime;
	}
	public void setDoneTime(Timestamp doneTime) {
		this.doneTime = doneTime;
	}
	public Timestamp getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Timestamp finishTime) {
		this.finishTime = finishTime;
	}
	public Timestamp getDelayTime() {
		return delayTime;
	}
	public void setDelayTime(Timestamp delayTime) {
		this.delayTime = delayTime;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getDelayDesc() {
		return delayDesc;
	}
	public void setDelayDesc(String delayDesc) {
		this.delayDesc = delayDesc;
	}
	public Integer getComtVal() {
		return comtVal;
	}
	public void setComtVal(Integer comtVal) {
		this.comtVal = comtVal;
	}
	public String getComtCont() {
		return comtCont;
	}
	public void setComtCont(String comtCont) {
		this.comtCont = comtCont;
	}
	public Timestamp getComtTime() {
		return comtTime;
	}
	public void setComtTime(Timestamp comtTime) {
		this.comtTime = comtTime;
	}
	public Timestamp getRemitDate() {
		return remitDate;
	}
	public void setRemitDate(Timestamp remitDate) {
		this.remitDate = remitDate;
	}
	public String getRemitState() {
		return remitState;
	}
	public void setRemitState(String remitState) {
		this.remitState = remitState;
	}
	public Timestamp getPayDate() {
		return payDate;
	}
	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}
	public Integer getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}
	public Integer getPayState() {
		return payState;
	}
	public void setPayState(Integer payState) {
		this.payState = payState;
	}
	
}
