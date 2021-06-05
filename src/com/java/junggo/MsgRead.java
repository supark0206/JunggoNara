package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MsgRead  extends JFrame{
	
	JPanel panel;
	JLabel sendIdLbl, reciIdLbl,timeIdLbl,sendIdLbl2, reciIdLbl2,titleLbl,contentLbl;

	JButton sendBtn;

	
	
	public MsgRead() {
		Container con;
		con = getContentPane();
		
		panel = new JPanel();
		panel.setLayout(null);	
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		
		//레이블

		timeIdLbl = new JLabel("보낸시간");
		timeIdLbl.setBounds(250, 50, 220, 30);
		timeIdLbl.setFont(font);
		panel.add(timeIdLbl);
		

		sendIdLbl = new JLabel("작성자:");
		sendIdLbl.setBounds(60, 50, 70, 30);
		sendIdLbl.setOpaque(true);
		sendIdLbl.setFont(font);
		sendIdLbl.setBackground(Color.WHITE);
		panel.add(sendIdLbl);
		
		sendIdLbl2 = new JLabel("작성자아이디");
		sendIdLbl2.setBounds(130, 50, 100, 30);
		sendIdLbl2.setOpaque(true);
		sendIdLbl2.setFont(font);
		sendIdLbl2.setBackground(Color.WHITE);
		panel.add(sendIdLbl2);
		
		
		reciIdLbl = new JLabel("수신자:");
		reciIdLbl.setBounds(60, 370, 70, 30);
		reciIdLbl.setOpaque(true);
		reciIdLbl.setFont(font);
		reciIdLbl.setBackground(Color.WHITE);
		panel.add(reciIdLbl);
		
		
		reciIdLbl2 = new JLabel("수신자아이디");
		reciIdLbl2.setBounds(130, 370, 100, 30);
		reciIdLbl2.setOpaque(true);
		reciIdLbl2.setFont(font);
		reciIdLbl2.setBackground(Color.WHITE);
		panel.add(reciIdLbl2);
		

		titleLbl = new JLabel("");
		titleLbl.setBounds(60, 100, 350, 30);
		titleLbl.setOpaque(true);
		titleLbl.setBackground(Color.WHITE);
		panel.add(titleLbl);
		
		//텍스트에리어
		contentLbl = new JLabel("");
		contentLbl.setBounds(60, 150, 350, 200);
		contentLbl.setOpaque(true);
		contentLbl.setBackground(Color.WHITE);
		panel.add(contentLbl);
		
		
		//버튼
		sendBtn = new JButton("답장");
		sendBtn.setBounds(330, 370, 80, 30);
		panel.add(sendBtn);
		sendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MsgWrite mw = new MsgWrite();
				
				mw.reciIdLbl2.setText(sendIdLbl2.getText());
				mw.sendIdLbl2.setText(reciIdLbl2.getText());
				
			}
		});
	
		
		
		//판넬에 올림
		con.add(panel);
				


		// 프레임 설정
		setVisible(true);
		setTitle("쪽지 읽기");
		setSize(500,500);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new MsgRead();

	}

}
