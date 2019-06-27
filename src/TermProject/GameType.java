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

import TermProject.GameExplain.ExplainButtonListener;

public class GameType extends JFrame {
	private JButton[] button = new JButton[3];
	private JButton title;
	private int qNum, time, teamNum;
	boolean team;
	static String [] movie = {"����������","��������","��������","�������� ������","������ ����","��������","������������",
			"��������","��������","������ ���� ����","������ ����","����","������","��������","������ ������","������ ��",
			"������","��������","���� ��������","������ ����","��������","���� ������","������ ��������","����������","��������",
			"����","��������","������ ����","��������","������","������","��������","���������� ����","������","����","������",
			"������ ����","������","������","������ ��������","����������","������ ����","�������� ����","���� ������","���� ����",
			"������ ����","����������","����","��������","��������","������ ������","������ ������","������ �� ������","��������",
			"���������� ������","������","��������","�� ���� ������ �������� ����","���� ���� ������ ���� ������","������ ����","����������",
			"����������","�������� ������","������","������","����","���� �� ���� ����","���� ����","������","������","7������ ����","����",
			"����, ���� �� ����","����������","������ ��������","������","������","���� ����"};
	
	static String [] brand = { "�Ƶ�ٽ�", "���ҳ���Ʈ", "����Ƹ�", "�̵��Ŀ��", "�����̽�","����ŷ","����","ȭ����",
			"��Ÿ����","�丮ī��","�׳�ġŲ","�뽺���̽�","���̳�����","Ķ��Ŭ����", "�����", "�ĵ�", "�Ｚ", "�ڼ����Ѻ�",
			"��ȭ", "����Ű","�����","���߶���","ī�亣��","Ŀ����","�Ƶ�����","�Ľ�����","������","��귣��","ó����","����ġŲ",
			"������","�̽�������","�ٶ�","����","���͸�ƾ","�Ե�","�������� ��������", "�ƽĽ�", "ǻ��","���","��ī�ݶ�","���׷�",
			"����","�λ�","���ֿ���","�ƽþƳ�","�����װ�","�̸�Ʈ","Ȩ�÷���","������","�������","������","�ڽ�","Į��Ʈ","�ݽ�",
			"������ ���ݷ�","��Ʈ �����","����","����","���ͷκ꽺Ű","BBQ","��(MAC)","������","������", "��ũ �����߽�","�ѵ�","�ϸ�","��Ű��","�ڿ��� ������"
	}; 
	
	static String [] fourWord = { "���� ����","���� ����","�ٸ� ��Ÿ","�ż� ��ȭ","�޼� ����","�ż� ���","�Ƶ� ����", "���� �ȱ�","��� ġŲ","��Ÿ ����","�˶� �ð�","���� ����","�ż� ����","�Ƶ� �ٽ�","��ġ ���","ũ�� �Ľ�",
			"���� ��","�׸� ����","���� �ϵ�","�Ե� ����","���� ����","õ�� â��","���� �ڻ�","���� ��","� ����","�ƹ� ����","���� ���","���� ����","���� ����","���� ��ī","���� �׷�","���� ��ȣ","�ƴ� ����","Ȩ�� ����", 
			"��� ��ȣ","�޴� ��ȭ","���� ��","�ظ� ����","��¥ ��Ʈ","�ع� ���","�η� ġ��","���� ����","�׸� �ϱ�","��� ����","�ΰ� ����","���� �ܰ�","���� ����","���� ġŲ","�и� ����","���� ��ġ","���� ����","���� ���", 
			"���� ģ��","���� ��Ƽ","���� �ø�","��� ����","���� ��Ƽ","�η� ����","���� ����","ġ�� ����","���� ��","��� �Ƹ�","�ҳ� �ô�","���� Ƣ��","���� ���","���� �ȱ�","���� ����","��� ����","���� ����","�ý� ���",
			"���� ���","��� ����","���� õ��","�߹� ����","�汹 ����","�� ����","���� ȣȣ","ȣ�� ����","��� ���","��� ����","���� ���","��� ���","���� ���","���� �ϻ�","��� ���","��� �ʰ�","��� �ʷ�","���� ����",
			"���� �ǽ�", "�ɱ� ����", "�ɻ� ����","���� ����","���� ����","��� ���","���� �δ�","���� ����","���� ����","���� ����","���� ����"};
	
	public GameType(boolean team, int qNum, int time, int teamNum) {
		// TODO Auto-generated constructor stub
		this.team = team;
		this.qNum = qNum;
		this.time = time;
		this.teamNum = teamNum;
		
		setSize(900, 600);
		MainBackground main = new MainBackground(0);
		main.add(new TitlePanel(), BorderLayout.NORTH);
		main.add(new ButtonPanel(), BorderLayout.CENTER);
		main.add(new JLabel(" "+ team+ qNum+ time+" "), BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		add(main);
		setVisible(true);
	}
	
	// TitlePanel (���� ���� ȭ�� �ΰ� ���� �г� Ŭ����)
	class TitlePanel extends JPanel {
		public TitlePanel() {
			// layout
			setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
			setOpaque(false);
			
			title = new JButton();
			// �̹��� ���� �� ũ�� �����ϱ�
			ImageIcon originIcon = new ImageIcon("images/GameTypeTitle.png");
			Image originImg = originIcon.getImage();
			Image changedImg = originImg.getScaledInstance(350, 70, Image.SCALE_SMOOTH);
			ImageIcon title_icon = new ImageIcon(changedImg);
			title.setIcon(title_icon);
			ButtonChanger(title, 350, 70);
			title.addActionListener(new TypeButtonListener());
			add(title);
		}
	}
	// ButtonPanel (���� ������ ���� ��ư �г� Ŭ����)
	class ButtonPanel extends JPanel {
		public ButtonPanel() {

			// layout
			setLayout(new GridLayout(3, 0, 5, 5));
			setOpaque(false);

			// button
			for (int i = 0; i < button.length; i++) {
				button[i] = new JButton();
				button[i].setPreferredSize(new Dimension(200, 80));
				button[i].setBorderPainted(false);
				button[i].setContentAreaFilled(false);
				button[i].addActionListener(new btnListener());

				// �̹��� ���� �� ũ�� ����
				ImageIcon originIcon2 = new ImageIcon("images/gamebutton" + i + ".png");
				Image originImg2 = originIcon2.getImage();
				Image changedImg2 = originImg2.getScaledInstance(200, 80, Image.SCALE_SMOOTH);
				ImageIcon button_icon = new ImageIcon(changedImg2);
				button[i].setIcon(button_icon);
				add(button[i]);
			}
		}
	}
	
	class TypeButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==title) {
				new GameMain(team, qNum, time, teamNum);	
				setVisible(false);
			}
		}
	}
	
	class btnListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button[0]) {
			/**��ȭ ���� ����**/
			if(team == false) {
				new Question1Panel("movie", movie, qNum, time,teamNum);
				setVisible(false);
			} else {
				new Question2Panel("movie", movie, qNum, time, teamNum);
				setVisible(false);
			}
			
		}
		if(e.getSource() == button[1]) {
			/**�귣�� ����**/
			if(team == false) {
				new Question1Panel("brand", brand, qNum, time, teamNum);
				setVisible(false);
		} else {
			new Question2Panel("brand", brand, qNum, time, teamNum);
			setVisible(false);
		}
		}
		if(e.getSource() == button[2]) {
			/**�ױ��� ����**/
			if(team == false) {
			new Question1Panel("fourWord", fourWord, qNum, time, teamNum);
			setVisible(false);
		} else {
			new Question2Panel("foruWord", fourWord, qNum, time, teamNum);
			setVisible(false);
		}
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
}

