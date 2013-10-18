package komodo.rpg.sounds;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import komodo.rpg.sounds.ui.LibTree;
import komodo.rpg.sounds.ui.LibTreePanel;
import lombok.Setter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;


public class RPGSound extends JFrame implements InitializingBean {
	
	private LibTreePanel treePanel;
	private JMenuBar menuBar;
	
	@Setter
	private MessageSource messages;
	
	public void init() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JSplitPane splitPane = new JSplitPane();
		
//		initMenu();
		
		
		treePanel = new LibTreePanel();
		splitPane.setAutoscrolls(true);
		splitPane.setOneTouchExpandable(true);
		splitPane.add(treePanel, JSplitPane.LEFT);
		splitPane.add(new JPanel(),JSplitPane.RIGHT);
		getContentPane().add(splitPane);
		
		JPanel statusBar = new JPanel();
		statusBar.setLayout(new BoxLayout(statusBar, BoxLayout.LINE_AXIS));
		statusBar.add(new JLabel("Statusbar"));
		
		getContentPane().add(statusBar,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(messages.toString());
		
	}
}
