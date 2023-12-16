package com.cha104g1.freshtown.likestore.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Like_storeJDBCDAO implements Like_storeDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cha104g1?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "19920220";

	private static final String INSERT_STMT = "INSERT INTO Like_store(customerId, storeId,likeUnlike) VALUES(?,?,?)";
	private static final String GET_ALL_STMT = "SELECT id, customerId, storeId,likeUnlike FROM Like_store ORDER BY customerId";
	private static final String GET_ONE_STMT = "SELECT id, customerId, storeId,likeUnlike FROM Like_store WHERE customerId = ?";
	private static final String UPDATE = "UPDATE  Like_store SET likeUnlike=? WHERE customerId=?";

	
	
	@Override
	public void insert(Like_storeVO like_storeVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, like_storeVO.getCustomerId());
			pstmt.setInt(2, like_storeVO.getStoreId());
			pstmt.setInt(3, like_storeVO.getLikeUnlike());

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
	public void update(Like_storeVO like_storeVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, like_storeVO.getLikeUnlike());
			pstmt.setInt(2, like_storeVO.getCustomerId());


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
	public Like_storeVO findByPrimaryKey(Integer id) {
 
		Like_storeVO like_storeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				like_storeVO = new Like_storeVO();
				like_storeVO.setId(rs.getInt("id"));
				like_storeVO.setCustomerId(rs.getInt("customerId"));
				like_storeVO.setStoreId(rs.getInt("storeId"));
				like_storeVO.setLikeUnlike(rs.getInt("likeUnlike"));
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

		return like_storeVO;
	}


	@Override
	public Like_storeVO findByCustomer(Integer customerId) {

		Like_storeVO like_storeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, customerId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				like_storeVO = new Like_storeVO();
				like_storeVO.setId(rs.getInt("id"));
				like_storeVO.setCustomerId(rs.getInt("customerId"));
				like_storeVO.setStoreId(rs.getInt("storeId"));
				like_storeVO.setLikeUnlike(rs.getInt("likeUnlike"));
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

		return like_storeVO;
	}


	@Override
	public List<Like_storeVO> getAll() {

		List<Like_storeVO> list = new ArrayList<Like_storeVO>();
		Like_storeVO lsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				lsVO = new Like_storeVO();
				lsVO.setId(rs.getInt("id"));
				lsVO.setCustomerId(rs.getInt("customerId"));
				lsVO.setStoreId(rs.getInt("storeId"));
				lsVO.setLikeUnlike(rs.getInt("likeUnlike"));
				list.add(lsVO);
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

		Like_storeJDBCDAO dao = new Like_storeJDBCDAO();

		// �s�W
//		Like_storeVO like_storeVO1 = new Like_storeVO();
//		like_storeVO1.setCustomerId(0);
//		like_storeVO1.setStoreId(0);
//		like_storeVO1.setLikeUnlike(1);
//		System.out.println("�s�W���\");

		// �d��
//		Like_storeVO like_storeVO3 = dao.findByPrimaryKey(1);
//		System.out.print(like_storeVO3.getId()+",");
//		System.out.print(like_storeVO3.getCustomerId()+",");
//		System.out.print(like_storeVO3.getStoreId()+",");
//		System.out.println(like_storeVO3.getLikeUnlike()+",");
//		System.out.println("-----------------------------------");
		
		// �d��
		List<Like_storeVO> list = dao.getAll();
		for(Like_storeVO lsVO : list) {
			System.out.print(lsVO.getId()+",");
			System.out.print(lsVO.getCustomerId()+",");
			System.out.print(lsVO.getStoreId()+",");
			System.out.println(lsVO.getLikeUnlike()+",");
		}
	
	}


}
