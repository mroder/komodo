package komodo.rpg.sounds;

import java.awt.BorderLayout;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import komodo.rpg.sounds.ui.LibTreePanel;
import lombok.Setter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;


public class RPGSound extends JFrame implements InitializingBean {
	
	private LibTreePanel treePanel;
	private JMenuBar menuBar;
	private JSplitPane splitPane;
	private ResourceBundle bundle;

	@Setter
	private MessageSource messages;
	
	public void init() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		String baseName = "locale";
	    try
	    {
	      bundle =   ResourceBundle.getBundle  ( baseName );
	      setTitle(bundle.getString("app.name"));
	    }
	    catch ( MissingResourceException e ) {
	      System.err.println( e );
	    }
		
		initMenu();
		
		createSplitPane();
		
		
		JPanel statusBar = new JPanel();
		statusBar.setLayout(new BoxLayout(statusBar, BoxLayout.LINE_AXIS));
		statusBar.add(new JLabel("Statusbar"));
		
		getContentPane().add(statusBar,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	private void createSplitPane() {
		splitPane = new JSplitPane();
		treePanel = new LibTreePanel();
		splitPane.setAutoscrolls(true);
		splitPane.setOneTouchExpandable(true);
//		splitPane.set
		splitPane.add(treePanel, JSplitPane.LEFT);
		splitPane.add(new JPanel(),JSplitPane.RIGHT);
		getContentPane().add(splitPane);
		
	}

	private void initMenu() {
		menuBar = new JMenuBar();
		
//		System.out.println(bundle.getStringArray("app.menu"));
		
		JMenu menu = new JMenu(bundle.getString("app.menu.file"));
		menuBar.add(menu);
		menu = new JMenu(bundle.getString("app.menu.help"));
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(messages.toString());
		
	}
}
