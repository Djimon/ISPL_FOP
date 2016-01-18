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
	

	
	





	
	
	//Methoden***************************************
	
	//GuiMethoden***************************************
	//GuiMethoden***************************************
	
	//ActionListener***************************************
		private ActionListener timerEvent = new ActionListener() {
			  public void actionPerformed( ActionEvent e )
			  {
				  if(min == 0 && sek == 0 && pause == 0 && currentPart != 0)
				  {
					  currentPart--;
					  pause = 5000;
					  min = gameTime;
					  sek = 0;
				  }	
				  original(e);
			  }
			};
		
		
	//ActionListener***************************************
}
