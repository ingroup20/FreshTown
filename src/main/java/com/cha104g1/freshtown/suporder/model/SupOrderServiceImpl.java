package com.cha104g1.freshtown.suporder.model;

import java.util.List;

public class SupOrderServiceImpl implements SupOrderServiceH{

	private SupOrderDAOH dao;
	
	public SupOrderServiceImpl() {
		dao = new SupOrderDAOHImpl();
	}

	@Override
	public SupOrderH addSupOrder(SupOrderH supOrderH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupOrderH updateSupOrder(SupOrderH supOrderH) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSupOrder(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SupOrderH getSupOrderHByPK(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupOrderH> getAllSupOrder(int currentPage) {
		// TODO Auto-generated method stub
		return dao.getAll(currentPage);
	}
}
