package TermProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Question2Result extends JFrame {
	private int qNum, team, time;
	private String dir;
	private String [] file;
	private int[] score;
	JPanel p1, p2, p3, p4;
	JLabel result, comment;
	JLabel [] count;
	JButton menu, replay, rank, menuBtn;
	private ArrayList data;
	
	public Question2Result(String dir, String[] file, int qNum, int time, int team, int[] score, ArrayList data) {
		this.dir = dir;
		this.file = file;
		this.qNum = qNum;
		this.time = time;
		this.team = team;
		this.score = score;
		this.data = data;
		//ÆÐ³Î·Î µû·Î »©¼­ ¿À¹ö·ÎµùÇØº¸ÀÚ
		
		setTitle("°á°úÃ¢");
		//menuBtn
		menuBtn = new JButton();
		menuBtn.setHorizontalAlignment(JButton.LEFT);
		ButtonChanger(menuBtn, 350, 70);
		menuBtn.setIcon(ImageChanger("images/GameResultTitle.png",350, 70));
		
		//p1
		p1 = new JPanel();
		p1.setOpaque(false);
		p1.setLayout(new GridLayout(2, 1, 5, 5));
		result = new JLabel("<°á °ú>");
		result.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD ,70));
		result.setForeground(Color.red);
		result.setHorizontalAlignment(JLabel.CENTER);
		p1.add(result);
		
		//p2
		p2 = new JPanel();
		p2.setOpaque(false);
		
		p2.setLayout(new FlowLayout(FlowLayout.CENTER, 90, 30));
		p2.setBorder(new EmptyBorder(0, 0, 30, 0));
		
		count = new JLabel[team];
		for(int i =0; i < team; i++) {
			count[i] = new JLabel((i+1)+"ÆÀ: "+ score[i]+ "Á¡");
			count[i].setOpaque(false);
			count[i].setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD ,40));
			count[i].setHorizontalAlignment(JLabel.CENTER);
			count[i].setForeground(Color.WHITE);
			p2.add(count[i]);
		}
		p1.add(p2);
		
		//p3
		p3 = new JPanel();
		p3.setOpaque(false);
		p3.setBorder(new EmptyBorder(30, 0, 10, 0));
		
		menu = new JButton("¸Þ ´º");
		ButtonChanger2(menu);
		menu.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD ,40));
		menu.setForeground(Color.YELLOW);
		
		replay = new JButton("ÀÌ¾îÇÏ±â");
		ButtonChanger2(replay);
		replay.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD ,40));
		replay.setForeground(Color.YELLOW);
		
		p3.add(menu);

		p3.add(replay);

		setSize(900, 600);
		
		MainBackground main = new MainBackground(1);
		main.setBorder(new EmptyBorder(20, 0, 0, 0));
		main.add(menuBtn, BorderLayout.NORTH);
		main.add(p1, BorderLayout.CENTER);
		main.add(p3, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		add(main);
		
		setVisible(true);
	}
	
	public ImageIcon ImageChanger(String imageLink, int width, int height) {
		
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon new_icon = new ImageIcon(changedImg);
		
		return new_icon;
	}
	
	public void ButtonChanger(JButton button, int width, int height) {
			button.addActionListener(new ResultButtonListener());
			button.setPreferredSize(new Dimension(width, height));
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setOpaque(false);
	}
	
	public void ButtonChanger2(JButton button) {

			button.addActionListener(new ResultButtonListener());
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setOpaque(false);
	}

	class ResultButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==menuBtn) {
				new GameMain(true, qNum, time, team);	
				setVisible(false);
			}else if(e.getSource()==menu) {
				new GameMain(true, qNum, time, team);
				setVisible(false);
			}else if(e.getSource()==replay) {
				new Question2Panel(dir, file, qNum, time, team);	
				setVisible(false);
			}
		}
	}
	
}