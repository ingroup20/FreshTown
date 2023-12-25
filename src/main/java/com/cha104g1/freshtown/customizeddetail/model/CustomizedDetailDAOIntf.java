package com.cha104g1.freshtown.customizeddetail.model;

import java.util.*;

public interface CustomizedDetailDAOIntf {
	public CustomizedDetailVO findByPrimaryKey(Integer custedDtlNo);
	public List<CustomizedDetailVO> getAll();
}
