package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.java.dao.MemberDao;
import com.java.dao.ProductDao;
import com.java.dto.MemberDto;
import com.java.dto.ProductDto;

public class MyHopeList extends JFrame {

	
	

	JScrollPane mainScroll;
	public JPanel scrollPanel;
	JPanel panel;
	JLabel userIdLabel;
	JTextField searchTxt;
	JComboBox<String> pdStateCbox;
	ArrayList<ProductDto> dtos;
	ProductDao pdDao;
	ProductDto pdDto;
	JButton[] imgBtns;
	Font font2;
	public MyHopeList() {
		Container con;
		con = getContentPane();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		font2 = new Font("맑은 고딕",Font.PLAIN,20);
		//스크롤팬
		scrollPanel = new JPanel();
		scrollPanel.setBackground(Color.LIGHT_GRAY);
		scrollPanel.setLayout(new GridBagLayout());  //스크롤팬 내부 pane
		mainScroll = new JScrollPane(scrollPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		mainScroll.setBounds(45, 100, 1000, 430);
		panel.add(mainScroll);
		
		//레이블
		userIdLabel = new JLabel("사용자아이디");   
		userIdLabel.setFont(font);
		userIdLabel.setBounds(30, 30, 200, 50);
		panel.add(userIdLabel);
		
		//버튼
		JButton myshopBtn =new JButton("마이샵");
		myshopBtn.setBounds(950, 38, 95, 35);
		panel.add(myshopBtn);
		myshopBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyShop mshop = new MyShop();
				
				mshop.idLabel2.setText(userIdLabel.getText());
				
				MemberDto dto = new MemberDto();
				MemberDao dao = new MemberDao();
				

				dto = dao.memInfo(mshop.idLabel2.getText());
				
				if(dto.getM_id()!=null) {
			
				mshop.nameLabel2.setText(dto.getM_name());
				mshop.phoneLabel2.setText(dto.getM_phone());
				mshop.birthLabel2.setText(dto.getM_birth());
				mshop.emailLabel2.setText(dto.getM_email());
				}
				else {
					JOptionPane.showMessageDialog(null, "정보를 읽어올 수 없습니다.", "오류 메세지", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		
		

		
		

		//판넬에 올림
		con.add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료

		// 프레임 설정
		setVisible(true);
		setTitle("찜목록");
		setSize(1100,600);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
	}
	public static void main(String[] args) {
		new MyHopeList();

	}

}
