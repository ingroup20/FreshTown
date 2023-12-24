package com.cha104g1.freshtown.platform_emp.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlatformEmpJDBCDAO implements PlatformEmpDAO_Interface {
    // Database settings
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/cha104g1?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "x13579x2468";

    // SQL statements
    private static final String INSERT_STMT = "INSERT INTO platform_emp (pEmpPw, pEmpName, pEmpEmail, pEmpAccount, pEmpPerm, pEmpState) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_STMT = "SELECT pEmpId, pEmpPw, pEmpName, pEmpEmail, pEmpAccount, pEmpPerm, pEmpState FROM platform_emp order by pEmpId";
    private static final String GET_ONE_STMT = "SELECT pEmpId, pEmpPw, pEmpName, pEmpEmail, pEmpAccount, pEmpPerm, pEmpState FROM platform_emp where pEmpId = ?";
    private static final String DELETE = "DELETE FROM platform_emp where pEmpId = ?";
    private static final String UPDATE = "UPDATE platform_emp set pEmpPw=?, pEmpName=?, pEmpEmail=?, pEmpAccount=?, pEmpPerm=?, pEmpState=? where pEmpId = ?";

    @Override
    public void insert(PlatformEmpVO platformEmpVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_STMT);

            pstmt.setString(1, platformEmpVO.getpEmpPw());
            pstmt.setString(2, platformEmpVO.getpEmpName());
            pstmt.setString(3, platformEmpVO.getpEmpEmail());
            pstmt.setString(4, platformEmpVO.getpEmpAccount());
            pstmt.setByte(5, platformEmpVO.getpEmpPerm());
            pstmt.setByte(6, platformEmpVO.getpEmpState());

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        } finally {
            closeResources(con, pstmt, null);
        }
    }

    @Override
    public void update(PlatformEmpVO platformEmpVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setString(1, platformEmpVO.getpEmpPw());
            pstmt.setString(2, platformEmpVO.getpEmpName());
            pstmt.setString(3, platformEmpVO.getpEmpEmail());
            pstmt.setString(4, platformEmpVO.getpEmpAccount());
            pstmt.setByte(5, platformEmpVO.getpEmpPerm());
            pstmt.setByte(6, platformEmpVO.getpEmpState());
            pstmt.setInt(7, platformEmpVO.getpEmpId());

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        } finally {
            closeResources(con, pstmt, null);
        }
    }

    @Override
    public void delete(Integer pEmpId) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, pEmpId);

            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        } finally {
            closeResources(con, pstmt, null);
        }
    }

    @Override
    public PlatformEmpVO findByPrimaryKey(Integer pEmpId) {
        PlatformEmpVO platformEmpVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_STMT);

            pstmt.setInt(1, pEmpId);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                platformEmpVO = new PlatformEmpVO();
                platformEmpVO.setpEmpId(rs.getInt("pEmpId"));
                platformEmpVO.setpEmpPw(rs.getString("pEmpPw"));
                platformEmpVO.setpEmpName(rs.getString("pEmpName"));
                platformEmpVO.setpEmpEmail(rs.getString("pEmpEmail"));
                platformEmpVO.setpEmpAccount(rs.getString("pEmpAccount"));
                platformEmpVO.setpEmpPerm(rs.getByte("pEmpPerm"));
                platformEmpVO.setpEmpState(rs.getByte("pEmpState"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Database error: " + e.getMessage());
        } finally {
            closeResources(con, pstmt, rs);
        }

        return platformEmpVO;
    }

    @Override
    public List<PlatformEmpVO> getAll() {
        List<PlatformEmpVO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_STMT);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                PlatformEmpVO platformEmpVO = new PlatformEmpVO();
                platformEmpVO.setpEmpId(rs.getInt("pEmpId"));
                platformEmpVO.setpEmpPw(rs.getString("pEmpPw"));
                platformEmpVO.setpEmpName(rs.getString("pEmpName"));
                platformEmpVO.setpEmpEmail(rs.getString("pEmpEmail"));
                platformEmpVO.setpEmpAccount(rs.getString("pEmpAccount"));
                platformEmpVO.setpEmpPerm(rs.getByte("pEmpPerm"));
                platformEmpVO.setpEmpState(rs.getByte("pEmpState"));
                list.add(platformEmpVO);
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
