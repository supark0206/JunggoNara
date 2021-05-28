package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.java.dao.MemberDao;
import com.java.dao.ProductDao;
import com.java.dto.MemberDto;
import com.java.dto.ProductDto;

public class junggoMain extends JFrame{
	
	public JLabel userIdLabel;
	public JPanel scrollPanel;
	public JScrollPane mainScroll;
	public JButton test1;
	JPanel panel;
	public Font font2;

	public JComboBox<String> pdSortCbox;
	public JTextField searchTxt;
	
	
	public junggoMain() {
		Container con;
		con = getContentPane();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		//폰트
		font2 = new Font("맑은 고딕",Font.PLAIN,20);
		//스크롤팬

		scrollPanel = new JPanel();
		scrollPanel.setBackground(Color.LIGHT_GRAY);
		scrollPanel.setLayout(new GridBagLayout());  //스크롤팬 내부 panel

		mainScroll = new JScrollPane(scrollPanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		mainScroll.setBounds(45, 100, 1000, 430);
		panel.add(mainScroll);
		
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,15);

		
		//레이블
		userIdLabel = new JLabel("사용자아이디");   
		panel.add(userIdLabel);
		
		
		//텍스트필드
		searchTxt = new JTextField();
		searchTxt.setBounds(350,38, 300, 35);
		panel.add(searchTxt);
		
		
		
		//버튼
		JButton logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(130, 38, 95, 35);
		panel.add(logoutBtn);
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				dispose();
				
			}
		});
		
		JButton myshopBtn = new JButton("마이샵");
		myshopBtn.setBounds(950, 38, 95, 35);
		panel.add(myshopBtn);
		myshopBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		JButton chatBtn = new JButton("내채팅");
		chatBtn.setBounds(850, 38, 95, 35);
		panel.add(chatBtn);
		
		JButton addBtn = new JButton("상품등록");
		addBtn.setBounds(750, 38, 95, 35);
		panel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProductUpload pdUP = new ProductUpload();
				pdUP.idLabel.setText(userIdLabel.getText());;
				dispose();
				
			}
		});
		
		
		
		
		JButton searchBtn = new JButton("검색");
		searchBtn.setBounds(650, 38, 95, 35);
		panel.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				junggoMain m = new junggoMain();
				pdSearch(m, searchTxt.getText(),pdSortCbox.getSelectedItem().toString());
				System.out.println("분류 : "+pdSortCbox.getSelectedItem().toString()+"/검색내용 :"+searchTxt.getText());

			}
		});
		
		
		//콤보박스
		String[] pdSortName= {"의류","전자제품","가전제품","생활용품","운동화"};
		pdSortCbox = new JComboBox<>(pdSortName);
		pdSortCbox.setBounds(255, 38,90 ,35);
		panel.add(pdSortCbox);
		
		

		//레이블 폰트적용
		userIdLabel.setFont(font);
	
		//레이블 위치 지정
		userIdLabel.setBounds(30, 30, 200, 50);
	
		
		


		//판넬에 올림
		con.add(panel);


	
		

		
		// 프레임 설정
		setVisible(true);
		setTitle("중고나라");
		setSize(1100,600);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료
		
		
	
	}
	public void pdSearch(junggoMain m,String name,String sort) {

		System.out.println("메소드내의 이름:"+name+ "/분류:"+sort);
		// 로그인 하고나면 상품 목록을 보여준다.
		ProductDao pdDao = new ProductDao();
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		dtos = pdDao.pdSearch(name, sort);
		// dtos 만큼 배열생성
		//버튼
		JButton[] imgBtns = new JButton[dtos.size()];  
		//이미지
		ImageIcon[] imgicon = new ImageIcon[dtos.size()];
		ImageIcon[] imgiconUse = new ImageIcon[dtos.size()];
		Image[] imgChgSize = new Image[dtos.size()];
		Image[] imgUse = new Image[dtos.size()];
		//레이블
		JLabel[] pdNameLbl = new JLabel[dtos.size()];
		JLabel[] pdPriceLbl = new JLabel[dtos.size()];
		//버튼 간격
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 50, 10, 50);   //(top,left,bottom,right)
		 
		 
		for(int i = 0; i<dtos.size(); i++) {
			 gbc.gridx = i;
			
			 //이미지 크기 재설정.
			 imgicon[i] = new ImageIcon(dtos.get(i).getP_image1());
			 imgChgSize[i] = imgicon[i].getImage();
			 imgUse[i] = imgChgSize[i].getScaledInstance(250, 250,Image.SCALE_SMOOTH);
			 imgiconUse[i] = new ImageIcon(imgUse[i]);
			 
			 System.out.println("상품명 : " + dtos.get(i).getP_name());
			 System.out.println("======================================");
			 
			 //상품 이름 라벨 출력
			 pdNameLbl[i] = new JLabel( "상품명 : "+dtos.get(i).getP_name());
			 pdNameLbl[i].setOpaque(true);
			 pdNameLbl[i].setBackground(Color.WHITE);
			 pdNameLbl[i].setHorizontalAlignment(JLabel.CENTER);
			 pdNameLbl[i].setFont(font2);
			 pdNameLbl[i].setPreferredSize(new Dimension(250, 40));
			 m.scrollPanel.add(pdNameLbl[i],gbc);
			 
			 //상품 이미지 버튼 출력
			 imgBtns[i]=new JButton();
			 imgBtns[i].setPreferredSize(new Dimension(250, 250));
			 imgBtns[i].setIcon(imgiconUse[i]);
			 m.scrollPanel.add(imgBtns[i],gbc);

			 //상품 가격 라벨 출력
			 pdPriceLbl[i] = new JLabel( "상품가격 : "+Integer.toString(dtos.get(i).getP_price()));
			 pdPriceLbl[i].setOpaque(true);
			 pdPriceLbl[i].setBackground(Color.WHITE);
			 pdPriceLbl[i].setHorizontalAlignment(JLabel.CENTER);
			 pdPriceLbl[i].setFont(font2);
			 pdPriceLbl[i].setPreferredSize(new Dimension(250, 40));
			 m.scrollPanel.add(pdPriceLbl[i],gbc);
			
		}
	}
	
	
	// 상품 목록 출력 메소드
	public void pdView(junggoMain m) {

		// 로그인 하고나면 상품 목록을 보여준다.
		ProductDao pdDao = new ProductDao();
		ArrayList<ProductDto> dtos = new ArrayList<ProductDto>();
		
		dtos = pdDao.pdSelect();
		// dtos 만큼 배열생성
		//버튼
		JButton[] imgBtns = new JButton[dtos.size()];  
		//이미지
		ImageIcon[] imgicon = new ImageIcon[dtos.size()];
		ImageIcon[] imgiconUse = new ImageIcon[dtos.size()];
		Image[] imgChgSize = new Image[dtos.size()];
		Image[] imgUse = new Image[dtos.size()];
		//레이블
		JLabel[] pdNameLbl = new JLabel[dtos.size()];
		JLabel[] pdPriceLbl = new JLabel[dtos.size()];
		//버튼 간격
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 50, 10, 50);   //(top,left,bottom,right)
		 
		 
		for(int i = 0; i<dtos.size(); i++) {
			 gbc.gridx = i;
			
			 //이미지 크기 재설정.
			 imgicon[i] = new ImageIcon(dtos.get(i).getP_image1());
			 imgChgSize[i] = imgicon[i].getImage();
			 imgUse[i] = imgChgSize[i].getScaledInstance(250, 250,Image.SCALE_SMOOTH);
			 imgiconUse[i] = new ImageIcon(imgUse[i]);
			 
			 System.out.println("상품명 : " + dtos.get(i).getP_name());
			 System.out.println("======================================");
			 
			 //상품 이름 라벨 출력
			 pdNameLbl[i] = new JLabel( "상품명 : "+dtos.get(i).getP_name());
			 pdNameLbl[i].setOpaque(true);
			 pdNameLbl[i].setBackground(Color.WHITE);
			 pdNameLbl[i].setHorizontalAlignment(JLabel.CENTER);
			 pdNameLbl[i].setFont(font2);
			 pdNameLbl[i].setPreferredSize(new Dimension(250, 40));
			 m.scrollPanel.add(pdNameLbl[i],gbc);
			 
			 //상품 이미지 버튼 출력
			 imgBtns[i]=new JButton();
			 imgBtns[i].setPreferredSize(new Dimension(250, 250));
			 imgBtns[i].setIcon(imgiconUse[i]);
			 m.scrollPanel.add(imgBtns[i],gbc);

			 //상품 가격 라벨 출력
			 pdPriceLbl[i] = new JLabel( "상품가격 : "+Integer.toString(dtos.get(i).getP_price()));
			 pdPriceLbl[i].setOpaque(true);
			 pdPriceLbl[i].setBackground(Color.WHITE);
			 pdPriceLbl[i].setHorizontalAlignment(JLabel.CENTER);
			 pdPriceLbl[i].setFont(font2);
			 pdPriceLbl[i].setPreferredSize(new Dimension(250, 40));
			 m.scrollPanel.add(pdPriceLbl[i],gbc);
			
		}
	}
		
	

	public static void main(String[] args) {
	
		new junggoMain();

	}

}
