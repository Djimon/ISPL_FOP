package SwingPlayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * This class counts playing time in the form of HH:mm:ss
 * It also updates the time slider
 * @author www.codejava.net
 *
 */
public class PlayingTimer extends Thread {
	
	private boolean isPause = false;
	private long pauseTime;
	
	
	
	void pauseTimer() {
		isPause = true;
	}
	
	void resumeTimer() {
		isPause = false;
	}
	

}