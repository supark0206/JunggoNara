package com.java.junggo;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

public class FindIdPw extends JFrame{

	public JTextField idTxt, nameTxt, birthTxt, phoneTxt, emailTxt;
	public JLabel nameLabel,idLabel,birthLabel,phoneLabel,eamilLabel;
	public JButton findIdBtn;
	public JButton findPwBtn;
	
public FindIdPw(){
		
		
		Container con;
		con = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		
		//버튼
		
		//아이디 찾기
		findIdBtn = new JButton("아이디찾기");  
		findIdBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDto dto = new MemberDto();
				MemberDao dao = new MemberDao();
				
				
		
				
				

				if(dto.getM_id() != null) {
					dto=dao.findId(nameTxt.getText(),birthTxt.getText(),phoneTxt.getText(),emailTxt.getText());
					JOptionPane.showMessageDialog(null, "아이디는( "+dto.getM_id()+" )입니다.", "아이디 찾기", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "가입된 정보가 없습니다", "아이디 찾기", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		//비밀번호 찾기
		findPwBtn = new JButton("비밀번호찾기");
		findPwBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDto dto = new MemberDto();
				MemberDao dao = new MemberDao();
				
				
	
				
				
				if(dto.getM_pw() != null) {
					dto=dao.findPw(nameTxt.getText(),birthTxt.getText(),phoneTxt.getText(),emailTxt.getText(),idTxt.getText());
					JOptionPane.showMessageDialog(null, "비밀번호는( "+dto.getM_pw()+" )입니다.", "비밀번호 찾기", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "가입된 정보가 없습니다", "비밀번호 찾기", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		//텍스트필드
		 nameTxt = new JTextField();
		 birthTxt = new JTextField();
		 phoneTxt = new JTextField();
		 emailTxt = new JTextField(); 
		 idTxt = new JTextField();
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,17);
		
		//레이블
		JLabel nameLabel = new JLabel("이름"); 
		JLabel birthLabel = new JLabel("생년월일"); 
		JLabel phoneLabel = new JLabel("핸드폰번호"); 
		JLabel emailLabel = new JLabel("이메일");
		JLabel idLabel = new JLabel("아이디"); 

		//라디오 버튼
		ButtonGroup rdGroup = new ButtonGroup();
		
		JRadioButton findId = new JRadioButton("아아디찾기",true);
		JRadioButton findPw = new JRadioButton("비밀번호찾기");
		
		findId.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					idLabel.setVisible(false);
					idTxt.setVisible(false);
					findIdBtn.setVisible(true);
					findPwBtn.setVisible(false);
				}
				
			}
		});
		
		findPw.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					idLabel.setVisible(true);
					idTxt.setVisible(true);
					findPwBtn.setVisible(true);
					findIdBtn.setVisible(false);
				}
				
			}
		});

		
		
		rdGroup.add(findId);
		rdGroup.add(findPw);
		
		panel.add(findId);
		panel.add(findPw);
		
		findId.setBounds(90,10,100,40);
		findPw.setBounds(190,10,120,40);

			
		//버튼생성

		
		
		
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
		idLabel.setBounds(60,250,100,40);
		
		//텍스트필드 위치 지정
		nameTxt.setBounds(155,55,160,30);
		birthTxt.setBounds(155,105,160,30);
		phoneTxt.setBounds(155,155,160,30);
		emailTxt.setBounds(155,205,160,30);
		idTxt.setBounds(155,255,160,30);
		
		//버튼 위치 지정
		findIdBtn.setBounds(90,330,200,40);
		findPwBtn.setBounds(90,330,200,40);
		
		
		idLabel.setVisible(false);
		idTxt.setVisible(false);
		findIdBtn.setVisible(true);
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
		
		

		
	}


	public static void main(String[] args) {
		new FindIdPw();

	}

}
