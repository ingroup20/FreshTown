package com.cha104g1.freshtown.orderdetail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailJDBCDAO implements OrderDetailDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha104g1?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "";

	private static final String INSERT_STMT = "INSERT INTO OrderDetail(mealNo, mealQty, orderId,priceBought) VALUES(?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT orderDtlNo, mealNo, mealQty, orderId,priceBought FROM OrderDetail ORDER BY orderId";
	private static final String GET_ONE_STMT = "SELECT orderDtlNo, mealNo, mealQty, orderId,priceBought FROM OrderDetail WHERE orderId = ?";
	private static final String UPDATE = "UPDATE  OrderDetail SET mealQty=?,priceBought=? WHERE orderDtlNo=?";
//缺刪除
	
	@Override
	public void insert(OrderDetailVO orderDetailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			//pstmt.setInt(1, orderDetailVO.getMealNo());
			pstmt.setInt(2, orderDetailVO.getMealQty());
			//pstmt.setInt(3, orderDetailVO.getOrderId());
			pstmt.setInt(4, orderDetailVO.getPriceBought());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("couldn't load database driver." + e.getMessage());

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
				} catch (Exception se) {
					se.printStackTrace(System.err);
				}
			}
		}

		
	}


	@Override
	public void update(OrderDetailVO orderDetailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, orderDetailVO.getMealQty());
			pstmt.setInt(2, orderDetailVO.getPriceBought());
			pstmt.setInt(3, orderDetailVO.getOrderDtlNo());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());

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
	public OrderDetailVO findByPrimaryKey(Integer orderDtlNo) {
		OrderDetailVO orderDetailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
	
			pstmt.setInt(1, orderDtlNo);
	
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				orderDetailVO = new OrderDetailVO();
				orderDetailVO.setOrderDtlNo(rs.getInt("orderDtlNo"));
				//orderDetailVO.setMealNo(rs.getInt("mealNo"));
				orderDetailVO.setMealQty(rs.getInt("mealQty"));
				//orderDetailVO.setOrderId(rs.getInt("orderId"));
				orderDetailVO.setPriceBought(rs.getInt("priceBought"));
	
			}
	
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
	
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

		return orderDetailVO;
	}


	@Override
	public List<OrderDetailVO> getAll() {

		List<OrderDetailVO> list = new ArrayList<OrderDetailVO>();
		OrderDetailVO odVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				odVO = new OrderDetailVO();
				odVO.setOrderDtlNo(rs.getInt("orderDtlNo"));
			//	odVO.setMealNo(rs.getInt("mealNo"));
				odVO.setMealQty(rs.getInt("mealQty"));
				//odVO.setOrderId(rs.getInt("orderId"));
				odVO.setPriceBought(rs.getInt("priceBought"));
				list.add(odVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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


	public static void main(String[] args) {

		OrderDetailJDBCDAO dao = new OrderDetailJDBCDAO();

		// 新增
//		orderDetailVO orderDetailVO1 = new orderDetailVO();
//		orderDetailVO1.setOrderId(0);
//		orderDetailVO1.setRefundState("N");
//		orderDetailVO1.setRefundDollar(300);
//		orderDetailVO1.setRefundDate(java.sql.Date.valueOf("2023-12-10"));
//		System.out.println("新增成功");

		// 查詢
//		orderDetailVO orderDetailVO3 = dao.findByPrimaryKey(1);
//		System.out.print(orderDetailVO3.getId()+",");
//		System.out.print(orderDetailVO3.getOrderId()+",");
//		System.out.print(orderDetailVO3.getRefundState()+",");
//		System.out.print(orderDetailVO3.getRefundDollar()+",");
//		System.out.println(orderDetailVO3.getRefundDate());
//		System.out.println("-----------------------------------");
		
		// 查詢
		List<OrderDetailVO> list = dao.getAll();
		for(OrderDetailVO odVO : list) {
			//System.out.print(odVO.getMealNo()+",");
			//System.out.print(odVO.getMealNo()+",");
			System.out.print(odVO.getMealQty()+",");
			//System.out.print(odVO.getOrderId()+",");
			System.out.println(odVO.getPriceBought());
			System.out.println("-----------------------------------");
		}
	}
	
}
