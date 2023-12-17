package com.cha104g1.freshtown.likestore.model;

import java.util.List;

public interface LikeStoreDAO_interface {
	public void insert(LikeStoreVO likeStoreVO);
	public void update(LikeStoreVO likeStoreVO);
	public LikeStoreVO findByPrimaryKey(Integer Id);
	public LikeStoreVO findByCustomer(Integer customerId);
	public List<LikeStoreVO> getAll();
	//�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<Like_storeVO> getAll(Map<String, String[]> map); 
}
