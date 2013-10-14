package komodo.rpg.sounds;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTree;

import komodo.rpg.sounds.ui.ClipPanel;

public class RPGSounds extends JFrame {
	
	private JTree clipTree;
	
	public RPGSounds() {
		super("RPG Sounds");
		
		JMenuBar menubar = new JMenuBar();
		
		JMenu file = new JMenu("Datei");
		menubar.add(file);
		JMenuItem menu_new = new JMenuItem("Neu...");
		file.add(menu_new);
		JMenuItem menu_open = new JMenuItem("Open...");
		file.add(menu_open);
		file.add(new JSeparator());
		JMenuItem menu_exit = new JMenuItem("Beenden");
		file.add(menu_exit);
		
		this.setJMenuBar(menubar);
		
		
		JPanel scrollpane_panel = new JPanel();
		JScrollPane scrollpane = new JScrollPane(scrollpane_panel);
		scrollpane_panel.setLayout(new BoxLayout(scrollpane_panel, BoxLayout.PAGE_AXIS));
		for(int i=0; i<10; i++)
			scrollpane_panel.add(new ClipPanel(null));
		this.getContentPane().add(scrollpane);
		
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		RPGSounds rpgsounds = new RPGSounds();
		rpgsounds.setVisible(true);
		System.out.println("Hello World!");
	}
}
