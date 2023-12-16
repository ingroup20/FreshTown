package com.cha104g1.freshtown.supplier.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SupDAO implements SupDAO_interface {

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
		"INSERT INTO supplier (supplierName,supplierContact,supplierPhone,storeId,supplierState) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT supId,supplierName,supplierContact,supplierPhone,storeId,supplierState FROM supplier order by supId";
	private static final String GET_ONE_STMT = 
		"SELECT supId,supplierName,supplierContact,supplierPhone,storeId,supplierState FROM supplier where supId = ?";
	private static final String DELETE = 
		"DELETE FROM supplier where supId = ?";
	private static final String UPDATE = 
		"UPDATE supplier set supplierName=?, supplierContact=?, supplierPhone=?, storeId=?, supplierState=? where supId = ?";

	@Override
	public void insert(SupVO supVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, supVO.getSupplierName());
			pstmt.setString(2, supVO.getSupplierContact());
			pstmt.setString(3, supVO.getSupplierPhone());
			pstmt.setInt(4, supVO.getStoreId());
			pstmt.setInt(5, supVO.getSupplierState());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void update(SupVO supVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, supVO.getSupplierName());
			pstmt.setString(2, supVO.getSupplierContact());
			pstmt.setString(3, supVO.getSupplierPhone());
			pstmt.setInt(4, supVO.getStoreId());
			pstmt.setInt(5, supVO.getSupplierState());
			pstmt.setInt(6, supVO.getSupId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public void delete(Integer supId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, supId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
	public SupVO findByPrimaryKey(Integer supId) {

		SupVO supVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, supId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				supVO = new SupVO();
				supVO.setSupId(rs.getInt("supId"));
				supVO.setSupplierName(rs.getString("supplierName"));
				supVO.setSupplierContact(rs.getString("supplierContact"));
				supVO.setSupplierPhone(rs.getString("supplierPhone"));
				supVO.setStoreId(rs.getInt("storeId"));
				supVO.setSupplierState(rs.getInt("supplierState"));
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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
		return supVO;
	}

	@Override
	public List<SupVO> getAll() {
		List<SupVO> list = new ArrayList<SupVO>();
		SupVO supVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				supVO = new SupVO();
				supVO.setSupId(rs.getInt("supId"));
				supVO.setSupplierName(rs.getString("supplierName"));
				supVO.setSupplierContact(rs.getString("supplierContact"));
				supVO.setSupplierPhone(rs.getString("supplierPhone"));
				supVO.setStoreId(rs.getInt("storeId"));
				supVO.setSupplierState(rs.getInt("supplierState"));
				list.add(supVO);
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
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