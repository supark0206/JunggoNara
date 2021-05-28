package com.java.junggo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.java.dao.ProductDao;
import com.java.dto.ProductDto;

public class ProductUpload extends JFrame {
	public JTextField img1 ,img2 ,pdNameTxt , pdPriceTxt;
	public JButton pdUpBtn, imgUpBtn1 , imgUpBtn2;
	public JTextArea pdContentArea;
	public JComboBox<String> pdSortCbox;
	public JLabel idLabel;
	File f ,f2;
	JFileChooser jc;
	Login log;

	ProductDao dao  = new ProductDao();
	public ProductUpload() {
		Container con;
		con = getContentPane();
		
	
		
		//판넬------------------
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(15, 50, 400, 500);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setLayout(null);
		
		
		//폰트
		Font font = new Font("맑은 고딕",Font.BOLD,15);
		Font font1 = new Font("맑은 고딕",Font.BOLD,17);
		Font font2 = new Font("맑은 고딕",Font.PLAIN,15);
		//레이블-------------------------------
		
		img1 = new JTextField();
		img1.setFont(font);
		img1.setOpaque(true);
		img1.setEnabled(false);
		img1.setBackground(Color.WHITE);
		img1.setBounds(30, 200, 200, 35);
		panel2.add(img1);
		

		
		img2 = new JTextField();
		img2.setFont(font);
		img2.setOpaque(true);
		img2.setEnabled(false);
		img2.setBackground(Color.WHITE);
		img2.setBounds(30, 250, 200, 35);
		panel2.add(img2);
	
		

		JLabel pdSortLabel = new JLabel("상품분류");
		pdSortLabel.setFont(font);
		pdSortLabel.setBounds(30, 10, 130, 35);
		panel2.add(pdSortLabel);
		
		idLabel = new JLabel("아이디");
		idLabel.setFont(font);
		idLabel.setBounds(320, 10, 95, 35);
		panel.add(idLabel);
		
		JLabel pdNameLabel = new JLabel("상품명");
		pdNameLabel.setFont(font);
		pdNameLabel.setBounds(30, 50, 130, 35);
		panel2.add(pdNameLabel);
		
		JLabel pdPriceLabel = new JLabel("가격");
		pdPriceLabel.setFont(font);
		pdPriceLabel.setBounds(30, 90, 130, 35);
		panel2.add(pdPriceLabel);
		
		JLabel pdStateLabel = new JLabel("판매중");
		pdStateLabel.setFont(font1);
		pdStateLabel.setBounds(180, 145, 130, 35);
		panel2.add(pdStateLabel);


	
		
		
		
		//텍스트필드
		pdNameTxt = new JTextField();
		pdNameTxt.setFont(font2);
		pdNameTxt.setBounds(100,50, 250, 35);
		panel2.add(pdNameTxt);
		
		pdPriceTxt = new JTextField();
		pdPriceTxt.setFont(font2);
		pdPriceTxt.setBounds(100,90, 250, 35);
		panel2.add(pdPriceTxt);
		
		//텍스트에리어
		pdContentArea = new JTextArea();
		pdContentArea.setFont(font2);
		pdContentArea.setLineWrap(true);   //자동줄바꿈
		pdContentArea.setBounds(30,330, 325, 150);
		
		panel2.add(pdContentArea);
		
		//콤보박스

		String[] pdSortName= {"의류","전자제품","가전제품","생활용품","운동화"};
		pdSortCbox = new JComboBox<>(pdSortName);
		pdSortCbox.setBounds(100, 10,130 ,35);
		panel2.add(pdSortCbox);
		
		//버튼------------------------------------

		
		JButton mainBtn = new JButton("메인");
		mainBtn.setBounds(15, 10, 95, 35);
		panel.add(mainBtn);
		mainBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				junggoMain m = new junggoMain();
				m.userIdLabel.setText(idLabel.getText());
				m.pdView(m); // 상품 출력 메소드
				dispose();
				
			}
		});

		imgUpBtn1 = new JButton("1번 이미지");
		imgUpBtn1.setBounds(250, 200, 105, 35);
		panel2.add(imgUpBtn1);
		imgUpBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==imgUpBtn1)
				{
					jc = new JFileChooser();
					//이미지 파일 필터 입니다.
					FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지 파일", "png", "jpg", "gif");
					jc.setFileFilter(filter);
					
					
					
				
					if(jc.showOpenDialog(jc)==jc.APPROVE_OPTION) {
						f = jc.getSelectedFile();
						
						
						File Fname = new File("C:\\Users\\wjdgu\\OneDrive\\Desktop\\image"+"\\"+f.getName());
						
						//동일한 파일이있으면 값할당 x 
						if(Fname.isFile()) {
							JOptionPane.showMessageDialog(null,"동일한 파일이있습니다..","경고",JOptionPane.ERROR_MESSAGE);
						}else {
							img1.setText("C:\\Users\\wjdgu\\OneDrive\\Desktop\\image"+"\\"+f.getName());
						}
						

					//값을 못받으면 경고창.	
					}else{
						JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다.","경고",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		});
		
		imgUpBtn2 = new JButton("2번 이미지");
		imgUpBtn2.setBounds(250, 250, 105, 35);
		panel2.add(imgUpBtn2);
		imgUpBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==imgUpBtn2)
				{
					jc = new JFileChooser();
					//이미지 파일 필터 입니다.
					FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지 파일", "png", "jpg", "gif");
					jc.setFileFilter(filter);
					
					if(jc.showOpenDialog(jc)==jc.APPROVE_OPTION) {
						f2 = jc.getSelectedFile();
						File Fname = new File("C:\\Users\\wjdgu\\OneDrive\\Desktop\\image"+"\\"+f2.getName());
						
						//동일한 파일이있으면 값할당 x 
						if(Fname.isFile()) {
							JOptionPane.showMessageDialog(null,"동일한 파일이있습니다..","경고",JOptionPane.ERROR_MESSAGE);
						}else {
							img2.setText("C:\\Users\\wjdgu\\OneDrive\\Desktop\\image"+"\\"+f2.getName());
						}

						
					//값을 못받으면 경고창.	
					}else{
						JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다.","경고",JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		});
		pdUpBtn = new JButton("상품등록");
		pdUpBtn.setBounds(310, 560, 105, 35);
		panel.add(pdUpBtn);
		
		//상품 등록 이벤트
		pdUpBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(img1.getText().length()==0 || 
						img2.getText().length()==0 ||
						pdPriceTxt.getText().length()==0 ||
						pdNameTxt.getText().length()==0 ||
						pdContentArea.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				
				}else if(regularPrice(pdPriceTxt.getText())==false) {
					JOptionPane.showMessageDialog(null, "가격은 숫자만 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					int uploadChk = JOptionPane.showConfirmDialog(null,"입력하신 정보로 등록하시겠습니까?","상품등록",JOptionPane.YES_NO_OPTION);
					//회원가입
					
					if(uploadChk == JOptionPane.YES_OPTION) {
						
						fileSave1(f,"C:\\Users\\wjdgu\\OneDrive\\Desktop\\image",f.getName());
						fileSave2(f2,"C:\\Users\\wjdgu\\OneDrive\\Desktop\\image",f2.getName());
						dao.pdInsert(idLabel.getText(),img1.getText(), img2.getText(), pdNameTxt.getText(), Integer.parseInt(pdPriceTxt.getText()),
								1,pdContentArea.getText(),pdSortCbox.getSelectedItem().toString());
						System.out.println("이미지1 : "+img1.getText()+ "/이미지2 : "+img2.getText()+"/분류 :" + pdSortCbox.getSelectedItem().toString());
						junggoMain m = new junggoMain();
						m.pdView(m); // 상품 출력 메소드
						dispose();
					}				
					

				}
				
			}
		});
		


		
		//판넬에 올림
		con.add(panel);
		panel.add(panel2);
		


		// 프레임 설정
		setVisible(true);
		setTitle("상품등록");
		setSize(450,650);
		setLocationRelativeTo(null);
		setResizable(false); // 창 크기조절 불가.
		
		

		
		
	
	}
	
	
	
	public void fileSave1(File file,String path,String name)
 	{
 		try {

				File check = new File(path+"\\"+name);
				

				
					File f = new File(path);
					String filePath = path+"\\"+name;
					
					//imgLabel1.setText(filePath);
					System.out.println(filePath);
					
					FileInputStream fis = new FileInputStream(file);
				
					FileOutputStream fos = new FileOutputStream(filePath);
				
					int i =0;
					byte[] buffer = new byte[1024];
				
					while((i=fis.read(buffer,0,1024))!=-1)
					{
							fos.write(buffer,0,i);
					
					}
					fis.close();
					fos.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
 	}
	
	public void fileSave2(File file,String path,String name)
 	{
 		try {

				File check = new File(path+"\\"+name);
				
				

				
					File f = new File(path);
					String filePath = path+"\\"+name;

					System.out.println(filePath);
					FileInputStream fis = new FileInputStream(file);
				
					FileOutputStream fos = new FileOutputStream(filePath);
				
					int i =0;
					byte[] buffer = new byte[1024];
				
					while((i=fis.read(buffer,0,1024))!=-1)
					{
							fos.write(buffer,0,i);
					
					}
					fis.close();
					fos.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
 	}
	
	
	  public static boolean regularPrice(String price) {
			if (Pattern.matches("^[0-9]*$", price)) {
				return true;

			} else {
				return false;
			}
		}

	public static void main(String[] args) {
	
		new  ProductUpload();

	}

}
