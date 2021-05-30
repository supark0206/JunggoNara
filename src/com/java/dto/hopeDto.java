package com.java.dto;

public class hopeDto {
	int p_num;
	String m_id;
	
	public hopeDto() {}
	
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public hopeDto(int p_num, String m_id) {
		super();
		this.p_num = p_num;
		this.m_id = m_id;
	}
}
