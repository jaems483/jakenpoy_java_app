package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

public class jak_en_poy extends JFrame implements ActionListener{
	
	JButton rock,paper,scissors,reset;
	static Label t1 ,t2 ,t3;
	static JLabel background, score;
	static String COMPUTER = null, player = null;
	Border border = BorderFactory.createEmptyBorder();
	Random rnd = new Random();
	static int p1,ai;
	ImageIcon icon = new ImageIcon("main\\stone.png");
	ImageIcon icon2 = new ImageIcon("main\\scissor.png");
	ImageIcon icon3 = new ImageIcon("main\\paper.png");
	
	jak_en_poy(){
		Image img = icon.getImage() ; 
		Image newimg = img.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		
		Image img2 = icon2.getImage() ; 
		Image newimg2 = img2.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon2 = new ImageIcon( newimg2 );
		
		Image img3 = icon3.getImage() ; 
		Image newimg3 = img3.getScaledInstance( 50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon3 = new ImageIcon( newimg3 );
		
		t1 = new Label("|| PLAYER ||");
		t1.setBounds(175, 20, 150, 20);
		t1.setBackground(new Color(52, 49, 26));
		t1.setAlignment(Label.CENTER);
		t1.setForeground(Color.cyan);
		
		t2 = new Label("|| COMPUTER ||");
		t2.setBounds(175, 50, 150, 20);
		t2.setBackground(new Color(52, 49, 26));
		t2.setAlignment(Label.CENTER);
		t2.setForeground(Color.cyan);

		t3 = new Label("|| RESULT ||");
		t3.setBounds(175, 80, 150, 20);
		t3.setBackground(new Color(52, 49, 26));
		t3.setAlignment(Label.CENTER);
		t3.setForeground(Color.cyan);
		
		background = new JLabel(new ImageIcon("main\\wood.gif"));
		background.setBounds(0,0,500,288);
		
		score = new JLabel("P1 VS AI");
		score.setVerticalAlignment(Label.CENTER);
		score.setBounds(12,135,130,150);
		score.setBackground(new Color(0,0,0));
		
		reset = new JButton("RESET");
		reset.setBounds(200, 150, 100, 30);
		reset.addActionListener(this);
		reset.setBorder(border);
		reset.setBackground(Color.red);
		reset.setForeground(Color.cyan);
		reset.setHorizontalTextPosition(JButton.CENTER);
		reset.setVerticalTextPosition(JButton.BOTTOM);
		reset.setVisible(false);
		
		rock = new JButton("ROCK");
		rock.setContentAreaFilled(false);
		rock.setBounds(30, 180, 150, 80);
		rock.addActionListener(this);
		rock.setBorder(border);
		rock.setBackground(new Color(40, 78, 92));
		rock.setFocusable(false);
		rock.setForeground(Color.cyan);
		rock.setHorizontalTextPosition(JButton.CENTER);
		rock.setVerticalTextPosition(JButton.BOTTOM);
		rock.setIcon(icon);
		
		paper = new JButton("PAPER");
		paper.setContentAreaFilled(false);
		paper.setBounds(170, 180, 150, 80);
		paper.addActionListener(this);
		paper.setBorder(border);
		paper.setBackground(new Color(40, 78, 92));
		paper.setFocusable(false);
		paper.setForeground(Color.cyan);
		paper.setHorizontalTextPosition(JButton.CENTER);
		paper.setVerticalTextPosition(JButton.BOTTOM);
		paper.setIcon(icon2);
		
		scissors = new JButton("SCISSORS");
		scissors.setBounds(300, 180, 150, 80);
		scissors.addActionListener(this);
		scissors.setBorder(border);
		scissors.setContentAreaFilled(false);
		scissors.setFocusable(false);
		scissors.setForeground(Color.cyan);
		scissors.setHorizontalTextPosition(JButton.CENTER);
		scissors.setVerticalTextPosition(JButton.BOTTOM);
		scissors.setIcon(icon3);
		
		setVisible(true);
		setLayout(null);
		setSize(515, 325);
		setTitle("JAK EN POY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new GridLayout(2,3,10,10));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().add(background);
		
		background.add(t1);
        background.add(t3);
        background.add(t2);
        background.add(rock);
        background.add(scissors);
        background.add(paper);
        background.add(score);
        background.add(reset);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 int temp = rnd.nextInt(1, 4);
		 if(temp == 1) {
			 COMPUTER = "ROCK";
		 }
		 if(temp == 2) {
			 COMPUTER = "PAPER";
		 }
		 if(temp == 3){
			 COMPUTER = "SCISSORS";
		 }
		 
		 if(e.getSource()==rock) {
			 player = "ROCK";
		 }
		 if(e.getSource()==paper) {
			 player = "PAPER";
		 }
		 if(e.getSource()==scissors) {
			 player = "SCISSORS";
		 }
		 
		 if("ROCK".equalsIgnoreCase(player) && "PAPER".equalsIgnoreCase(COMPUTER)) {
				t1.setText("PLAYER: ROCK");
				t2.setText("COMPUTER: PAPER");
				t3.setText("COMPUTER WINS!!");
				ai++;
			}
			else if("PAPER".equalsIgnoreCase(player) && "ROCK".equalsIgnoreCase(COMPUTER)){
				t1.setText("PLAYER: PAPER");
				t2.setText("COMPUTER: ROCK");
				t3.setText("PLAYER WINS!!");
				p1++;
			}
			else if("ROCK".equalsIgnoreCase(player) && "SCISSORS".equalsIgnoreCase(COMPUTER)) {
				t1.setText("PLAYER: ROCK");
				t2.setText("COMPUTER: SCISSORS");
				t3.setText("PLAYER WINS!!");
				p1++;
			}
			else if("SCISSORS".equalsIgnoreCase(player) && "ROCK".equalsIgnoreCase(COMPUTER)){
				t1.setText("PLAYER: SCISSORS");
				t2.setText("COMPUTER: ROCK");
				t3.setText("COMPUTER WINS!!");
				ai++;
			}
			else if("PAPER".equalsIgnoreCase(player) && "SCISSORS".equalsIgnoreCase(COMPUTER)){
				t1.setText("PLAYER: PAPER");
				t2.setText("COMPUTER: SCISSORS");
				t3.setText("COMPUTER WINS!!");
				ai++;
			}
			else if("SCISSORS".equalsIgnoreCase(player) && "PAPER".equalsIgnoreCase(COMPUTER)){
				t1.setText("PLAYER: SCISSORS");
				t2.setText("COMPUTER: PAPER");
				t3.setText("PLAYER WINS!!");
				p1++;
			}
			else if(player.equalsIgnoreCase(COMPUTER)){
				t1.setText("PLAYER: " + player);
				t2.setText("COMPUTER: " + COMPUTER);
				t3.setText("IT'S A TIE!!");
			}
		 
		 	score.setText("P1:" + p1 + "VS " + "AI: " + ai);
		 	if(p1 == 3) {
		 		score.setText("P1 WINS!");
		 		rock.setVisible(false);
		 		scissors.setVisible(false);
		 		paper.setVisible(false);
		 		reset.setVisible(true);
		 	}
		 	else if(ai == 3) {
		 		score.setText("AI WINS!");
		 		rock.setVisible(false);
		 		scissors.setVisible(false);
		 		paper.setVisible(false);
		 		reset.setVisible(true);
		 	}
		 	
		 	if(e.getSource()==reset) {
		 		rock.setVisible(true);
		 		scissors.setVisible(true);
		 		paper.setVisible(true);
		 		reset.setVisible(false);
		 		ai = 0;
		 		p1 = 0;
		 		score.setText("P1 VS AI");
		 		t1.setText("|| PLAYER ||");
		 		t2.setText("|| COMPUTER ||");
		 		t3.setText("|| RESULT ||");
		 	}
	}
	public static void main(String[] args){
		new jak_en_poy();
	}
}

//public static final String str = "h3ll0 w0rld";
//static void digit(){
//	for(int i = 0; i < str.length(); i++) {
//		if(Character.isDigit(str.charAt(i))) {
//			System.out.print(str.charAt(i));
//		}
//	}
//}
//
//static void letters() {
//	for(int i = 0; i < str.length(); i++) {
//		if(!Character.isDigit(str.charAt(i))) {
//			System.out.print(str.charAt(i));
//		}
//	}
//}
//
//static void reversed_letters() {
//	int x1 = str.length()-1;
//	for(int x = 0; x < str.length(); x++) {
//		if(Character.isDigit(str.charAt(x))) {
//			System.out.print(str.charAt(x));
//		}
//		else {
//			for(; Character.isDigit(str.charAt(x1)); x1--) {
//			}
//			System.out.print(str.charAt(x1));
//			x1--;
//		}
//	}
//}
//
//static void find_w0rld() {
//	int start = str.indexOf("w0rld");
//	int end = start + "w0rld".length();
//	int x = 0;
//	String world = str.substring(start, end);
//	for(int i = 0; i < str.length(); i++) {
//		if (world.charAt(x) == str.charAt(i)) {
//			x++;
//			if(x == world.length()) {
//				System.out.println(world + " found.");
//			}
//		}
//		else {
//			x = 0;
//		}
//	}
//}
//
//
//
//public static void main(String[] args) {
//	digit();
//	System.out.println();
//	letters();
//	System.out.println();
//	reversed_letters();
//	System.out.println();
//	find_w0rld();
//}
//}
