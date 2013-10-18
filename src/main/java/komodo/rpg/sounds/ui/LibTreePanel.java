package komodo.rpg.sounds.ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class LibTreePanel extends JPanel {
	
	private LibTree libTree;
	
	public LibTreePanel() {
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.add(new JLabel("<html><h1>test</h1></html>"));
		
		add(topPanel, BorderLayout.NORTH);
		
		libTree = new LibTree();
		add(libTree,BorderLayout.CENTER);
	}
}
