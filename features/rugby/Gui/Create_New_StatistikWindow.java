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

public class Create_New_StatistikWindow {
	private JFrame f;
	private JPanel mainPanel = new JPanel(new BorderLayout());
	private JFrame m_parent;
	public String g_sport;
	private Top_Layout top;
	private List<Object> PlayerList;
	

	
	public Create_New_StatistikWindow(String sport, JFrame parent){
		original(sport,parent);
		
		if (sport =="Rugby"){
			Creat_Window("Rugby");
			
			Add_Bottom_Top(sport);	
		}
		
	}

	private void Add_Bottom_Top(String s) {
		original(s);
		else if (s == "Rugby"){
			Add_Top(b.getBPlayer());
		}
		
	}



	
}
