package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.java.dto.ProductDto;


public class ProductDao {
	static String driver = "org.mariadb.jdbc.Driver";
	static String url = "jdbc:mariadb://localhost:3306/junggo";
	static String uid = "junggo";
	static String pwd = "1234";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public ProductDao() {
		try {
			Class.forName(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProductDto> pdSearch(String name,String sort) {
		String query = "select * from product_info where p_name = ? and p_sort = ?";

		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		try {
			con = DriverManager.getConnection(url, uid, pwd);
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, name);
			pstmt.setString(2, sort);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int p_num = rs.getInt("p_num");
				String m_id = rs.getString("m_id");
				String p_image1 = rs.getString("p_image1");
				String p_image2 = rs.getString("p_image2");
				String p_name = rs.getString("p_name");
				int p_price = rs.getInt("p_price");
				int p_state = rs.getInt("p_state");
				String p_sort = rs.getString("p_sort");
				int p_hopeNum = rs.getInt("p_hopeNum");
				int p_click = rs.getInt("p_click");

				ProductDto dto = new ProductDto(p_num,m_id,p_image1,p_image2,p_name,p_price,p_state,p_sort,p_hopeNum,p_click);

				dtos.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					rs.close();
				if (con != null)
					rs.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
		
	}	
	
public ArrayList<ProductDto> pdSelect() {
	String query = "select * from product_info order by p_click DESC";

	ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
	try {
		con = DriverManager.getConnection(url, uid, pwd);
		pstmt = con.prepareStatement(query);

		rs = pstmt.executeQuery();

		while (rs.next()) {

			int p_num = rs.getInt("p_num");
			String m_id = rs.getString("m_id");
			String p_image1 = rs.getString("p_image1");
			String p_image2 = rs.getString("p_image2");
			String p_name = rs.getString("p_name");
			int p_price = rs.getInt("p_price");
			int p_state = rs.getInt("p_state");
			String p_sort = rs.getString("p_sort");
			int p_hopeNum = rs.getInt("p_hopeNum");
			int p_click = rs.getInt("p_click");

			ProductDto dto = new ProductDto(p_num,m_id,p_image1,p_image2,p_name,p_price,p_state,p_sort,p_hopeNum,p_click);

			dtos.add(dto);

		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {

			if (rs != null)
				rs.close();
			if (pstmt != null)
				rs.close();
			if (con != null)
				rs.close();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	return dtos;
	
}
	
public int pdInsert(String m_id,String p_image1, String p_image2, String p_name, int p_price, int p_state,String p_content,String p_sort) {

		
		String query = "insert into product_info(m_id,p_image1,p_image2,p_name,p_price,p_state,p_content,p_sort) values(?,?,?,?,?,?,?,?)";

		try {
			con = DriverManager.getConnection(url,uid,pwd);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m_id);
			pstmt.setString(2, p_image1);
			pstmt.setString(3, p_image2);
			pstmt.setString(4, p_name);
			pstmt.setInt(5, p_price);
			pstmt.setInt(6, p_state);
			pstmt.setString(7, p_content);
			pstmt.setString(8, p_sort);
			
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
}
