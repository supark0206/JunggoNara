package com.java.dto;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.java.dao.ProductDao;
import com.java.junggo.ProductInfo;
import com.java.junggo.junggoMain;

public class MyProductMng extends JFrame {


	JScrollPane mainScroll;
	public JPanel scrollPanel;
	JPanel panel;
	JLabel userIdLabel;
	JTextField searchTxt;
	JComboBox<String> pdStateCbox;

	
	public MyProductMng() {
		Container con;
		con = getContentPane();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,15);

		//스크롤팬
		scrollPanel = new JPanel();
		scrollPanel.setBackground(Color.LIGHT_GRAY);
		scrollPanel.setLayout(new GridBagLayout());  //스크롤팬 내부 pane
		mainScroll = new JScrollPane(scrollPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		mainScroll.setBounds(45, 100, 1000, 430);
		panel.add(mainScroll);
		
		//레이블
		userIdLabel = new JLabel("사용자아이디");   
		userIdLabel.setFont(font);
		userIdLabel.setBounds(30, 30, 200, 50);
		panel.add(userIdLabel);
		
		//버튼
		JButton myshopBtn =new JButton("마이샵");
		myshopBtn.setBounds(950, 38, 95, 35);
		panel.add(myshopBtn);
		
		JButton searchBtn = new JButton("검색");
		searchBtn.setBounds(650, 38, 95, 35);
		panel.add(searchBtn);
		
		//텍스트필드
		searchTxt = new JTextField();
		searchTxt.setBounds(420,38, 220, 35);
		panel.add(searchTxt);
		
		
		//콤보박스
		String[] pdStateName= {"전체상품","판매중","판매완료"};
		pdStateCbox = new JComboBox<>(pdStateName);
		pdStateCbox.setBounds(320, 38,90 ,35);
		panel.add(pdStateCbox);
		
		//판넬에 올림
		con.add(panel);

		// 프레임 설정
		setVisible(true);
		setTitle("등록 상품");
		setSize(1100,600);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
	}

	

	public static void main(String[] args) {
		
		new MyProductMng();
	}

}
