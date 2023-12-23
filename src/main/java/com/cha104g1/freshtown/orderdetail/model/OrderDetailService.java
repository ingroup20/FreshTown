package com.cha104g1.freshtown.orderdetail.model;

import java.util.List;

public class OrderDetailService {

	private OrderDetailDAO_interface dao;

	public OrderDetailService() {
		dao = new OrderDetailJDBCDAO();
	}

	public OrderDetailVO addOrderDetail(Integer orderDtlNo, Integer mealNo, Integer mealQty, Integer orderId,
			Integer priceBought

	) {
		OrderDetailVO OrderDetailVO = new OrderDetailVO();

		OrderDetailVO.setOrderDtlNo(orderDtlNo);
	//	OrderDetailVO.setMealNo(mealNo);
		OrderDetailVO.setMealQty(mealQty);
		//OrderDetailVO.setOrderId(orderId);
		OrderDetailVO.setPriceBought(priceBought);

		dao.insert(OrderDetailVO);

		return OrderDetailVO;
	}

	public OrderDetailVO updateOrderDetail(Integer orderDtlNo, Integer mealNo, Integer mealQty, Integer orderId,
			Integer priceBought) {
		
		OrderDetailVO OrderDetailVO = new OrderDetailVO();
		OrderDetailVO.setOrderDtlNo(orderDtlNo);
		//OrderDetailVO.setMealNo(mealNo);
		OrderDetailVO.setMealQty(mealQty);
		//OrderDetailVO.setOrderId(orderId);
		OrderDetailVO.setPriceBought(priceBought);

		dao.update(OrderDetailVO);

		return OrderDetailVO;
	}

	public OrderDetailVO getOneOrderDetail(Integer orderDtlNo) {
		return dao.findByPrimaryKey(orderDtlNo);
	}

	public List<OrderDetailVO> getAll() {
		return dao.getAll();
	}

}
