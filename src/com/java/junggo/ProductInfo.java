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

public class ProductInfo extends JFrame {
	
	JLabel mnameLbl,pdNameLbl,pdPricetLbl,pdNameLbl2,pdPricetLbl2,mnameLbl2;
	JButton mainBtn , hopeBtn , chatBtn;
	JTextArea contentArea;
	Font font1,areafont;
	JPanel imgPanel1,imgPanel2;
	int num;
	
	public ProductInfo() {
		Container con;
		con = getContentPane();
		//폰트
		font1 = new Font("맑은 고딕",Font.BOLD,18);
		areafont = new Font("맑은 고딕",Font.PLAIN,16);
		
		
		//판넬------------------
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		con.add(mainPanel);
		
		imgPanel1 = new JPanel();
		imgPanel1.setLayout(null);
		imgPanel1.setBounds(70, 70, 300, 300);
		imgPanel1.setBackground(Color.GRAY);
		mainPanel.add(imgPanel1);
		
		imgPanel2 = new JPanel();
		imgPanel2.setLayout(null);
		imgPanel2.setBounds(400, 70, 300, 300);
		imgPanel2.setBackground(Color.GRAY);
		mainPanel.add(imgPanel2);
		//레이블
		mnameLbl = new JLabel("등록자 :");
		mnameLbl.setBounds(70, 390, 150, 50);
		mnameLbl.setFont(font1);
		mainPanel.add(mnameLbl);
		
		mnameLbl2 = new JLabel("사용자");
		mnameLbl2.setBounds(150, 390, 200, 50);
		mnameLbl2.setFont(font1);
		mainPanel.add(mnameLbl2);
		
		
		pdNameLbl = new JLabel("상품명 :");
		pdNameLbl.setBounds(70, 440, 150, 50);
		pdNameLbl.setFont(font1);
		mainPanel.add(pdNameLbl);
		
		pdNameLbl2 = new JLabel("상품명");
		pdNameLbl2.setBounds(150, 440, 200, 50);
		pdNameLbl2.setFont(font1);
		mainPanel.add(pdNameLbl2);
		
		
		pdPricetLbl = new JLabel("상품가격 :");
		pdPricetLbl.setBounds(70, 490, 150, 50);
		pdPricetLbl.setFont(font1);
		mainPanel.add(pdPricetLbl);
		
		pdPricetLbl2 = new JLabel("상품 가격");
		pdPricetLbl2.setBounds(160, 490, 200, 50);
		pdPricetLbl2.setFont(font1);
		mainPanel.add(pdPricetLbl2);
		
		
		//버튼
		hopeBtn = new JButton("찜하기");
		hopeBtn.setBounds(550, 560, 140, 50);
		hopeBtn.setFont(font1);
		mainPanel.add(hopeBtn);
		
		chatBtn = new JButton("채팅하기");
		chatBtn.setBounds(550, 640, 140, 50);
		chatBtn.setFont(font1);
		mainPanel.add(chatBtn);
		
		mainBtn = new JButton("메인");
		mainBtn.setBounds(70, 15, 100, 35);
		mainBtn.setFont(font1);
		mainPanel.add(mainBtn);
		
		mainBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				junggoMain m = new junggoMain();
				
				m.pdView(m);
			}
		});
		//텍스트 에리어
		
		contentArea = new JTextArea();
		contentArea.setBounds(70, 550, 450, 150);
		contentArea.setFont(areafont);
		contentArea.setLineWrap(true);
		mainPanel.add(contentArea);


		// 프레임 설정
		setVisible(true);
		setTitle("상품상세정보");
		setSize(800,800);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
	}
	
	public static void main(String[] args) {
		
		new  ProductInfo();

	}

}