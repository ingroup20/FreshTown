package com.cha104g1.freshtown.suporder.model;

import static util.Constants.PAGE_MAX_RESULT;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class SupOrderDAOHImpl implements SupOrderDAOH{

	private SessionFactory factory;
	
	public SupOrderDAOHImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public int insert(SupOrderH entity) {
		// 回傳給 service 剛新增成功的自增主鍵值
		return (Integer) getSession().save(entity);
	}
	
	@Override
	public int update(SupOrderH entity) {
		try {
			getSession().update(entity);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}
	
	@Override
	public int delete(Integer id) {
		SupOrderH supOrderH = getSession().get(SupOrderH.class, id);
		if (supOrderH != null) {
			getSession().delete(supOrderH);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
	}

	@Override
	public SupOrderH findByPK(Integer id) {
		return getSession().get(SupOrderH.class, id);
	}

	@Override
	public List<SupOrderH> getAll() {
		return getSession().createQuery("from Emp", SupOrderH.class).list();
	}

	@Override
	public List<SupOrderH> getAll(int currentPage) {
		int first = (currentPage - 1) * PAGE_MAX_RESULT;
		return getSession().createQuery("from SupOrderH", SupOrderH.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT)
				.list();
	}

}
