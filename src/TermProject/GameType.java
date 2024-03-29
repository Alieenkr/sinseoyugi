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
	static String [] movie = {"ぜけいしぜ","ぞぉそぜ","ぞぁぁし","げぞけし ぉさぇ","ささせ ぜず","しししけ","じさぜさぉぁ",
			"げぉそさ","ぁししぁ","さしぇ しげ けじ","さぉぁ しぞ","ぜす","げぜぉ","さぉずぁ","いいし しぇぁ","ぜぉけ さ",
			"げさぞ","いげじぇ","けさ しそさげ","げじし じし","けぜぉさ","げぁ しぁし","しさし しぉぇし","さそしぇけ","しげじさ",
			"ぞせ","じぜそし","いぞぉ じし","ぜしぜぁ","しじざ","じぁし","せそそぇ","せぉげしし ぞじ","けさせ","けぉ","ずぁじ",
			"しぇし ずけ","せじぉ","しいげ","げぉさ しけしぜ","しぜさぜぉ","しげし ぜし","そぉさぜ ぁそ","いし しぉし","ぉぉ ぉぇ",
			"けいし しさ","ぉけじぉげ","ぉし","ぁぉげぜ","ぁぞじし","さぇぉ ぉさぜ","しぜい ささし","げぜけ ぇ さそけ","ぁぉぉぜ",
			"さしさしぇ させぇ","しさけ","ぇしぞぇ","ぁ さじ しぉぁ じしぞぇ さい","いい いし しじし いし けいぇ","さげし じじ","ぜぉさそけ",
			"そしいさぜ","じじずし しげぇ","ぁしし","ぞしぇ","ぉし","けぞ さ しい げけ","さぁ ぞあ","しげぜ","ぇぇぇ","7げげし さけ","しさ",
			"ぁぞ, しし ぇ いじ","ぜさしじさ","ぜぁぁ ぞいぉけ","げぞし","さけぇ","しし いじ"};
	
	static String [] brand = { "焼巨陥什", "児社蟹戚闘", "情希焼袴", "戚巨醤朕杷", "軒郊戚什","獄暗天","因託","鉢裾戚",
			"什展漉什","凪軒朝蟹","革革帖轍","葛什凪戚什","亀耕葛杷切","超朔適虞昔", "壕含搭", "田巨", "誌失", "酵綬橿廃差",
			"廃鉢", "蟹戚徹","功鷺櫛","敢降空什","朝凪今革","朕獄慨","呼亀劾球","督什庭卓","時神耕","葛崎沓球","坦茜増","荏革帖轍",
			"牽何塊","耕什斗杷切","蕃虞","推奄推","韓斗原鴇","茎汽","壕斗走澗 持儀亜什", "焼縦什", "濃原","奄焼","坪朝紬虞","桜益傾",
			"背殿","砧至","薦爽拭嬢","焼獣焼蟹","企廃牌因","戚原闘","幡巴君什","杷切矧","辞崎裾戚","珍獄什","韓什","町馬闘","鋼什",
			"稽戚綜 段紬型","杉闘 巨綜艦","時楽","姥卓","什人稽崎什徹","BBQ","呼(MAC)","伯走什","獄獄軒", "原滴 薦戚吊什","廃儀","馬顕","呼徹什","坪神荊 什匂苧"
	}; 
	
	static String [] fourWord = { "人戚 督戚","尻走 逸走","郊軒 什展","重紗 舛鉢","厭紗 中穿","重紗 壕含","呼亀 劾球", "淑掻 独姥","丞割 帖轍","什展 趨綜","硝寓 獣域","厩嬢 紫穿","重辞 政奄","焼巨 陥什","凧帖 沿剛","滴傾 督什",
			"識越 虞什","益軒 什亀","穿虞 栽亀","茎汽 軒焼","紫切 失嬢","探走 但繕","疑号 酵紫","諦辞 搾什","嬢鍵 戚増","汎肯 舛製","室曽 企腎","督昔 蕉巴","神塘 郊戚","什匂 苧朝","覗稽 益轡","域疎 腰硲","焼澗 莫還","幡凪 戚走", 
			"搾腔 腰硲","妃企 穿鉢","褐託 虞脅","背軒 匂斗","乞促 牽闘","背郊 虞奄","砧欠 帖奄","巷廃 亀穿","益顕 析奄","域空 源戚","昔因 走管","失莫 須引","左球 惟績","娃舌 帖轍","歳軒 呪暗","壕蓄 沿帖","爽税 紫牌","社覗 虞葛", 
			"食切 庁姥","什督 惟銅","郊戚 臣鍵","鷺欠 燈什","焼戚 什銅","採欠 原鷺","匂舌 原託","帖綜 追斥","段坪 虞脅","情希 焼袴","社橿 獣企","歯酔 蕩沿","掬走 壱奄","淑掻 独姥","壱遭 姶掘","嬢採 走軒","引企 諺雌","獣獣 搾搾",
			"穿穿 園園","企奄 幻失","鯵引 探識","胃弘 持宿","井厩 走事","壱浦 歳燈","亜亜 硲硲","硲尻 走奄","誤叔 雌採","詞重 失昔","繕誌 乞誌","号号 溢溢","舛舛 雁雁","姥紫 析持","紫持 衣舘","紫檎 段亜","誌壱 段形","竺雌 亜雌",
			"買買 叔叔", "宿奄 析穿", "宿紫 寿壱","蝕走 紫走","神軒 巷掻","遂砧 紫耕","酔政 採舘","政姥 巷情","歯針 走原","析昼 杉舌","莫竺 走因"};
	
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
	
	// TitlePanel (惟績 識澱 鉢檎 稽壱研 是廃 鳶確 適掘什)
	class TitlePanel extends JPanel {
		public TitlePanel() {
			// layout
			setLayout(new FlowLayout(FlowLayout.LEFT, 30, 30));
			setOpaque(false);
			
			title = new JButton();
			// 戚耕走 蓄窒 貢 滴奄 痕井馬奄
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
	// ButtonPanel (惟績 識澱聖 是廃 獄動 鳶確 適掘什)
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

				// 戚耕走 蓄窒 貢 滴奄 痕井
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
			/**慎鉢 薦鯉 訂綜**/
			if(team == false) {
				new Question1Panel("movie", movie, qNum, time,teamNum);
				setVisible(false);
			} else {
				new Question2Panel("movie", movie, qNum, time, teamNum);
				setVisible(false);
			}
			
		}
		if(e.getSource() == button[1]) {
			/**崎沓球 訂綜**/
			if(team == false) {
				new Question1Panel("brand", brand, qNum, time, teamNum);
				setVisible(false);
		} else {
			new Question2Panel("brand", brand, qNum, time, teamNum);
			setVisible(false);
		}
		}
		if(e.getSource() == button[2]) {
			/**革越切 訂綜**/
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
		
		// 戚耕走 蓄窒 貢 滴奄 痕井
		ImageIcon originIcon = new ImageIcon(imageLink);
		Image originImg = originIcon.getImage();
		Image changedImg = originImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon new_icon = new ImageIcon(changedImg);
		
		return new_icon;
	}
	
	public void ButtonChanger(JButton button, int width, int height) {
		// 獄動 滴奄 貢 燈誤亀 繕箭
			button.setPreferredSize(new Dimension(width, height));
			button.setBorderPainted(false);
			button.setContentAreaFilled(false);
			button.setFocusable(false);
			button.setOpaque(false);
	}
}

