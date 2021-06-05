package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.dto.MessageDto;
import com.java.dto.ProductDto;

public class MsgDao {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3306/junggo";
	static String uid = "junggo";
	static String pwd = "1234";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	

	
	
	public MsgDao() {
		try {
			Class.forName(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void msgclick(int num) {
		String query = "UPDATE message SET msg_check = 0 WHERE msg_num =?";

		
		try {
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);

			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	
	public MessageDto msginfo(int num) {
		String query = "select * from message where msg_num = ?";
		MessageDto msgDto = new MessageDto();
		
		
		try {
		
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, num);

			
			rs = pstmt.executeQuery();

			if(rs.next()) {

				int msg_num = rs.getInt("msg_num");
				String reci_id = rs.getString("reci_id");
				String send_id = rs.getString("send_id");
				String msg_title =rs.getString("msg_title");
				String msg_content =rs.getString("msg_content");
				String msg_date =rs.getString("msg_date");
				int msg_check = rs.getInt("msg_check");
				
				msgDto = new MessageDto(msg_num,reci_id,send_id,msg_title,msg_content,msg_date,msg_check);
				
				
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
		return msgDto;
		
	}	
	
	public ArrayList<MessageDto> SelectMsg(String id , String check){
		String query = "SELECT * FROM message WHERE reci_id = ? AND msg_check like ?";

		ArrayList<MessageDto> dtos = new ArrayList<MessageDto>();
		try {
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, id);
			pstmt.setString(2, "%"+check);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int msg_num = rs.getInt("msg_num");
				String reci_id = rs.getString("reci_id");
				String send_id = rs.getString("send_id");
				String msg_title =rs.getString("msg_title");
				String msg_content =rs.getString("msg_content");
				String msg_date =rs.getString("msg_date");
				int msg_check = rs.getInt("msg_check");
				
				MessageDto dto = new MessageDto(msg_num,reci_id,send_id,msg_title,msg_content,msg_date,msg_check);

				dtos.add(dto);
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
		return dtos;
		
	}
	
	public void sendMsg(String reciID,String sendID,String msgTitle,String msgContent,int msgCheck) {
		String query = "insert into message(reci_id,send_id,msg_title,msg_content,msg_check)VALUES(?,?,?,?,?)";

		try {
			con = DriverManager.getConnection(url,uid,pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reciID);
			pstmt.setString(2, sendID);
			pstmt.setString(3, msgTitle);
			pstmt.setString(4, msgContent);
			pstmt.setInt(5, msgCheck);

			
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
