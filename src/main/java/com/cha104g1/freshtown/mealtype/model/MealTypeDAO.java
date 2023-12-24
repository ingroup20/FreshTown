package com.cha104g1.freshtown.mealtype.model;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cha104g1.freshtown.util.HibernateUtil;

public class MealTypeDAO implements MealTypeDAOIntf{

	
	private SessionFactory factory;

	public MealTypeDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	
	@Override
	public int insert(MealTypeVO mealTypeVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(MealTypeVO mealTypeVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MealTypeVO getById(Integer mealTypeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealTypeVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealTypeVO> getAll(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MealTypeVO> getByCompositeQuery(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
