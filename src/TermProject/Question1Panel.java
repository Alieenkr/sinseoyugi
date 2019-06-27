package TermProject;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Question1Panel extends JFrame{
	private int count=0, score=0, qNum, time, teamNum;
	private String dir;
	private String [] file;
	private ArrayList<String> quiz, data;
	private ArrayList <Integer> rank;
	
	private JLabel timer, question, result, questionText;
	private JButton falseBtn, passBtn, trueBtn, menuBtn;
	private String [] game1Btn = {"falseBtn", "passBtn", "trueBtn"};
	private TimerThread timeThread ;
	
	public Question1Panel(String dir, String[] file, int qNum, int time, int teamNum) {

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.dir = dir;
		this.file = file;
		/*********************************/
		this.time = time; 
		this.qNum = qNum;
		this.teamNum = teamNum;
		random(file);
		timeThread = new TimerThread();
		rank = new ArrayList(); 
		
		setSize(900, 600);
		MainBackground main = new MainBackground(1);
		main.add(new HeadPanel(),BorderLayout.NORTH);
		main.add(new QPanel(), BorderLayout.CENTER);
		main.add(new BtnPanel(), BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		add(main);
		setVisible(true);
		}
	
	//오버로딩
	public Question1Panel(String dir, String[] file, int qNum, int time, int teamNum, ArrayList rankList, ArrayList data) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.dir = dir;
		this.file = file;
		this.time = time;
		this.qNum = qNum;
		//결과값과 다회차 플레이를 위한 데이터 저장 코드
		this.rank = rankList;
		this.data = data;
		random(file);
		timeThread = new TimerThread();
		
		setSize(900, 600);
		MainBackground main = new MainBackground(1);
		main.add(new HeadPanel(),BorderLayout.NORTH);
		main.add(new QPanel(), BorderLayout.CENTER);
		main.add(new BtnPanel(), BorderLayout.SOUTH);

		setLocationRelativeTo(null);
		add(main);
		setVisible(true);
	}
	
	
	class HeadPanel extends JPanel {
		public HeadPanel() {
			setOpaque(false);
			
			//menuBtn
			menuBtn = new JButton();
			ImageChanger(menuBtn, "images/title.png",160,40);
			menuBtn.addActionListener(new PanelButtonListener());
			
			//timer
			timer = new JLabel("시간");
			timer.setFont(new Font("나눔바른고딕", Font.BOLD, 50));
			timer.setHorizontalAlignment(SwingConstants.CENTER);
			timer.setForeground(Color.WHITE);
			
			//result
			result = new JLabel(count + "/" + (qNum));
			result.setFont(new Font("고딕", Font.BOLD, 30));
			result.setHorizontalAlignment(SwingConstants.RIGHT);
			result.setForeground(Color.WHITE);
			result.setBorder(new EmptyBorder(0, 0, 0, 40));
			
			setLayout(new GridLayout(0, 3, 50, 0));
			setBorder(new EmptyBorder(20, 0, 0, 0));
			add(menuBtn);
			add(timer);
			add(result);
			timeThread.setDaemon(true);
			timeThread.start();
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
			questionText.setFont(new Font("나눔바른고딕", Font.BOLD, 100));
			questionText.setForeground(Color.WHITE);
			
			changePicture(dir, quiz.get(count));
			add(question, BorderLayout.NORTH);
			add(questionText, BorderLayout.CENTER);
		}
	}
	
	class BtnPanel extends JPanel{
		public BtnPanel() {
			setOpaque(false);
			
			falseBtn = new JButton();
			ImageChanger(falseBtn, "images/falseBtn.png",110,60);
			
			passBtn = new JButton();
			ImageChanger(passBtn, "images/passBtn.png",110,60);
			
			trueBtn = new JButton();
			ImageChanger(trueBtn, "images/trueBtn.png",110,60);
			
			setLayout(new GridLayout(0, 3, 10, 0));
			setBorder(new EmptyBorder(0, 0, 20, 0));
			add(falseBtn);
			add(passBtn);
			add(trueBtn);
		}
	}
	class btnListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		//이터레이터로 출력 가능한지 알아보기
		if(e.getSource() == trueBtn) {
			count++;
			score++;
			if(count == qNum) {
				timeThread.cancel();
				//changeFrame();
				}
			changePicture(dir, quiz.get(count));
		}
		
		if(e.getSource() == passBtn) {
			count++;
				if(count == qNum) {
		    	timeThread.cancel();
				//changeFrame();
				}
				changePicture(dir, quiz.get(count));
			}

		// 뒤로가기 버튼
		if(e.getSource() == falseBtn) {
			count--;
			score--;
			changePicture(dir, quiz.get(count));
		}
	}
}
	
	class TimerThread extends Thread {
		private volatile boolean shutdown = false;
		private volatile boolean forMain = false;
		public void run() {
			for (int i = time; i>=0; i--) {
				try {
					Thread.sleep(1000);
			  } catch(InterruptedException e) {
					e.printStackTrace();}
				catch(IndexOutOfBoundsException e) {
					e.printStackTrace();}
				timer.setText(" "+ (i)+ " ");
				
				if(i == 10) {
					timer.setForeground(Color.red);
					timer.setFont(new Font("나눔바른고딕", Font.BOLD, 80));
					repaint();
			  } if(i == 0 || shutdown==true) {
					changeFrame();
					synchronized (this) {
						break; }
			  } if(forMain==true) {
					synchronized (this) {
						break;
					}}}}
		
		public void cancel() {
			synchronized (this) {
				this.shutdown = true;
			}
			}
		public void forM() {
			synchronized (this) {
				this.forMain = true;
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
		//오버로딩하면 해결가능
		new Question1Result(dir, file, qNum, time, teamNum, score, rank, data);
		setVisible(false);
	}	
	
    protected void changePicture(String dir, String name) {
        ImageIcon icon = new ImageIcon(dir+ "/" + name + ".png");
        question.setIcon(icon);
        if (icon != null) {
                question.setText(null);
                questionText.setText(name + "");
                result.setText((count+1) + "/" + (qNum));
        } else {
        		question.setVisible(false);
        }
    }
    
    class PanelButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==menuBtn) {
				new GameMain(true, qNum, time, teamNum);	
				timeThread.forM();
				setVisible(false);
			}
		}
	}
    //GUI관련 메소드
    //이미지 크기 변경하기
    public JButton ImageChanger(JButton button, String imageLink, int width, int height) {
    	
    	// 버튼 크기 및 투명도 조절
		button.addActionListener(new btnListener());
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
}
