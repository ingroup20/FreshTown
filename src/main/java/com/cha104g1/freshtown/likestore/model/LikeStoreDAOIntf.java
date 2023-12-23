package com.cha104g1.freshtown.likestore.model;

import java.util.List;
import java.util.Map;

public interface LikeStoreDAOIntf {
	int insert(LikeStoreVO likeStoreVO);
	
	int update(LikeStoreVO likeStoreVO);
	
	LikeStoreVO getById(Integer id);
	
	List<LikeStoreVO> getAll();
	
	List<LikeStoreVO> getAll(int currentPage);
	
	List<LikeStoreVO> getByCompositeQuery(Map<String, String> map);

	long getTotal();
}
