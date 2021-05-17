package com.java.junggo;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class infoChg extends JFrame {
	public infoChg() {

		Container con;
		con = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		//폰드
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Font font1 = new Font("맑은 고딕",Font.BOLD,12);
		//레이블
	

	

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(font);
		nameLabel.setBounds(60,50,100,40);
		panel.add(nameLabel);

		JLabel birthLabel = new JLabel("생년월일"); 
		birthLabel.setFont(font);
		birthLabel.setBounds(60,100,100,40);
		panel.add(birthLabel);

		JLabel phoneLabel = new JLabel("핸드폰번호"); 
		phoneLabel.setFont(font);
		phoneLabel.setBounds(60,150,100,40);
		panel.add(phoneLabel);

		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setFont(font);
		emailLabel.setBounds(60,200,100,40);
		panel.add(emailLabel);
		
		JLabel pwLabel = new JLabel("비밀번호"); 
		pwLabel.setFont(font);
		pwLabel.setBounds(60,300,100,40);
		panel.add(pwLabel);

		JLabel pwChkLabel = new JLabel("비밀번호 확인");
		pwChkLabel.setFont(font);
		pwChkLabel.setBounds(60,350,100,40);
		panel.add(pwChkLabel);
		//텍스트필드
	
		

		JTextField nameTxt = new JTextField();
		nameTxt.setBounds(155,55,160,30);
		panel.add(nameTxt);

		JTextField birthTxt = new JTextField();
		birthTxt.setBounds(155,105,160,30);
		panel.add(birthTxt);

		JTextField phoneTxt = new JTextField();
		phoneTxt.setBounds(155,155,160,30);
		panel.add(phoneTxt);

		JTextField emailTxt = new JTextField();
		emailTxt.setBounds(155,205,160,30);
		panel.add(emailTxt);

		JPasswordField pwTxt = new JPasswordField();
		pwTxt.setBounds(155,305,160,30);
		panel.add(pwTxt);
		
		JPasswordField pwChkTxt = new JPasswordField(); 
		pwChkTxt.setBounds(155,355,160,30);
		panel.add(pwChkTxt);
		
		
		//버튼생성
		JButton signUpBtn = new JButton("회원정보수정");
		signUpBtn.setBounds(90,420,200,50);
		panel.add(signUpBtn);
		

		
	
		
		
		

		
		// 프레임 설정
		setVisible(true);
		setTitle("회원가입");
		setSize(450,550);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
		
		
		
	
	}

	public static void main(String[] args) {
		new infoChg();

	}
}
