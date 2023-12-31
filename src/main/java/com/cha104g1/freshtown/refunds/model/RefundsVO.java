package com.cha104g1.freshtown.refunds.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.cha104g1.freshtown.orders.model.OrdersVO;

@Entity
@Table(name = "refunds")
public class RefundsVO implements java.io.Serializable {
	@Id
	@Column(name = "id", updatable = false)
	private Integer id;
	
	@JoinColumn(name="orderId", referencedColumnName="orderId")
	private OrdersVO ordersVO;
		//	@Column(name="orderId")
		//	private Integer orderId; 
	
	@Column(name="refundState")
	private String refundState;
	
	@Column(name="refundDollar")
	private Integer refundDollar;
	
	@Column(name="refundDate")
	private Date refundDate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public Integer getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}	
	public OrdersVO getOrdersVO() {
		return ordersVO;
	}
	public void setOrdersVO(OrdersVO ordersVO) {
		this.ordersVO = ordersVO;
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
