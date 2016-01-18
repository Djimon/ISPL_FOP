package Gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Create_New_GameClockWindow {
	
	private Timer timer;
	private int sek=0;
	private int min;
	private int gameTime;
	private int gameParts = 0;
	private int currentPart=0;
	private JLabel l_timer = new JLabel("00:00");
	private JFrame f ;
	private JPanel g_mainPanel;
	private JPanel buttonPanel;
	private JButton startButton;
	private JButton resetButton;
	private int pause = 5000;
	private String game;
	private String h = "Halbzeit";
	private String d = "Drittel";
	private String q = "Quater";
	private String s = "Spielzeit";
	
	
	//Construktor***************************************
	public Create_New_GameClockWindow(String m_game, int m_gameParts, int partTime, boolean runningClock){
		this.gameTime = partTime;
		this.min = this.gameTime;
		this.gameParts = m_gameParts;
		this.currentPart = 1;
		this.game = m_game;
		this.g_mainPanel = createFrame(game);
		this.g_mainPanel.add(createGameLable(), BorderLayout.NORTH);
		
	}
	//Construktor***************************************
	
	
	




	//Methoden***************************************
	private JPanel createFrame(String game){
		f = new JFrame("GameClock: " + game);
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.buttonPanel = new JPanel(new FlowLayout());
		this.startButton = new JButton("Start");
		this.startButton.addActionListener(this.startTimer);
		this.buttonPanel.add(startButton);
		this.buttonPanel.add(resetButton);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize(300, 300);
		Point p = new Point();
			  p.x = 950;
			  p.y = 400;
		f.setLocation(p);
		f.add(mainPanel);
		this.timer = new Timer(100, timerEvent);
		return mainPanel;
	}
	
	
	
	private JLabel createGameLable() {
		if(this.game == "Fussball" || this.game == "Handball")
		{
			this.l_timer.setText(this.h + " " + this.currentPart + this.min + ":" + this.sek);
		}
		if(this.game == "Basketball")
		{
			this.l_timer.setText(this.q + " " + this.currentPart + this.min + ":" + this.sek);
		}

		if(this.game == "Rugby")
		{
			this.l_timer.setText(this.h + " " + this.currentPart + this.min + ":" + this.sek);
		}
		if(this.game == "Ultimate")
		{
			this.l_timer.setText(this.s + " " + this.currentPart + this.min + ":" + this.sek);
		}
		return this.l_timer;
	}
	
	private void resetLable(){
		this.l_timer.setText(this.h + " " + this.currentPart + this.min + ":" + this.sek);
	}
	
	public void setVisible(){
		this.f.setVisible(true);
	}
	//Methoden***************************************
	
	//GuiMethoden***************************************
	//GuiMethoden***************************************
	
	//ActionListener***************************************
		private ActionListener timerEvent = new ActionListener() {
			  public void actionPerformed( ActionEvent e ) {
				  if (min != 0 && sek != 0){
					  sek--;
				  }				  
				  resetLable();
				  if (min == 0 && sek == 0){
					  // ToDo Ring bell or play Jingel
					  pause--;					  
				  }
				  if(sek == 0){
					  sek = 60;
					  min--;
				  }
				 if(min == 0 && sek == 0 && pause == 0 && currentPart == 0){
					  timer.stop();
				  }				  
			  }
			};
		
		private ActionListener startTimer = new ActionListener() {
			   public void actionPerformed( ActionEvent e ) {
				  timer.start();
			  }
		};
		

	//ActionListener***************************************
}
