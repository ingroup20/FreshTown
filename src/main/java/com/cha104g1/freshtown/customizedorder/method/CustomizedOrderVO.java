package com.cha104g1.freshtown.customizedorder.method;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.cha104g1.freshtown.customizeddetail.model.CustomizedDetailVO;
import com.cha104g1.freshtown.orderdetail.model.OrderDetailVO;

@Table(name="customized_order")
public class CustomizedOrderVO {

	@Id
	@Column(name="custedOrderNo")
	private Integer custedOrderNo;
	
	@JoinColumn(name="orderDtlNo",referencedColumnName="orderDtlNo")
	private OrderDetailVO orderDetailVO;
		//	@Column(name="orderDtlNo")
		//	private Integer orderDtlNo;
	
	@JoinColumn(name="custedDtlNo",referencedColumnName="custedDtlNo")
	private CustomizedDetailVO customizedDetailVO;
		//	@Column(name="custedDtlNo")
		//	private Integer custedDtlNo;
	
	
	public Integer getCustedOrderNo() {
		return custedOrderNo;
	}
	public void setCustedOrderNo(Integer custedOrderNo) {
		this.custedOrderNo = custedOrderNo;
	}
//	public Integer getOrderDtlNo() {
//		return orderDtlNo;
//	}
//	public void setOrderDtlNo(Integer orderDtlNo) {
//		this.orderDtlNo = orderDtlNo;
//	}
//	public Integer getCustedDtlNo() {
//		return custedDtlNo;
//	}
//	public void setCustedDtlNo(Integer custedDtlNo) {
//		this.custedDtlNo = custedDtlNo;
//	}
	public OrderDetailVO getOrderDetailVO() {
		return orderDetailVO;
	}
	public void setOrderDetailVO(OrderDetailVO orderDetailVO) {
		this.orderDetailVO = orderDetailVO;
	}
	public CustomizedDetailVO getCustomizedDetailVO() {
		return customizedDetailVO;
	}
	public void setCustomizedDetailVO(CustomizedDetailVO customizedDetailVO) {
		this.customizedDetailVO = customizedDetailVO;
	}
	
	
	
	
	
}
