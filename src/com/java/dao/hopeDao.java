package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.dto.ProductDto;
import com.java.dto.hopeDto;

public class hopeDao {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3306/junggo";
	static String uid = "junggo";
	static String pwd = "1234";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public  hopeDao() {
		try {
			Class.forName(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	
	
	public int hopeCheck(int p_num,String m_id) {
		
		String query = "SELECT * FROM hope_info where p_num = ? and m_id = ?";
		
		try {
			con = DriverManager.getConnection(url,uid,pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, p_num);
			pstmt.setString(2, m_id);
			

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return 0;

	}
	

	public void hopeInsert(int p_num,String m_id) {
		String query = "insert into hope_info(p_num,m_id) values(?,?)";

		try {
			con = DriverManager.getConnection(url,uid,pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, p_num);
			pstmt.setString(2, m_id);
			


			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	public void hopeDelete(int p_num,String m_id) {
		String query = "Delete from hope_info where p_num = ? and m_id = ?";
		

		try {
			con = DriverManager.getConnection(url,uid,pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, p_num);
			pstmt.setString(2, m_id);
			


			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
}
}