package com.cha104g1.freshtown.service.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cha104g1.freshtown.util.Util;

public class ServiceJDBCDAO implements ServiceDAOIntf {
	private static final String INSERT_STMT = "INSERT INTO service(pEmpId, storeId, customerId, custMessage "
			+ " custTime ) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE service set pEmpId=?, storeId=?, customerId=?,"
			+ "custMessage=?, custTime=? WHERE custSerNo=?";
	private static final String FIND_BY_PK = "SELECT * FROM service WHERE custSerNo=?";
	private static final String GET_ALL = "SELECT * FROM service";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void insert(ServiceVO serviceVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, serviceVO.getPEmpId());
			pstmt.setInt(2, serviceVO.getStoreId());
			pstmt.setInt(3, serviceVO.getCustomerId());
			pstmt.setString(4, serviceVO.getCustMessage());
			pstmt.setDate(5, serviceVO.getCustTime());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}

	}

	@Override
	public void update(ServiceVO serviceVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, serviceVO.getPEmpId());
			pstmt.setInt(2, serviceVO.getStoreId());
			pstmt.setInt(3, serviceVO.getCustomerId());
			pstmt.setString(4, serviceVO.getCustMessage());
			pstmt.setDate(5, serviceVO.getCustTime());
			pstmt.setInt(6, serviceVO.getCustSerNo());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}

	}

	@Override
	public ServiceVO findByPrimaryKey(Integer custSerNo) {
		ServiceVO item = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, custSerNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				item = new ServiceVO();

				item.setCustSerNo(rs.getInt("custSerNo"));
				item.setPEmpId(rs.getInt("pEmpId"));
				item.setStoreId(rs.getInt("storeId"));
				item.setCustomerId(rs.getInt("customerId"));
				item.setCustMessage(rs.getString("custMessage"));
				item.setCustTime(rs.getDate("custTime"));

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, rs);
		}
		return item;
	}

	@Override
	public List<ServiceVO> getAll() {
		List<ServiceVO> itemList = new ArrayList<>();
		ServiceVO item = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				item = new ServiceVO();

				item.setCustSerNo(rs.getInt("custSerNo"));
				item.setPEmpId(rs.getInt("pEmpId"));
				item.setStoreId(rs.getInt("storeId"));
				item.setCustomerId(rs.getInt("customerId"));
				item.setCustMessage(rs.getString("custMessage"));
				item.setCustTime(rs.getDate("custTime"));
				itemList.add(item);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, rs);
		}
		return itemList;
	}

	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace(System.err);
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace(System.err);
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

}
