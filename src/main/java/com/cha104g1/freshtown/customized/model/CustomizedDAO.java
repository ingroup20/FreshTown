package com.cha104g1.freshtown.customized.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustomizedDAO implements CustomizedDAOIntf{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CHA104G1");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	
	
//	private static final String INSERT_STMT = "INSERT INTO customized (mealNo,custedItemsNo) VALUES (?, ?)";
	private static final String GET_ALL_STMT = "SELECT mealNo,custedItemsNo FROM customized order by mealNo,custedItemsNo";
	private static final String GET_ONE_STMT = "SELECT mealNo,custedItemsNo FROM customized where mealNo = ? && custedItemsNo = ?";
//	private static final String UPDATE = "UPDATE customized set mealNo=?, custedItemsNo=? where mealNo = ? && custedItemsNo= ?";
	
//	@Override
//	public void insert(CustomizedVO customizedVO) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(INSERT_STMT);
//			
//			pstmt.setInt(1, customizedVO.getMealNo());
//			pstmt.setInt(2, customizedVO.getCustedItemsNo());
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
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
//		}		
//	}

//	@Override
//	public void update(CustomizedVO customizedVO) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			con = ds.getConnection();
//			pstmt = con.prepareStatement(UPDATE);
//			
//			pstmt.setInt(1, customizedVO.getMealNo());
//			pstmt.setInt(2, customizedVO.getCustedItemsNo());
//
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
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
//		}		
//	}

	@Override
	public CustomizedVO findByPrimaryKey(Integer mealNo, Integer custedItemsNo) {
		CustomizedVO customizedVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, mealNo);
			pstmt.setInt(2, custedItemsNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				customizedVO = new CustomizedVO();
				customizedVO.setMealNo(rs.getInt("mealNo"));
				customizedVO.setCustedItemsNo(rs.getInt("custedItemsNo"));
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return customizedVO;
	}

	@Override
	public List<CustomizedVO> getAll() {
		List<CustomizedVO> list = new ArrayList<CustomizedVO>();
		CustomizedVO customizedVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				customizedVO = new CustomizedVO();
				customizedVO.setMealNo(rs.getInt("mealNo"));
				customizedVO.setCustedItemsNo(rs.getInt("custedItemsNo"));
				list.add(customizedVO); // Store the row in the list
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return list;
	}
	
}
