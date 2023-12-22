package com.cha104g1.freshtown.suporder.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SupOrderDAO implements SupOrderDAOIntf {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cha104g1");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
		"INSERT INTO sup_order (supId,purNo,amount,unitPrice, purDate, preDate, oStatus, deliDate, marks, storeId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT id,supId,purNo,amount,unitPrice, purDate, preDate, oStatus, deliDate, marks, storeId FROM sup_order order by id";
//	private static final String GET_ONE_STMT = 
//		"SELECT supId,supplierName,supplierContact,supplierPhone,storeId,supplierState FROM supplier where supplierName = ?";
//	private static final String GET_ID_STMT = 
//			"SELECT supId,supplierName,supplierContact,supplierPhone,storeId,supplierState FROM supplier where supId = ?";
//	private static final String GET_CON_STMT = 
//			"SELECT supId,supplierName,supplierContact,supplierPhone,storeId,supplierState FROM supplier where supplierContact = ?";
	private static final String DELETE = 
		"DELETE FROM sup_order where id = ?";
	private static final String UPDATE = 
		"UPDATE sup_order set supId=?, purNo=?, amount=?, unitPrice=?, purDate=?, preDate=?, oStatus=?, deliDate=?, marks=? where id = ?";

	@Override
	public void insert(SupOrderVO supOrderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, supOrderVO.getSupId());
			pstmt.setInt(2, supOrderVO.getPurNo());
			pstmt.setInt(3, supOrderVO.getAmount());
			pstmt.setInt(4, supOrderVO.getUnitPrice());
			pstmt.setDate(5, supOrderVO.getPurDate());
			pstmt.setDate(6, supOrderVO.getPreDate());
			pstmt.setString(7, supOrderVO.getoStatus());
			pstmt.setDate(8, supOrderVO.getDeliDate());
			pstmt.setString(9, supOrderVO.getMarks());
			pstmt.setInt(10, supOrderVO.getStoreId());

			pstmt.executeUpdate();


		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(SupOrderVO supOrderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, supOrderVO.getSupId());
			pstmt.setInt(2, supOrderVO.getPurNo());
			pstmt.setInt(3, supOrderVO.getAmount());
			pstmt.setInt(4, supOrderVO.getUnitPrice());
			pstmt.setDate(5, supOrderVO.getPurDate());
			pstmt.setDate(6, supOrderVO.getPreDate());
			pstmt.setString(7, supOrderVO.getoStatus());
			pstmt.setDate(8, supOrderVO.getDeliDate());
			pstmt.setString(9, supOrderVO.getMarks());
			pstmt.setInt(10, supOrderVO.getStoreId());

			pstmt.executeUpdate();


		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, id);

			pstmt.executeUpdate();


		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}
	
//	@Override
//	public SupOrderVO findByPrimaryKey(Integer supId) {
//
//		SupOrderVO supVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(GET_ID_STMT);
//
//			pstmt.setInt(1, supId);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				supVO = new SupOrderVO();
//				supVO.setSupId(rs.getInt("supId"));
//				supVO.setSupplierName(rs.getString("supplierName"));
//				supVO.setSupplierContact(rs.getString("supplierContact"));
//				supVO.setSupplierPhone(rs.getString("supplierPhone"));
//				supVO.setStoreId(rs.getInt("storeId"));
//				supVO.setSupplierState(rs.getInt("supplierState"));
//			}
//
//
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
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
//		}
//		return supVO;
//	}

//	@Override
//	public SupOrderVO findByKey(String supplierName) {
//
//		SupOrderVO supVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(GET_ONE_STMT);
//
//			pstmt.setString(1, supplierName);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				supVO = new SupOrderVO();
//				supVO.setSupId(rs.getInt("supId"));
//				supVO.setSupplierName(rs.getString("supplierName"));
//				supVO.setSupplierContact(rs.getString("supplierContact"));
//				supVO.setSupplierPhone(rs.getString("supplierPhone"));
//				supVO.setStoreId(rs.getInt("storeId"));
//				supVO.setSupplierState(rs.getInt("supplierState"));
//			}
//
//
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
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
//		}
//		return supVO;
//	}
	
//	@Override
//	public SupOrderVO findByCon(String supplierContact) {
//
//		SupOrderVO supVO = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(GET_CON_STMT);
//
//			pstmt.setString(1, supplierContact);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				supVO = new SupOrderVO();
//				supVO.setSupId(rs.getInt("supId"));
//				supVO.setSupplierName(rs.getString("supplierName"));
//				supVO.setSupplierContact(rs.getString("supplierContact"));
//				supVO.setSupplierPhone(rs.getString("supplierPhone"));
//				supVO.setStoreId(rs.getInt("storeId"));
//				supVO.setSupplierState(rs.getInt("supplierState"));
//			}
//
//
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. "
//					+ se.getMessage());
//
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
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
//		}
//		return supVO;
//	}

	@Override
	public List<SupOrderVO> getAll() {
		List<SupOrderVO> list = new ArrayList<SupOrderVO>();
		SupOrderVO supOrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				supOrderVO = new SupOrderVO();
				supOrderVO.setId(rs.getInt("id"));
				supOrderVO.setSupId(rs.getInt("supId"));
				supOrderVO.setPurNo(rs.getInt("purNo"));
				supOrderVO.setAmount(rs.getInt("amount"));
				supOrderVO.setUnitPrice(rs.getInt("unitPrice"));
				supOrderVO.setPurDate(rs.getDate("purDate"));
				supOrderVO.setPreDate(rs.getDate("preDate"));
				supOrderVO.setoStatus(rs.getString("oStatus"));
				supOrderVO.setDeliDate(rs.getDate("deliDate"));
				supOrderVO.setMarks(rs.getString("marks"));
				supOrderVO.setStoreId(rs.getInt("storeId"));
				list.add(supOrderVO);
			}


		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
}