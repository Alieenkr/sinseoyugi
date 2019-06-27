package TermProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import TermProject.GameExplain.ExplainButtonListener;
import TermProject.GameMain.ButtonPanel;
import TermProject.GameMain.TitlePanel;
import TermProject.Question1Panel.btnListener;

public class GameOption extends JFrame { 
	private boolean team = true; 
	private int qNum = 10; 
	private int time = 60;
	private int teamNum = 5;
	
	private JPanel [] panel = new JPanel[4];
	private JPanel AddPanel, buttonPanel;
	private JButton completeBtn, resetBtn, title;
	
	JButton [] choice = new JButton[3];
	JButton [] number = new JButton[8];
	JButton [] problem = new JButton[7];
	JButton [] timeBtn = new JButton[5];
	
	String[] CHOICE = {null, "TEAM", "SOLO"}; //Quesion1Panel, Question2Panel 
	Integer[] NUMBER = {null, 2, 3, 4, 5, 6, 7, 8}; //group
	Integer[] PROBLEM = {null, 3, 5, 7, 10, 15, 20}; //qNum
	Integer[] TIME = {null, 30, 60, 90, 120}; //time
    // 각각 배열을 만들고, 배열에 들어갈 원소들을 넣어준다.
	
	class TitlePanel extends JPanel {
		public TitlePanel() {
			// layout
			setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
			setOpaque(false);

			title = new JButton();
			// 이미지 추출 및 크기 변경하기
			
			ImageIcon title_icon = ImageChanger("images/GameOptionTitle.png",350, 70);
			title.setIcon(title_icon);
			ButtonChanger(title, 350, 70);
			title.addActionListener(new OptionButtonListener());
			add(title);
		}
	}
	
	public GameOption() {
		setTitle(" GameOption ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//panel[0] 단체전, 개인전
		panel[0] = new JPanel();
		panel[0].setOpaque(false);
		//panel[0].setLayout(new GridLayout(1, 3, 5, 5));
		panel[0].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		for(int i = 0; i<choice.length; i++) {
			ImageIcon teamsolo_icon = ImageChanger("images/teamsolo" + i + ".png",100, 50);
			ImageIcon teamsoloC = ImageChanger("images/teamsoloC" + i + ".png",100, 50);
			choice[i] = new JButton();
			ButtonChanger(choice[i], 100, 50);
			choice[i].setIcon(teamsolo_icon);
			choice[i].setPressedIcon(teamsoloC);
			choice[i].setRolloverIcon(teamsoloC);
			
			choice[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton choiceSelect = (JButton)e.getSource();
					
					for(int i = 1; i < choice.length; i++) {
						if(choiceSelect == choice[i]) {
							ImageIcon teamsoloC = ImageChanger("images/teamsoloC" + i + ".png",100, 50);
							choice[i].setIcon(teamsoloC);
							repaint();
							if(CHOICE[i].equals("TEAM")){
								team = true;
							}else {
								team = false;
							}
						}
						if(choiceSelect != choice[i]){
							ImageIcon teamsolo_icon = ImageChanger("images/teamsolo" + i + ".png",100, 50);
							choice[i].setIcon(teamsolo_icon);
							repaint();
						}
					}
				}
			});
			
			panel[0].add(choice[i]);
		}
		
		
		//panel[1] 인원 수
		panel[1] = new JPanel();
		panel[1].setOpaque(false);
		//panel[1].setLayout(new GridLayout(1, 8, 5, 5));
		panel[1].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		for(int i = 0; i<number.length; i++) {
			if(i==0) {
				ImageIcon teamsolo_icon = ImageChanger("images/number" + i + ".png",100, 50);
				number[i] = new JButton();
				ButtonChanger(number[i], 100, 50);
				number[i].setIcon(teamsolo_icon);
				
			}else {
				ImageIcon number_icon = ImageChanger("images/number" + i + ".png",50, 50);
				ImageIcon numberC = ImageChanger("images/numberC" + i + ".png",50, 50);
				number[i] = new JButton();
				ButtonChanger(number[i], 50, 50);
				number[i].setIcon(number_icon);
				number[i].setPressedIcon(numberC);
				number[i].setRolloverIcon(numberC);
			}
				number[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton numberSelect = (JButton)e.getSource();
						
						for(int i = 1; i < number.length; i++) {
							if(numberSelect == number[i]) {
								ImageIcon numberC = ImageChanger("images/numberC" + i + ".png",50, 50);
								number[i].setIcon(numberC);
								teamNum = NUMBER[i];
								repaint();
							}
							if(numberSelect != number[i]){
								ImageIcon number_icon = ImageChanger("images/number" + i + ".png",50, 50);
								number[i].setIcon(number_icon);
								repaint();
							}
						}
					}
				});
			panel[1].add(number[i]);
		}
		
		
		//panel[2] 문제 수
		panel[2] = new JPanel();
		panel[2].setOpaque(false);
		//panel[2].setLayout(new GridLayout(1, 8));
		panel[2].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		for(int i = 0; i<problem.length; i++) {
			
			if(i==0) {
				ImageIcon teamsolo_icon = ImageChanger("images/problem" + i + ".png",100, 50);
				problem[i] = new JButton();
				ButtonChanger(problem[i], 100, 50);
				problem[i].setIcon(teamsolo_icon);
			}else {
				ImageIcon teamsolo_icon = ImageChanger("images/problem" + i + ".png",50, 50);
				ImageIcon problemC = ImageChanger("images/problemC" + i + ".png",50, 50);
				problem[i] = new JButton();
				ButtonChanger(problem[i], 50, 50);
				problem[i].setIcon(teamsolo_icon);
				problem[i].setPressedIcon(problemC);
				problem[i].setRolloverIcon(problemC);
			}
			problem[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton problemSelect = (JButton)e.getSource();
					
					for(int i = 1; i < problem.length; i++) {
						
						if(problemSelect == problem[i]) {
							ImageIcon problemC = ImageChanger("images/problemC" + i + ".png",50, 50);
							problem[i].setIcon(problemC);
							qNum = PROBLEM[i];
							repaint();
						}
						if(problemSelect != problem[i]){
							ImageIcon problem_icon = ImageChanger("images/problem" + i + ".png",50, 50);
							problem[i].setIcon(problem_icon);
							repaint();
						}
					}
				}
			});
			
			panel[2].add(problem[i]);
		}
		
		//panel[3] 제한시간
		panel[3] = new JPanel();
		panel[3].setOpaque(false);
		//panel[3].setLayout(new GridLayout(1, 8));
		panel[3].setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		for(int i = 0; i<timeBtn.length; i++) {
			ImageIcon time_icon = ImageChanger("images/time" + i + ".png",100, 50);
			ImageIcon timeBtnC = ImageChanger("images/timeC" + i + ".png",100, 50);
			timeBtn[i] = new JButton();
			ButtonChanger(timeBtn[i], 100, 50);
			timeBtn[i].setIcon(time_icon);
			timeBtn[i].setPressedIcon(timeBtnC);
			timeBtn[i].setRolloverIcon(timeBtnC);
			
			timeBtn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton timeSelect = (JButton)e.getSource();
					
					for(int i = 1; i < timeBtn.length; i++) {
						if(timeSelect == timeBtn[i]) {
							ImageIcon timeBtnC = ImageChanger("images/timeC" + i + ".png",100, 50);
							timeBtn[i].setIcon(timeBtnC);
							time = TIME[i];
							repaint();
						}
						if(timeSelect != timeBtn[i]){
							ImageIcon timeBtn_icon = ImageChanger("images/time" + i + ".png",100, 50);
							timeBtn[i].setIcon(timeBtn_icon);
							repaint();
						}
						
					}
				}
			});
			
			panel[3].add(timeBtn[i]);
		}
		
		//completeBtn
		completeBtn = new JButton();
		ButtonChanger(completeBtn, 90, 50);
		ImageIcon completeBtn_icon = ImageChanger("images/completeBtn.png",90, 50);
		ImageIcon completeCBtn_icon = ImageChanger("images/completeCBtn.png",90, 50);
		completeBtn.setIcon(completeBtn_icon);
		completeBtn.setPressedIcon(completeCBtn_icon);
		completeBtn.setRolloverIcon(completeCBtn_icon);
		
		completeBtn.addActionListener(new OptionButtonListener());
		
		//panel 모든 버튼 패널 합치기
		AddPanel =  new JPanel();
		AddPanel.setOpaque(false);
		AddPanel.setLayout(new GridLayout(5, 1, 20, 20));
		AddPanel.setBorder(BorderFactory.createEmptyBorder(10, 170, 0, 50));
		for(int i = 0; i < panel.length; i++) {
			AddPanel.add(panel[i]);
		}
		
		setSize(900, 600);
		MainBackground main = new MainBackground(0);
		main.add(new TitlePanel(), BorderLayout.NORTH);
		main.add(AddPanel, BorderLayout.CENTER);
		main.add(completeBtn, BorderLayout.SOUTH);
		main.setBorder(new EmptyBorder(0, 0, 30, 0));
		setLocationRelativeTo(null);
		add(main);
		
		setVisible(true);		
		
	}
	
	class OptionButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==completeBtn) {
				new GameMain(team, qNum, time, teamNum);	
				setVisible(false);
			}else if(e.getSource() == title) {
				new GameMain();
				setVisible(false);
			}
		}
	}
	
	public ImageIcon ImageChanger(String imageLink, int width, int height) {
		
		// 이미지 추출 및 크기 변경
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		//ImageIcon new_icon = new ImageIcon(originImg);
		ImageIcon new_icon = new ImageIcon(changedImg);
		return new_icon;
	}
	
	public void ButtonChanger(JButton button, int width, int height) {
		// 버튼 크기 및 투명도 조절
			button.setPreferredSize(new Dimension(width, height));
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setOpaque(false);
	}
}
 