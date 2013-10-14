package komodo.rpg.sounds.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.sound.sampled.AudioInputStream;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class ClipPanel extends JPanel {
	
	public ClipPanel(AudioInputStream audio) {
		setPreferredSize(new Dimension(400, 100));
		
		JPanel panel_left = new JPanel();
//		panel_left.setPreferredSize(new Dimension(50,this.getHeight()));
		panel_left.setBorder(BorderFactory.createLineBorder(Color.RED));
		JLabel lbl_left   = new JLabel("left side");
		panel_left.add(lbl_left);
		this.add(panel_left, BorderLayout.EAST);
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		
		JPanel centerPanel = new JPanel();
		this.add(new JPanel());
	}

}
