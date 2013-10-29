package komodo.rpg.sounds;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import komodo.rpg.sounds.ui.LibTreePanel;

import org.springframework.beans.factory.InitializingBean;

public class RPGSound extends JFrame implements InitializingBean,
		ActionListener {

	private LibTreePanel treePanel;
	private ProjectPane projectPane;
	private JMenuBar menuBar;
	private JSplitPane splitPane;
	private ResourceBundle bundle;

	private JToolBar toolBar;

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
		
		setMinimumSize(new Dimension(800,600));
		JSplitPane splitPane = new JSplitPane();

		initMenu();
		initToolbar();

		treePanel = new LibTreePanel();
		splitPane.setAutoscrolls(true);
		splitPane.setOneTouchExpandable(true);
		splitPane.add(treePanel, JSplitPane.LEFT);
		projectPane = new ProjectPane();
		splitPane.add(projectPane, JSplitPane.RIGHT);
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

		global_player.add(new JButton(new ImageIcon(getClass().getResource(
				"/imgs/icon_play.png"))));
		global_player.add(new JButton(new ImageIcon(getClass().getResource(
				"/imgs/icon_pause.png"))));
		global_player.add(new JButton(new ImageIcon(getClass().getResource(
				"/imgs/icon_stop.png"))));
		global_player.add(new JCheckBox("Fade in"));
		global_player.add(new JCheckBox("Fade out"));

	}

	private void initMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu1 = new JMenu("Datei");
		JMenu menu2 = new JMenu("Bearbeiten");
		menuBar.add(menu1);
//		menuBar.add(menu2)

		JMenuItem new_scene = new JMenuItem("Neue Szene", KeyEvent.VK_N);
		new_scene.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		new_scene.setActionCommand("newscene");
		new_scene.addActionListener(this);
		
		JMenuItem load_szene = new JMenuItem("Szene laden...", KeyEvent.VK_O);
		load_szene.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		load_szene.setEnabled(false); // TODO: implementation missing
		load_szene.setActionCommand("loadscene");
		load_szene.addActionListener(this);
		
		JMenuItem save_szene = new JMenuItem("Szene speichern");
		save_szene.setEnabled(false); // TODO: implementation missing
		save_szene.setActionCommand("savescene");
		save_szene.addActionListener(this);
		
		JMenuItem save_szene_as = new JMenuItem("Szene speichern unter...");
		save_szene_as.setEnabled(false); // TODO: implementation missing
		save_szene_as.setActionCommand("saveSceneAs");
		save_szene_as.addActionListener(this);

		JMenuItem exit = new JMenuItem("Beenden");
		exit.setActionCommand("appclose");
		exit.addActionListener(this);

		menu1.add(new_scene);
		menu1.add(load_szene);
		menu1.add(save_szene);
		menu1.add(save_szene_as);
		menu1.add(new JSeparator());
		menu1.add(exit);
		
		

	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				RPGSound sound = new RPGSound();
				sound.init();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0);
		
		if (arg0.getActionCommand().equals("newscene")) {
			String proj_name = JOptionPane.showInputDialog(this.getContentPane(),
					"Please provide a scene name:",
					"Create new Szene",
					JOptionPane.QUESTION_MESSAGE);
			if(proj_name != null) {
				projectPane.addScene(proj_name);
			}
		}
		else if (arg0.getActionCommand().equals("loadscene")) {
			System.out.println("In loading scene");
		}
	}

}
