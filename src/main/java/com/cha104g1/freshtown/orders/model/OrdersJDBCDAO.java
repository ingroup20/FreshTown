package com.cha104g1.freshtown.orders.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrdersJDBCDAO implements OrdersDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha104g1?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "";

	private static final String INSERT_STMT = "INSERT INTO Orders(orderState, orderTime, doneTime,finishTime,delayTime,customerId,totalPrice,storeId,delayDesc,comtVal,comtCont,comtTime,remitDate,remitState,payDate,payMethod,payState) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT orderId, orderState, orderTime, doneTime,finishTime,delayTime,customerId,totalPrice,storeId,delayDesc,comtVal,comtCont,comtTime,remitDate,remitState,payDate,payMethod,payState FROM Orders ORDER BY orderId";
	private static final String GET_ONE_STMT = "SELECT orderId, orderState, orderTime, doneTime,finishTime,delayTime,customerId,totalPrice,storeId,delayDesc,comtVal,comtCont,comtTime,remitDate,remitState,payDate,payMethod,payState FROM Orders WHERE orderId = ?";
	private static final String UPDATE = "UPDATE Orders SET orderState=?, orderTime=?, doneTime=?,finishTime=?,delayTime=?,totalPrice=?,delayDesc=?,comtVal=?,comtCont=?,comtTime=?,remitDate=?,remitState=?,payDate=?,payMethod=?,payState=? WHERE orderId=?";

	@Override
	public void insert(OrdersVO ordersVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, ordersVO.getOrderState());
			pstmt.setTimestamp(2, ordersVO.getOrderTime());
			pstmt.setTimestamp(3, ordersVO.getDoneTime());
			pstmt.setTimestamp(4, ordersVO.getFinishTime());
			pstmt.setTimestamp(5, ordersVO.getDelayTime());
			//pstmt.setInt(6, ordersVO.getCustomerId());
			pstmt.setInt(7, ordersVO.getTotalPrice());
		//	pstmt.setInt(8, ordersVO.getStoreId());
			pstmt.setString(9, ordersVO.getDelayDesc());
			pstmt.setInt(10, ordersVO.getComtVal());
			pstmt.setString(11, ordersVO.getComtCont());
			pstmt.setTimestamp(12, ordersVO.getComtTime());
			pstmt.setTimestamp(13, ordersVO.getRemitDate());
			pstmt.setString(14, ordersVO.getRemitState());
			pstmt.setTimestamp(15, ordersVO.getPayDate());
			pstmt.setInt(16, ordersVO.getPayMethod());
			pstmt.setInt(17, ordersVO.getPayState());

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
	public void update(OrdersVO ordersVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, ordersVO.getOrderState());
			pstmt.setTimestamp(2, ordersVO.getOrderTime());
			pstmt.setTimestamp(3, ordersVO.getDoneTime());
			pstmt.setTimestamp(4, ordersVO.getFinishTime());
			pstmt.setTimestamp(5, ordersVO.getDelayTime());
			//pstmt.setInt(6, ordersVO.getCustomerId());
			pstmt.setInt(7, ordersVO.getTotalPrice());
			//pstmt.setInt(8, ordersVO.getStoreId());
			pstmt.setString(9, ordersVO.getDelayDesc());
			pstmt.setInt(10, ordersVO.getComtVal());
			pstmt.setString(11, ordersVO.getComtCont());
			pstmt.setTimestamp(12, ordersVO.getComtTime());
			pstmt.setTimestamp(13, ordersVO.getRemitDate());
			pstmt.setString(14, ordersVO.getRemitState());
			pstmt.setTimestamp(15, ordersVO.getPayDate());
			pstmt.setInt(16, ordersVO.getPayMethod());
			pstmt.setInt(17, ordersVO.getPayState());
			pstmt.setInt(18, ordersVO.getOrderId());

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
	public OrdersVO findByPrimaryKey(Integer orderId) {

		OrdersVO ordersVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, orderId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ordersVO = new OrdersVO();
				ordersVO.setOrderId(rs.getInt("orderId"));
				ordersVO.setOrderState(rs.getInt("orderState"));
				ordersVO.setOrderTime(rs.getTimestamp("orderTime"));
				ordersVO.setDoneTime(rs.getTimestamp("doneTime"));
				ordersVO.setFinishTime(rs.getTimestamp("finishTime"));
				ordersVO.setDelayTime(rs.getTimestamp("delayTime"));
				//ordersVO.setCustomerId(rs.getInt("customerId"));
				ordersVO.setTotalPrice(rs.getInt("totalPrice"));
				//ordersVO.setStoreId(rs.getInt("storeId"));
				ordersVO.setDelayDesc(rs.getString("delayDesc"));
				ordersVO.setComtVal(rs.getInt("comtVal"));
				ordersVO.setComtCont(rs.getString("comtCont"));
				ordersVO.setComtTime(rs.getTimestamp("comtTime"));
				ordersVO.setRemitDate(rs.getTimestamp("remitDate"));
				ordersVO.setRemitState(rs.getString("remitState"));
				ordersVO.setPayDate(rs.getTimestamp("payDate"));
				ordersVO.setPayMethod(rs.getInt("payMethod"));
				ordersVO.setPayState(rs.getInt("payState"));

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

		return ordersVO;
	}

	@Override
	public List<OrdersVO> getAll() {

		List<OrdersVO> list = new ArrayList<OrdersVO>();
		OrdersVO ordersVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ordersVO = new OrdersVO();
				ordersVO.setOrderId(rs.getInt("orderId"));
				ordersVO.setOrderState(rs.getInt("orderState"));
				ordersVO.setOrderTime(rs.getTimestamp("orderTime"));
				ordersVO.setDoneTime(rs.getTimestamp("doneTime"));
				ordersVO.setFinishTime(rs.getTimestamp("finishTime"));
				ordersVO.setDelayTime(rs.getTimestamp("delayTime"));
			//	ordersVO.setCustomerId(rs.getInt("customerId"));
				ordersVO.setTotalPrice(rs.getInt("totalPrice"));
			//	ordersVO.setStoreId(rs.getInt("storeId"));
				ordersVO.setDelayDesc(rs.getString("delayDesc"));
				ordersVO.setComtVal(rs.getInt("comtVal"));
				ordersVO.setComtCont(rs.getString("comtCont"));
				ordersVO.setComtTime(rs.getTimestamp("comtTime"));
				ordersVO.setRemitDate(rs.getTimestamp("remitDate"));
				ordersVO.setRemitState(rs.getString("remitState"));
				ordersVO.setPayDate(rs.getTimestamp("payDate"));
				ordersVO.setPayMethod(rs.getInt("payMethod"));
				ordersVO.setPayState(rs.getInt("payState"));

				list.add(ordersVO);
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

		OrdersJDBCDAO dao = new OrdersJDBCDAO();

		// 新增
//		OrdersVO ordersVO1 = new OrdersVO();
//		Timestamp rightNow = new Timestamp(System.currentTimeMillis());
//		
//		ordersVO1.setOrderId(0);
//		ordersVO1.setOrderState(0);
//		ordersVO1.setOrderTime(rightNow);
//		ordersVO1.setDoneTime(rightNow);
//		ordersVO1.setFinishTime(rightNow);
//		ordersVO1.setDelayTime(rightNow);
//		ordersVO1.setCustomerId(0);
//		ordersVO1.setTotalPrice(5555);
//		ordersVO1.setStoreId(0);
//		ordersVO1.setDelayDesc("XXX");
//		ordersVO1.setComtVal(5);
//		ordersVO1.setComtCont("YYY");
//		ordersVO1.setComtTime(rightNow);
//		ordersVO1.setRemitDate(rightNow);
//		ordersVO1.setRemitState("N");
//		ordersVO1.setPayDate(rightNow);
//		ordersVO1.setPayMethod(0);
//		ordersVO1.setPayState(0);
//		System.out.println("新增成功");

		// 查詢
//		OrdersVO ordersVO3 = dao.findByPrimaryKey(1);
//		System.out.print(ordersVO3.getOrderId()+",");
//		System.out.print(ordersVO3.getOrderState()+",");
//		System.out.print(ordersVO3.getOrderTime()+",");
//		System.out.print(ordersVO3.getDoneTime()+",");
//		System.out.print(ordersVO3.getFinishTime()+",");
//		System.out.print(ordersVO3.getDelayTime()+",");
//		System.out.print(ordersVO3.getCustomerId()+",");
//		System.out.print(ordersVO3.getTotalPrice()+",");
//		System.out.print(ordersVO3.getStoreId()+",");
//		System.out.print(ordersVO3.getDelayDesc()+",");
//		System.out.print(ordersVO3.getComtVal()+",");
//		System.out.print(ordersVO3.getComtCont()+",");
//		System.out.print(ordersVO3.getComtTime()+",");
//		System.out.print(ordersVO3.getRemitDate()+",");
//		System.out.print(ordersVO3.getRemitState()+",");
//		System.out.print(ordersVO3.getPayDate()+",");
//		System.out.print(ordersVO3.getPayMethod()+",");
//		System.out.println(ordersVO3.getPayState());
//		System.out.println("-----------------------------------");

		// 查詢
		List<OrdersVO> list = dao.getAll();
		for (OrdersVO ordersVO : list) {
			System.out.print(ordersVO.getOrderId() + ",");
			System.out.print(ordersVO.getOrderState() + ",");
			System.out.print(ordersVO.getOrderTime() + ",");
			System.out.print(ordersVO.getDoneTime() + ",");
			System.out.print(ordersVO.getFinishTime() + ",");
			System.out.print(ordersVO.getDelayTime() + ",");
		//	System.out.print(ordersVO.getCustomerId() + ",");
			System.out.print(ordersVO.getTotalPrice() + ",");
		//	System.out.print(ordersVO.getStoreId() + ",");
			System.out.print(ordersVO.getDelayDesc() + ",");
			System.out.print(ordersVO.getComtVal() + ",");
			System.out.print(ordersVO.getComtCont() + ",");
			System.out.print(ordersVO.getComtTime() + ",");
			System.out.print(ordersVO.getRemitDate() + ",");
			System.out.print(ordersVO.getRemitState() + ",");
			System.out.print(ordersVO.getPayDate() + ",");
			System.out.print(ordersVO.getPayMethod() + ",");
			System.out.println(ordersVO.getPayState());

		}

	}

}