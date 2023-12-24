package com.cha104g1.freshtown.likestore.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import static com.cha104g1.freshtown.util.Constants.PAGE_MAX_RESULT_M;
import com.cha104g1.freshtown.util.HibernateUtil;

public class LikeStoreDAO  implements LikeStoreDAOIntf{
	
	private SessionFactory factory;

	public LikeStoreDAO() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	

	@Override
	public int insert(LikeStoreVO likeStoreVO) {
		// 回傳給 service 剛新增成功的自增主鍵值
		return (Integer) getSession().save(likeStoreVO);
	}

	@Override
	public int update(LikeStoreVO likeStoreVO) {
		try {
			getSession().update(likeStoreVO);
			return 1;
		}catch(Exception e) {
			return -1;
		}
		
	}

	@Override
	public LikeStoreVO getById(Integer id) {
		return getSession().get(LikeStoreVO.class, id);
	}

	@Override
	public List<LikeStoreVO> getAll() {
		return getSession().createQuery("form LikeStoreVO", LikeStoreVO.class).list();
	}

	@Override
	public List<LikeStoreVO> getAll(int currentPage) {
		int first = (currentPage - 1) * PAGE_MAX_RESULT_M;
		return getSession().createQuery("form  LikeStoreVO", LikeStoreVO.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT_M)
				.list();
	}

	@Override
	public List<LikeStoreVO> getByCompositeQuery(Map<String, String> map) {
		if (map.size() == 0) { return getAll(); }
		
		CriteriaBuilder builder =getSession().getCriteriaBuilder();
		CriteriaQuery<LikeStoreVO> criteria = builder.createQuery(LikeStoreVO.class);
		Root<LikeStoreVO> root = criteria.from(LikeStoreVO.class);
		//謂語:不含主詞的內容(動詞+受詞)；完整句子(主詞+動詞+受詞)
		List<Predicate> predicates= new ArrayList<>();
		
//		if(map.containsKey("startCustomerId") && map.containsKey("endCustomerId")) {
//			predicates.add(builder.between(root.get("CustomerId"), Integer.valueOf(map.get("startCustomerId")), Integer.valueOf("endCustomerId")));
//		}
//		
//		if(map.containsKey("startStoreId") && map.containsKey("endStoreId")) {
//			predicates.add(builder.between(root.get("storeId"), Integer.valueOf(map.get("startStoreId")), Integer.valueOf("endStoreId")));
//		}
		
//		if(map.containsKey("startLikeUnlike") && map.containsKey("endLikeUnlike")) {
//			predicates.add(builder.between(root.get("likeUnlike"),map.get("startLikeUnlike") , map.get("endLikeUnlike")));
//		}
		
		for(Map.Entry<String,String> row: map.entrySet()) {
//			if("id".equals(row.getKey())) {
//				predicates.add(builder.like(root.get("id"), row.getValue()));
//			}
				
			
			if("customerId".equals(row.getKey())) {
				predicates.add(builder.like(root.get("customerId"),row.getValue()));
			}
			
			if("storeId".equals(row.getKey())) {
				predicates.add(builder.like(root.get("storeId"),row.getValue()));
			}
			
			if("likeUnlike".equals(row.getKey())) {
				predicates.add(builder.like(root.get("likeUnlike"),row.getValue()));
			}
			
		}
		
		
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		criteria.orderBy(builder.asc(root.get("customerId")));
		TypedQuery<LikeStoreVO> query = getSession().createQuery(criteria);
		
		return query.getResultList();
	}

	@Override
	public long getTotal() {
		return getSession().createQuery("select count(*) from LikeStoreVO", Long.class).uniqueResult();
	}

	
	
	
	
	
	
	
//	private static DataSource ds = null;
//	static {
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cha104g1");
//			
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static final String INSERT_STMT = "INSERT INTO Like_store(customerId, storeId,likeUnlike) VALUES(?,?,?)";
//	private static final String GET_ALL_STMT = "SELECT id, customerId, storeId,likeUnlike FROM Like_store ORDER BY id";
//	private static final String GET_ONE_STMT = "SELECT id, customerId, storeId,likeUnlike FROM Like_store WHERE id = ?";
//	private static final String UPDATE = "UPDATE  like_store SET customerId=?, storeId=?,likeUnlike=? WHERE id=?";
//	
//	
//	@Override
//	public void insert(LikeStoreVO likeStoreVO) {
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(INSERT_STMT);
//			
//			pstmt.setInt(1, likeStoreVO.getCustomerId());
//			pstmt.setObject(2, likeStoreVO.getStoresVO());
//			pstmt.setString(3, likeStoreVO.getLikeUnlike());
//
//			pstmt.executeUpdate();
//
//		}catch (SQLException se) {
//			throw new RuntimeException("A database error occured." + se.getMessage());
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception se) {
//					se.printStackTrace(System.err);
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public void update(LikeStoreVO likeStoreVO) {
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(UPDATE);
//			
//
//			pstmt.setInt(1, likeStoreVO.getCustomerId());
//			pstmt.setInt(2, likeStoreVO.getStoreId());
//			pstmt.setString(3, likeStoreVO.getLikeUnlike());
//			pstmt.setInt(4, likeStoreVO.getId());
//
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured." + se.getMessage());
//
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//
//		}
//
//		
//	}
//
//	@Override
//	public LikeStoreVO findByPrimaryKey(Integer id) {
//		
//		LikeStoreVO likeStoreVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			
//			con =ds.getConnection();
//			pstmt = con.prepareStatement(GET_ONE_STMT);
//			
//			pstmt.setInt(1, id);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				likeStoreVO = new LikeStoreVO();
//				likeStoreVO.setId(rs.getInt("id"));
//				likeStoreVO.setCustomerId(rs.getInt("customerId"));
//				likeStoreVO.setStoreId(rs.getInt("storeId"));
//				likeStoreVO.setLikeUnlike(rs.getString("likeUnlike"));
//			}
//
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured." + se.getMessage());
//
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace(System.err);
//				}
//			}
//
//		}
//
//		return likeStoreVO;
//	}
//
//
//
//	@Override
//	public List<LikeStoreVO> getAll() {
//		
//		List<LikeStoreVO> list = new ArrayList<LikeStoreVO>();
//		LikeStoreVO likeStoreVO =null;
//		
//		Connection con = null;
//		PreparedStatement pstmt=null;
//		ResultSet rs =null;
//		
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(GET_ALL_STMT);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				likeStoreVO = new LikeStoreVO();
//				likeStoreVO.setId(rs.getInt("id"));
//				likeStoreVO.setCustomerId(rs.getInt("customerId"));
//				likeStoreVO.setStoreId(rs.getInt("storeId"));
//				likeStoreVO.setLikeUnlike(rs.getString("likeUnlike"));
//				list.add(likeStoreVO);
//			}
//
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//
//		}
//		return list;
//	}
	
	
	

}
