package com.cha104g1.freshtown.orderdetail.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cha104g1.freshtown.meals.model.MealsVO;
import com.cha104g1.freshtown.orders.model.OrdersVO;

@Entity
@Table(name = "order_detail")
public class OrderDetailVO {
	@Id
	@Column(name = "orderDtlNo", updatable = false)
	private Integer	orderDtlNo;
	
	@JoinColumn(name="mealNo",referencedColumnName="mealNo")
	private MealsVO mealsVO;
			//	@Column(name="mealNo")
			//	private Integer	mealNo;
	
	@Column(name="mealQty")
	private Integer	mealQty;
	
	
	@JoinColumn(name="orderId", referencedColumnName="orderId")
	private OrdersVO ordersVO;
		//	@Column(name="orderId")
		//	private Integer	orderId;
	
	@Column(name="priceBought")
	private Integer	priceBought;
	
	
	
	public Integer getOrderDtlNo() {
		return orderDtlNo;
	}
	public void setOrderDtlNo(Integer orderDtlNo) {
		this.orderDtlNo = orderDtlNo;
	}
	
//	public Integer getMealNo() {
//		return mealNo;
//	}
//	public void setMealNo(Integer mealNo) {
//		this.mealNo = mealNo;
//	}	
	public MealsVO getMealsVO() {
		return mealsVO;
	}
	public void setMealsVO(MealsVO mealsVO) {
		this.mealsVO = mealsVO;
	}
	
	

	public Integer getMealQty() {
		return mealQty;
	}

	public void setMealQty(Integer mealQty) {
		this.mealQty = mealQty;
	}
	
//	public Integer getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}
	public void setOrdersVO(OrdersVO ordersVO) {
		this.ordersVO = ordersVO;
	}
	public OrdersVO getOrdersVO() {
		return ordersVO;
	}

	
	public Integer getPriceBought() {
		return priceBought;
	}
	public void setPriceBought(Integer priceBought) {
		this.priceBought = priceBought;
	}
	

//	@OneToMany(mappedBy="orderDetailVO" ,cascade=CasecadeType.ALL)
//	private CustomizedOrderVO customizedOrderVO;
//
//
//
//	public CustomizedOrderVO getCustomizedOrderVO() {
//		return customizedOrderVO;
//	}
//	public void setCustomizedOrderVO(CustomizedOrderVO customizedOrderVO) {
//		this.customizedOrderVO = customizedOrderVO;
//	}
	
	

}
