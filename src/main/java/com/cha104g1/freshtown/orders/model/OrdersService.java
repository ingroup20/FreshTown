package com.cha104g1.freshtown.orders.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class OrdersService {

	private OrdersDAO_interface dao;

	public OrdersService() {
		dao = new OrdersJDBCDAO();
	}

	public OrdersVO addOrders(Integer orderId, Integer orderState, Timestamp orderTime, Timestamp doneTime,
			Timestamp finishTime, Timestamp delayTime, Integer customerId, Integer totalPrice, Integer storeId,
			String delayDesc, Integer comtVal, String comtCont, Timestamp comtTime, Timestamp remitDate,
			String remitState, Timestamp payDate, Integer payMethod, Integer payState

	) {
		OrdersVO OrdersVO = new OrdersVO();

		OrdersVO.setOrderId(orderId);
		OrdersVO.setOrderState(orderState);
		OrdersVO.setOrderTime(doneTime);
		OrdersVO.setDoneTime(doneTime);
		OrdersVO.setFinishTime(finishTime);
		OrdersVO.setDelayTime(delayTime);
	//	OrdersVO.setCustomerId(customerId);
		OrdersVO.setTotalPrice(totalPrice);
	//	OrdersVO.setStoreId(storeId);
		OrdersVO.setDelayDesc(delayDesc);
		OrdersVO.setComtVal(comtVal);
		OrdersVO.setComtCont(comtCont);
		OrdersVO.setComtTime(comtTime);
		OrdersVO.setRemitDate(remitDate);
		OrdersVO.setRemitState(remitState);
		OrdersVO.setPayDate(payDate);
		OrdersVO.setPayMethod(payMethod);
		OrdersVO.setPayState(payState);

		dao.insert(OrdersVO);

		return OrdersVO;
	}

	public OrdersVO updateOrders(Integer orderId, Integer orderState, Timestamp orderTime, Timestamp doneTime,
			Timestamp finishTime, Timestamp delayTime, Integer customerId, Integer totalPrice, Integer storeId,
			String delayDesc, Integer comtVal, String comtCont, Timestamp comtTime, Timestamp remitDate,
			String remitState, Timestamp payDate, Integer payMethod, Integer payState
) {
		OrdersVO OrdersVO = new OrdersVO();

		OrdersVO.setOrderId(orderId);
		OrdersVO.setOrderState(orderState);
		OrdersVO.setOrderTime(doneTime);
		OrdersVO.setDoneTime(doneTime);
		OrdersVO.setFinishTime(finishTime);
		OrdersVO.setDelayTime(delayTime);
	//	OrdersVO.setCustomerId(customerId);
		OrdersVO.setTotalPrice(totalPrice);
	//	OrdersVO.setStoreId(storeId);
		OrdersVO.setDelayDesc(delayDesc);
		OrdersVO.setComtVal(comtVal);
		OrdersVO.setComtCont(comtCont);
		OrdersVO.setComtTime(comtTime);
		OrdersVO.setRemitDate(remitDate);
		OrdersVO.setRemitState(remitState);
		OrdersVO.setPayDate(payDate);
		OrdersVO.setPayMethod(payMethod);
		OrdersVO.setPayState(payState);
		dao.update(OrdersVO);

		return OrdersVO;
	}

	public OrdersVO getOneOrders(Integer OrderId) {
		return dao.findByPrimaryKey(OrderId);
	}


	public List<OrdersVO> getAll() {
		return dao.getAll();
	}

}
