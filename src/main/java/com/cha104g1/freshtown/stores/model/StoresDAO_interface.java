package com.cha104g1.freshtown.stores.model;

import java.util.List;

public interface StoresDAO_interface {
	public void insert(StoresVO storesVO);
	public void update(StoresVO storesVO);
	public StoresVO findByPrimaryKey(Integer storeId);
	public List<StoresVO> getAll();
	//�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<StoresVO> getAll(Map<String, String[]> map); 
}
