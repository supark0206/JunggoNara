package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProductChg extends JFrame {
	
	public ProductChg() {
		Container con;
		con = getContentPane();
		
	
		
		//판넬------------------
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(15, 50, 400, 500);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setLayout(null);
		
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Font font1 = new Font("맑은 고딕",Font.BOLD,17);
		//레이블-------------------------------
		
		JLabel imgLabel1 = new JLabel("1번 이미지");
		imgLabel1.setFont(font);
		imgLabel1.setOpaque(true);
		imgLabel1.setHorizontalAlignment(imgLabel1.CENTER);
		imgLabel1.setBackground(Color.WHITE);
		imgLabel1.setBounds(30, 180, 200, 35);
		panel2.add(imgLabel1);

		
		JLabel imgLabel2 = new JLabel("2번 이미지");
		imgLabel2.setFont(font);
		imgLabel2.setOpaque(true);
		imgLabel2.setHorizontalAlignment(imgLabel2.CENTER);
		imgLabel2.setBackground(Color.WHITE);
		imgLabel2.setBounds(30, 230, 200, 35);
		panel2.add(imgLabel2);
	
		
		JLabel imgLabel3 = new JLabel("3번 이미지");
		imgLabel3.setFont(font);
		imgLabel3.setOpaque(true);
		imgLabel3.setHorizontalAlignment(imgLabel3.CENTER);
		imgLabel3.setBackground(Color.WHITE);
		imgLabel3.setBounds(30, 280, 200, 35);
		panel2.add(imgLabel3);
		
		JLabel pdSortLabel = new JLabel("상품분류");
		pdSortLabel.setFont(font);
		pdSortLabel.setBounds(30, 10, 130, 35);
		panel2.add(pdSortLabel);
		
		
		JLabel pdNameLabel = new JLabel("상품명");
		pdNameLabel.setFont(font);
		pdNameLabel.setBounds(30, 50, 130, 35);
		panel2.add(pdNameLabel);
		
		JLabel pdPriceLabel = new JLabel("가격");
		pdPriceLabel.setFont(font);
		pdPriceLabel.setBounds(30, 90, 130, 35);
		panel2.add(pdPriceLabel);
		
		JLabel pdStateLabel = new JLabel("판매중");
		pdStateLabel.setFont(font1);
		pdStateLabel.setBounds(180, 135, 130, 35);
		panel2.add(pdStateLabel);


	
		
		
		
		//텍스트필드
		JTextField pdNameTxt = new JTextField();
		pdNameTxt.setBounds(100,50, 250, 35);
		panel2.add(pdNameTxt);
		
		JTextField pdPriceTxt = new JTextField();
		pdPriceTxt.setBounds(100,90, 250, 35);
		panel2.add(pdPriceTxt);
		
		//텍스트에리어
		JTextArea pdContentArea = new JTextArea();
		pdContentArea.setBounds(30,330, 325, 150);
		panel2.add(pdContentArea);
		
		//버튼------------------------------------
		JButton pdUpBtn = new JButton("상품등록");
		pdUpBtn.setBounds(310, 560, 105, 35);
		panel.add(pdUpBtn);
		
		JButton mainBtn = new JButton("메인");
		mainBtn.setBounds(15, 10, 95, 35);
		panel.add(mainBtn);

		JButton imgUpBtn1 = new JButton("1번 이미지");
		imgUpBtn1.setBounds(250, 180, 105, 35);
		panel2.add(imgUpBtn1);
		
		JButton imgUpBtn2 = new JButton("2번 이미지");
		imgUpBtn2.setBounds(250, 230, 105, 35);
		panel2.add(imgUpBtn2);
		
		JButton imgUpBtn3 = new JButton("3번 이미지");
		imgUpBtn3.setBounds(250, 280, 105, 35);
		panel2.add(imgUpBtn3);
	
		String[] pdSortName= {"의류","전자제품","가전제품","생활용품","운동화"};
		//콤보박스
		JComboBox<String> pdSortCbox = new JComboBox<>(pdSortName);
		pdSortCbox.setBounds(100, 10,130 ,35);
		panel2.add(pdSortCbox);
		
		//판넬에 올림
		con.add(panel);
		panel.add(panel2);
		


		// 프레임 설정
		setVisible(true);
		setTitle("상품등록");
		setSize(450,650);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료
		
		
	
	}
		
		
	


	public static void main(String[] args) {
	
		new  ProductChg();

	}

}
