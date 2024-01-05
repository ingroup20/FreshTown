package com.cha104g1.freshtown.suporder.model;

import java.util.List;

public interface SupOrderDAOH {

	int insert(SupOrderH entity);
	
	int update(SupOrderH entity);
	
	int delete(Integer id);
	
	SupOrderH findByPK(Integer id);
	
	List<SupOrderH> getAll();
	
	List<SupOrderH> getAll(int currentPage);
}
