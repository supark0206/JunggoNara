package com.java.junggo;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.dao.SignUpDao;

public class SignUp extends JFrame{
	
	public SignUp() {

		Container con;
		con = getContentPane();
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);
		
		

		
		SignUpDao dao = new SignUpDao();
		
		
		
		//폰드
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Font font1 = new Font("맑은 고딕",Font.BOLD,12);
		//레이블
		JLabel idLabel = new JLabel("아이디");   
		idLabel.setFont(font);
		idLabel.setBounds(50,50,100,40);
		panel.add(idLabel);
		

		JLabel pwLabel = new JLabel("비밀번호"); 
		pwLabel.setFont(font);
		pwLabel.setBounds(50,100,100,40);
		panel.add(pwLabel);

		JLabel pwChkLabel = new JLabel("비밀번호 확인");
		pwChkLabel.setFont(font);
		pwChkLabel.setBounds(50,150,100,40);
		panel.add(pwChkLabel);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(font);
		nameLabel.setBounds(50,200,100,40);
		panel.add(nameLabel);

		JLabel birthLabel = new JLabel("주민번호앞자리"); 
		birthLabel.setFont(font);
		birthLabel.setBounds(50,250,120,40);
		panel.add(birthLabel);

		JLabel phoneLabel = new JLabel("핸드폰번호"); 
		phoneLabel.setFont(font);
		phoneLabel.setBounds(50,300,100,40);
		panel.add(phoneLabel);

		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setFont(font);
		emailLabel.setBounds(50,350,100,40);
		panel.add(emailLabel);
		
		//텍스트필드
		JTextField idTxt = new JTextField(); 
		idTxt.setBounds(155,55,160,30);
		idTxt.setEnabled(false);
		panel.add(idTxt);
		
		JPasswordField pwTxt = new JPasswordField();
		pwTxt.setBounds(155,105,160,30);
		panel.add(pwTxt);
		
		JPasswordField pwChkTxt = new JPasswordField(); 
		pwChkTxt.setBounds(155,155,160,30);
		panel.add(pwChkTxt);
		
		JTextField nameTxt = new JTextField();
		nameTxt.setBounds(155,205,160,30);
		panel.add(nameTxt);

		JTextField birthTxt = new JTextField();
		birthTxt.setBounds(155,255,160,30);
		panel.add(birthTxt);
		
	
		JTextField phoneTxt = new JTextField();
		phoneTxt.setBounds(155,305,160,30);
		phoneTxt.setEnabled(false);
		panel.add(phoneTxt);


		JTextField emailTxt = new JTextField();
		emailTxt.setBounds(155,355,160,30);
		panel.add(emailTxt);

		
		
		//버튼생성
		JButton signUpBtn = new JButton("회원가입");
		signUpBtn.setBounds(90,420,200,50);
		panel.add(signUpBtn);
		signUpBtn.addActionListener(new ActionListener() {
			//텍스트 필드 내부 값
	
			@Override
			public void actionPerformed(ActionEvent e) {
				//텍스트 필드 비었는지 확인
				if(idTxt.getText().length()==0 || 
						pwTxt.getText().length()==0 ||
						pwChkTxt.getText().length()==0 ||
						nameTxt.getText().length()==0 ||
						birthTxt.getText().length()==0 ||
						phoneTxt.getText().length()==0 ||
						emailTxt.getText().length()==0) 
				{
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				
				}
				
	
				else {// 모든 정보가 입력되었을 때
				
					if(regularPw(pwTxt.getText())==false) {
						JOptionPane.showMessageDialog(null, "영문자,숫자로 구성된 8~16자 비밀번호를 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
					}
					else if(regularPwChk(pwTxt.getText(),pwChkTxt.getText())==false) {
						JOptionPane.showMessageDialog(null, "첫번째 작성한 비밀번호와 비밀번호 확인을 같게 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
					}
					else if(regularName(nameTxt.getText())==false) {
						JOptionPane.showMessageDialog(null, "정확한 이름을 입력해주세요(한글만가능).", "입력 오류", JOptionPane.ERROR_MESSAGE);
					}
					
					else if(regularBirth(birthTxt.getText())==false) {
						JOptionPane.showMessageDialog(null, "6자리 주민등록번호 앞자리를 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
					}
				
					else if(regularEmail(emailTxt.getText())==false) {
						JOptionPane.showMessageDialog(null, "@를포함한 정확한 이메일을 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
					}
					else {
				
						int insertChk = JOptionPane.showConfirmDialog(null,"입력하신 정보로 가입하시겠습니까?","회원가입",JOptionPane.YES_NO_OPTION);
						//회원가입
						
						if(insertChk == JOptionPane.YES_OPTION) {
							
							
							dao.mInsert(idTxt.getText(), pwTxt.getText(), nameTxt.getText(), birthTxt.getText(), phoneTxt.getText(), emailTxt.getText());
							dispose();
						}				
				    }
				}
					
			}
		});
		
		
		JButton idOverlapBtn = new JButton("중복 확인");
		idOverlapBtn.setFont(font1);
		idOverlapBtn.setBounds(320,55,100,30);
		panel.add(idOverlapBtn);
		idOverlapBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				
				String chkId =JOptionPane.showInputDialog("아이디를 입력하세요");

				if(chkId!=null) {
				
					int result = dao.idCheck(chkId);
					
					
					if(regularID(chkId)==false){
						JOptionPane.showMessageDialog(null, "6~15자리 영문자,숫자만 입력하세요.", "중복검사", JOptionPane.ERROR_MESSAGE);
					}
				
					else if(0 == result) {
						JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.", "중복검사", JOptionPane.ERROR_MESSAGE);
					}
					
					else if(1 == result) {
						idTxt.setText(chkId);
					}
				}
			}
		});
		
		JButton phOverlapBtn = new JButton("중복 확인");
		phOverlapBtn.setFont(font1);
		phOverlapBtn.setBounds(320,305,100,30);
		panel.add(phOverlapBtn);
		phOverlapBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String chkPhone = (String) JOptionPane.showInputDialog("핸드폰번호를 입력하세요");
				

				if(chkPhone!=null) {
					int result = dao.phoneCheck(chkPhone);
					
					if(regularPhone(chkPhone)==false) {
						JOptionPane.showMessageDialog(null, "핸드폰 번호를 재입력해주세요.", "중복검사", JOptionPane.ERROR_MESSAGE);
					}
					else if(0 == result) {
						JOptionPane.showMessageDialog(null, "사용중인 핸드폰번호입니다.", "중복검사", JOptionPane.ERROR_MESSAGE);
					}else if(1 == result) {
						phoneTxt.setText(chkPhone);
					}
				}
			}
		});
		
	
		
		
		

		
		// 프레임 설정
		setVisible(true);
		setTitle("회원가입");
		setSize(450,550);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
	
		
		
		
		
	
	}
	//핸드폰 검사 메소드
	public static boolean regularPhone(String phone) {
		if (Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", phone)) {
			return true;

		} else {
			return false;
		}
	}
	
	//아이디 검사 메소드
	  public static boolean regularID(String id) {
			if (Pattern.matches("^[a-z]+[a-z0-9]{5,16}$", id)) {
				return true;

			} else {
				return false;
			}
		}
	//이름 검사 메소드
		public static boolean regularName(String name) {
			if (Pattern.matches("^[가-힣]{2,5}$", name)) {
				return true;

			} else {
				return false;
			}
		}
	//주민번호 앞자리 검사 메소드
		public static boolean regularBirth(String birth) {
			if(Pattern.matches("\\d{2}([0]\\d|[1][0-2])([0][1-9]|[1-2]\\d|[3][0-1])", birth)) {
				return true;
			}else {
				return false;
			}
		}

	//이메일 검사 메소드
		public static boolean regularEmail(String eamil) {
			if(Pattern.matches("[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]$", eamil)) {
				return true;
				
			}else {
				return false;
			}
		}
	//비밀번호 재입력 확인 메소드
		public static boolean regularPwChk(String pw1,String pw2) {
			if(pw1.equals(pw2)) {
				return true;
			}else {
				return false;
			}
		}
	//비밀번호 검사 메소드
		public static boolean regularPw(String pw) {
			if(Pattern.matches("^[a-z]+[a-z0-9]{7,17}$", pw)) {
				return true;
			}else {
				return false;
			}
		}
	public static void main(String[] args) {
		new SignUp();

	}

}
