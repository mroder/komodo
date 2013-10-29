package komodo.rpg.sounds.ui.waveform;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WaveFormPanelContainer extends JPanel {
	private ArrayList singleChannelWaveformPanels = new ArrayList();
	private AudioInfo audioInfo = null;
	
	public WaveFormPanelContainer() {
		setLayout(new GridLayout(0, 1));
	}
	
	public void setAudioToDisplay(AudioInputStream audioInputStream) {
		singleChannelWaveformPanels = new ArrayList();
		audioInfo = new AudioInfo(audioInputStream);
		
		for (int i = 0; i < audioInfo.getNumberOfChannels(); i++) {
			SingleWaveformPanel waveFormPanel = new SingleWaveformPanel(audioInfo, i);
			singleChannelWaveformPanels.add(waveFormPanel);
			add(createChannelDisplay(waveFormPanel,i));
		}
	}

	private Component createChannelDisplay(SingleWaveformPanel waveFormPanel,
			int i) {
		JPanel p = new JPanel(new BorderLayout());
		p.add(waveFormPanel, BorderLayout.CENTER);
		
		JLabel lbl = new JLabel("Channel "+ ++i);
		p.add(lbl,BorderLayout.NORTH);
		return p;
	}

}
