package TermProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainBackground extends JPanel {
	
	private JLabel copyright;
	int color;
	
	// background
	public void paintComponent(Graphics g) {
		// 이미지 추출 및 크기 변경하기
		if(color==0) {
			ImageIcon background_icon = ImageChanger("images/titlebg.png", 900, 600);
			g.drawImage(background_icon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}else if(color==1) {
			this.setBackground(Color.BLACK);
			super.paintComponent(g);
		}else if(color==2) {
			Color color2 = new Color(255, 228, 181);
			this.setBackground(color2);
			super.paintComponent(g);
		}
	}

	public MainBackground() {
		setSize(900, 600);
		setLayout(new BorderLayout());
		
		// copyright
		copyright = new JLabel("copyright @ 문찬국, 김진영, 박현진, 정연정");
		copyright.setFont(new Font("나눔바른고딕", Font.PLAIN, 10));
		copyright.setForeground(Color.white);
		copyright.setHorizontalAlignment(JLabel.RIGHT);
		add(copyright, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public MainBackground(int color_num) {
		setSize(900, 600);
		setLayout(new BorderLayout());
		
		//Background
		if(color_num==0) {
			color = 0;
		}else if(color_num==1){
			color = 1;
		}else if(color_num==2){
			color = 2;
		}
		
		// copyright
		copyright = new JLabel("copyright @ 문찬국, 김진영, 박현진, 정연정");
		copyright.setFont(new Font("나눔바른고딕", Font.PLAIN, 10));
		copyright.setForeground(Color.white);
		copyright.setHorizontalAlignment(JLabel.RIGHT);
		add(copyright, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	//이미지 추출함수
		public ImageIcon ImageChanger(String imageLink, int width, int height) {
			ImageIcon originIcon = new ImageIcon(imageLink);
			Image originImg = originIcon.getImage();
			Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			ImageIcon new_icon = new ImageIcon(changedImg);
			return new_icon;
		}

}
