package com.cha104g1.freshtown.customizedorder.method;

import java.util.List;
import java.util.Map;


public interface CustomizedOrderDAOIntf {
	int insert(CustomizedOrderVO customizedOrderVO);
	
	int update(CustomizedOrderVO customizedOrderVO);
	
	CustomizedOrderVO getById(Integer id);
	
	List<CustomizedOrderVO> getAll();
	
	List<CustomizedOrderVO> getAll(int currentPage);
	
	List<CustomizedOrderVO> getByCompositeQuery(Map<String, String> map);

	long getTotal();
}
