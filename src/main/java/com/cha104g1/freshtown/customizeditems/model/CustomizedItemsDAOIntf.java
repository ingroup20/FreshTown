package com.cha104g1.freshtown.customizeditems.model;

import java.util.*;

public interface CustomizedItemsDAOIntf {
	public CustomizedItemsVO findByPrimaryKey(Integer custedItemsNo);
	public List<CustomizedItemsVO> getAll();
}
