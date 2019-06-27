package TermProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameMake extends JFrame implements ActionListener {
	
	private JTextArea userChart;
	private JButton create, update, delete;
	
	public GameMake() {
		setSize(500, 500);
		setLayout(new BorderLayout());
		add(new UserList(), BorderLayout.CENTER);
		add(new btnPanel(),BorderLayout.EAST);
		setVisible(true);
	}
	
	class UserList extends JPanel {
		public UserList() {
			// TODO Auto-generated constructor stub
			userChart = new JTextArea(35, 30);
			setBorder(BorderFactory.createTitledBorder("리스트"));
			userChart.append(" 1. Hard Question(Movie) \n");
			userChart.append(" 2. My Question \n");
			add(userChart);
			userChart.setEditable(false);
			
		}
	}
	class btnPanel extends JPanel {
		public btnPanel() {
			// TODO Auto-generated constructor stub
			setLayout(new GridLayout(7, 0, 0, 20));
			create = new JButton("생성");
			update = new JButton("수정");
			delete = new JButton("삭제");
			add(create);
			add(update);
			add(delete);
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	public static void main(String [] args) {
		GameMake mp = new GameMake();
		
	}
}