package komodo.rpg.sounds;

import javax.swing.JFrame;
import javax.swing.JTree;

public class RPGSounds extends JFrame {
	
	private JTree clipTree;
	
	public RPGSounds() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		RPGSounds rpgsounds = new RPGSounds();
		rpgsounds.setVisible(true);
		System.out.println("Hello World!");
	}
}
