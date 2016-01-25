package Gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import SwingPlayer.SwingAudioPlayer;

public class Main {
	private static List<String> usedSports = new ArrayList<String>();
	public static void main(String[] args) {
		
		original(args);
		
		SwingAudioPlayer mPlayer = new SwingAudioPlayer();
		mPlayer.setRun();
		
		
		
		
		//ToDO Frame for Pro and Elite
	}

}
