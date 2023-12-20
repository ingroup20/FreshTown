package com.cha104g1.freshtown.customized.model;

import java.util.List;

public interface CustomizedDAO_interface {
	public CustomizedVO findByPrimaryKey(Integer mealNo, Integer custedItemsNo);
	public List<CustomizedVO> getAll();
}
