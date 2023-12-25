package com.cha104g1.freshtown.customizeditems.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustomizedItemsDAO implements CustomizedItemsDAOIntf{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CHA104G1");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	
	
	private static final String GET_ALL_STMT = "SELECT custedItemsNo,custedName FROM customized_items order by custedItemsNo";
	private static final String GET_ONE_STMT = "SELECT custedItemsNo,custedName FROM customized_items where custedItemsNo = ?";
	
	@Override
	public CustomizedItemsVO findByPrimaryKey(Integer custedItemsNo) {
		CustomizedItemsVO customizedItemsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, custedItemsNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				customizedItemsVO = new CustomizedItemsVO();
				customizedItemsVO.setCustedItemsNo(rs.getInt("custedItemsNo"));
				customizedItemsVO.setCustedName(rs.getString("custedName"));
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
		return customizedItemsVO;
	}

	@Override
	public List<CustomizedItemsVO> getAll() {
		List<CustomizedItemsVO> list = new ArrayList<CustomizedItemsVO>();
		CustomizedItemsVO customizedItemsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				customizedItemsVO = new CustomizedItemsVO();
				customizedItemsVO.setCustedItemsNo(rs.getInt("custedItemsNo"));
				customizedItemsVO.setCustedName(rs.getString("custedName"));
				list.add(customizedItemsVO); // Store the row in the list
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
