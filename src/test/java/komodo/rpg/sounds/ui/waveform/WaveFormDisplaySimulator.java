package komodo.rpg.sounds.ui.waveform;

import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class WaveFormDisplaySimulator {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedAudioFileException, IOException {
		JFrame frame = new JFrame("WaveForm Simulator");
		frame.setBounds(200, 200, 500, 350);
		
		File file = new File(WaveFormDisplaySimulator.class.getResource("/lib/battle/swing.wav").getFile());
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
		
//		System.out.println(AudioSystem.get);
		WaveFormPanelContainer cont = new WaveFormPanelContainer();
		cont.setAudioToDisplay(audioInputStream);
		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(cont,BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
