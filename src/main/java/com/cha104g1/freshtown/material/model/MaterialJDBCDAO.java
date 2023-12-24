package com.cha104g1.freshtown.material.model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cha104g1.freshtown.util.Util;

public class MaterialJDBCDAO implements MaterialDAOIntf {

	private static final String INSERT_STMT = "INSERT INTO material(itemName, itemClassId, stockQuantity, quantityNot,"
			+ " itemUnit, safetyStock, itemStatus, purDate, storeId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE material set itemName=?, itemClassId=?, stockQuantity=?, quantityNot=?,"
    		+ "itemUnit=?, safetyStock=?, itemStatus=?, purDate=?, storeId=? WHERE itemNumber=?";
    private static final String FIND_BY_PK = "SELECT * FROM material WHERE itemNumber=?";
    private static final String GET_ALL = "SELECT * FROM material";
    
    
     static {
    	 try {
    		Class.forName(Util.DRIVER); 
    	 }catch(ClassNotFoundException ce) {
    		 ce.printStackTrace();
    	 }
     }
    
	@Override
	public void insert(MaterialVO materialVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
		    pstmt = con.prepareStatement(INSERT_STMT);
		    
		    pstmt.setString(1, materialVO.getItemName());
		    pstmt.setInt(2, materialVO.getItemClassId());
		    pstmt.setInt(3, materialVO.getStockQuantity());
		    pstmt.setInt(4, materialVO.getQuantityNot());
		    pstmt.setString(5, materialVO.getItemUnit());
		    pstmt.setInt(6, materialVO.getSafetyStock());
		    pstmt.setInt(7, materialVO.getItemStatus());
		    pstmt.setDate(8, materialVO.getPurDate());
		    pstmt.setInt(9, materialVO.getStoreId());
		    
		    pstmt.executeUpdate();
		    
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			closeResources(con, pstmt, null);
		}
		

	}

	@Override
	public void update(MaterialVO materialVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		    con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
	        pstmt = con.prepareStatement(UPDATE);
		
		    pstmt.setString(1, materialVO.getItemName());
		    pstmt.setInt(2, materialVO.getItemClassId());
		    pstmt.setInt(3, materialVO.getStockQuantity());
		    pstmt.setInt(4, materialVO.getQuantityNot());
		    pstmt.setString(5, materialVO.getItemUnit());
		    pstmt.setInt(6, materialVO.getSafetyStock());
		    pstmt.setInt(7, materialVO.getItemStatus());
		    pstmt.setDate(8, materialVO.getPurDate());
		    pstmt.setInt(9, materialVO.getStoreId());
		    pstmt.setInt(10, materialVO.getItemNumber());
		    
		    pstmt.executeUpdate();
		
		
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			closeResources(con, pstmt, null);
		}

	    

	}

	@Override
	public MaterialVO findByPrimaryKey(Integer itemNumber) {
		
		MaterialVO item = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
		    pstmt = con.prepareStatement(FIND_BY_PK);
		    pstmt.setInt(1, itemNumber);
		    rs = pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	item = new MaterialVO();
		    	
		    	item.setItemNumber(rs.getInt("itemNumber"));
		    	item.setItemName(rs.getString("itemName"));
		    	item.setItemClassId(rs.getInt("itemClassId"));
		    	item.setStockQuantity(rs.getInt("stockQuantity"));
		    	item.setQuantityNot(rs.getInt("quantityNot"));
		    	item.setItemUnit(rs.getString("itemUnit"));
		    	item.setSafetyStock(rs.getInt("safetyStock"));
		    	item.setItemStatus(rs.getInt("itemStatus"));
		    	item.setPurDate(rs.getDate("PurDate"));
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
	public List<MaterialVO> getAll() {
		
		List<MaterialVO> itemList = new ArrayList<>();
		MaterialVO item = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
	        pstmt = con.prepareStatement(GET_ALL);
	        rs = pstmt.executeQuery();
	        
		    while(rs.next()) {
		    	item = new MaterialVO();
		    	
		    	item.setItemNumber(rs.getInt("itemNumber"));
		    	item.setItemName(rs.getString("itemName"));
		    	item.setItemClassId(rs.getInt("itemClassId"));
		    	item.setStockQuantity(rs.getInt("stockQuantity"));
		    	item.setQuantityNot(rs.getInt("quantityNot"));
		    	item.setItemUnit(rs.getString("itemUnit"));
		    	item.setSafetyStock(rs.getInt("safetyStock"));
		    	item.setItemStatus(rs.getInt("itemStatus"));
		    	item.setPurDate(rs.getDate("PurDate"));
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
