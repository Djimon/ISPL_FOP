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
	

	private List<Spieler> rPlayers = new ArrayList<Spieler>();

	private int rGby  = 15;
	
	public Bottom_Layout( String sport){
		original(sport);	
		if (sport == "Rugby"){
			int count = 1;
			for (int i = rGby; i > 0; i --){
				Spieler rPlayer = new Spieler(""+count);
				this.bottom.add(rPlayer.getPlayer());
				this.rPlayers.add(rPlayer);
				count ++;
			}
		}
	}
	

	public List<Spieler> getRPlayer(){
		return this.rPlayers;
	} 
	
	
	public List getPLayerList(){
	
		else if (!this.rPlayers.isEmpty()){
			return this.rPlayers;
		}
		original();
		return null;
	}
}
