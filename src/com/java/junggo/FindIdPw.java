package com.java.junggo;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FindIdPw extends JFrame{

public FindIdPw(){
		
		
		Container con;
		con = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		//폰드
		Font font = new Font("맑은 고딕",Font.BOLD,17);
		
		//레이블
		JLabel nameLabel = new JLabel("이름"); 
		JLabel birthLabel = new JLabel("생년월일"); 
		JLabel phoneLabel = new JLabel("핸드폰번호"); 
		JLabel emailLabel = new JLabel("이메일");
		JLabel idLabel = new JLabel("아이디"); 


		
		//텍스트필드
		JTextField nameTxt = new JTextField(15);
		JTextField birthTxt = new JTextField(15);
		JTextField phoneTxt = new JTextField(15);
		JTextField emailTxt = new JTextField(15); 
		JTextField idTxt = new JTextField(15);
			
		//버튼생성
		JButton findIdBtn = new JButton("아이디찾기");
		JButton findPwBtn = new JButton("비밀번호찾기");
		
		//레이블 폰트적용
		idLabel.setFont(font);
		nameLabel.setFont(font);
		birthLabel.setFont(font);
		emailLabel.setFont(font);
		phoneLabel.setFont(font);

		
		//레이블 위치 지정
		nameLabel.setBounds(60,50,100,40);
		birthLabel.setBounds(60,100,100,40);
		phoneLabel.setBounds(60,150,100,40);
		emailLabel.setBounds(60,200,100,40);
		idLabel.setBounds(60,270,100,40);
		
		//텍스트필드 위치 지정
		nameTxt.setBounds(155,55,160,30);
		birthTxt.setBounds(155,105,160,30);
		phoneTxt.setBounds(155,155,160,30);
		emailTxt.setBounds(155,205,160,30);
		idTxt.setBounds(155,275,160,30);
		
		//버튼 위치 지정
		findIdBtn.setBounds(90,330,200,50);
		findPwBtn.setBounds(90,370,200,50);
		
		
		//판넬에 올림
		add(panel);
		panel.add(idLabel);
		panel.add(nameLabel);
		panel.add(birthLabel);
		panel.add(phoneLabel);
		panel.add(emailLabel);
		
		panel.add(idTxt);
		panel.add(nameTxt);
		panel.add(birthTxt);
		panel.add(phoneTxt);
		panel.add(emailTxt);
		
		panel.add(findIdBtn);
		panel.add(findPwBtn);
		
		// 프레임 설정
		setVisible(true);
		setTitle("아이디/비밀번호 찾기");
		setSize(400,500);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료
		
		
	
		
		
	}

	
	public static void main(String[] args) {
		new FindIdPw();

	}

}
