package Gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Objects.Spieler;


public class Top_Layout {

	
	private JButton b_loadStatistik = new JButton("Statistik Laden");
	

	
	public Top_Layout(String sport,List m_PlayerList ){
	   original(sport,m_PlayerList);
		
		right.add(this.b_loadStatistik);

		
		
		
	}
	


	
	

	
	

	
	//ActionListener***************************************
	private ActionListener loadlis = new ActionListener() {
		  @Override public void actionPerformed( ActionEvent e ) {
			  
			  load();
			  
		  }
		};

		/* TName.xsave:
		 * Siege,Niederlage,Pass_voll,Pass_fehl,Pass_jeSP,Tor_jeSP,anzSP;
		 * Spielernummer-vollst_pass-fehl_pass-vorlage-Tore,
		 * Spielernummer-vollst_pass-fehl_pass-vorlage-Tore,
		 * Spielernummer-vollst_pass-fehl_pass-...; //erstes Spiel
		 * Spielernummer-vollst_pass-fehl_pass-vorlage-Tore,
		 * Spielernummer-vollst_pass-fehl_pass-vorlage-Tore,
		 * Spielernummer-vollst_pass-fehl_pass-...; // zweites Spiel
		 * ...
		 */
		
	private ActionListener lostlis = new ActionListener() {
		  @Override public void actionPerformed( ActionEvent e ) {
			  //lostgames++
			  int los = i_lGames++;
			  set_lGames(Integer.toString(los));
			  
			  save();
			  //TODO: close Statistik-Fenster
		  }
		};
		
	private ActionListener winlis = new ActionListener() {
		  @Override public void actionPerformed( ActionEvent e ) {
			  // wongames ++
			  int won = i_wGames++;
			  set_wGames(Integer.toString(won));
			  
			  save();
			  
		  }
		};
		
	private void save()
	{
		  String teamname="Team"; //TODO: Teamname abfragen User-Eingabe
		  String suffix;
		  switch (typeOfSport)
		  {
		  case "Fussball": suffix = ".fsave";
			  break;
		  case "Basketball": suffix = ".bsave";
			  break;
		  case "Handball": suffix =".hsave";
			  break;
		  case "Rugby": suffix = ".rsave";
			  break;
		  case "Ultimate": suffix = "usave";
			  break;
			  default: suffix = ".xsave";
		  }
		  Archiv.setFilepath("src/saves/" + teamname + suffix);
		  
		  String game = Integer.toString(this.i_wGames)+","+
				  		Integer.toString(this.i_lGames)+","+
				  		Integer.toString(this.i_tgamesPasses)+","+
				  		Integer.toString(this.i_tgamesMPasses)+","+
				  		Integer.toString(this.i_gamesPasses)+","+
				  		Integer.toString(this.i_gamesGoals)+
				  		",";
	
		  try {Archiv.save(getPlayerList(), game);} 
		  catch (Exception e) {e.printStackTrace();}
	}	
	
	
	private void load()
	{	
		String[] gamestats = Archiv.loadSaves(typeOfSport);
		System.out.println("spieler-split:");
	    System.out.println(gamestats);
		//Gamestats setzen
		i_wGames = Integer.parseInt(gamestats[0]);
		i_lGames = Integer.parseInt(gamestats[1]);
		i_tgamesPasses = Integer.parseInt(gamestats[2]);
		i_tgamesMPasses = Integer.parseInt(gamestats[3]);
		i_gamesPasses = Integer.parseInt(gamestats[4]);
		i_gamesGoals = Integer.parseInt(gamestats[5]);
		
		//neue Spielerlist TODO: fenster neu laden?
		List<Spieler> playerlist = Archiv.getPList(gamestats);
		
		
		
	}
	
	//ActionListener***************************************
		

		
		
}
