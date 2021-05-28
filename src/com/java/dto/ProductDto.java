package com.java.dto;

public class ProductDto {
	private int p_num;
	private String m_id;
	private String p_image1;
	private String p_image2;
	private String p_name;
	private int p_price;
	private int p_state;
	private String p_sort;
	private int p_hopeNum;
	private int p_click;
	public int getP_num() {
		return p_num;
	}
	
	public ProductDto() {}
	
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getP_image1() {
		return p_image1;
	}
	public void setP_image1(String p_image1) {
		this.p_image1 = p_image1;
	}
	public String getP_image2() {
		return p_image2;
	}
	public void setP_image2(String p_image2) {
		this.p_image2 = p_image2;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_state() {
		return p_state;
	}
	public void setP_state(int p_state) {
		this.p_state = p_state;
	}
	public String getP_sort() {
		return p_sort;
	}
	public void setP_sort(String p_sort) {
		this.p_sort = p_sort;
	}
	public int getP_hopeNum() {
		return p_hopeNum;
	}
	public void setP_hopeNum(int p_hopeNum) {
		this.p_hopeNum = p_hopeNum;
	}
	public int getP_click() {
		return p_click;
	}
	public void setP_click(int p_click) {
		this.p_click = p_click;
	}
	public ProductDto(int p_num, String m_id, String p_image1, String p_image2, String p_name, int p_price, int p_state,
			String p_sort, int p_hopeNum, int p_click) {
		super();
		this.p_num = p_num;
		this.m_id = m_id;
		this.p_image1 = p_image1;
		this.p_image2 = p_image2;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_state = p_state;
		this.p_sort = p_sort;
		this.p_hopeNum = p_hopeNum;
		this.p_click = p_click;
	}
	
	
}
