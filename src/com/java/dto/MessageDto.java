package com.java.dto;

public class MessageDto {
	int msg_num;
	String reci_id,send_id,msg_title,msg_content,msg_date;
	int msg_check;
	
	public MessageDto() {}
	
	public int getMsg_num() {
		return msg_num;
	}
	public void setMsg_num(int msg_num) {
		this.msg_num = msg_num;
	}
	public String getReci_id() {
		return reci_id;
	}
	public void setReci_id(String reci_id) {
		this.reci_id = reci_id;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public String getMsg_title() {
		return msg_title;
	}
	public void setMsg_title(String msg_title) {
		this.msg_title = msg_title;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public String getMsg_date() {
		return msg_date;
	}
	public void setMsg_date(String msg_date) {
		this.msg_date = msg_date;
	}
	public int getMsg_check() {
		return msg_check;
	}
	public void setMsg_check(int msg_check) {
		this.msg_check = msg_check;
	}
	public MessageDto(int msg_num, String reci_id, String send_id, String msg_title, String msg_content,
			String msg_date, int msg_check) {
		super();
		this.msg_num = msg_num;
		this.reci_id = reci_id;
		this.send_id = send_id;
		this.msg_title = msg_title;
		this.msg_content = msg_content;
		this.msg_date = msg_date;
		this.msg_check = msg_check;
	}
}
