package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class junggoMain extends JFrame{
	
	public JLabel userIdLabel;

	public junggoMain() {
		Container con;
		con = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,15);

		
		//레이블
		userIdLabel = new JLabel("사용자아이디");   
		
		
		
		//텍스트필드
		JTextField searchTxt = new JTextField();
	
		
		
		
		//버튼생성
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				dispose();
				
			}
		});
		
		JButton myshopBtn = new JButton("마이샵");
		JButton chatBtn = new JButton("내채팅");
		JButton addBtn = new JButton("상품등록");
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProductUpload();
				
			}
		});
		
		
		JButton searchBtn = new JButton("검색");
		
	
		//콤보박스
		String[] pdSortName= {"의류","전자제품","가전제품","생활용품","운동화"};
		JComboBox<String> pdSortCbox = new JComboBox<>(pdSortName);
		pdSortCbox.setBounds(239, 38,100 ,35);
		panel.add(pdSortCbox);
		
		//스크롤팬

		JPanel scrollPanel = new JPanel();
		scrollPanel.setBackground(Color.LIGHT_GRAY);
		scrollPanel.setLayout(new GridLayout(0,3));  //스크롤팬 내부 panel
		JScrollPane mainScroll = new JScrollPane(scrollPanel);	
		panel.add(mainScroll);

		
		//스크롤팬 위치지정
		mainScroll.setBounds(45, 100, 1000, 430);
		
		

		//레이블 폰트적용
		userIdLabel.setFont(font);
	
		//레이블 위치 지정
		userIdLabel.setBounds(30, 30, 200, 50);
	
		
		//텍스트필드 위치 지정
		searchTxt.setBounds(340,38, 300, 35);

		
		//버튼 위치 지정
		logoutBtn.setBounds(130, 38, 95, 35);
		searchBtn.setBounds(650, 38, 95, 35);
		addBtn.setBounds(750, 38, 95, 35);
		chatBtn.setBounds(850, 38, 95, 35);
		myshopBtn.setBounds(950, 38, 95, 35);
		

		//판넬에 올림
		con.add(panel);

		
		panel.add(searchBtn);
		panel.add(logoutBtn);
		panel.add(myshopBtn);
		panel.add(chatBtn);
		panel.add(addBtn);
		
		panel.add(userIdLabel);
		
		panel.add(searchTxt);

		
		

		
		// 프레임 설정
		setVisible(true);
		setTitle("중고나라");
		setSize(1100,600);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료
		
		
	
	}
		
		
	

	public static void main(String[] args) {
	
		new junggoMain();

	}

}
