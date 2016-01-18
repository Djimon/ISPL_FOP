package SwingPlayer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;

/**
 * A Swing-based audio player program.
 * NOTE: Can play only WAVE (*.wav) file.
 * @author www.codejava.net
 *
 */
public class SwingAudioPlayer extends JFrame implements ActionListener {
	private AudioPlayer player = new AudioPlayer();
	private PlayingTimer timer;
	private Thread playbackThread;
	private JButton buttonPause = new JButton("Pause");
	private boolean isPlaying = false;
	private boolean isPause = false;
	
	public void _SwingAudioPlayer() {
		original();
		panelButtons.add(buttonPause);
		buttonPause.addActionListener(this);
	}
	

	/**
	 * Handle click events on the buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		JButton button = (JButton) source;
		original(event);		
		if (button == buttonPause) {
				if (!isPause) {
					pausePlaying();
				} else {
					resumePlaying();
				}
			}
	}

	public void _run()
	{
		buttonPause.setText("Pause");
		buttonPause.setEnabled(true);
		original();
	}

	
	private void resetControls() {
		buttonPause.setEnabled(false);
		original();
	}
	
	private void pausePlaying() {
		buttonPause.setText("Resume");
		isPause = true;
		player.pause();
		timer.pauseTimer();
		playbackThread.interrupt();
	}
	
	private void resumePlaying() {
		buttonPause.setText("Pause");
		isPause = false;
		player.resume();
		timer.resumeTimer();
		playbackThread.interrupt();		
	}
	
	
	


}