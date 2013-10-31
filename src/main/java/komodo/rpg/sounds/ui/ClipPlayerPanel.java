package komodo.rpg.sounds.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import komodo.rpg.sounds.ui.waveform.AudioInfo;
import komodo.rpg.sounds.ui.waveform.SingleWaveformPanel;
import lombok.Getter;
import lombok.Setter;


public class ClipPlayerPanel extends JPanel {
	
	@Getter
	@Setter
	private File soundClip;
	
	private int loudnes = 0;
	private JSlider noiseSlider;
	
	public ClipPlayerPanel(File sound_Clip) {
		this.soundClip = sound_Clip;
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setLayout(new BorderLayout());
		setMaximumSize(new Dimension(1024,100));
		setMinimumSize(new Dimension(1024,100));
		setPreferredSize(new Dimension(1024,100));
		setFocusable(true);
		setAutoscrolls(true);
		setBackground(Color.GREEN);
		
		JPanel content = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		AudioInputStream audioInputStream;
		AudioInfo info = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(sound_Clip)));
			info = new AudioInfo(audioInputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (info != null) {
			content.add(new SingleWaveformPanel(info));	
		}
		
		add(new JLabel("<html><h3>"+soundClip.getName()+"</h3></html>"),BorderLayout.PAGE_START);
		
		
		content.add(new JButton(new ImageIcon(getClass().getResource("/imgs/icon_play.png"))));
		content.add(new JButton(new ImageIcon(getClass().getResource("/imgs/icon_pause.png"))));
		content.add(new JButton(new ImageIcon(getClass().getResource("/imgs/icon_stop.png"))));
		
		content.add(new JCheckBox("Fade in"));
		content.add(new JCheckBox("Fade out"));
		noiseSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		noiseSlider.setMinorTickSpacing(5);
		noiseSlider.setMajorTickSpacing(25);
		noiseSlider.setPaintTicks(true);
		noiseSlider.setPaintLabels(true);
		content.add(noiseSlider);
		add(content,BorderLayout.CENTER);
	}

}
