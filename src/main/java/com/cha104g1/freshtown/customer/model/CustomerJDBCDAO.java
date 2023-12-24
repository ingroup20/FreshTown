package com.cha104g1.freshtown.customer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerJDBCDAO implements CustomerDAO_Interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha104g1?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "x13579x2468";

	private static final String INSERT_STMT = "INSERT INTO customer (customerPw, customerMob, mobChecked, customerEmail, customerNic, customerAddress, customerState) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT customerId, customerPw, customerMob, mobChecked, customerEmail, customerNic, customerAddress, customerState FROM customer order by customerId";
	private static final String GET_ONE_STMT = "SELECT customerId, customerPw, customerMob, mobChecked, customerEmail, customerNic, customerAddress, customerState FROM customer where customerId = ?";
	private static final String DELETE = "DELETE FROM customer where customerId = ?";
	private static final String UPDATE = "UPDATE customer set customerPW=?, customerMob=?, mobChecked=?, customerEmail=?, customerNic=?, customerAddress=?, customerState=? where customerId = ?";

	@Override
	public void insert(CustomerVO customerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, customerVO.getCustomerPw());
			pstmt.setString(2, customerVO.getCustomerMob());
			pstmt.setString(3, customerVO.getMobChecked());
			pstmt.setString(4, customerVO.getCustomerEmail());
			pstmt.setString(5, customerVO.getCustomerNic());
			pstmt.setString(6, customerVO.getCustomerAddress());
			pstmt.setByte(7, customerVO.getCustomerState());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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
	public void update(CustomerVO customerVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, customerVO.getCustomerPw());
			pstmt.setString(2, customerVO.getCustomerMob());
			pstmt.setString(3, customerVO.getMobChecked());
			pstmt.setString(4, customerVO.getCustomerEmail());
			pstmt.setString(5, customerVO.getCustomerNic());
			pstmt.setString(6, customerVO.getCustomerAddress());
			pstmt.setByte(7, customerVO.getCustomerState());
			pstmt.setInt(8, customerVO.getCustomerId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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
	public void delete(Integer customerID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, customerID);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
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
	public CustomerVO findByPrimaryKey(Integer customerID) {

		CustomerVO customerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, customerID);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				customerVO = new CustomerVO();
				customerVO.setCustomerId(rs.getInt("customerID"));
				customerVO.setCustomerPw(rs.getString("customerPw"));
				customerVO.setCustomerMob(rs.getString("customerMob"));
				customerVO.setMobChecked(rs.getString("mobChecked"));
				customerVO.setCustomerEmail(rs.getString("customerEmail"));
				customerVO.setCustomerNic(rs.getString("customerNic"));
				customerVO.setCustomerAddress(rs.getString("customerAddress"));
				customerVO.setCustomerState(rs.getByte("customerState"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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
		return customerVO;
	}

	@Override
	public List<CustomerVO> getAll() {
		List<CustomerVO> list = new ArrayList<CustomerVO>();
		CustomerVO customerVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				customerVO = new CustomerVO();
				customerVO.setCustomerId(rs.getInt("customerId"));
				customerVO.setCustomerPw(rs.getString("customerPw"));
				customerVO.setCustomerMob(rs.getString("customerMob"));
				customerVO.setMobChecked(rs.getString("mobChecked"));
				customerVO.setCustomerEmail(rs.getString("customerEmail"));
				customerVO.setCustomerNic(rs.getString("customerNic"));
				customerVO.setCustomerAddress(rs.getString("customerAddress"));
				customerVO.setCustomerState(rs.getByte("customerState"));
				list.add(customerVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
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

	public static void main(String[] args) {

		CustomerJDBCDAO dao = new CustomerJDBCDAO();

//		// 範例: 新增客戶
//		CustomerVO customerVO1 = new CustomerVO();
//		customerVO1.setCustomerPw("123456");
//		customerVO1.setCustomerMob("0912345678");
//		customerVO1.setMobChecked("Y");
//		customerVO1.setCustomerEmail("example@email.com");
//		customerVO1.setCustomerNic("A123456789");
//		customerVO1.setCustomerAddress("台灣台北市");
//		customerVO1.setCustomerState((byte) 1);
//		dao.insert(customerVO1);
//
//		// 範例: 更新客戶
//		CustomerVO customerVO2 = new CustomerVO();
//		customerVO2.setCustomerId(1); // 假設ID為1的客戶
//		customerVO2.setCustomerPw("654321");
//		customerVO2.setCustomerMob("0987654321");
//		customerVO2.setMobChecked("N");
//		customerVO2.setCustomerEmail("example2@email.com");
//		customerVO2.setCustomerNic("B123456789");
//		customerVO2.setCustomerAddress("台灣新北市");
//		customerVO2.setCustomerState((byte) 0);
//		dao.update(customerVO2);
//
//		// 刪除
//		dao.delete(1);

		// 查詢
		CustomerVO customerVO3 = new CustomerVO();
		customerVO3 = dao.findByPrimaryKey(1);
		System.out.print(customerVO3.getCustomerId() + ",");
		System.out.print(customerVO3.getCustomerPw() + ",");
		System.out.print(customerVO3.getCustomerMob() + ",");
		System.out.print(customerVO3.getMobChecked() + ",");
		System.out.print(customerVO3.getCustomerEmail() + ",");
		System.out.print(customerVO3.getCustomerNic() + ",");
		System.out.print(customerVO3.getCustomerAddress() + ",");
		System.out.print(customerVO3.getCustomerState());
		System.out.println("---------------------");

		// 查詢
		List<CustomerVO> list = dao.getAll();
		for (CustomerVO aCustomer : list) {
			System.out.print(aCustomer.getCustomerId() + ",");
			System.out.print(aCustomer.getCustomerPw() + ",");
			System.out.print(aCustomer.getCustomerMob() + ",");
			System.out.print(aCustomer.getMobChecked() + ",");
			System.out.print(aCustomer.getCustomerEmail() + ",");
			System.out.print(aCustomer.getCustomerNic() + ",");
			System.out.print(aCustomer.getCustomerAddress() + ",");
			System.out.print(aCustomer.getCustomerState());
			System.out.println();
		}
	}

}
