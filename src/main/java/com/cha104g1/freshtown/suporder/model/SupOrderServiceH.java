package com.cha104g1.freshtown.suporder.model;

import java.util.List;

public interface SupOrderServiceH {
	
	SupOrderH addSupOrder(SupOrderH supOrderH);
	
	SupOrderH updateSupOrder(SupOrderH supOrderH);
	
	void deleteSupOrder(Integer id);
	
	SupOrderH getSupOrderHByPK(Integer id);
	
	List<SupOrderH> getAllSupOrder(int currentPage);

}
