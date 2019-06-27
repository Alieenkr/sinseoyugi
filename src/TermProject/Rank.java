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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import TermProject.GameOption.TitlePanel;
import TermProject.Question1Panel.btnListener;
import TermProject.Question1Result.ResultButtonListener;

public class Rank extends JFrame{
	String dir;
	String[] file;
	int qNum, time, teamNum;
	JButton menu, goBack, reset;
	private ArrayList data, rankList;
	// zResult에서 던지는 값을 배열로 받자
	JLabel[] rankLabel = new JLabel[10];
	
	public Rank(String dir, String[] file, int qNum, int time, int teamNum,  ArrayList rankList, ArrayList data) {
		this.dir = dir;
		this.file = file;
		this.time = time;
		this.qNum = qNum;
		//결과값과 다회차 플레이를 위한 데이터 저장 코드
		this.rankList = rankList;
		this.data = data;
		
		setTitle("순위 보기");
		setSize(900,550);	
		MainBackground main = new MainBackground(1);
		main.setBorder(new EmptyBorder(0, 0, 20, 0));
		main.add(new MenuPanel(), BorderLayout.NORTH);
		main.add(new RankPanel(), BorderLayout.CENTER);
		main.add(new SouthPanel(), BorderLayout.SOUTH);
		add(main);
		setLocationRelativeTo(null);
		setVisible(true);
	}	
	
	class MenuPanel extends JPanel{
		public MenuPanel() {
			setOpaque(false);
			setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
			
			//menuBtn
			menu = new JButton();
			ImageChanger(menu, "images/GameRankTitle.png",350, 70).addActionListener(new RankButtonListener());
			menu.addActionListener(new RankButtonListener());
			
			add(menu);
		}
	}
	
	class RankPanel extends JPanel{
		public RankPanel() {
			setOpaque(false);
			//나중에 자료구조를 이용하면, 여기서 팀 명과 점수를 출력하는 메소드를 여기서 실행
			setLayout(new GridLayout(rankList.size(), 0, 0, 10));
			setBorder(new EmptyBorder(0, 0, 20, 0));
			
		for(int i = 0; i< rankList.size(); i++) {
			rankLabel[i] = new JLabel((i+1)+" 팀 "+"맞힌 개수: "+ rankList.get(i)+" 개");
			rankLabel[i].setOpaque(false);
			rankLabel[i].setFont(new Font("나눔바른고딕", Font.BOLD ,30));
			rankLabel[i].setHorizontalAlignment(JLabel.CENTER);
			rankLabel[i].setForeground(Color.WHITE);
			add(rankLabel[i]);
		}
	}
	}
	class SouthPanel extends JPanel{
			public SouthPanel() {
				setOpaque(false);
				//goBack
				goBack = new JButton("한 번 더 하기");
				ButtonChanger2(goBack);
				add (goBack);
				goBack.setFont(new Font("나눔바른고딕", Font.BOLD ,40));
				goBack.setForeground(Color.YELLOW);
				
				//reset
				reset = new JButton("초기화");
				ButtonChanger2(reset);;
				add(reset);
				reset.setFont(new Font("나눔바른고딕", Font.BOLD ,40));
				reset.setForeground(Color.YELLOW);
			}
		}
	
	class RankButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==menu) {
				new GameMain();
				setVisible(false);
			}else if(e.getSource()==goBack) {
				new Question1Panel(dir, file, qNum, time, teamNum, rankList, data);
				setVisible(false);
			}else if(e.getSource()==reset) {
				new GameMain(false, qNum, time, teamNum);
				setVisible(false);
			}
		}
	}
		
	public JButton ImageChanger(JButton button, String imageLink, int width, int height) {
    	
    	// 버튼 크기 및 투명도 조절
		button.setPreferredSize(new Dimension(width, height));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setOpaque(false);
		
		// 이미지 추출 및 크기 변경
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon new_icon = new ImageIcon(changedImg);
		
		button.setIcon(new_icon);
		
		return button;
	}
	public void ButtonChanger2(JButton button) {
		// 버튼 크기 및 투명도 조절
			button.addActionListener(new RankButtonListener());
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setOpaque(false);
	}

}
