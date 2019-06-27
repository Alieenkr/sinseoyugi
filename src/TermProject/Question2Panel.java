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

public class Question2Panel extends JFrame{
	private int count=0, qNum, team, time;
	private int [] score;
	private String dir;
	private JLabel timer, question, result, questionText;
	private JButton[] teamBtn;
	private JButton menuBtn;
	private String [] file;
	private ArrayList<String> quiz, data;

	public Question2Panel(String dir, String[] file, int qNum, int time, int team) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setTitle("Question2Panel");
		
		this.dir = dir;
		this.file = file;
		this.team = team;
		this.qNum = qNum;
		this.time = time;
		random(file);
		
		score = new int[team];
		
		teamBtn = new JButton[team];
		for(int i = 0; i< team; i++) {
			teamBtn[i] = new JButton((i+1) + "ÆÀ");
			score[i]=0;
		}
		
		MainBackground main = new MainBackground(1);
		main.add(new HeadPanel(),BorderLayout.NORTH);
		main.add(new QPanel(), BorderLayout.CENTER);
		main.add(new BtnPanel(), BorderLayout.SOUTH);
		add(main);

		setVisible(true);
	}
	
	public Question2Panel(String dir, String[] file, int qNum, int time, int team, ArrayList data) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);
		setTitle("Question2Panel");
		
		this.dir = dir;
		this.file = file;
		this.team = team;
		this.qNum = qNum;
		this.time = time;
		random(file);
		
		score = new int[team];
		
		teamBtn = new JButton[team];
		for(int i = 0; i< team; i++) {
			teamBtn[i] = new JButton((i+1) + "ÆÀ");
			score[i]=0;
		}
		
		MainBackground main = new MainBackground(1);
		
		main.add(new HeadPanel(),BorderLayout.NORTH);
		main.add(new QPanel(), BorderLayout.CENTER);
		main.add(new BtnPanel(), BorderLayout.SOUTH);
		add(main);

		setVisible(true);
	}
	
	class HeadPanel extends JPanel {
		public HeadPanel() {
			setOpaque(false);
			
			//menuBtn
			menuBtn = new JButton();
			menuBtn.addActionListener(new btnListener2());
			ImageChanger(menuBtn, "images/title.png",160,40);
			
			//timer
			timer = new JLabel("");
			timer.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 30));
			timer.setHorizontalAlignment(SwingConstants.CENTER);
			timer.setForeground(Color.WHITE);
			
			//result
			result = new JLabel(count + "/" + (qNum));
			result.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 30));
			result.setHorizontalAlignment(SwingConstants.RIGHT);
			result.setForeground(Color.WHITE);
			result.setBorder(new EmptyBorder(0, 0, 0, 40));

			setLayout(new GridLayout(0, 3));
			setBorder(new EmptyBorder(20, 0, 0, 0));
			add(menuBtn);
			add(timer);
			add(result);
		}
	}
	
	class QPanel extends JPanel{
		public QPanel() {
			setOpaque(false);
			setLayout(new BorderLayout());
			
			//question
			question = new JLabel();
			question.setHorizontalAlignment(JLabel.CENTER);
			
			//questionText
			questionText = new JLabel();
			questionText.setHorizontalAlignment(JLabel.CENTER);
			questionText.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 100));
			questionText.setForeground(Color.WHITE);
			
			changePicture(dir, quiz.get(count));
			add(question, BorderLayout.NORTH);
			add(questionText, BorderLayout.CENTER);
		}
	}
	
	class BtnPanel extends JPanel{
		public BtnPanel() {
			setOpaque(false);
			setBorder(new EmptyBorder(0, 0, 20, 0));
			if(team<5) {
				setLayout(new GridLayout(0, team, 5, 0));
			}else {
				setLayout(new GridLayout(2, team, 5, 0));
			}
			for(int i = 0; i< team; i++) {
				ImageChanger(teamBtn[i], "images/team"+i+".png",60,60);
				teamBtn[i].setForeground(Color.WHITE);
				teamBtn[i].setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 20));
				teamBtn[i].addActionListener(new btnListener());
				add(teamBtn[i]);	
			}
		}
	}
	
	class btnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<team; i++) {
			if(e.getSource() == teamBtn[i]) {
				count++;
				score[i]+=1;
				if(count == qNum) {
					changeFrame();
					}
				changePicture(dir, quiz.get(count));
				}
			}
		}
	}
	class btnListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == menuBtn) {
				new GameMain(true, qNum, time, team);
				setVisible(false);
			}
		}
	}
	
	protected void random(String[] name) {
		quiz = new ArrayList<String>();
		data = new ArrayList<String>(100);
		do {
			int random = (int)(Math.random()*name.length);
			String inputData = name[random];
			if(data.contains(inputData)) {
					continue;
			}
			else {
					data.add(inputData);
					quiz.add(inputData);	
			}
		} while (quiz.size()<qNum) ;
	}
	
	protected void changeFrame() {
		new Question2Result(dir, file, qNum, time, team, score, data);
		setVisible(false);
	}
	
    protected void changePicture(String dir, String name) {
        ImageIcon icon = new ImageIcon(dir+ "/" + name + ".png");
        question.setIcon(icon);
        if (icon != null) {
                question.setText(null);
                questionText.setText(name + "");
                result.setText((count+1) + "/" + (qNum));
                
        }else{        		
        	question.setVisible(false);
        }
    }
    
    public JButton ImageChanger(JButton button, String imageLink, int width, int height) {
    	
    	// ¹öÆ° Å©±â ¹× Åõ¸íµµ Á¶Àý
    	button.setPreferredSize(new Dimension(width, height));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setOpaque(false);
		
		// ÀÌ¹ÌÁö ÃßÃâ ¹× Å©±â º¯°æ
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon new_icon = new ImageIcon(changedImg);
		
		button.setIcon(new_icon);
		
		return button;
	}

}
