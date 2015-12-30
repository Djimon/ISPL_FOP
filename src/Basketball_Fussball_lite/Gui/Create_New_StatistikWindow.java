package Gui; 

import java.awt.BorderLayout; 
import java.awt.FlowLayout; 
import java.awt.GridLayout; 
import java.awt.Point; 
import java.awt.ScrollPane; 
import java.util.ArrayList; 
import java.util.List; 

import javax.swing.JFrame; 
import javax.swing.JPanel; 

import Objects.BasketballSpieler; 
import Objects.FussballSpieler; 
import Objects.HandballSpieler; 
import Objects.RugbySpieler; 
import Objects.UltimateSpieler; 

public  class  Create_New_StatistikWindow {
	
	private JFrame f;

	
	private JPanel mainPanel = new JPanel(new BorderLayout());

	
	private JFrame m_parent;

	
	public String g_sport;

	
	private Top_Layout top;

	
	private List<Object> PlayerList;

	
	

	
	public Create_New_StatistikWindow(String sport, JFrame parent){
		this.m_parent = parent;
		this.g_sport = sport;
		
	
		
	}

	

	private void Add_Bottom_Top(String s) {
		// TODO Auto-generated method stub
		Bottom_Layout b = new Bottom_Layout(s);
		ScrollPane sc = new ScrollPane();
		
		this.mainPanel.add(b.getBottom(), BorderLayout.CENTER);
		
	}

	



	private void Add_Top(List pList) {
		Top_Layout t = new Top_Layout(g_sport, pList);
		this.top = t;
		this.mainPanel.add(t.getTop(), BorderLayout.NORTH);
	}

	

	private void Creat_Window(String sport) {
		f = new JFrame(sport);
		f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		f.setSize(1400, 600);
		Point p = new Point();
			  p.x = 100;
			  p.y = 0;
		f.setLocation(p);
		f.add(mainPanel);
		f.setVisible(true);
	}

	
	
	private void redraw()
	{
	    f.revalidate();
	    f.repaint();
	    f.pack();
	}


}
