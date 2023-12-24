package com.cha104g1.freshtown.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
     public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
     public static final String URL = "jdbc:mysql://localhost:3306/cha104g1?serverTimezone=Asia/Taipei";
     public static final String USER = "root";
     public static final String PASSWORD = "!Cha10404";
     
     public static void closeResources (Connection con, PreparedStatement pstmt, ResultSet rs ) {
    	 
    	 if(rs != null) {
    		 try {
    			 rs.close();
    		 }catch(SQLException e) {
    			 e.printStackTrace();
    		 }
    	 }
    	 if(pstmt != null) {
    		 try {
    			 rs.close();
    		 }catch(SQLException e) {
    			 e.printStackTrace();
    		 }
    	 }
    	 if(con != null) {
    		 try {
    			 rs.close();
    		 }catch(SQLException e) {
    			 e.printStackTrace();
    		 }
    	 }
     }
}
