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
	// zResult���� ������ ���� �迭�� ����
	JLabel[] rankLabel = new JLabel[10];
	
	public Rank(String dir, String[] file, int qNum, int time, int teamNum,  ArrayList rankList, ArrayList data) {
		this.dir = dir;
		this.file = file;
		this.time = time;
		this.qNum = qNum;
		//������� ��ȸ�� �÷��̸� ���� ������ ���� �ڵ�
		this.rankList = rankList;
		this.data = data;
		
		setTitle("���� ����");
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
			//���߿� �ڷᱸ���� �̿��ϸ�, ���⼭ �� ��� ������ ����ϴ� �޼ҵ带 ���⼭ ����
			setLayout(new GridLayout(rankList.size(), 0, 0, 10));
			setBorder(new EmptyBorder(0, 0, 20, 0));
			
		for(int i = 0; i< rankList.size(); i++) {
			rankLabel[i] = new JLabel((i+1)+" �� "+"���� ����: "+ rankList.get(i)+" ��");
			rankLabel[i].setOpaque(false);
			rankLabel[i].setFont(new Font("�����ٸ����", Font.BOLD ,30));
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
				goBack = new JButton("�� �� �� �ϱ�");
				ButtonChanger2(goBack);
				add (goBack);
				goBack.setFont(new Font("�����ٸ����", Font.BOLD ,40));
				goBack.setForeground(Color.YELLOW);
				
				//reset
				reset = new JButton("�ʱ�ȭ");
				ButtonChanger2(reset);;
				add(reset);
				reset.setFont(new Font("�����ٸ����", Font.BOLD ,40));
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
    	
    	// ��ư ũ�� �� ���� ����
		button.setPreferredSize(new Dimension(width, height));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setOpaque(false);
		
		// �̹��� ���� �� ũ�� ����
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon new_icon = new ImageIcon(changedImg);
		
		button.setIcon(new_icon);
		
		return button;
	}
	public void ButtonChanger2(JButton button) {
		// ��ư ũ�� �� ���� ����
			button.addActionListener(new RankButtonListener());
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setOpaque(false);
	}

}
