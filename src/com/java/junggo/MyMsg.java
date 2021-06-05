package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.java.dao.MsgDao;
import com.java.dto.MessageDto;

public class MyMsg extends JFrame {
	JScrollPane mainScroll;
	public JPanel scrollPanel;
	JPanel panel;
	Font font2;
	JButton readBtn , unreadBtn, msgBtn ;
	public JLabel user;
	
	public JButton[] msgBtns;
	public MyMsg() {
		Container con;
		con = getContentPane();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		//
		user = new JLabel("아이딩");
		panel.add(user);
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,12);
		font2 = new Font("맑은 고딕",Font.PLAIN,20);
		//스크롤팬
		scrollPanel = new JPanel();
		scrollPanel.setBackground(Color.LIGHT_GRAY);
		scrollPanel.setLayout(new GridBagLayout());  //스크롤팬 내부 pane
		mainScroll = new JScrollPane(scrollPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainScroll.setBounds(40, 70, 400, 650);
		panel.add(mainScroll);
		

		//버튼
		msgBtn = new JButton("전체쪽지");
		msgBtn.setBounds(40, 30, 100, 30);
		msgBtn.setFont(font);
		panel.add(msgBtn);
		msgBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userid = user.getText();
				MyMsg mmg = new MyMsg();
				mmg.user.setText(userid);
				Msg(mmg, user.getText(), "");
				dispose();
			}
		});
		
		readBtn = new JButton("읽은쪽지");
		readBtn.setBounds(240, 30, 100, 30);
		readBtn.setFont(font);
		panel.add(readBtn);
		
		
		readBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				String userid = user.getText();
				MyMsg mmg = new MyMsg();
				mmg.user.setText(userid);
				Msg(mmg, user.getText(), "0");
				dispose();
				
				
			}
		});
		
		unreadBtn = new JButton("안읽은쪽지");
		unreadBtn.setBounds(140, 30, 100, 30);
		unreadBtn.setFont(font);
		panel.add(unreadBtn);
		unreadBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				String userid = user.getText();
				MyMsg mmg = new MyMsg();
				mmg.user.setText(userid);
				Msg(mmg, user.getText(), "1");
				dispose();

			}
		});

		//판넬에 올림
		con.add(panel);

		// 프레임 설정
		setVisible(true);
		setTitle("쪽지함");
		setSize(500,800);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
	
	
	}
	

	//쪽지함 메소드
		public void Msg(MyMsg mmg,String id,String check) {

			Font msgfont = new Font("맑은 고딕",Font.PLAIN,12);
			// 쪽지함 목록
			MsgDao msgDao = new MsgDao();
			ArrayList<MessageDto> mdtos = new ArrayList<MessageDto>();
			mdtos = msgDao.SelectMsg(id,check);
			// dtos 만큼 배열생성
			//버튼
			msgBtns = new JButton[mdtos.size()];  

			//레이블
			JLabel[] msgTitleLbl = new JLabel[mdtos.size()];

			JLabel[] msgsendLbl = new JLabel[mdtos.size()];
			//버튼 간격
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.insets = new Insets(10, 10, 10, 10);   //(top,left,bottom,right)
			
			int[] num = new int[mdtos.size()];
			 
			for(int i = 0; i<mdtos.size(); i++) {
				 gbc.gridy = i;
				 //상품 가격 라벨 출력
				 msgsendLbl[i] = new JLabel( "발신자:"+mdtos.get(i).getSend_id());
				 msgsendLbl[i].setOpaque(true);
				 msgsendLbl[i].setBackground(Color.WHITE);
				 msgsendLbl[i].setHorizontalAlignment(JLabel.CENTER);
				 msgsendLbl[i].setFont(msgfont);
				 msgsendLbl[i].setPreferredSize(new Dimension(100, 40));
				 mmg.scrollPanel.add(msgsendLbl[i],gbc);
				 //상품 이름 라벨 출력
				 msgTitleLbl[i] = new JLabel( "제목:"+mdtos.get(i).getMsg_title());
				 msgTitleLbl[i].setOpaque(true);
				 msgTitleLbl[i].setBackground(Color.WHITE);
				 msgTitleLbl[i].setHorizontalAlignment(JLabel.CENTER);
				 msgTitleLbl[i].setFont(msgfont);
				 msgTitleLbl[i].setPreferredSize(new Dimension(100, 40));
				 mmg.scrollPanel.add(msgTitleLbl[i],gbc);
				 
				 if(mdtos.get(i).getMsg_check()==1) {
					 msgTitleLbl[i].setForeground(Color.BLUE);
					 msgsendLbl[i].setForeground(Color.BLUE);
				 }
				 
				 //버튼 이미지 아이콘
				 ImageIcon btnicon = new ImageIcon("images/msgimg.png");
				 Image imgChgSize1 = btnicon.getImage();
				 Image imgUse1 = imgChgSize1.getScaledInstance(70, 40,Image.SCALE_SMOOTH);
				 ImageIcon imgiconUse1 = new ImageIcon(imgUse1);
				 
				 //메세지 버튼
				 num[i] = mdtos.get(i).getMsg_num();
				 msgBtns[i]=new JButton(Integer.toString(num[i]));
				 msgBtns[i].setPreferredSize(new Dimension(70, 40));
				 msgBtns[i].setIcon(imgiconUse1);
				 mmg.scrollPanel.add(msgBtns[i],gbc);
				 msgBtns[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						MsgRead mr = new MsgRead();
						MessageDto msgDto = new MessageDto();
						MsgDao msgDao = new MsgDao();
						
						//버튼 값을 상품 번호로 설정하여 getActionCommand 로 클릭한 버튼값을 가져온다.
						int a =Integer.parseInt(e.getActionCommand());
						//상품 번호를통해 상품 정보 출력

						msgDto = msgDao.msginfo(a);
						
						mr.contentLbl.setText(msgDto.getMsg_content());
						mr.titleLbl.setText(msgDto.getMsg_title());
						mr.reciIdLbl2.setText(msgDto.getReci_id());
						mr.sendIdLbl2.setText(msgDto.getSend_id());
						mr.timeIdLbl.setText(msgDto.getMsg_date());
						msgDao.msgclick(a); //상품 클릭시 클릭횟수 올라감

					}
				});

			
			}
		}
		
	
	
	
	public static void main(String[] args) {
		new MyMsg();

	}

}
