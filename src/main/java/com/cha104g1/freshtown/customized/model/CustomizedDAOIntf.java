package com.cha104g1.freshtown.customized.model;

import java.util.*;


public interface CustomizedDAOIntf {
//	public void insert(CustomizedVO customizedVO);
//	public void update(CustomizedVO customizedVO);	
	public CustomizedVO findByPrimaryKey(Integer mealNo, Integer custedItemsNo);
	public List<CustomizedVO> getAll();
}
