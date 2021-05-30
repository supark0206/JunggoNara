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
import javax.swing.JPanel;

import com.java.dao.ProductDao;
import com.java.dao.hopeDao;
import com.java.dto.ProductDto;
import com.java.dto.hopeDto;

public class MyShop extends JFrame {

	public JLabel idLabel2, nameLabel2, phoneLabel2, birthLabel2, emailLabel2;

	JButton[] imgBtns;
	Font font2;
	ProductDto pdDto;
	ProductDao pdDao;
	ArrayList<ProductDto> dtos;
	
	public MyShop() {
		Container con;
		con = getContentPane();

		// 판넬------------------
		JPanel panel = new JPanel();
		panel.setLayout(null);
		con.add(panel);

		// 폰트
		Font font = new Font("맑은 고딕", Font.BOLD, 18);
		font2 = new Font("맑은 고딕",Font.PLAIN,20);
		// 버튼
		JButton mainBtn = new JButton("메인");
		mainBtn.setBounds(10, 10, 105, 35);
		panel.add(mainBtn);
		mainBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				junggoMain m= new junggoMain();
				m.userIdLabel.setText(idLabel2.getText());
				m.pdSearch(m, "","","","");
			}
		});

		JButton hopeListBtn = new JButton("나의찜목록");
		hopeListBtn.setBounds(10, 330, 120, 50);
		panel.add(hopeListBtn);
		hopeListBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				MyHopeList mh = new MyHopeList();
				pdHope(mh, idLabel2.getText());
				mh.userIdLabel.setText(idLabel2.getText());

				
			}
		});

		JButton pdUpMngBtn = new JButton("등록상품관리");
		pdUpMngBtn.setBounds(155, 330, 120, 50);
		panel.add(pdUpMngBtn);
		pdUpMngBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MyProductMng mpd = new MyProductMng();
				myUploadPd(mpd, "", "", "",idLabel2.getText());
				dispose();
				mpd.userIdLabel.setText(idLabel2.getText());
			}
		});

		JButton chgInfoBtn = new JButton("비밀번호 변경");
		chgInfoBtn.setBounds(300, 330, 120, 50);
		panel.add(chgInfoBtn);
		chgInfoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				PwChg pwchg = new PwChg();
				
				pwchg.idvalue = idLabel2.getText() ;
				
				
				
			}
		});

		// 레이블
		JLabel idLabel = new JLabel("아이디");
		idLabel.setFont(font);
		idLabel.setBounds(30, 70, 130, 35);
		panel.add(idLabel);

		idLabel2 = new JLabel("아이디");
		idLabel2.setFont(font);
		idLabel2.setBounds(160, 70, 200, 35);
		panel.add(idLabel2);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(font);
		nameLabel.setBounds(30, 120, 200, 35);
		panel.add(nameLabel);

		nameLabel2 = new JLabel("이름");
		nameLabel2.setFont(font);
		nameLabel2.setBounds(160, 120, 130, 35);
		panel.add(nameLabel2);

		JLabel phoneLabel = new JLabel("핸드폰번호");
		phoneLabel.setFont(font);
		phoneLabel.setBounds(30, 170, 200, 35);
		panel.add(phoneLabel);

		phoneLabel2 = new JLabel("핸드폰번호");
		phoneLabel2.setFont(font);
		phoneLabel2.setBounds(160, 170, 200, 35);
		panel.add(phoneLabel2);

		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setFont(font);
		birthLabel.setBounds(30, 220, 130, 35);
		panel.add(birthLabel);

		birthLabel2 = new JLabel("생년월일");
		birthLabel2.setFont(font);
		birthLabel2.setBounds(160, 220, 200, 35);
		panel.add(birthLabel2);

		JLabel emailLabel = new JLabel("이메일");
		emailLabel.setFont(font);
		emailLabel.setBounds(30, 270, 130, 35);
		panel.add(emailLabel);

		emailLabel2 = new JLabel("이메일");
		emailLabel2.setFont(font);
		emailLabel2.setBounds(160, 270, 250, 35);
		panel.add(emailLabel2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프레임닫히면 전부 종료

		// 프레임 설정
		setVisible(true);
		setTitle("마이샵");
		setSize(450, 450);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
	}

	
	
	//찜 상품
	public void pdHope(MyHopeList mH,String id) {
		// 로그인 하고나면 상품 목록을 보여준다.
		pdDao = new ProductDao();
		dtos = new ArrayList<ProductDto>();
		
		dtos = pdDao.hopeSelect(id);
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
			 mH.scrollPanel.add(pdNameLbl[i],gbc);
			 //상품 가격 라벨 출력
			 pdPriceLbl[i] = new JLabel( "상품가격 : "+Integer.toString(dtos.get(i).getP_price()));
			 pdPriceLbl[i].setOpaque(true);
			 pdPriceLbl[i].setBackground(Color.WHITE);
			 pdPriceLbl[i].setHorizontalAlignment(JLabel.CENTER);
			 pdPriceLbl[i].setFont(font2);
			 pdPriceLbl[i].setPreferredSize(new Dimension(250, 40));
			 mH.scrollPanel.add(pdPriceLbl[i],gbc);
			
			 //상품 이미지 버튼 출력
			 num[i] = dtos.get(i).getP_num();
			 imgBtns[i]=new JButton(Integer.toString(num[i]));
			 imgBtns[i].setPreferredSize(new Dimension(250, 250));
			 imgBtns[i].setIcon(imgiconUse[i]);
			 mH.scrollPanel.add(imgBtns[i],gbc);
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
					p.num = pdDto.getP_num();
					p.user = idLabel2.getText();
					
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
					mH.dispose();
				}
			});

		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			//내가등록한 상품 검색 메소드
			    public void myUploadPd(MyProductMng mPd,String name,String sort ,String state,String id) {
			    	ArrayList<ProductDto> dtos;
			    	ProductDao pdDao;
			    	ProductDto pdDto;
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
							ProductDao pdDao;
							ProductDto pdDto;
							
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

		new MyShop();

	}
}
