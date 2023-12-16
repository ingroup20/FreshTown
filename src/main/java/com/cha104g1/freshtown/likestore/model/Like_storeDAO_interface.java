package com.cha104g1.freshtown.likestore.model;

import java.util.List;

public interface Like_storeDAO_interface {
	public void insert(Like_storeVO like_storeVO);
	public void update(Like_storeVO like_storeVO);
	public Like_storeVO findByPrimaryKey(Integer Id);
	public Like_storeVO findByCustomer(Integer customerId);
	public List<Like_storeVO> getAll();
	//�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<Like_storeVO> getAll(Map<String, String[]> map); 
}
