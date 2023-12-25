package com.cha104g1.freshtown.meals.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MealsDAO implements MealsDAOIntf{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CHA104G1");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = "INSERT INTO meals (mealName,mealPrice,mealTypeNo,mealOnsale,storeId,mealPicture,cookingTime) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT mealNo,mealName,mealPrice,mealTypeNo,mealOnsale,storeId,mealPicture,cookingTime FROM meals order by mealNo";
	private static final String GET_ONE_STMT = "SELECT mealNo,mealName,mealPrice,mealTypeNo,mealOnsale,storeId,mealPicture,cookingTime FROM meals where mealNo = ?";
	private static final String UPDATE = "UPDATE meals set mealName=?, mealPrice=?, mealTypeNo=?, mealOnsale=?, storeId=?, mealPicture=?, cookingTime=? where mealNo = ?";

	@Override
	public void insert(MealsVO mealsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, mealsVO.getMealName());
			pstmt.setInt(2, mealsVO.getMealPrice());
			pstmt.setInt(3, mealsVO.getMealTypeNo());
			pstmt.setInt(4, mealsVO.getMealOnsale());
			pstmt.setInt(5, mealsVO.getStoreId());
			pstmt.setBytes(6, mealsVO.getMealPicture());
			pstmt.setTime(7, mealsVO.getCookingTime());
			pstmt.executeUpdate();

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
	}
	
	@Override
	public void update(MealsVO mealsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, mealsVO.getMealName());
			pstmt.setInt(2, mealsVO.getMealPrice());
			pstmt.setInt(3, mealsVO.getMealTypeNo());
			pstmt.setInt(4, mealsVO.getMealOnsale());
			pstmt.setInt(5, mealsVO.getStoreId());
			pstmt.setBytes(6, mealsVO.getMealPicture());
			pstmt.setTime(7, mealsVO.getCookingTime());
			pstmt.executeUpdate();

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
	}
	
	@Override
	public MealsVO findByPrimaryKey(Integer mealNo) {
		MealsVO mealsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, mealNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mealsVO = new MealsVO();
				mealsVO.setMealNo(rs.getInt("mealNo"));
				mealsVO.setMealName(rs.getString("mealName"));
				mealsVO.setMealPrice(rs.getInt("mealPrice"));
				mealsVO.setMealTypeNo(rs.getInt("mealTypeNo"));
				mealsVO.setMealOnsale(rs.getInt("mealOnsale"));
				mealsVO.setStoreId(rs.getInt("storeId"));
				mealsVO.setMealPicture(rs.getBytes("mealPicture"));
				mealsVO.setCookingTime(rs.getTime("cookingTime"));
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
		return mealsVO;
	}
	
	@Override
	public List<MealsVO> getAll() {
		List<MealsVO> list = new ArrayList<MealsVO>();
		MealsVO mealsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				mealsVO = new MealsVO();
				mealsVO.setMealNo(rs.getInt("mealNo"));
				mealsVO.setMealName(rs.getString("mealName"));
				mealsVO.setMealPrice(rs.getInt("mealPrice"));
				mealsVO.setMealTypeNo(rs.getInt("mealTypeNo"));
				mealsVO.setMealOnsale(rs.getInt("mealOnsale"));
				mealsVO.setStoreId(rs.getInt("storeId"));
				mealsVO.setMealPicture(rs.getBytes("mealPicture"));
				mealsVO.setCookingTime(rs.getTime("cookingTime"));
				list.add(mealsVO); // Store the row in the list
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
