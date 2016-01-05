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

	
	
	public Top_Layout(String sport,List m_PlayerList ){
		original(sport,m_PlayerList);
		left.add(this.wGames);
		left.add(this.lGames);
		left.add(this.gamesPasses);
		left.add(this.gamesMPasses);
		left.add(this.tgamesPasses);
		left.add(this.tgamesMPasses);
		
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
	
		
		
}
