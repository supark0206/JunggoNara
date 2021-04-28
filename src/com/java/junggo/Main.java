package com.java.junggo;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Main extends JFrame{
	
	public Main() {
		Container con;
		con = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		
		//레이블
		JLabel UserIdLabel = new JLabel("사용자아이디");   
		
		
		
		//텍스트필드
		JTextField searchTxt = new JTextField();
	
		//버튼생성
		JButton logoutBtn = new JButton();
		JButton addBtn = new JButton();
		JButton chatBtn = new JButton();
		JButton MyshopBtn = new JButton();
		JButton searchBtn = new JButton();
		
		//스크롤바
		JScrollPane mainScroll = new JScrollPane();

		//레이블 폰트적용
	

		
		//레이블 위치 지정
	
		
		//텍스트필드 위치 지정

		
		//버튼 위치 지정
	
		
		//
		
	

		
		//판넬에 올림
		add(panel);
		add(mainScroll);

		

		
		// 프레임 설정
		setVisible(true);
		setTitle("회원가입");
		setSize(1100,600);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료
		
		
	
	}
		
		
	

	public static void main(String[] args) {
	
		new Main();

	}

}
