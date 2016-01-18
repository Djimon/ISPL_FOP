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

import Objects.Spieler;


public class Create_New_StatistikWindow 
{
	private JFrame f;
	private JPanel mainPanel = new JPanel(new BorderLayout());
	private JFrame m_parent;
	public String g_sport;
	private Top_Layout top;
	private List<Object> PlayerList;
	

	public void _Create_New_StatistikWindow(String sport, JFrame parent)
	{
		original(sport,parent);		
		if (sport =="Basketball"){
			Creat_Window("Basketball");
			
			Add_Bottom_Top(sport);	
		}
	}
	
	private void Add_Bottom_Top(String s) 
	{
		Bottom_Layout b = new Bottom_Layout(s);
		original(s);
		if (s == "Basketball"){
			Add_Top(b.getBPlayer());
		}
		
	}



	
}
