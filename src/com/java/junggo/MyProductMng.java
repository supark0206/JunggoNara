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

public class MyProductMng extends JFrame {


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
	
	public MyProductMng() {
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
		
		JButton searchBtn = new JButton("검색");
		searchBtn.setBounds(650, 38, 95, 35);
		panel.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				MyShop m = null;
				MyProductMng mpd = new MyProductMng();
				
				String id = userIdLabel.getText();
				
				if(pdStateCbox.getSelectedItem()=="판매중") {
					myUploadSearch( mpd, searchTxt.getText(), "", "1", id);
					mpd.userIdLabel.setText(id);
				}else if(pdStateCbox.getSelectedItem()=="판매완료") {
					myUploadSearch( mpd, searchTxt.getText(), "", "0", id);
					mpd.userIdLabel.setText(id);
				}else if(pdStateCbox.getSelectedItem()=="전체상품") {
					myUploadSearch( mpd, searchTxt.getText(), "", "", id);
					mpd.userIdLabel.setText(id);
				}
				
				dispose();
				
			}
		});
		
		//텍스트필드
		searchTxt = new JTextField();
		searchTxt.setBounds(420,38, 220, 35);
		panel.add(searchTxt);
		
		
		//콤보박스
		String[] pdStateName= {"전체상품","판매중","판매완료"};
		pdStateCbox = new JComboBox<>(pdStateName);
		pdStateCbox.setBounds(320, 38,90 ,35);
		panel.add(pdStateCbox);
		
		//판넬에 올림
		con.add(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료

		// 프레임 설정
		setVisible(true);
		setTitle("등록 상품");
		setSize(1100,600);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
	}

	 
	
	
	public void myUploadSearch(MyProductMng mPd,String name,String sort ,String state,String id) {

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
				 mPd.scrollPanel.add(pdNameLbl[i],gbc);
				 //상품 가격 라벨 출력
				 pdPriceLbl[i] = new JLabel( "상품가격 : "+Integer.toString(dtos.get(i).getP_price()));
				 pdPriceLbl[i].setOpaque(true);
				 pdPriceLbl[i].setBackground(Color.WHITE);
				 pdPriceLbl[i].setHorizontalAlignment(JLabel.CENTER);
				 pdPriceLbl[i].setFont(font2);
				 pdPriceLbl[i].setPreferredSize(new Dimension(250, 40));
				 mPd.scrollPanel.add(pdPriceLbl[i],gbc);
				
				 //상품 이미지 버튼 출력
				 num[i] = dtos.get(i).getP_num();
				 imgBtns[i]=new JButton(Integer.toString(num[i]));
				 imgBtns[i].setPreferredSize(new Dimension(250, 250));
				 imgBtns[i].setIcon(imgiconUse[i]);
				 mPd.scrollPanel.add(imgBtns[i],gbc);
				 imgBtns[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						
						ProductChg pdc = new ProductChg();
						pdDao = new ProductDao();
						pdDto = new ProductDto();
						//버튼 값을 상품 번호로 설정하여 getActionCommand 로 클릭한 버튼값을 가져온다.
						int a =Integer.parseInt(e.getActionCommand());
						//상품 번호를통해 상품 정보 출력
						pdDto=pdDao.pdinfo(a);
							//상품상태 출력

						pdc.img1.setText(pdDto.getP_image1());
						pdc.img2.setText(pdDto.getP_image2());
						pdc.pdPriceTxt.setText(Integer.toString(pdDto.getP_price()));
						pdc.pdSortCbox.setSelectedItem(pdDto.getP_sort());
						pdc.pdStateCbox.setSelectedIndex(pdDto.getP_state());
						pdc.pdnumLbl.setText(Integer.toString(pdDto.getP_num()));
						pdc.pdContentArea.setText(pdDto.getP_content());
						pdc.idLabel.setText(pdDto.getM_id());
						pdc.pdNameTxt.setText(pdDto.getP_content());
						


						
						pdDao.pdclick(a); //상품 클릭시 클릭횟수 올라감
						mPd.dispose();
					}
				});

			
			}
		}

	public static void main(String[] args) {
		
		new MyProductMng();
	}

}
