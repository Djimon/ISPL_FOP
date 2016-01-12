package Gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import SwingPlayer.SwingAudioPlayer;

public class Main {
	private static List<String> usedSports = new ArrayList<String>();
	public static void main(String[] args) {
		
		usedSports.add("Fussball");
	
		
		

		

		
		Create_New_MainWindow w = new Create_New_MainWindow(250,250,"SportStatistikCenter Lite",usedSports);
		
		SwingAudioPlayer mPlayer = new SwingAudioPlayer();
		
		
		
		w.setVisilbe();
		
		mPlayer.setRun();
		
		
		//ToDO Frame for Pro and Elite
	}

}
