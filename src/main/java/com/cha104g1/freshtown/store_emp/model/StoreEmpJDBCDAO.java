package com.cha104g1.freshtown.store_emp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreEmpJDBCDAO implements StoreEmpDAO_Interface{
	
	String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/cha104g1?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "x13579x2468";

    // SQL statements
    private static final String INSERT_STMT = "INSERT INTO store_emp (sEmpName, invPerm, purPerm, manuPerm, orderPerm, modifyPerm, storeId, sEmpDeptno, sEmpTitle, sEmpState) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_STMT = "SELECT sEmpId, sEmpName, invPerm, purPerm, manuPerm, orderPerm, modifyPerm, storeId, sEmpDeptno, sEmpTitle, sEmpState FROM store_emp order by sEmpId";
    private static final String GET_ONE_STMT = "SELECT sEmpId, sEmpName, invPerm, purPerm, manuPerm, orderPerm, modifyPerm, storeId, sEmpDeptno, sEmpTitle, sEmpState FROM store_emp where sEmpId = ?";
    private static final String DELETE = "DELETE FROM store_emp where sEmpId = ?";
    private static final String UPDATE = "UPDATE store_emp set sEmpName=?, invPerm=?, purPerm=?, manuPerm=?, orderPerm=?, modifyPerm=?, storeId=?, sEmpDeptno=?, sEmpTitle=?, sEmpState=? where sEmpId = ?";
    
    @Override
    public void insert(StoreEmpVO storeEmpVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setString(1, storeEmpVO.getsEmpName());
            pstmt.setByte(2, storeEmpVO.getInvPerm());
            pstmt.setByte(3, storeEmpVO.getPurPerm());
            pstmt.setByte(4, storeEmpVO.getManuPerm());
            pstmt.setByte(5, storeEmpVO.getOrderPerm());
            pstmt.setByte(6, storeEmpVO.getModifyPerm());
            pstmt.setInt(7, storeEmpVO.getStoreId());
            pstmt.setString(8, storeEmpVO.getsEmpDeptno());
            pstmt.setString(9, storeEmpVO.getsEmpTitle());
            pstmt.setByte(10, storeEmpVO.getsEmpState());

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        } finally {
            closeResources(con, pstmt, null);
        }
    }

    @Override
    public void update(StoreEmpVO storeEmpVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setString(1, storeEmpVO.getsEmpName());
            pstmt.setByte(2, storeEmpVO.getInvPerm());
            pstmt.setByte(3, storeEmpVO.getPurPerm());
            pstmt.setByte(4, storeEmpVO.getManuPerm());
            pstmt.setByte(5, storeEmpVO.getOrderPerm());
            pstmt.setByte(6, storeEmpVO.getModifyPerm());
            pstmt.setInt(7, storeEmpVO.getStoreId());
            pstmt.setString(8, storeEmpVO.getsEmpDeptno());
            pstmt.setString(9, storeEmpVO.getsEmpTitle());
            pstmt.setByte(10, storeEmpVO.getsEmpState());
            pstmt.setInt(11, storeEmpVO.getsEmpId());

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        } finally {
            closeResources(con, pstmt, null);
        }
    }

    @Override
    public void delete(Integer sEmpId) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, sEmpId);

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        } finally {
            closeResources(con, pstmt, null);
        }
    }

    @Override
    public StoreEmpVO findByPrimaryKey(Integer sEmpId) {
        StoreEmpVO storeEmpVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, sEmpId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                storeEmpVO = new StoreEmpVO();
                storeEmpVO.setsEmpId(rs.getInt("sEmpId"));
                storeEmpVO.setsEmpName(rs.getString("sEmpName"));
                storeEmpVO.setInvPerm(rs.getByte("invPerm"));
                storeEmpVO.setPurPerm(rs.getByte("purPerm"));
                storeEmpVO.setManuPerm(rs.getByte("manuPerm"));
                storeEmpVO.setOrderPerm(rs.getByte("orderPerm"));
                storeEmpVO.setModifyPerm(rs.getByte("modifyPerm"));
                storeEmpVO.setStoreId(rs.getInt("storeId"));
                storeEmpVO.setsEmpDeptno(rs.getString("sEmpDeptno"));
                storeEmpVO.setsEmpTitle(rs.getString("sEmpTitle"));
                storeEmpVO.setsEmpState(rs.getByte("sEmpState"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        } finally {
            closeResources(con, pstmt, rs);
        }

        return storeEmpVO;
    }

    @Override
    public List<StoreEmpVO> getAll() {
        List<StoreEmpVO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_STMT);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                StoreEmpVO storeEmpVO = new StoreEmpVO();
                storeEmpVO.setsEmpId(rs.getInt("sEmpId"));
                storeEmpVO.setsEmpName(rs.getString("sEmpName"));
                storeEmpVO.setInvPerm(rs.getByte("invPerm"));
                storeEmpVO.setPurPerm(rs.getByte("purPerm"));
                storeEmpVO.setManuPerm(rs.getByte("manuPerm"));
                storeEmpVO.setOrderPerm(rs.getByte("orderPerm"));
                storeEmpVO.setModifyPerm(rs.getByte("modifyPerm"));
                storeEmpVO.setStoreId(rs.getInt("storeId"));
                storeEmpVO.setsEmpDeptno(rs.getString("sEmpDeptno"));
                storeEmpVO.setsEmpTitle(rs.getString("sEmpTitle"));
                storeEmpVO.setsEmpState(rs.getByte("sEmpState"));
                list.add(storeEmpVO);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        } finally {
            closeResources(con, pstmt, rs);
        }

        return list;
    }

    // Utility method to close resources
    private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try { rs.close(); } catch (SQLException e) { e.printStackTrace(System.err); }
        }
        if (pstmt != null) {
            try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(System.err); }
        }
        if (con != null) {
            try { con.close(); } catch (SQLException e) { e.printStackTrace(System.err); }
        }
    }

}
