package TermProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TermProject.GameMain.mainButtonListener;

public class GameMain extends JFrame {
	
	private JLabel title;
	//private JButton[] button = new JButton[4];
	private JButton[] button = new JButton[3];
	//true�̸� ��ü�� ��ȸ�� ������ ����, false�̸� ���� (��)�� ���ߴ� ���ǵ�����;
	private boolean team = true; 
	private int qNum = 10; 
	private int time = 60;
	private int teamNum = 5;
	
	
	// GameMain ������
	public GameMain() {
		setSize(900, 600);
		MainBackground main = new MainBackground(0);
		main.add(new TitlePanel(), BorderLayout.NORTH);
		main.add(new ButtonPanel(), BorderLayout.CENTER);
		add(main);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public GameMain(boolean team, int qNum, int time, int teamNum) {
		this.team = team;
		this.qNum = qNum;
		this.time = time;
		this.teamNum = teamNum;
		setSize(900, 600);
		MainBackground main = new MainBackground(0);
		main.add(new TitlePanel(), BorderLayout.NORTH);
		main.add(new ButtonPanel(), BorderLayout.CENTER);
		add(main);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}


	//TitlePanel (���� ���� ȭ�� �ΰ� �ֱ� ���� �г� Ŭ����)
	class TitlePanel extends JPanel {
		public TitlePanel() {
			
			//layout
			setLayout(new FlowLayout(FlowLayout.CENTER, 500, 20));
			setOpaque(false);
			
			//title
			title = new JLabel();
			title.setIcon(ImageChanger("images/title2.png", 400, 130));
			title.setHorizontalAlignment(JLabel.CENTER);
			add(title);
		}
	}
	
	//ButtonPanel (���� ���� ȭ�� ��ư Ŭ����)
	class ButtonPanel extends JPanel {

		public ButtonPanel() {
			//layout
			setLayout(new GridLayout(4, 0, 5, 5));
			setOpaque(false);
			setBorder(new EmptyBorder(30, 0, 0, 0));
			// button
			for (int i = 0; i < button.length; i++) {
				button[i] = new JButton();
				button[i].addActionListener(new mainButtonListener());
				button[i].setPreferredSize(new Dimension(250, 90));
				button[i].setBorderPainted(false);
				button[i].setContentAreaFilled(false);
				// �̹��� ���� �� ũ�� ����
				ImageIcon button_icon = ImageChanger("images/button" + i + ".png",250, 90);
				ImageIcon buttonC_icon = ImageChanger("images/buttonC" + i + ".png",250, 90);
				button[i].setIcon(button_icon);
				button[i].setPressedIcon(buttonC_icon);
				button[i].setRolloverIcon(buttonC_icon);
				add(button[i]);
			}
		}
	}
	
	class mainButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button[0]) {
				new GameExplain (team, qNum, time, teamNum);
				setVisible(false);
			}else if(e.getSource()==button[1]) {
				new GameOption();
				setVisible(false);
			}else if(e.getSource()==button[2]) {
				new GameType(team, qNum, time, teamNum);
				setVisible(false);
			}/*else if(e.getSource()==button[3]) {
				//UserMode um = new UserMode();
				setVisible(false);
			}*/
		}
	}
	
	public ImageIcon ImageChanger(String imageLink, int width, int height) {
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon new_icon = new ImageIcon(changedImg);
		return new_icon;
	}
}
