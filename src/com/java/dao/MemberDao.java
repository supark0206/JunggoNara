package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.dto.MemberDto;
import com.java.junggo.FindIdPw;

public class MemberDao {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3306/junggo";
	static String uid = "junggo";
	static String pwd = "1234";

	Connection con = null;
	ResultSet rs = null; // 쿼리를 받아온는 객체
	PreparedStatement pstmt = null;

	private String query = null;

	public MemberDao() {
		try {
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberDto findId(String m_name, String m_birth, String m_phone, String m_email) {

		query = "SELECT * FROM member_info WHERE m_name= ? and m_birth = ? and m_phone = ? and m_email = ?";

		try {
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, m_name);
			pstmt.setString(2, m_birth);
			pstmt.setString(3, m_phone);
			pstmt.setString(4, m_email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				MemberDto dto = new MemberDto();
				String id = rs.getString("m_id");
				String pw = rs.getString("m_pw");
				String name = rs.getString("m_name");
				String email = rs.getString("m_email");
				String birth = rs.getString("m_birth");
				String phone = rs.getString("m_phone");

				dto = new MemberDto(id, pw, name, email, birth, phone);

				return dto;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	
	public MemberDto findPw(String m_name, String m_birth, String m_phone, String m_email,String m_id) {

		query = "SELECT * FROM member_info WHERE m_name= ? and m_birth = ? and m_phone = ? and m_email = ? and m_id = ?";

		try {
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, m_name);
			pstmt.setString(2, m_birth);
			pstmt.setString(3, m_phone);
			pstmt.setString(4, m_email);
			pstmt.setString(5, m_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				MemberDto dto = new MemberDto();
				String id = rs.getString("m_id");
				String pw = rs.getString("m_pw");
				String name = rs.getString("m_name");
				String email = rs.getString("m_email");
				String birth = rs.getString("m_birth");
				String phone = rs.getString("m_phone");

				dto = new MemberDto(id, pw, name, email, birth, phone);

				return dto;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}
	/*
	 * public ArrayList<MemberDto> findId(String m_name, String m_birth, String
	 * m_phone, String m_email) {
	 * 
	 * query =
	 * "SELECT * FROM member_info WHERE m_name= ? and m_birth = ? and m_phone = ? and m_email = ?"
	 * ;
	 * 
	 * ArrayList<MemberDto> dtos = new ArrayList<MemberDto>(); try { con =
	 * DriverManager.getConnection(url, uid, pwd); pstmt =
	 * con.prepareStatement(query);
	 * 
	 * pstmt.setString(1, m_name); pstmt.setString(2, m_birth); pstmt.setString(3,
	 * m_phone); pstmt.setString(4, m_email); rs = pstmt.executeQuery(query);
	 * 
	 * while (rs.next()) {
	 * 
	 * String id = rs.getString("m_id"); String pw = rs.getString("m_pw"); String
	 * name = rs.getString("m_name"); String email = rs.getString("m_email"); String
	 * birth = rs.getString("m_birth"); String phone = rs.getString("m_phone");
	 * 
	 * MemberDto dto = new MemberDto(id, pw, name, email, birth, phone);
	 * 
	 * dtos.add(dto);
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); } finally { try {
	 * 
	 * if (rs != null) rs.close(); if (pstmt != null) pstmt.close(); if (con !=
	 * null) con.close();
	 * 
	 * } catch (Exception e2) { e2.printStackTrace(); } } return dtos; }
	 */

}
