package com.cha104g1.freshtown.customizedorder.method;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cha104g1.freshtown.util.HibernateUtil;

public class CustomizedOrderDAO implements CustomizedOrderDAOIntf{
	
	private SessionFactory factory;

	public CustomizedOrderDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}
	

	@Override
	public int insert(CustomizedOrderVO customizedOrderVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CustomizedOrderVO customizedOrderVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CustomizedOrderVO getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomizedOrderVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomizedOrderVO> getAll(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomizedOrderVO> getByCompositeQuery(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
