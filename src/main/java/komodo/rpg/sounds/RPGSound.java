package komodo.rpg.sounds;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class RPGSound extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3474677628159223869L;
	private LibTree treeNav; 
	
	public RPGSound() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("./lib").getFile());
		treeNav = new LibTree(file);
		splitPane.setAutoscrolls(true);
		splitPane.add(treeNav, JSplitPane.LEFT);
		splitPane.add(new JPanel(),JSplitPane.RIGHT);
		getContentPane().add(splitPane);
		
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new RPGSound();
	}
}
