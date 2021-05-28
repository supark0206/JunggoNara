package com.java.junggo;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

public class PwChg extends JFrame {
	public String idvalue;

	public PwChg() {

		Container con;
		con = getContentPane();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		add(panel);

		// 폰드
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		Font font1 = new Font("맑은 고딕", Font.BOLD, 12);

		// 레이블
		JLabel pwLabel = new JLabel("변경 전 비밀번호");
		pwLabel.setFont(font);
		pwLabel.setBounds(50, 50, 140, 40);
		panel.add(pwLabel);

		JLabel pwchgLabel = new JLabel("변경 비밀번호");
		pwchgLabel.setFont(font);
		pwchgLabel.setBounds(50, 150, 100, 40);
		panel.add(pwchgLabel);

		JLabel pwChkLabel = new JLabel("비밀번호 확인");
		pwChkLabel.setFont(font);
		pwChkLabel.setBounds(50, 200, 100, 40);
		panel.add(pwChkLabel);

		// 텍스트필드
		JPasswordField pwTxt = new JPasswordField();
		pwTxt.setBounds(175, 55, 160, 30);
		panel.add(pwTxt);

		JPasswordField pwchgTxt = new JPasswordField();
		pwchgTxt.setBounds(175, 155, 160, 30);
		panel.add(pwchgTxt);

		JPasswordField pwChkTxt = new JPasswordField();
		pwChkTxt.setBounds(175, 205, 160, 30);
		panel.add(pwChkTxt);

		// 버튼생성
		JButton pwChgBtn = new JButton("비밀번호 변경");
		pwChgBtn.setBounds(90, 270, 200, 50);
		panel.add(pwChgBtn);
		pwChgBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDao dao = new MemberDao();
				MemberDto dto = new MemberDto();

				dto = dao.memInfo(idvalue);

				String pw = pwTxt.getText();

				String pwchg = pwchgTxt.getText();
				String pwchk = pwChkTxt.getText();

				if (pw.equals(dto.getM_pw())) {

					if (pwchg.equals(pwchk)) {

						if (regularPw(pwchg) == false) {

							JOptionPane.showMessageDialog(null, "영문자,숫자로 구성된 8~16자 비밀번호를 입력해주세요.", "입력 오류",
									JOptionPane.ERROR_MESSAGE);

						} else {
							int insertChk = JOptionPane.showConfirmDialog(null, "입력하신 정보로 변경하시겠습니까?", "비밀번호 변경",
									JOptionPane.YES_NO_OPTION);
				

							if (insertChk == JOptionPane.YES_OPTION) {

								if (1 == dao.chgPw(pwchg, idvalue)) {
									new MyShop();
									dispose();
								} else {
									JOptionPane.showMessageDialog(null, "접속 오류.", "비밀번호 변경", JOptionPane.ERROR_MESSAGE);
								}

							
							}

						}
					} else {
						JOptionPane.showMessageDialog(null, "변경 비밀번호 확인 오류.", "비밀번호 변경", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "기존 비밀번호 입력 오류.", "비밀번호 변경", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		// 프레임 설정
		setVisible(true);
		setTitle("비밀번호 변경");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.

	}

	// 비밀번호 검사 메소드
	public static boolean regularPw(String pwpattern) {
		if (Pattern.matches("^[a-z]+[a-z0-9]{7,17}$", pwpattern)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		new PwChg();

	}
}
