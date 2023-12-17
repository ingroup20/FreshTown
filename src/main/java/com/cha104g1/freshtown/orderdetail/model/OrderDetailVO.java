package com.cha104g1.freshtown.orderdetail.model;

import java.sql.Timestamp;

public class OrderDetailVO {
	private Integer	orderDtlNo;
	private Integer	mealNo;
	private Integer	mealQty;
	private Integer	orderId;
	private Integer	priceBought;
	
	public Integer getOrderDtlNo() {
		return orderDtlNo;
	}
	public void setOrderDtlNo(Integer orderDtlNo) {
		this.orderDtlNo = orderDtlNo;
	}
	public Integer getMealNo() {
		return mealNo;
	}
	public void setMealNo(Integer mealNo) {
		this.mealNo = mealNo;
	}
	public Integer getMealQty() {
		return mealQty;
	}
	public void setMealQty(Integer mealQty) {
		this.mealQty = mealQty;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPriceBought() {
		return priceBought;
	}
	public void setPriceBought(Integer priceBought) {
		this.priceBought = priceBought;
	}
	
	

	
	
	

}
