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
public class SwingAudioPlayer extends JFrame implements ActionListener 
{	
	private String audioFilePath;
	private AudioPlayer player = new AudioPlayer();
	private String lastOpenPath;	
	private JButton buttonOpen = new JButton("Open");
	JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));		
		
	public void _SwingAudioPlayer() {
		original();
		panelButtons.add(buttonOpen);				
		buttonOpen.addActionListener(this);	
	}

	/**
	 * Handle click events on the buttons.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		JButton button = (JButton) source;
		if (source instanceof JButton) {
			original(event);
			if (button == buttonOpen) {
				openFile();
			}  
		}
	}

	private void openFile() {
		JFileChooser fileChooser = null;
		
		if (lastOpenPath != null && !lastOpenPath.equals("")) {
			fileChooser = new JFileChooser(lastOpenPath);
		} else {
			fileChooser = new JFileChooser();
		}
		
		FileFilter wavFilter = new FileFilter() {
			@Override
			public String getDescription() {
				return "Sound file (*.WAV)";
			}

			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) {
					return true;
				} else {
					return file.getName().toLowerCase().endsWith(".wav");
				}
			}
		};

		
		fileChooser.setFileFilter(wavFilter);
		fileChooser.setDialogTitle("Open Audio File");
		fileChooser.setAcceptAllFileFilterUsed(false);

		int userChoice = fileChooser.showOpenDialog(this);
		if (userChoice == JFileChooser.APPROVE_OPTION) {
			audioFilePath = fileChooser.getSelectedFile().getAbsolutePath();
			lastOpenPath = fileChooser.getSelectedFile().getParent();
			if (isPlaying || isPause) {
				stopPlaying();
				while (player.getAudioClip().isRunning()) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
			playBack();
		}
	}

	private void playBack() {
		
		try
		{
			player.load(audioFilePath);
		}
		catch (IOException ex)
		{
			JOptionPane.showMessageDialog(SwingAudioPlayer.this,  
					"I/O error while playing the audio file!", "Error", JOptionPane.ERROR_MESSAGE);
			resetControls();
			ex.printStackTrace();
		}
		catch (UnsupportedAudioFileException ex)
		{
			JOptionPane.showMessageDialog(SwingAudioPlayer.this,  
					"The audio format is unsupported!", "Error", JOptionPane.ERROR_MESSAGE);
			resetControls();
			ex.printStackTrace();
		}  
		catch (LineUnavailableException ex)
		{
			JOptionPane.showMessageDialog(SwingAudioPlayer.this,  
					"Could not play the audio file because line is unavailable!", "Error", JOptionPane.ERROR_MESSAGE);
			resetControls();
			ex.printStackTrace();
		}  
		original();
	}
	


}