package TermProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameExplain extends JFrame {
	
	int qNum, time, teamNum, step=0;
	boolean team;

	private JButton title;
	private JLabel explain_image;
	private JButton[] button = new JButton[3];

	// TitlePanel (게임 설명 화면 로고 넣기 위한 패널 클래스)
	class ForMenuPanel extends JPanel{
		public ForMenuPanel() {
			JButton menuButton = new JButton("menu");
			menuButton.addActionListener(new ExplainButtonListener());
		}
	}
	
	class TitlePanel extends JPanel {
		public TitlePanel() {
			// layout
			setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
			setOpaque(false);
			
			title = new JButton();
			// 이미지 추출 및 크기 변경하기
			ImageIcon originIcon = new ImageIcon("images/ExplainTitle.png");
			Image originImg = originIcon.getImage();
			Image changedImg = originImg.getScaledInstance(350, 70, Image.SCALE_SMOOTH);
			ImageIcon title_icon = new ImageIcon(changedImg);
			title.setIcon(title_icon);
			ButtonChanger(title, 350, 70);
			title.addActionListener(new ExplainButtonListener());
			add(title);
		}
	}

	// ButtonPanel (설명을 원하는 게임을 선택하는 버튼 패널 클래스)
	class ButtonPanel extends JPanel {
		public ButtonPanel() {

			// layout
			setLayout(new GridLayout(1, 3));
			setOpaque(false);
			

			// button
			for (int i = 0; i < button.length; i++) {
				button[i] = new JButton();
				button[i].setPreferredSize(new Dimension(210, 70));
				button[i].setBorderPainted(false);
				button[i].setContentAreaFilled(false);
				button[i].addActionListener(new ExplainButtonListener());
				// 이미지 추출 및 크기 변경
				ImageIcon buttonC_icon = ImageChanger("images/step" + i + "CBtn.png",210, 70);
				ImageIcon button_icon = ImageChanger("images/step" + i + "Btn.png",210, 70);
				button[i].setIcon(button_icon);
				button[i].setPressedIcon(buttonC_icon);
				button[i].setRolloverIcon(buttonC_icon);
				add(button[i]);
			}
			ImageIcon button_icon0 = ImageChanger("images/step0CBtn.png",210, 70);
			button[0].setIcon(button_icon0);
		}
	}
	
	// ExplainPanel (게임 설명 TextArea 패널 클래스)
	class ExplainPanel extends JPanel {
		public ExplainPanel() {
			setOpaque(false);
			explain_image = new JLabel();
			ImageIcon explain_icon = ImageChanger("images/step0.png",650, 350);
			explain_image.setIcon(explain_icon);
			add(explain_image);
			repaint();
		}
	}
	
	class AddPanel extends JPanel {
		public AddPanel() {
			setOpaque(false);
			setLayout(new BorderLayout());
			//setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 0));
			add(new ButtonPanel(), BorderLayout.NORTH);
			add(new ExplainPanel(), BorderLayout.CENTER);
		}
	}

	public GameExplain(boolean team,  int qNum, int time, int teamNum) throws HeadlessException {
		this.teamNum = teamNum;
		this.time = time;
		this.qNum = qNum;
		this.team = team;
		setSize(900, 600);
		MainBackground main = new MainBackground(2);
		main.add(new TitlePanel(), BorderLayout.NORTH);
		main.add(new AddPanel(), BorderLayout.CENTER);
		add(main);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	class ExplainButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==title) {
				new GameMain(team, qNum, time, teamNum);
				setVisible(false);
			}
			for(int i = 0; i < button.length; i++) {
				if(e.getSource() == button[i]) {
					step = i;
					ImageIcon button_icon = ImageChanger("images/step" + i + "CBtn.png",210, 70);
					button[i].setIcon(button_icon);
					
					ImageIcon explain_icon = ImageChanger("images/step"+i+".png",650, 350);
					explain_image.setIcon(explain_icon);
					repaint();
					
				}
				if(e.getSource() != button[i]){
					ImageIcon button_icon = ImageChanger("images/step" + i + "Btn.png",210, 70);
					button[i].setIcon(button_icon);
					repaint();
				}
			}
		}
	}
	
	public void ButtonChanger(JButton button, int width, int height) {
		// 버튼 크기 및 투명도 조절
			button.setPreferredSize(new Dimension(width, height));
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setOpaque(false);
	}
	
	public ImageIcon ImageChanger(String imageLink, int width, int height) {
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon new_icon = new ImageIcon(changedImg);
		return new_icon;
	}
	
	public ImageIcon ImageChanger2(String imageLink) {
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		ImageIcon new_icon = new ImageIcon(originImg);
		return new_icon;
	}

}
