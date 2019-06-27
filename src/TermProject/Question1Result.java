package TermProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
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

import TermProject.Question2Result.ResultButtonListener;

public class Question1Result extends JFrame{

	private int qNum, time, score, teamNum;
	private String dir;
	private String [] file;
	ArrayList rankList, data;
	JPanel HeadPanel, BodyPanel, bottomPanel;
	JLabel result, count, comment; 
	JButton menu, replay, rank, nav;
	
	public Question1Result(String dir, String[] file, int qNum, int time, int teamNum, int score, ArrayList rankList, ArrayList data) {
		this.qNum = qNum;
		this.time = time;
		this.dir = dir;
		this.file = file;
		this.score = score;
		this.rankList = rankList;
		this.data = data;
		//�гη� ���� ���� �����ε��غ���
		rankList.add(score);
		setTitle("���â");
		
		//menuBtn
		nav = new JButton();
		nav.setHorizontalAlignment(JButton.LEFT);
		ButtonChanger(nav, 350, 70);
		nav.setIcon(ImageChanger("images/GameResultTitle.png",350, 70));
		nav.addActionListener(new ResultButtonListener());
				
		//HeadPanel
		HeadPanel = new JPanel();
		HeadPanel.setOpaque(false);
		HeadPanel.setLayout(new GridLayout(2, 1));
		
		result = new JLabel("<���>");
		result.setFont(new Font("�����ٸ����", Font.BOLD ,80));
		result.setForeground(Color.white);
		result.setHorizontalAlignment(JLabel.CENTER);
		HeadPanel.add(result);
				
		//BodyPanel
		BodyPanel = new JPanel();
		BodyPanel.setOpaque(false);
		
		count = new JLabel(score+ "�� ����");
		count.setHorizontalAlignment(JLabel.CENTER);
		count.setFont(new Font("�����ٸ����", Font.BOLD ,80));
		count.setForeground(Color.RED);
		
		BodyPanel.add(count);
		HeadPanel.add(BodyPanel);
		
		//bottomPanel
		bottomPanel = new JPanel();
		bottomPanel.setOpaque(false);
		
		menu = new JButton("�����̵�");
		replay = new JButton("�̾��ϱ�");
		rank = new JButton("��������");
		
		bottomPanel.add(menu);
		ButtonChanger2(menu);
		menu.setFont(new Font("�����ٸ����", Font.BOLD ,25));
		menu.setForeground(Color.YELLOW);
		
		
		bottomPanel.add(replay);
		ButtonChanger2(replay);
		replay.setFont(new Font("�����ٸ����", Font.BOLD ,25));
		replay.setForeground(Color.YELLOW);
		
		bottomPanel.add(rank);
		ButtonChanger2(rank);
		rank.setFont(new Font("�����ٸ����", Font.BOLD ,25));
		rank.setForeground(Color.YELLOW);
		
		setSize(900, 600);
		
		MainBackground main = new MainBackground(1);
		main.setBorder(new EmptyBorder(20, 0, 0, 0));
		main.add(nav, new BorderLayout().NORTH);
		main.add(HeadPanel, BorderLayout.CENTER);
		main.add(bottomPanel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		add(main);
		
		setVisible(true);
	}
	
	class ResultButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==menu) {
				new GameMain(false, qNum, time, teamNum);	
				setVisible(false);
			}
			if(e.getSource()==replay) {
				new Question1Panel(dir, file, qNum, time, teamNum, rankList, data);
				setVisible(false);
			}
			if(e.getSource()==rank) {
				new Rank (dir, file, qNum, time, teamNum, rankList, data);	
				setVisible(false);
			}
			if(e.getSource()==nav) {
				new GameMain(false, qNum, time, teamNum);	
				setVisible(false);
			}
		}
	}
	
	public ImageIcon ImageChanger(String imageLink, int width, int height) {
		
		// �̹��� ���� �� ũ�� ����
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon new_icon = new ImageIcon(changedImg);
		
		return new_icon;
	}
	
	public void ButtonChanger(JButton button, int width, int height) {
		// ��ư ũ�� �� ���� ����
			button.setPreferredSize(new Dimension(width, height));
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setOpaque(false);
	}
	public void ButtonChanger2(JButton button) {
		// ��ư ũ�� �� ���� ����
			button.addActionListener(new ResultButtonListener());
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setOpaque(false);
	}
}
