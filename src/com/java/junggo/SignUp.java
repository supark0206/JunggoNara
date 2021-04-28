package com.java.junggo;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame{
	
	public SignUp() {

		Container con;
		con = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		//폰드
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Font font1 = new Font("맑은 고딕",Font.BOLD,12);
		//레이블
		JLabel idLabel = new JLabel("아이디");   
		JLabel pwLabel = new JLabel("비밀번호"); 
		JLabel pwChkLabel = new JLabel("비밀번호 확인"); 
		JLabel nameLabel = new JLabel("이름"); 
		JLabel birthLabel = new JLabel("생년월일"); 
		JLabel phoneLabel = new JLabel("핸드폰번호"); 
		JLabel emailLabel = new JLabel("이메일");

		
		
		//텍스트필드
		JTextField idTxt = new JTextField(15); //아이디입력 컴포넌트 텍스트필드 15자제한
		JPasswordField pwTxt = new JPasswordField(15);
		JPasswordField pwChkTxt = new JPasswordField(15);  
		JTextField nameTxt = new JTextField(15);
		JTextField birthTxt = new JTextField(15);
		JTextField phoneTxt = new JTextField(15);
		JTextField emailTxt = new JTextField(15);
			
		//버튼생성
		JButton signUpBtn = new JButton("회원가입");
		JButton overlapBtn = new JButton("중복 확인");
		
		

		//레이블 폰트적용
		idLabel.setFont(font);
		pwLabel.setFont(font);
		pwChkLabel.setFont(font);
		nameLabel.setFont(font);
		birthLabel.setFont(font);
		phoneLabel.setFont(font);
		emailLabel.setFont(font);
		overlapBtn.setFont(font1);
		
		//레이블 위치 지정
		idLabel.setBounds(60,50,100,40);
		pwLabel.setBounds(60,100,100,40);
		pwChkLabel.setBounds(60,150,100,40);
		nameLabel.setBounds(60,200,100,40);
		birthLabel.setBounds(60,250,100,40);
		phoneLabel.setBounds(60,300,100,40);
		emailLabel.setBounds(60,350,100,40);
		
		//텍스트필드 위치 지정
		idTxt.setBounds(155,55,160,30);
		pwTxt.setBounds(155,105,160,30);
		pwChkTxt.setBounds(155,155,160,30);
		nameTxt.setBounds(155,205,160,30);
		birthTxt.setBounds(155,255,160,30);
		phoneTxt.setBounds(155,305,160,30);
		emailTxt.setBounds(155,355,160,30);
		
		//버튼 위치 지정
		overlapBtn.setBounds(320,55,100,30);
		signUpBtn.setBounds(90,420,200,50);

		
		//판넬에 올림
		add(panel);
		panel.add(idLabel);
		panel.add(pwLabel);
		panel.add(pwChkLabel);
		panel.add(nameLabel);
		panel.add(birthLabel);
		panel.add(phoneLabel);
		panel.add(emailLabel);
		
		panel.add(idTxt);
		panel.add(pwTxt);
		panel.add(pwChkTxt);
		panel.add(nameTxt);
		panel.add(birthTxt);
		panel.add(phoneTxt);
		panel.add(emailTxt);
		
		panel.add(signUpBtn);
		panel.add(overlapBtn);
		
		

		
		// 프레임 설정
		setVisible(true);
		setTitle("회원가입");
		setSize(450,550);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료
		
		
	
	}

	public static void main(String[] args) {
		new SignUp();

	}

}
