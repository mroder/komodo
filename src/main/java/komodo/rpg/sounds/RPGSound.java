package komodo.rpg.sounds;

import java.io.File;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;

import lombok.Setter;


public class RPGSound extends JFrame implements InitializingBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3474677628159223869L;
	private LibTree treeNav;
	
	@Setter
	private MessageSource messages;
	
	public void init() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		
		treeNav = new LibTree();
		splitPane.setAutoscrolls(true);
		splitPane.add(treeNav, JSplitPane.LEFT);
		splitPane.add(new JPanel(),JSplitPane.RIGHT);
		getContentPane().add(splitPane);
		
		setVisible(true);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(messages.toString());
		
	}
}
