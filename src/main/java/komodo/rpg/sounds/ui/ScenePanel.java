package komodo.rpg.sounds.ui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ScenePanel extends JPanel {

	private Box box;
	
	public ScenePanel() {
		setLayout(new BorderLayout());
		setOpaque(true);

		box = Box.createVerticalBox();
		
		JScrollPane scroller = new JScrollPane(box);
		scroller.getVerticalScrollBar().setUnitIncrement(24);
		box.add(new ClipPlayerPanel(null));
		box.add(new ClipPlayerPanel(null));
		box.add(new ClipPlayerPanel(null));
		box.add(new ClipPlayerPanel(null));
		box.add(new ClipPlayerPanel(null));
		box.add(new ClipPlayerPanel(null));
		box.add(new ClipPlayerPanel(null));
		box.add(new ClipPlayerPanel(null));
		box.add(new ClipPlayerPanel(null));
		box.add(new ClipPlayerPanel(null));
		add(scroller, BorderLayout.CENTER);
		add(new JLabel("<html><h3>Action Buttons</h3></html>"), BorderLayout.SOUTH);
	}
}
