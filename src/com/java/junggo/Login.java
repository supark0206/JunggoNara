package com.java.junggo;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{

	public Login() {
		
		
		Container con;
		con = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		//폰드
		Font font = new Font("맑은 고딕",Font.BOLD,17);
		
		//레이블
		JLabel idLabel = new JLabel("ID");    //아이디 레이블	
		JLabel pwLabel = new JLabel("Password"); // 패스워드 레이블

		//레이블 폰트적용
		idLabel.setFont(font);
		pwLabel.setFont(font);
		
		
		//텍스트필드
		JTextField idTxt = new JTextField(15); //아이디입력 컴포넌트 텍스트필드 15자제한
		JPasswordField pwTxt = new JPasswordField(15);  
			
		//버튼생성
		JButton logBtn = new JButton("로그인");
		JButton signUpBtn = new JButton("회원가입");
		JButton findBtn = new JButton("아이디/비밀번호찾기");
		
		//위치 지정
		idLabel.setBounds(120,100,40,40);
		pwLabel.setBounds(60,150,100,40);
		idTxt.setBounds(155,105,160,30);
		pwTxt.setBounds(155,155,160,30);
		
		logBtn.setBounds(100,200,200,40);
		signUpBtn.setBounds(100,270,200,30);
		findBtn.setBounds(100,310,200,30);
		
		//판넬에 올림
		add(panel);
		panel.add(idLabel);
		panel.add(idTxt);
		panel.add(pwLabel);
		panel.add(pwTxt);
		panel.add(logBtn);
		panel.add(signUpBtn);
		panel.add(findBtn);
		
		// 프레임 설정
		setVisible(true);
		setTitle("로그인");
		setSize(400,500);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료
		
		
	
		
		
	}
	
	
	
	public static void main(String[] args) {
		new Login();

	}

}
