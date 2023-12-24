package com.cha104g1.freshtown.mealtype.model;

import java.util.List;
import java.util.Map;

public interface MealTypeDAOIntf {
	
	int insert(MealTypeVO mealTypeVO);
	
	int update(MealTypeVO mealTypeVO);
	
	MealTypeVO getById(Integer mealTypeNo);
	
	List<MealTypeVO> getAll();
	
	List<MealTypeVO> getAll(int currentPage);
	
	List<MealTypeVO> getByCompositeQuery(Map<String, String> map);

	long getTotal();
	

}
