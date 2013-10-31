package komodo.rpg.sounds.ui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import lombok.Getter;

public class ScenePanel extends JPanel {

	@Getter
	JPanel listContainer;
	
	public ScenePanel() {
		setLayout(new BorderLayout());
		setOpaque(true);

		
		listContainer = new JPanel();
		listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));
		
		JScrollPane scroller = new JScrollPane(listContainer);
		scroller.getVerticalScrollBar().setUnitIncrement(24);
		listContainer.add(new ClipPlayerPanel(new File(getClass().getResource("/lib/battle/magic1.wav").getFile())));
		listContainer.add(new ClipPlayerPanel(new File(getClass().getResource("/lib/battle/swing.wav").getFile())));
		listContainer.add(new ClipPlayerPanel(new File(getClass().getResource("/lib/NPC/giant/giant1.wav").getFile())));
		listContainer.add(new ClipPlayerPanel(new File(getClass().getResource("/lib/NPC/giant/giant2.wav").getFile())));
		listContainer.add(new ClipPlayerPanel(new File(getClass().getResource("/lib/NPC/giant/giant3.wav").getFile())));
		listContainer.add(new ClipPlayerPanel(new File(getClass().getResource("/lib/NPC/giant/giant4.wav").getFile())));

		add(scroller, BorderLayout.CENTER);
		add(new JLabel("<html><h3>Action Buttons</h3></html>"), BorderLayout.SOUTH);
	}
}
