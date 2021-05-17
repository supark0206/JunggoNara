package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3306/junggo";
	static String uid = "junggo";
	static String pwd = "1234";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	
	
	public LoginDao() {
		try {
			Class.forName(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public int login(String m_id, String m_pw) {
		 	

	        String query = "select * from member_info where m_id = ? and m_pw = ?";


	        try {
	        	con = DriverManager.getConnection(url,uid,pwd);
	            pstmt = con.prepareStatement(query);
	            
	            pstmt.setString(1,m_id);
	            pstmt.setString(2,m_pw);
	            
	            
	           rs = pstmt.executeQuery();
	            
	            if(rs.next()) {
	            	return 1;
	            }
	         
	        
	               
	        }catch(Exception e) {

	            e.printStackTrace();   

	        }finally {
	        	try {
	        		if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
	        	}catch(Exception e2){
	        		e2.printStackTrace();
	        	}
	        }

	        return -1;
	  
	    }
}
