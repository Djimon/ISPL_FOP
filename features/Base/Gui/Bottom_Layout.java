package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Objects.BasketballSpieler;
import Objects.FussballSpieler;
import Objects.HandballSpieler;
import Objects.RugbySpieler;
import Objects.Spieler;
import Objects.UltimateSpieler;

public class Bottom_Layout {
	
	private JPanel bottom = new JPanel(new FlowLayout());	
	private List<JButton> bList = new ArrayList<JButton>();
	
	public Bottom_Layout( String sport){
	
	}
	
	
	
	public JPanel getBottom(){
		return this.bottom;
	}
	
	

	
	public List getPLayerList(){
		
		
		
		return null;
	}
}
