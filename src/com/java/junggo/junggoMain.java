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
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	JPanel panel;
	Font font2;
	
	public JComboBox<String> pdSortCbox , pdStateCbox;
	public JTextField searchTxt;
	ArrayList<ProductDto> dtos;
	ProductDao pdDao;
	ProductDto pdDto;
	JLabel[] pdNumLbl;

	public JButton[] imgBtns;
	
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
		userIdLabel.setFont(font);
		userIdLabel.setBounds(30, 30, 200, 50);
		
		//텍스트필드
		searchTxt = new JTextField();
		searchTxt.setBounds(420,38, 220, 35);
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
				pdUP.idLabel.setText(userIdLabel.getText());
				dispose();
				
			}
		});
		
		
		
		
		JButton searchBtn = new JButton("검색");
		searchBtn.setBounds(650, 38, 95, 35);
		panel.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				junggoMain m = new junggoMain();
				String id = userIdLabel.getText();
				if(pdStateCbox.getSelectedItem()=="판매중") {
				pdSearch(m, searchTxt.getText(),pdSortCbox.getSelectedItem().toString(),"1","");
				m.userIdLabel.setText(id);
				}else if(pdStateCbox.getSelectedItem()=="판매완료") {
				pdSearch(m, searchTxt.getText(),pdSortCbox.getSelectedItem().toString(),"0","");
				m.userIdLabel.setText(id);
				}else if(pdStateCbox.getSelectedItem()=="전체상품") {
				pdSearch(m, searchTxt.getText(),pdSortCbox.getSelectedItem().toString(),"","");
				m.userIdLabel.setText(id);
				}
				
				System.out.println("상태:"+pdStateCbox.getSelectedItem()+ "분류 : "+pdSortCbox.getSelectedItem().toString()+"/검색내용 :"+searchTxt.getText());
				dispose();
			}
		});
		
		
		//콤보박스
		String[] pdSortName= {"의류","전자제품","가전제품","생활용품","운동화"};
		pdSortCbox = new JComboBox<>(pdSortName);
		pdSortCbox.setBounds(325, 38,90 ,35);
		panel.add(pdSortCbox);
		
		String[] pdStateName= {"전체상품","판매중","판매완료"};
		pdStateCbox = new JComboBox<>(pdStateName);
		pdStateCbox.setBounds(230, 38,90 ,35);
		panel.add(pdStateCbox);

	
	
		
		


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
	
	
	//상품 검색 메소드
	public void pdSearch(junggoMain m,String name,String sort ,String state,String id) {

		System.out.println("메소드내의 이름:"+name+ "/분류:"+sort);
		// 로그인 하고나면 상품 목록을 보여준다.
		pdDao = new ProductDao();
		dtos = new ArrayList<ProductDto>();
		
		dtos = pdDao.pdSearch(name, sort,state,id);
		// dtos 만큼 배열생성
		//버튼
		imgBtns = new JButton[dtos.size()];  
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
		int[] num = new int[dtos.size()];
		 
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
			 //상품 가격 라벨 출력
			 pdPriceLbl[i] = new JLabel( "상품가격 : "+Integer.toString(dtos.get(i).getP_price()));
			 pdPriceLbl[i].setOpaque(true);
			 pdPriceLbl[i].setBackground(Color.WHITE);
			 pdPriceLbl[i].setHorizontalAlignment(JLabel.CENTER);
			 pdPriceLbl[i].setFont(font2);
			 pdPriceLbl[i].setPreferredSize(new Dimension(250, 40));
			 m.scrollPanel.add(pdPriceLbl[i],gbc);
			
			 //상품 이미지 버튼 출력
			 num[i] = dtos.get(i).getP_num();
			 imgBtns[i]=new JButton(Integer.toString(num[i]));
			 imgBtns[i].setPreferredSize(new Dimension(250, 250));
			 imgBtns[i].setIcon(imgiconUse[i]);
			 m.scrollPanel.add(imgBtns[i],gbc);
			 imgBtns[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					ProductInfo p = new ProductInfo();
					pdDao = new ProductDao();
					pdDto = new ProductDto();
					//버튼 값을 상품 번호로 설정하여 getActionCommand 로 클릭한 버튼값을 가져온다.
					int a =Integer.parseInt(e.getActionCommand());
					//상품 번호를통해 상품 정보 출력
					pdDto=pdDao.pdinfo(a);
						//상품상태 출력
					if(pdDto.getP_state()==1) {
						p.pdStateLbl2.setText("판매중");
					}else if(pdDto.getP_state()==0) {
						p.pdStateLbl2.setText("판매완료");
					}
					
					p.mnameLbl2.setText(pdDto.getM_id());
					p.pdNameLbl2.setText(pdDto.getP_name());
					p.pdPricetLbl2.setText(Integer.toString(pdDto.getP_price()));
					p.pdSortLbl2.setText(pdDto.getP_sort());
					p.pdhopeLbl2.setText(Integer.toString(pdDto.getP_hopeNum()));
					p.contentArea.setText(pdDto.getP_content());
					
						//판넬 이미지 출력
					String img1 = pdDto.getP_image1();
					String img2 = pdDto.getP_image2();
						
						//이미지 리사이징
					 ImageIcon imgicon1 = new ImageIcon(img1);
					 Image imgChgSize1 = imgicon1.getImage();
					 Image imgUse1 = imgChgSize1.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
					 ImageIcon imgiconUse1 = new ImageIcon(imgUse1);
					 
					 ImageIcon imgicon2 = new ImageIcon(img2);
					 Image imgChgSize2 = imgicon2.getImage();
					 Image imgUse2 = imgChgSize2.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
					 ImageIcon imgiconUse2 = new ImageIcon(imgUse2);
					 
					 p.imgLabel1.setIcon(imgiconUse1);
					 p.imgLabel2.setIcon(imgiconUse2);
					
					pdDao.pdclick(a); //상품 클릭시 클릭횟수 올라감
					m.dispose();
				}
			});

		
		}
	}
	
	
	// 상품 목록 출력 메소드
	public void pdView(junggoMain m) {

		// 로그인 하고나면 상품 목록을 보여준다.
		pdDao = new ProductDao();
		dtos = new ArrayList<ProductDto>();
		
		dtos = pdDao.pdSelect();
		// dtos 만큼 배열생성
		//버튼
		JButton[] imgBtns = new JButton[dtos.size()];  
		//이미지
		ImageIcon[] imgicon = new ImageIcon[dtos.size()];
		Image[] imgChgSize = new Image[dtos.size()];
		Image[] imgUse = new Image[dtos.size()];
		ImageIcon[] imgiconUse = new ImageIcon[dtos.size()];
		//레이블
		JLabel[] pdNameLbl = new JLabel[dtos.size()];
		JLabel[] pdPriceLbl = new JLabel[dtos.size()];
		pdNumLbl = new JLabel[dtos.size()];
		//버튼 간격
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 50, 10, 50);   //(top,left,bottom,right)

		int[] num = new int[dtos.size()];
		
		
		for(int i=0; i<dtos.size(); i++) {
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
			 
		
			 
			 

			 //상품 가격 라벨 출력
			 pdPriceLbl[i] = new JLabel( "상품가격 : "+Integer.toString(dtos.get(i).getP_price()));
			 pdPriceLbl[i].setOpaque(true);
			 pdPriceLbl[i].setBackground(Color.WHITE);
			 pdPriceLbl[i].setHorizontalAlignment(JLabel.CENTER);
			 pdPriceLbl[i].setFont(font2);
			 pdPriceLbl[i].setPreferredSize(new Dimension(250, 40));
			 m.scrollPanel.add(pdPriceLbl[i],gbc);
			 //상품 이미지 버튼 출력.
			 num[i] = dtos.get(i).getP_num();
			 imgBtns[i]=new JButton(Integer.toString(num[i]));
			 imgBtns[i].setPreferredSize(new Dimension(250, 250));
			 imgBtns[i].setIcon(imgiconUse[i]);
			 m.scrollPanel.add(imgBtns[i],gbc);

			 //상품 상세 페이지 출력.
			imgBtns[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ProductInfo p = new ProductInfo();
					pdDao = new ProductDao();
					pdDto = new ProductDto();
					//버튼 값을 상품 번호로 설정하여 getActionCommand 로 클릭한 버튼값을 가져온다.
					int a =Integer.parseInt(e.getActionCommand());
					//상품 번호를통해 상품 정보 출력
					pdDto=pdDao.pdinfo(a);
						//상품상태 출력
					if(pdDto.getP_state()==1) {
						p.pdStateLbl2.setText("판매중");
					}else if(pdDto.getP_state()==0) {
						p.pdStateLbl2.setText("판매완료");
					}
					
					p.mnameLbl2.setText(pdDto.getM_id());
					p.pdNameLbl2.setText(pdDto.getP_name());
					p.pdPricetLbl2.setText(Integer.toString(pdDto.getP_price()));
					p.pdSortLbl2.setText(pdDto.getP_sort());
					p.pdhopeLbl2.setText(Integer.toString(pdDto.getP_hopeNum()));
					p.contentArea.setText(pdDto.getP_content());
					
						//판넬 이미지 출력
					String img1 = pdDto.getP_image1();
					String img2 = pdDto.getP_image2();
						
						//이미지 리사이징
					ImageIcon imgicon1 = new ImageIcon(img1);
					Image imgChgSize1 = imgicon1.getImage();
					Image imgUse1 = imgChgSize1.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
					ImageIcon imgiconUse1 = new ImageIcon(imgUse1);
					 
					ImageIcon imgicon2 = new ImageIcon(img2);
					Image imgChgSize2 = imgicon2.getImage();
					Image imgUse2 = imgChgSize2.getScaledInstance(250, 250,Image.SCALE_SMOOTH);
					ImageIcon imgiconUse2 = new ImageIcon(imgUse2);
					 
					p.imgLabel1.setIcon(imgiconUse1);
					p.imgLabel2.setIcon(imgiconUse2);
					
					pdDao.pdclick(a); //상품 클릭시 클릭횟수 올라감
					dispose();
				}
			});
				  
				
			
		}//여기까지가 포문

	}
		
	

	public static void main(String[] args) {
	
		new junggoMain();

	}




}
