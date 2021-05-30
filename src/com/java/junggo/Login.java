package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.dao.LoginDao;
import com.java.dao.ProductDao;
import com.java.dto.ProductDto;



public class Login extends JFrame{
	public JLabel idLabel , pwLabel;
	public JTextField idTxt;
	public Font font2;

	
	public Login() {
		
		
		Container con;
		con = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);

		add(panel);
		
		
		
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,17);
		font2 = new Font("맑은 고딕",Font.PLAIN,20);
		//레이블
		idLabel = new JLabel("ID");    //아이디 레이블	
		idLabel.setFont(font);
		idLabel.setBounds(120,100,40,40);
		panel.add(idLabel);
		
		pwLabel = new JLabel("Password"); // 패스워드 레이블
		pwLabel.setFont(font);	
		pwLabel.setBounds(60,150,100,40);
		panel.add(pwLabel);
		
	
		
		
		//텍스트필드
		idTxt = new JTextField(); 
		idTxt.setBounds(155,105,160,30);
		panel.add(idTxt);
		
		JPasswordField pwTxt = new JPasswordField();  
		pwTxt.setBounds(155,155,160,30);
		panel.add(pwTxt);
		


		//버튼생성
		JButton logBtn = new JButton("로그인");
		logBtn.setBounds(100,200,200,40);
		panel.add(logBtn);
		logBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDao dao = new LoginDao();
				String id = idTxt.getText();
				String pw = pwTxt.getText();
				int result = dao.login(id, pw);
				
				if(1==result) {
					JOptionPane.showMessageDialog(null, "로그인 성공.", "로그인", JOptionPane.INFORMATION_MESSAGE);
					//로그인시 아이디값 넘겨줌
					junggoMain m = new junggoMain();
					m.userIdLabel.setText(idTxt.getText());
					m.pdSearch(m, "","","",""); // 상품 출력 메소드

					//로그인 창 닫기
					dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "로그인 실패.", "로그인", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton signUpBtn = new JButton("회원가입");
		signUpBtn.setBounds(100,270,200,30);
		panel.add(signUpBtn);
		signUpBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SignUp(); //회원가입으로 이동

				
			}
		});
		
		JButton findBtn = new JButton("아이디/비밀번호찾기");
		findBtn.setBounds(100,310,200,30);
		panel.add(findBtn);
		findBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FindIdPw();
				
			}
		});
	

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
