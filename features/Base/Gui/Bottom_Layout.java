package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Objects.Spieler;


public class Bottom_Layout {
	
	private JPanel bottom = new JPanel(new FlowLayout());	
	private List<JButton> bList = new ArrayList<JButton>();
	
	public void _Buttom_Layout(String sport)
	{
		System.out.println("Buttom_Layout initialized");
	}
	
	public Bottom_Layout( String sport){
		_Buttom_Layout(sport);
	}
	
	
	
	public JPanel getBottom(){
		return this.bottom;
	}
	
	

	
	public List getPLayerList(){
		
		
		
		return null;
	}
}
