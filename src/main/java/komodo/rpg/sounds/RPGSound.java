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
import komodo.rpg.sounds.util.Localizer;

import org.springframework.beans.factory.InitializingBean;

public class RPGSound extends JFrame implements InitializingBean,
		ActionListener {

	private LibTreePanel treePanel;
	private ProjectPane projectPane;
	private JMenuBar menuBar;
	private JSplitPane splitPane;
	private JToolBar toolBar;

	public void init() {
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		String baseName = "locale";
        setTitle(Localizer.getString("app.name"));
		
		setMinimumSize(new Dimension(800,600));
		splitPane = new JSplitPane();

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
				Localizer.getString("app.icon.play")))));
		global_player.add(new JButton(new ImageIcon(getClass().getResource(
				Localizer.getString("app.icon.pause")))));
		global_player.add(new JButton(new ImageIcon(getClass().getResource(
				Localizer.getString("app.icon.stop")))));
		global_player.add(new JCheckBox(Localizer.getString("app.txt.fadeIn")));
		global_player.add(new JCheckBox(Localizer.getString("app.txt.fadeOut")));

	}

	private void initMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu1 = new JMenu(Localizer.getString("app.menu.file"));
		JMenu menu2 = new JMenu(Localizer.getString("app.menu.edit"));
		menuBar.add(menu1);
		menuBar.add(menu2);

		JMenuItem new_scene = new JMenuItem(Localizer.getString("app.menuitem.newscene.txt"), KeyEvent.VK_N);
		new_scene.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		new_scene.setActionCommand(Localizer.getString("app.menuitem.newscene.cmd"));
		new_scene.addActionListener(this);
		
		JMenuItem load_szene = new JMenuItem(Localizer.getString("app.menuitem.loadscene.txt"), KeyEvent.VK_O);
		load_szene.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
//		load_szene.setEnabled(false); // TODO: implementation missing
		load_szene.setActionCommand(Localizer.getString("app.menuitem.loadscene.cmd"));
		load_szene.addActionListener(this);
		
		JMenuItem save_szene = new JMenuItem(Localizer.getString("app.menuitem.savescene.txt"));
		save_szene.setEnabled(false); // TODO: implementation missing
		save_szene.setActionCommand(Localizer.getString("app.menuitem.savescene.cmd"));
		save_szene.addActionListener(this);
		
		JMenuItem save_szene_as = new JMenuItem(Localizer.getString("app.menuitem.savesceneas.txt"));
		save_szene_as.setEnabled(false); // TODO: implementation missing
		save_szene_as.setActionCommand(Localizer.getString("app.menuitem.savesceneas.cmd"));
		save_szene_as.addActionListener(this);

		JMenuItem exit = new JMenuItem(Localizer.getString("app.menuitem.exit.txt"));
		exit.setActionCommand(Localizer.getString("app.menuitem.exit.cmd"));
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
	public void actionPerformed(ActionEvent event) {
		System.out.println(event);
		
		if (event.getActionCommand().equals(Localizer.getString("app.menuitem.newscene.cmd"))) {
			String proj_name = JOptionPane.showInputDialog(this.getContentPane(),
					"Please provide a scene name:",
					"Create new Szene",
					JOptionPane.QUESTION_MESSAGE);
			if(proj_name != null) {
				projectPane.addScene(proj_name);
			}
		}
		else if (event.getActionCommand().equals(Localizer.getString("app.menuitem.loadscene.cmd"))) {
			JOptionPane.showInternalMessageDialog(getContentPane(), "Not yet implemented"); // TODO
		}
	}

}
