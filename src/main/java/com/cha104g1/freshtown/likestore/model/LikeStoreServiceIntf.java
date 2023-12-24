package com.cha104g1.freshtown.likestore.model;

import java.util.List;
import java.util.Map;

public interface LikeStoreServiceIntf {
	LikeStoreVO addLikeStore(LikeStoreVO likeStoreVO);
	
	LikeStoreVO updateLikeStore(LikeStoreVO likeStoreVO);
	
	LikeStoreVO getLikeStoreById(Integer id);
	
	List<LikeStoreVO> getAllLikeStore(int currentPage);
	
	int getPageTotal();
	
	List<LikeStoreVO> getLikeStoreByCompositeQuery(Map<String, String[]> map);
}
