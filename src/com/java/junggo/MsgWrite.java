package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.java.dao.MsgDao;

public class MsgWrite extends JFrame{
	
	JPanel panel;
	JLabel sendIdLbl, reciIdLbl,sendIdLbl2, reciIdLbl2;
	JTextField titleTxt;
	JButton sendBtn;
	JTextArea contentArea;
	
	public 	MsgWrite() {
		Container con;
		con = getContentPane();
		
		panel = new JPanel();
		panel.setLayout(null);	
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		
		//레이블
		
		sendIdLbl = new JLabel("작성자:");
		sendIdLbl.setBounds(60, 50, 70, 30);
		sendIdLbl.setOpaque(true);
		sendIdLbl.setFont(font);
		sendIdLbl.setBackground(Color.WHITE);
		panel.add(sendIdLbl);
		
		sendIdLbl2 = new JLabel("작성자아이디");
		sendIdLbl2.setBounds(130, 50, 100, 30);
		sendIdLbl2.setOpaque(true);
		sendIdLbl2.setFont(font);
		sendIdLbl2.setBackground(Color.WHITE);
		panel.add(sendIdLbl2);
		
		
		reciIdLbl = new JLabel("수신자:");
		reciIdLbl.setBounds(60, 370, 70, 30);
		reciIdLbl.setOpaque(true);
		reciIdLbl.setFont(font);
		reciIdLbl.setBackground(Color.WHITE);
		panel.add(reciIdLbl);
		
		reciIdLbl2 = new JLabel("수신자아이디");
		reciIdLbl2.setBounds(130, 370, 100, 30);
		reciIdLbl2.setOpaque(true);
		reciIdLbl2.setFont(font);
		reciIdLbl2.setBackground(Color.WHITE);
		panel.add(reciIdLbl2);
		
		
		//텍스트필드
		titleTxt = new JTextField();
		titleTxt.setBounds(60, 100, 350, 30);
		panel.add(titleTxt);
		//텍스트에리어
		contentArea = new JTextArea();
		contentArea.setBounds(60, 150, 350, 200);
		contentArea.setLineWrap(true); 
		panel.add(contentArea);
		//버튼
		sendBtn = new JButton("전송");
		sendBtn.setBounds(330, 370, 80, 30);
		panel.add(sendBtn);
		sendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(titleTxt.getText().length()==0 || 
						contentArea.getText().length()==0)
					
				{
					JOptionPane.showMessageDialog(null, "메세지를 다시 작성해주세요.", "작성 오류", JOptionPane.ERROR_MESSAGE);
				
				}
				else {
					MsgDao msgDao = new MsgDao();
					msgDao.sendMsg(reciIdLbl2.getText(), sendIdLbl2.getText(), titleTxt.getText(), contentArea.getText(), 1);//1이면 아직안읽음
					JOptionPane.showConfirmDialog(null,"쪽지를 전송했습니다.","쪽지",JOptionPane.YES_NO_OPTION);
					dispose();
				}

				
			}
		});
	
		
		
		//판넬에 올림
		con.add(panel);
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료

		// 프레임 설정
		setVisible(true);
		setTitle("쪽지 쓰기");
		setSize(500,500);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		}
	
	public static void main(String[] args) {
		new MsgWrite();

	}
}
