package com.cha104g1.freshtown.orders.model;

import java.util.List;

public interface OrdersDAO_interface {
	public void insert(OrdersVO ordersVO);
	public void update(OrdersVO ordersVO);
	public OrdersVO findByPrimaryKey(Integer id);
	public List<OrdersVO> getAll();
	//�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<OrdersVO> getAll(Map<String, String[]> map); 
}
