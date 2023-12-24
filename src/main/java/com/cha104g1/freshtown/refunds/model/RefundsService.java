package com.cha104g1.freshtown.refunds.model;

import java.sql.Date;
import java.util.List;

public class RefundsService {

	private RefundsDAO_interface dao;

	public RefundsService() {
		dao = new RefundsDAO();
	}

	public RefundsVO addRefunds( Integer orderId, String refundState, Integer refundDollar,
			Date refundDate) {
		RefundsVO refundsVO = new RefundsVO();

		//refundsVO.setOrderId(orderId);
		refundsVO.setRefundState(refundState);
		refundsVO.setRefundDollar(refundDollar);
		refundsVO.setRefundDate(refundDate);
		dao.insert(refundsVO);

		return refundsVO;
	}

	public RefundsVO updateRefunds(Integer id, Integer orderId, String refundState, Integer refundDollar,
			Date refundDate) {
		RefundsVO refundsVO = new RefundsVO();

		refundsVO.setId(id);
		//refundsVO.setOrderId(orderId);
		refundsVO.setRefundState(refundState);
		refundsVO.setRefundDollar(refundDollar);
		refundsVO.setRefundDate(refundDate);
		dao.update(refundsVO);

		return refundsVO;
	}

	public RefundsVO getOneRefunds(Integer id) {
		return dao.findByPrimaryKey(id);
	}
	
	public RefundsVO getOneOrderId(Integer OrderId) {
		return dao.findByPrimaryKey(OrderId);
	}

	public List<RefundsVO> getAll() {
		return dao.getAll();
	}

}
