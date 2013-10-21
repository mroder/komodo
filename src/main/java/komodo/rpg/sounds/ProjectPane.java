package komodo.rpg.sounds;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import komodo.rpg.sounds.ui.ClipPlayerPanel;

public class ProjectPane extends JPanel implements ChangeListener {

	private JTabbedPane tabPane;
	
	public ProjectPane() {
		setLayout(new BorderLayout());
		
		
		tabPane = new JTabbedPane();
		tabPane.addChangeListener(this);
		add(tabPane,BorderLayout.CENTER);
		JPanel i = new JPanel();
		i.setOpaque(false);
//		i.setLayout(new FlowLayout());
		i.add(new ClipPlayerPanel(null));
		i.add(new ClipPlayerPanel(null));
		i.add(new ClipPlayerPanel(null));
		tabPane.addTab("Test 3", i);
		
		
		add(new JLabel("<html><h3>Action Buttons</h3></html>"), BorderLayout.SOUTH);
		
		addScene();
	}
	
	public void addScene() {
		tabPane.addTab("test", new ImageIcon(getClass().getResource("/imgs/icon_play.png")), new JLabel());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println(e.toString());
		System.out.println(tabPane.getTitleAt(tabPane.getSelectedIndex()));
		System.out.println(tabPane.getSelectedIndex());
		System.out.println(tabPane.getComponent(tabPane.getSelectedIndex()));
		
	}
}
