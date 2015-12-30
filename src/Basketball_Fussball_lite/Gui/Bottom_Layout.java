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

public   class  Bottom_Layout {
	
	
	private JPanel bottom = new JPanel(new FlowLayout());

		
	private List<JButton> bList = new ArrayList<JButton>();

	

	
	public Bottom_Layout  ( String sport){
	
	
		original(sport);
		if (sport == "Fussball"){
			int count = 1;
			for (int i = fBall; i > 0; i --){
				Spieler fPlayer = new Spieler(""+count);
				this.bottom.add(fPlayer.getPlayer());
				this.fPlayers.add(fPlayer);
				count ++;
			}
		}
		
		
	}

	
	
	
	
	public JPanel getBottom(){
		return this.bottom;
	}

	
	
	

	
	 private List  getPLayerList__wrappee__Base  (){
		
		
		
		return null;
	}

	 
	

	
	public List getPLayerList(){
		if (!this.fPlayers.isEmpty()){
			return this.fPlayers;
		}
		
		getPLayerList__wrappee__Base();
		return null;
	}

	
	
	
	private List<Spieler> fPlayers = new ArrayList<Spieler>();

	 

	
	private int fBall = 14;

	
	
	
	
	public List<Spieler> getFPlayer(){
		return this.fPlayers;
	}


}
