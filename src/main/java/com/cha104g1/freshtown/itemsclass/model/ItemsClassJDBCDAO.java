package com.cha104g1.freshtown.itemsclass.model;

import java.util.*;
import java.sql.*;

import com.cha104g1.freshtown.util.Util;

public class ItemsClassJDBCDAO implements ItemsClassDAOIntf{
    
	private static final String INSERT_STMT = "INSERT INTO itemsClass(itemClassName, storeId)"
			+ "VALUES (?, ?)";
	private static final String UPDATE = "UPDATE itemsClass set itemClassName=?, storeId=? WHERE itemClassId=?";
	private static final String FIND_BY_PK = "SELECT * FROM itemsClass WHERE itemClassId=?";
	private static final String GET_ALL = "SELECT * FROM itemsClass";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void insert(ItemsClassVO itemsClassVO) {
		    Connection con = null;
		    PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
		    pstmt = con.prepareStatement(INSERT_STMT);
		    
		    pstmt.setString(1, itemsClassVO.getItemClassName());
		    pstmt.setInt(2, itemsClassVO.getStoreId());
		    
		    pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public void update(ItemsClassVO itemsClassVO) {
		    Connection con = null;
		    PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
	        pstmt = con.prepareStatement(UPDATE);
	        
	        pstmt.setString(1, itemsClassVO.getItemClassName());
		    pstmt.setInt(2, itemsClassVO.getStoreId());
		    
		    pstmt.executeUpdate();
	        
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			closeResources(con, pstmt, null);
		}
	
		
	}

	@Override
	public ItemsClassVO findByPrimaryKey(Integer itemClassId) {
		
			ItemsClassVO item = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
		    pstmt = con.prepareStatement(FIND_BY_PK);
		    pstmt.setInt(1, itemClassId);
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	item = new ItemsClassVO();
		    	
		    	item.setItemClassId(rs.getInt("itemClassId"));
		    	item.setItemClassName(rs.getString("itemClassName"));
		    	item.setStoreId(rs.getInt("storeId"));
		    }
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			closeResources(con, pstmt, rs);
		}

		return item;
	}

	@Override
	public List<ItemsClassVO> getAll() {
		List<ItemsClassVO> itemList = new ArrayList<>();
		ItemsClassVO item = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
            pstmt = con.prepareStatement(GET_ALL);
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
		    	item = new ItemsClassVO();
		    	
		    	item.setItemClassId(rs.getInt("itemClassId"));
		    	item.setItemClassName(rs.getString("itemClassName"));
		    	item.setStoreId(rs.getInt("storeId"));
		    	itemList.add(item); 
            }
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			closeResources(con, pstmt, rs);
		}
		return itemList;
	}
	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace(System.err);
			}
		}
		
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace(System.err);
			}
		}
		
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace(System.err);
			}
		}
	}

	
}
