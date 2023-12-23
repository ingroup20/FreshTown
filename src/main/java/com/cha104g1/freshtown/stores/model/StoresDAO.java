package com.cha104g1.freshtown.stores.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StoresDAO  implements StoresDAO_interface{

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cha104g1");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
			"INSERT INTO Stores( storeAccount, storePw, storeLv,createDate,payDate,photo, storeDesc, pushUp, ownerName, ownerMob, ownerId, ownerAddress, ownerEmail, storeName, storeAddress, storePhone, storeState, scorePeople, total_score, storeLat, storeLag, openTime, restDay, store_gui) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = 
			"SELECT storeId, storeAccount, storePw, storeLv,createDate,payDate,photo, storeDesc, pushUp, ownerName, ownerMob, ownerId, ownerAddress, ownerEmail, storeName, storeAddress, storePhone, storeState, scorePeople, total_score, storeLat, storeLag, openTime, restDay, store_gui FROM Stores ORDER BY storeId";
	private static final String GET_ONE_STMT = 
			"SELECT storeId, storeAccount, storePw, storeLv,createDate,payDate,photo, storeDesc, pushUp, ownerName, ownerMob, ownerId, ownerAddress, ownerEmail, storeName, storeAddress, storePhone, storeState, scorePeople, total_score, storeLat, storeLag, openTime,restDay, store_gui FROM Stores WHERE storeId = ?";
	private static final String UPDATE = 
			"UPDATE Stores SET storeAccount=?, storePw=?, storeLv=?,createDate=?,payDate=?,photo=?, storeDesc=?, pushUp=?, ownerName=?, ownerMob=?, ownerId=?, ownerAddress=?, ownerEmail=?, storeName=?, storeAddress=?, storePhone=?, storeState=?, scorePeople=?, total_score=?, storeLat=?, storeLag=?, openTime=?, restDay=?, store_gui=? WHERE storeId=?";
	
	
	@Override
	public void insert(StoresVO storesVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, storesVO.getStoreId());
			pstmt.setString(1, storesVO.getStoreAccount());
			pstmt.setString(2, storesVO.getStorePw());
			pstmt.setInt(3, storesVO.getStoreLv());
			pstmt.setDate(4, storesVO.getCreateDate());
			pstmt.setDate(5, storesVO.getPayDate());
			pstmt.setBytes(6, storesVO.getPhoto());
			pstmt.setString(7, storesVO.getStoreDesc());
			pstmt.setInt(8, storesVO.getPushUp());
			pstmt.setString(9, storesVO.getOwnerName());
			pstmt.setString(10, storesVO.getOwnerMob());
			pstmt.setString(11, storesVO.getOwnerId());
			pstmt.setString(12, storesVO.getOwnerAddress());
			pstmt.setString(13, storesVO.getOwnerEmail());
			pstmt.setString(14, storesVO.getStoreName());
			pstmt.setString(15, storesVO.getStoreAddress());
			pstmt.setString(16, storesVO.getStorePhone());
			pstmt.setInt(17, storesVO.getStoreState());
			pstmt.setInt(18, storesVO.getScorePeople());
			pstmt.setInt(19, storesVO.getTotalScore());
			pstmt.setBigDecimal(20, storesVO.getStoreLat());
			pstmt.setBigDecimal(21, storesVO.getStoreLag());
			pstmt.setString(22, storesVO.getOpenTime());
			pstmt.setString(23, storesVO.getRestDay());
			pstmt.setString(24, storesVO.getStoreGui());

			pstmt.executeUpdate();


		}catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
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
				} catch (Exception se) {
					se.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(StoresVO storesVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, storesVO.getStoreAccount());
			pstmt.setString(2, storesVO.getStorePw());
			pstmt.setInt(3, storesVO.getStoreLv());
			pstmt.setDate(4, storesVO.getCreateDate());
			pstmt.setDate(5, storesVO.getPayDate());
			pstmt.setBytes(6, storesVO.getPhoto());
			pstmt.setString(7, storesVO.getStoreDesc());
			pstmt.setInt(8, storesVO.getPushUp());
			pstmt.setString(9, storesVO.getOwnerName());
			pstmt.setString(10, storesVO.getOwnerMob());
			pstmt.setString(11, storesVO.getOwnerId());
			pstmt.setString(12, storesVO.getOwnerAddress());
			pstmt.setString(13, storesVO.getOwnerEmail());
			pstmt.setString(14, storesVO.getStoreName());
			pstmt.setString(15, storesVO.getStoreAddress());
			pstmt.setString(16, storesVO.getStorePhone());
			pstmt.setInt(17, storesVO.getStoreState());
			pstmt.setInt(18, storesVO.getScorePeople());
			pstmt.setInt(19, storesVO.getTotalScore());
			pstmt.setBigDecimal(20, storesVO.getStoreLat());
			pstmt.setBigDecimal(21, storesVO.getStoreLag());
			pstmt.setString(22, storesVO.getOpenTime());
			pstmt.setString(24, storesVO.getRestDay());
			pstmt.setString(25, storesVO.getStoreGui());
			pstmt.setInt(26, storesVO.getStoreId());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());

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
	public StoresVO findByPrimaryKey(Integer storesId) {
		
		StoresVO storesVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con =ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, storesId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				storesVO = new StoresVO();
				storesVO.setStoreId(rs.getInt("storeId"));
				storesVO.setStoreAccount(rs.getString("storeAccount"));
				storesVO.setStorePw(rs.getString("storePw"));
				storesVO.setStoreLv(rs.getInt("storeLv"));
				storesVO.setCreateDate(rs.getDate("createDate"));
				storesVO.setPayDate(rs.getDate("payDate"));
				storesVO.setPhoto(rs.getBytes("photo"));
				storesVO.setStoreDesc(rs.getString("storeDesc"));
				storesVO.setPushUp(rs.getInt("pushUp"));
				storesVO.setOwnerName(rs.getString("ownerName"));
				storesVO.setOwnerMob(rs.getString("ownerMob"));
				storesVO.setOwnerId(rs.getString("ownerId"));
				storesVO.setOwnerAddress(rs.getString("ownerAddress"));
				storesVO.setOwnerEmail(rs.getString("ownerEmail"));
				storesVO.setStoreName(rs.getString("storeName"));
				storesVO.setStoreAddress(rs.getString("storeAddress"));
				storesVO.setStorePhone(rs.getString("storePhone"));
				storesVO.setStoreState(rs.getInt("storeState"));
				storesVO.setScorePeople(rs.getInt("scorePeople"));
				storesVO.setTotalScore(rs.getInt("total_score"));
				storesVO.setStoreLat(rs.getBigDecimal("storeLat"));
				storesVO.setStoreLag(rs.getBigDecimal("storeLag"));
				storesVO.setOpenTime(rs.getString("openTime"));
				storesVO.setRestDay(rs.getString("restDay"));
				storesVO.setStoreGui(rs.getString("store_gui"));

			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());

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
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}

		}

		return storesVO;
	}

	@Override
	public List<StoresVO> getAll() {
		
		List<StoresVO> list = new ArrayList<StoresVO>();
		StoresVO storesVO =null;
		
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs =null;
		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				storesVO = new StoresVO();
				storesVO.setStoreId(rs.getInt("storeId"));
				storesVO.setStoreAccount(rs.getString("storeAccount"));
				storesVO.setStorePw(rs.getString("storePw"));
				storesVO.setStoreLv(rs.getInt("storeLv"));
				storesVO.setCreateDate(rs.getDate("createDate"));
				storesVO.setPayDate(rs.getDate("payDate"));
				storesVO.setPhoto(rs.getBytes("photo"));
				storesVO.setStoreDesc(rs.getString("storeDesc"));
				storesVO.setPushUp(rs.getInt("pushUp"));
				storesVO.setOwnerName(rs.getString("ownerName"));
				storesVO.setOwnerMob(rs.getString("ownerMob"));
				storesVO.setOwnerId(rs.getString("ownerId"));
				storesVO.setOwnerAddress(rs.getString("ownerAddress"));
				storesVO.setOwnerEmail(rs.getString("ownerEmail"));
				storesVO.setStoreName(rs.getString("storeName"));
				storesVO.setStoreAddress(rs.getString("storeAddress"));
				storesVO.setStorePhone(rs.getString("storePhone"));
				storesVO.setStoreState(rs.getInt("storeState"));
				storesVO.setScorePeople(rs.getInt("scorePeople"));
				storesVO.setTotalScore(rs.getInt("totalScore"));
				storesVO.setStoreLat(rs.getBigDecimal("storeLat"));
				storesVO.setStoreLag(rs.getBigDecimal("storeLag"));
				storesVO.setOpenTime(rs.getString("openTime"));
				storesVO.setRestDay(rs.getString("restDay"));
				storesVO.setStoreGui(rs.getString("storeGui"));
				list.add(storesVO);
			}
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
