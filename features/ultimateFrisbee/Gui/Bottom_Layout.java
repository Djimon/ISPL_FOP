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
	

	private List<Spieler> uPlayers = new ArrayList<Spieler>();
	
	private int uTm = 17;
	
	public void _Bottom_Layout( String sport){
		original(sport);		
		if (sport == "Ultimate"){
			int count = 1;
			for (int i = uTm; i > 0; i --){
				Spieler uPlayer = new Spieler(""+count);
				this.bottom.add(uPlayer.getPlayer());
				this.uPlayers.add(uPlayer);
				count ++;
			}
		}
	}
	
 
	public List<Spieler> getUPlayer(){
		return this.uPlayers;
	}
	
	public List getPLayerList(){
		
		if (!this.uPlayers.isEmpty()){
			return this.uPlayers;
		}
		original();
		return null;
	}
}
