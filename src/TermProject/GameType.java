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
	static String [] movie = {"ㅌㅁㄴㅇㅌ","ㅎㄹㅍㅌ","ㅎㄱㄱㅇ","ㅂㅎㅁㅇ ㄹㅅㄷ","ㅅㅅㅋ ㅌㅊ","ㅇㅇㅇㅁ","ㅈㅅㅌㅅㄹㄱ",
			"ㅂㄹㅍㅅ","ㄱㅇㅇㄱ","ㅅㅇㄷ ㅇㅂ ㅁㅈ","ㅅㄹㄱ ㅇㅎ","ㅌㅉ","ㅂㅌㄹ","ㅅㄹㅊㄱ","ㄴㄴㅇ ㅇㄷㄱ","ㅌㄹㅁ ㅅ",
			"ㅂㅅㅎ","ㄴㅂㅈㄷ","ㅁㅅ ㅇㅍㅅㅂ","ㅂㅈㅇ ㅈㅇ","ㅁㅌㄹㅅ","ㅂㄱ ㅇㄱㅇ","ㅇㅅㅇ ㅇㄹㄷㅇ","ㅅㅍㅇㄷㅁ","ㅇㅂㅈㅅ",
			"ㅎㅋ","ㅈㅌㅍㅇ","ㄴㅎㄹ ㅈㅇ","ㅌㅇㅌㄱ","ㅇㅈㅆ","ㅈㄱㅇ","ㅋㅍㅍㄷ","ㅋㄹㅂㅇㅇ ㅎㅈ","ㅁㅅㅋ","ㅁㄹ","ㅊㄱㅈ",
			"ㅇㄷㅇ ㅊㅁ","ㅋㅈㄹ","ㅇㄴㅂ","ㅂㄹㅅ ㅇㅁㅇㅌ","ㅇㅌㅅㅌㄹ","ㅇㅂㅇ ㅌㅇ","ㅍㄹㅅㅌ ㄱㅍ","ㄴㅇ ㅇㄹㅇ","ㄹㄹ ㄹㄷ",
			"ㅁㄴㅇ ㅇㅅ","ㄹㅁㅈㄹㅂ","ㄹㅇ","ㄱㄹㅂㅌ","ㄱㅎㅈㅇ","ㅅㄷㄹ ㄹㅅㅌ","ㅇㅌㄴ ㅅㅅㅇ","ㅂㅌㅁ ㄷ ㅅㅍㅁ","ㄱㄹㄹㅌ",
			"ㅅㅇㅅㅇㄷ ㅅㅋㄷ","ㅇㅅㅁ","ㄷㅇㅎㄷ","ㄱ ㅅㅈ ㅇㄹㄱ ㅈㅇㅎㄷ ㅅㄴ","ㄴㄴ ㄴㅇ ㅇㅈㅇ ㄴㅇ ㅁㄴㄷ","ㅅㅂㅇ ㅈㅈ","ㅌㄹㅅㅍㅁ",
			"ㅍㅇㄴㅅㅌ","ㅈㅈㅊㅇ ㅇㅂㄷ","ㄱㅇㅇ","ㅎㅇㄷ","ㄹㅇ","ㅁㅎ ㅅ ㅇㄴ ㅂㅁ","ㅅㄱ ㅎㄲ","ㅇㅂㅌ","ㄷㄷㄷ","7ㅂㅂㅇ ㅅㅁ","ㅇㅅ",
			"ㄱㅎ, ㅇㅇ ㄷ ㄴㅈ","ㅌㅅㅇㅈㅅ","ㅌㄱㄱ ㅎㄴㄹㅁ","ㅂㅎㅇ","ㅅㅁㄷ","ㅇㅇ ㄴㅈ"};
	
	static String [] brand = { "아디다스", "샘소나이트", "언더아머", "이디야커피", "리바이스","버거킹","공차","화웨이",
			"스타벅스","페리카나","네네치킨","노스페이스","도미노피자","캘빈클라인", "배달통", "탠디", "삼성", "박술녀한복",
			"한화", "나이키","몽블랑","뉴발란스","카페베네","커버낫","맥도날드","파스쿠찌","샤오미","노브랜드","처갓집","굽네치킨",
			"르꼬끄","미스터피자","휠라","요기요","닥터마틴","롯데","배터지는 생돈가스", "아식스", "퓨마","기아","코카콜라","빙그레",
			"해태","두산","제주에어","아시아나","대한항공","이마트","홈플러스","피자헛","서브웨이","컨버스","닥스","칼하트","반스",
			"로이즈 초콜렛","월트 디즈니","샤넬","구찌","스와로브스키","BBQ","맥(MAC)","헤지스","버버리", "마크 제이콥스","한돈","하림","맥키스","코오롱 스포츠"
	}; 
	
	static String [] fourWord = { "와이 파이","연지 곤지","바리 스타","신속 정화","급속 충전","신속 배달","맥도 날드", "십중 팔구","양념 치킨","스타 워즈","알람 시계","국어 사전","신서 유기","아디 다스","참치 김밥","크레 파스",
			"선글 라스","그리 스도","전라 북도","롯데 리아","사자 성어","천지 창조","동방 박사","퀵서 비스","어린 이집","훈민 정음","세종 대왕","파인 애플","오토 바이","스포 츠카","프로 그램","계좌 번호","아는 형님","홈페 이지", 
			"비밀 번호","휴대 전화","녹차 라떼","해리 포터","모짜 르트","해바 라기","두루 치기","무한 도전","그림 일기","계란 말이","인공 지능","성형 외과","보드 게임","간장 치킨","분리 수거","배추 김치","주의 사항","소프 라노", 
			"여자 친구","스파 게티","바이 올린","블루 투스","아이 스티","부루 마블","포장 마차","치즈 케익","초코 라떼","언더 아머","소녀 시대","새우 튀김","돼지 고기","십중 팔구","고진 감래","어부 지리","과대 망상","시시 비비",
			"전전 긍긍","대기 만성","개과 천선","견물 생심","경국 지색","고군 분투","가가 호호","호연 지기","명실 상부","살신 성인","조삼 모삼","방방 곡곡","정정 당당","구사 일생","사생 결단","사면 초가","삼고 초려","설상 가상",
			"허허 실실", "심기 일전", "심사 숙고","역지 사지","오리 무중","용두 사미","우유 부단","유구 무언","새옹 지마","일취 월장","형설 지공"};
	
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
	
	// TitlePanel (게임 선택 화면 로고를 위한 패널 클래스)
	class TitlePanel extends JPanel {
		public TitlePanel() {
			// layout
			setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
			setOpaque(false);
			
			title = new JButton();
			// 이미지 추출 및 크기 변경하기
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
	// ButtonPanel (게임 선택을 위한 버튼 패널 클래스)
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

				// 이미지 추출 및 크기 변경
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
			/**영화 제목 퀴즈**/
			if(team == false) {
				new Question1Panel("movie", movie, qNum, time,teamNum);
				setVisible(false);
			} else {
				new Question2Panel("movie", movie, qNum, time, teamNum);
				setVisible(false);
			}
			
		}
		if(e.getSource() == button[1]) {
			/**브랜드 퀴즈**/
			if(team == false) {
				new Question1Panel("brand", brand, qNum, time, teamNum);
				setVisible(false);
		} else {
			new Question2Panel("brand", brand, qNum, time, teamNum);
			setVisible(false);
		}
		}
		if(e.getSource() == button[2]) {
			/**네글자 퀴즈**/
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
		
		// 이미지 추출 및 크기 변경
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
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

