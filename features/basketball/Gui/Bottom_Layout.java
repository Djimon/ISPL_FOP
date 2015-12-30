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
	
	
	 
	private List<Spieler> bPlayers = new ArrayList<Spieler>();
	
	
	private int bBall = 10;

	
	public Bottom_Layout( String sport){
		
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
	
		else if (!this.bPlayers.isEmpty()){
			return this.bPlayers;
		}
		original();
		return null;
	}
}
