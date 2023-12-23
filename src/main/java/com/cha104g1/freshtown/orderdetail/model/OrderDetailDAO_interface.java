package com.cha104g1.freshtown.orderdetail.model;

import java.util.List;

public interface OrderDetailDAO_interface {
	public void insert(OrderDetailVO orderDetailVO);
	public void update(OrderDetailVO orderDetailVO);
	public OrderDetailVO findByPrimaryKey(Integer orderDtlNo);
	public List<OrderDetailVO> getAll();
	//�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<OrderDetailVO> getAll(Map<String, String[]> map); 

}
