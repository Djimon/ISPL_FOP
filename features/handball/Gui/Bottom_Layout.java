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
	

	private List<Spieler> hPlayers = new ArrayList<Spieler>();

	private int hBall = 13;

	
	public void _Bottom_Layout( String sport){
		original(sport);
		if (sport == "Handball"){
			int count = 1;
			for (int i = hBall; i > 0; i --){
				Spieler hPlayer = new Spieler(""+count);
				this.bottom.add(hPlayer.getPlayer());
				this.hPlayers.add(hPlayer);
				count ++;
			}
		}
	}
	

	

	public List<Spieler> getHPlayer(){
		return this.hPlayers;
	} 

	
	public List getPLayerList(){
	
		if (!this.hPlayers.isEmpty()){
			return this.hPlayers;
		}
		original();
		return null;
	}
}
