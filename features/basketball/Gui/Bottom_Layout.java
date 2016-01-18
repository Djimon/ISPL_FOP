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
	
	
	 
	private List<Spieler> bPlayers = new ArrayList<Spieler>();
	
	
	private int bBall = 10;

	public void _Bottom_Layout(String sport)
	{
		original(sport);
		if (sport == "Basketball"){
			int count = 1;
			for (int i = bBall; i > 0; i --){
				Spieler bPlayer = new Spieler(""+count);
				this.bottom.add(bPlayer.getPlayer());
				this.bPlayers.add(bPlayer);
				count ++;
			}
		}		
	}
	
	
	
	
	public List<Spieler> getBPlayer(){
		return this.bPlayers;
	} 
	
	
	public List getPLayerList(){
	
		if (!this.bPlayers.isEmpty()){
			return this.bPlayers;
		}
		original();
		return null;
	}
}
