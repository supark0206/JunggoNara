package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpDao {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3306/junggo";
	static String uid = "junggo";
	static String pwd = "1234";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public SignUpDao() {
		try {
			Class.forName(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int mInsert(String m_id, String m_pw, String m_name, String m_birth, String m_phone,String m_email) {

		
		String query = "insert into member_info values(?,?,?,?,?,?)";

		try {
			con = DriverManager.getConnection(url,uid,pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			pstmt.setString(3, m_name);
			pstmt.setString(4, m_birth);
			pstmt.setString(5, m_phone);
			pstmt.setString(6, m_email);
			
			return pstmt.executeUpdate();
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
		return -1; //오류
	}

	public int idCheck(String m_id) {
		String query = "select * from member_info where m_id = ?";
		
		try {
			con = DriverManager.getConnection(url,uid,pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 0; //이용자가 있는경우
			}else {
				return 1; //이용자가 없을경우
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1; //오류
	}
	
	public int phoneCheck(String m_phone) {

		String query = "select * from member_info where m_phone = ?";
		try {
			con = DriverManager.getConnection(url,uid,pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m_phone);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 0; //사용중인 번호일경우
			}else {
				return 1; //없는 번호일경우
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1; //오류
	}
	
	
}
