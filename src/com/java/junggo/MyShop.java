package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyShop extends JFrame {
	
	public MyShop(){
		Container con;
		con = getContentPane();
		
	
		
		//판넬------------------
		JPanel panel = new JPanel();
		panel.setLayout(null);
		con.add(panel);
	
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,20);
		//버튼
		JButton mainBtn = new JButton("메인");
		mainBtn.setBounds(10, 10, 105, 35);
		panel.add(mainBtn);

		JButton hopeListBtn = new JButton("나의찜목록");
		hopeListBtn.setBounds(10, 330, 120, 50);
		panel.add(hopeListBtn);

		JButton pdUpMngBtn = new JButton("등록상품관리");
		pdUpMngBtn.setBounds(155, 330, 120, 50);
		panel.add(pdUpMngBtn);

		JButton chgInfoBtn = new JButton("내정보 수정");
		chgInfoBtn.setBounds(300, 330, 120, 50);
		panel.add(chgInfoBtn);
		chgInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new infoChg();
			}
		});

		//레이블
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(font);
		idLabel.setBounds(30, 70, 130, 35);
		panel.add(idLabel);
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(font);
		nameLabel.setBounds(30, 120, 130, 35);
		panel.add(nameLabel);
		
		JLabel phoneLabel = new JLabel("핸드폰번호");
		phoneLabel.setFont(font);
		phoneLabel.setBounds(30, 170, 130, 35);
		panel.add(phoneLabel);
		
		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setFont(font);
		birthLabel.setBounds(30, 220, 130, 35);
		panel.add(birthLabel);
		
		JLabel emailLabel  = new JLabel("이메일");
		emailLabel.setFont(font);
		emailLabel.setBounds(30, 270, 130, 35);
		panel.add(emailLabel);
		



		// 프레임 설정
		setVisible(true);
		setTitle("마이샵");
		setSize(450,450);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
	}
	public static void main(String[] args) {
		
		new  MyShop();

	}
}
