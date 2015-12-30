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


public  class  Top_Layout {
	
	private JPanel top = new JPanel(new BorderLayout());

	
	private JPanel left = new JPanel(new GridLayout(3,2));

	
	private JPanel right = new JPanel(new FlowLayout());

	
	private int i_wGames=0;

	
	private int i_lGames=0;

	
	private int i_gamesPasses=0;

	
	private int i_gamesGoals=0;

	
	private int i_tgamesPasses=0;

	
	private int i_tgamesMPasses=0;

	
	private JLabel wGames = new JLabel("Siege:"+i_wGames);

	
	private JLabel lGames = new JLabel("Niederlagen:"+i_lGames);

	
	private JLabel gamesPasses = new JLabel("P?sse je Spiel:"+i_gamesPasses);

	
	private JLabel gamesMPasses = new JLabel("Tore je Spiel:"+i_gamesGoals);

	
	private JLabel tgamesPasses = new JLabel("P?sse im Spiel:"+i_tgamesPasses);

	
	private JLabel tgamesMPasses = new JLabel("Fehlp?sse im Spiel:"+i_tgamesMPasses);

	

	private List<Spieler> fPlayers;

	 
	private List<Spieler> bPlayers;

	
	private List<Spieler> hPlayers;

	
	private List<Spieler> rPlayers;

	
	private List<Spieler> uPlayers;

	

	private File text;

	
	private String lastOpenPath;

	
	private String typeOfSport;

	
	
	public Top_Layout(String sport,List m_PlayerList ){
		this.typeOfSport=sport;
		Dimension d = new Dimension();
		this.top.setMaximumSize(d);
		this.top.add(left, BorderLayout.NORTH);

		this.top.add(right,BorderLayout.EAST);

		left.add(this.wGames);
		left.add(this.lGames);
		left.add(this.gamesPasses);
		left.add(this.gamesMPasses);
		left.add(this.tgamesPasses);
		left.add(this.tgamesMPasses);

		this.b_loadStatistik.addActionListener(loadlis);
		this.b_loseStatistik.addActionListener(lostlis);
		this.b_winStatistik.addActionListener(winlis);
		
		
		
		setPlayerList(sport,m_PlayerList);
		
	}

	
	


	public Top_Layout(String[] teamStatistik){
		//ToDO Teamstatistik laden und dann die Werte eintragen
	}

	
	
	//Getter***********************************************
	public String get_wGames(){
		return this.wGames.getText();
	}

	
	
	public String get_lGames(){
		return this.lGames.getText();
	}

	
	public String get_gamesPasses(){
		return this.gamesPasses.getText();
	}

	
	public String get_gamesMPasses(){
		return this.gamesMPasses.getText();
	}

	
	public String get_tgamesPasses(){
		return this.tgamesPasses.getText();
	}

	
	public String get_tgamesMPasses(){
		return this.tgamesMPasses.getText();
	}

	
	
	public JPanel getTop(){
		top.revalidate();
		return this.top;
	}

	
	
	private List<Spieler> getPlayerList(){
		if (this.typeOfSport == "Fussball"){
			return this.fPlayers ;
		}
		else if (this.typeOfSport  == "Basketball"){
			return this.bPlayers ;
		}
		else if (this.typeOfSport  == "Handball"){
			return this.hPlayers ;
		}
		else if (this.typeOfSport  == "Rugby"){
			return this.rPlayers ;
		}
		else if (this.typeOfSport  == "Ultimate"){
			return this.uPlayers ;
		}
		return null;
	}

	
	
	//Getter***********************************************
	
	//Setter***********************************************
	public void set_wGames(String s){
		this.wGames.setText(s);
	}

	
	
	public void  set_lGames(String s){
		this.lGames.setText(s);
	}

	
	public  void set_gamesPasses(String s){
		this.gamesPasses.setText(s);
	}

	
	public  void set_gamesMPasses(String s){
		this.gamesMPasses.setText(s);
	}

	
	public  void set_tgamesPasses(String s){
		this.tgamesPasses.setText(s);
	}

	
	public  void set_tgamesMPasses(String s){
		this.tgamesMPasses.setText(s);
	}

	
	
	private void setPlayerList(String sport, List m_PlayerList) {
		if (sport == "Fussball"){
			this.fPlayers = m_PlayerList;
		}
		else if (sport == "Basketball"){
			this.bPlayers = m_PlayerList;
		}
		else if (sport == "Handball"){
			this.hPlayers = m_PlayerList;
		}
		else if (sport == "Rugby"){
			this.rPlayers = m_PlayerList;
		}
		else if (sport == "Ultimate"){
			this.uPlayers = m_PlayerList;
		}
		
	}

	
	
	//Setter***********************************************
	
	
	
	
	
	//ActionListener***************************************
		
		private String openFile() {
			JFileChooser fileChooser = null;
			
			if (lastOpenPath != null && !lastOpenPath.equals("")) {
				fileChooser = new JFileChooser(lastOpenPath);
			} else {
				fileChooser = new JFileChooser();
			}
			
			FileFilter typeFilter = new FileFilter() {
				public String getDescription() {
					return "Sound file (*.player)";
				}

				@Override
				public boolean accept(File file) {
					if (file.isDirectory()) {
						return true;
					} else {
						text = file;
						return file.getName().toLowerCase().endsWith(".player");
					}
				}
			};
			return "";
		}


}
