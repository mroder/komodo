package komodo.rpg.sounds;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import komodo.rpg.sounds.ui.LibTreePanel;
import lombok.Setter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;

public class RPGSound extends JFrame implements InitializingBean {

	private LibTreePanel treePanel;
	private JMenuBar menuBar;
	private JToolBar toolBar;

	@Setter
	private MessageSource messages;

	public void init() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();

		initMenu();
		initToolbar();

		treePanel = new LibTreePanel();
		splitPane.setAutoscrolls(true);
		splitPane.setOneTouchExpandable(true);
		splitPane.add(treePanel, JSplitPane.LEFT);
		splitPane.add(new ProjectPane(), JSplitPane.RIGHT);
		getContentPane().add(splitPane);

		JPanel statusBar = new JPanel();
		statusBar.setLayout(new BoxLayout(statusBar, BoxLayout.LINE_AXIS));
		statusBar.add(new JLabel("Statusbar"));
		statusBar.setBorder(BorderFactory.createEtchedBorder());
		getContentPane().add(statusBar, BorderLayout.SOUTH);

		setVisible(true);
	}

	private void initToolbar() {
		toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel global_player = new JPanel();
		global_player.setBackground(toolBar.getBackground());
		toolBar.add(global_player);
		
		global_player.add(new JButton(new ImageIcon(getClass().getResource("/imgs/icon_play.png"))));
		global_player.add(new JButton(new ImageIcon(getClass().getResource("/imgs/icon_pause.png"))));
		global_player.add(new JButton(new ImageIcon(getClass().getResource("/imgs/icon_stop.png"))));
		global_player.add(new JCheckBox("Fade in"));
		global_player.add(new JCheckBox("Fade out"));

	}

	private void initMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu1 = new JMenu("Datei");
		menuBar.add(menu1);

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(messages.toString());

	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() 
	    {
	        public void run() 
	        {
	            RPGSound sound = new RPGSound();
	            sound.init();
	        }
	    });
	}
}
