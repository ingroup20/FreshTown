package com.cha104g1.freshtown.customizeddetail.model;

import java.util.List;

public interface CustomizedDetailDAO_interface {
	public CustomizedDetailVO findByPrimaryKey(Integer custedDtlNo);
	public List<CustomizedDetailVO> getAll();
}
