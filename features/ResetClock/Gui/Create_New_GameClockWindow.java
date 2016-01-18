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
	
	private JPanel createFrame(String game)
	{
		this.resetButton = new JButton("Reset");
		this.resetButton.addActionListener(resetTimer);
		original(game);
	}
	
	private void resetTimer(){
		this.min = this.gameTime;
		this.sek = 0;
		this.pause= 5000;
		this.currentPart = this.gameParts;
	}
	
	private ActionListener timerEvent = new ActionListener() {
		  public void actionPerformed( ActionEvent e ) 
		  {
			  if(min == 0 && sek == 0 && pause == 0 && currentPart == 0)
			  {	 
				  resetTimer();
				  timer.stop();
			  }
			  original(e);
		  }
	}
	
	private ActionListener resetTimer = new ActionListener() {
		   public void actionPerformed( ActionEvent e ) {
			  resetTimer();
			  original(e);
		  }
	};

}
