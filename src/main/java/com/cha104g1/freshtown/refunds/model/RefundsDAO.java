package com.cha104g1.freshtown.refunds.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RefundsDAO implements RefundsDAO_interface {

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

	private static final String INSERT_STMT = "INSERT INTO refunds(orderId, refundState, refundDollar,refundDate) VALUES(?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT id, orderId, refundState, refundDollar,refundDate FROM refunds ORDER BY id";
	private static final String GET_ONE_STMT = "SELECT id, orderId, refundState, refundDollar,refundDate FROM refunds WHERE orderId = ?";
	private static final String UPDATE = "UPDATE refunds SET refundState=?,refundDate=? WHERE orderId=?";

	@Override
	public void insert(RefundsVO refundsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

	//		pstmt.setInt(1, refundsVO.getOrderId());
			pstmt.setString(2, refundsVO.getRefundState());
			pstmt.setInt(3, refundsVO.getRefundDollar());
			pstmt.setDate(4, refundsVO.getRefundDate());

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
				} catch (Exception se) {
					se.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(RefundsVO refundsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(UPDATE);
			
			pstmt.setString(1, refundsVO.getRefundState());
			pstmt.setDate(2, refundsVO.getRefundDate());
	//		pstmt.setInt(3, refundsVO.getOrderId());

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
	public RefundsVO findByPrimaryKey(Integer id) {
		RefundsVO refundsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
		
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				refundsVO = new RefundsVO();
				refundsVO.setId(rs.getInt("id"));
			//	refundsVO.setOrderId(rs.getInt("orderId"));
				refundsVO.setRefundState(rs.getString("refundState"));
				refundsVO.setRefundDollar(rs.getInt("refundDollar"));
				refundsVO.setRefundDate(rs.getDate("refundDate"));

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

		return refundsVO;
	}

	@Override
	public List<RefundsVO> getAll() {
		List<RefundsVO> list =new ArrayList<RefundsVO>();
		RefundsVO refundsVO =null;
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = ds.getConnection();
			pstmt=con.prepareStatement(GET_ALL_STMT);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				refundsVO = new RefundsVO();
				refundsVO.setId(rs.getInt("id"));
		//		refundsVO.setOrderId(rs.getInt("orderId"));
				refundsVO.setRefundState(rs.getString("refundState"));
				refundsVO.setRefundDollar(rs.getInt("refundDollar"));
				refundsVO.setRefundDate(rs.getDate("refundDate"));
				list.add(refundsVO);
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
