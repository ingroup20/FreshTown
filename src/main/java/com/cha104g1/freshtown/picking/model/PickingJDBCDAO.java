package com.cha104g1.freshtown.picking.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cha104g1.freshtown.util.Util;

public class PickingJDBCDAO implements PickingDAOIntf {

	private static final String INSERT_STMT = "INSERT INTO picking(itemNumber, storeId, sEmpId,pickingQuantity, "
			+ "pickingUnit, pickingStatus, pickingClass, pickingDate, marks)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE itemsClass set itemNumber=?, storeId=?, sEmpId=?, "
			+ "pickingQuantity=?, pickingUnit=?, pickingStatus=?, pickingClass=?,  pickingDate=?, marks=? WHERE pickingNo=?";
	private static final String FIND_BY_PK = "SELECT * FROM picking WHERE pickingNo=?";
	private static final String GET_ALL = "SELECT * FROM picking";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void insert(PickingVO pickingVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, pickingVO.getItemNumber());
			pstmt.setInt(2, pickingVO.getStoreId());
			pstmt.setInt(3, pickingVO.getSEmpId());
			pstmt.setInt(4, pickingVO.getPickingQuantity());
			pstmt.setString(5, pickingVO.getPickingUnit());
			pstmt.setInt(6, pickingVO.getPickingStatus());
			pstmt.setInt(7, pickingVO.getPickingClass());
			pstmt.setDate(8, pickingVO.getPickingDate());
			pstmt.setString(9, pickingVO.getMarks());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}

	}

	@Override
	public void update(PickingVO pickingVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, pickingVO.getItemNumber());
			pstmt.setInt(2, pickingVO.getStoreId());
			pstmt.setInt(3, pickingVO.getSEmpId());
			pstmt.setInt(4, pickingVO.getPickingQuantity());
			pstmt.setString(5, pickingVO.getPickingUnit());
			pstmt.setInt(6, pickingVO.getPickingStatus());
			pstmt.setInt(7, pickingVO.getPickingClass());
			pstmt.setDate(8, pickingVO.getPickingDate());
			pstmt.setString(9, pickingVO.getMarks());
			pstmt.setInt(10, pickingVO.getPickingNo());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}

	}

	@Override
	public PickingVO findByPrimaryKey(Integer pickingNo) {
		PickingVO item = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, pickingNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				item = new PickingVO();

				item.setPickingNo(rs.getInt("pickingNo"));
				item.setItemNumber(rs.getInt("itemNumber"));
				item.setStoreId(rs.getInt("storeId"));
				item.setSEmpId(rs.getInt("sEmpId"));
				item.setPickingQuantity(rs.getInt("pickingQuantity"));
				item.setPickingUnit(rs.getString("pickingUnit"));
				item.setPickingStatus(rs.getInt("pickingStatus"));
				item.setPickingClass(rs.getInt("pickingClass"));
				item.setPickingDate(rs.getDate("pickingDate"));
				item.setMarks(rs.getString("marks"));

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, rs);
		}
		return item;
	}

	@Override
	public List<PickingVO> getAll() {
		List<PickingVO> itemList = new ArrayList<>();
		PickingVO item = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				item = new PickingVO();

				item.setPickingNo(rs.getInt("pickingNo"));
				item.setItemNumber(rs.getInt("itemNumber"));
				item.setStoreId(rs.getInt("storeId"));
				item.setSEmpId(rs.getInt("sEmpId"));
				item.setPickingQuantity(rs.getInt("pickingQuantity"));
				item.setPickingUnit(rs.getString("pickingUnit"));
				item.setPickingStatus(rs.getInt("pickingStatus"));
				item.setPickingClass(rs.getInt("pickingClass"));
				item.setPickingDate(rs.getDate("pickingDate"));
				item.setMarks(rs.getString("marks"));
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
