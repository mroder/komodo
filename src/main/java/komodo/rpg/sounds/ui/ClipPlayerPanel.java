package komodo.rpg.sounds.ui;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

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
		setBorder(BorderFactory.createLoweredBevelBorder());
		
//		ImageIcon icon =new ImageIcon(getClass().getResource("/imgs/a2pVM.jpg")); 
//		add(new JLabel(icon));
		
		add(new JLabel("Soundclip1..."));
		
		
		add(new JButton(new ImageIcon(getClass().getResource("/imgs/icon_play.png"))));
		add(new JButton(new ImageIcon(getClass().getResource("/imgs/icon_pause.png"))));
		add(new JButton(new ImageIcon(getClass().getResource("/imgs/icon_stop.png"))));
		
		add(new JCheckBox("Fade in"));
		add(new JCheckBox("Fade out"));
		noiseSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		noiseSlider.setMinorTickSpacing(5);
		noiseSlider.setMajorTickSpacing(25);
		noiseSlider.setPaintTicks(true);
		noiseSlider.setPaintLabels(true);
		add(noiseSlider);
	}

}
