package com.cha104g1.freshtown.customizeditems.model;

import java.util.List;

public interface CustomizedItemsDAO_interface {
	public CustomizedItemsVO findByPrimaryKey(Integer custedItemsNo);
	public List<CustomizedItemsVO> getAll();
}
