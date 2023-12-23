package com.cha104g1.freshtown.refunds.model;

import java.util.List;

public interface RefundsDAO_interface {
	public void insert(RefundsVO refundsVO);
	public void update(RefundsVO refundsVO);
	public RefundsVO findByPrimaryKey(Integer id);
	public List<RefundsVO> getAll();
	//�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<RefundsVO> getAll(Map<String, String[]> map); 
}
