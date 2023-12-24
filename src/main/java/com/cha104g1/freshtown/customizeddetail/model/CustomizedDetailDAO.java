package com.cha104g1.freshtown.customizeddetail.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustomizedDetailDAO implements CustomizedDetailDAOIntf{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CHA104G1");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	
	
	private static final String GET_ALL_STMT = "SELECT custedDtlNo,custedItemsNo,custedDtlName FROM customized_detail order by custedDtlNo";
	private static final String GET_ONE_STMT = "SELECT custedDtlNo,custedItemsNo,custedDtlName FROM customized_detail where custedDtlNo = ?";
	
	@Override
	public CustomizedDetailVO findByPrimaryKey(Integer custedDtlNo) {
		CustomizedDetailVO customizedDetailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, custedDtlNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				customizedDetailVO = new CustomizedDetailVO();
				customizedDetailVO.setCustedDtlNo(rs.getInt("custedDtlNo"));
				customizedDetailVO.setCustedItemsNo(rs.getInt("custedItemsNo"));
				customizedDetailVO.setCustedDtlName(rs.getString("custedDtlName"));
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
		return customizedDetailVO;
	}

	@Override
	public List<CustomizedDetailVO> getAll() {
		List<CustomizedDetailVO> list = new ArrayList<CustomizedDetailVO>();
		CustomizedDetailVO customizedDetailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				customizedDetailVO = new CustomizedDetailVO();
				customizedDetailVO.setCustedDtlNo(rs.getInt("custedDtlNo"));
				customizedDetailVO.setCustedItemsNo(rs.getInt("custedItemsNo"));
				customizedDetailVO.setCustedDtlName(rs.getString("custedDtlName"));
				list.add(customizedDetailVO); // Store the row in the list
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
