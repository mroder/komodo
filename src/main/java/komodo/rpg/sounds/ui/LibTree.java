package komodo.rpg.sounds.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import komodo.rpg.sounds.ProjectPane;
import komodo.rpg.sounds.SoundClip;
import komodo.rpg.sounds.util.Localizer;
import lombok.Setter;

public class LibTree extends JPanel implements TreeSelectionListener, MouseListener {
	private File basedir = new File(LibTree.class.getResource("/lib").getFile());
	private JTree tree;
	
	@Setter
	private ProjectPane projectPane;

	public LibTree() {
		setLayout(new BorderLayout());
		basedir  =new File(getClass().getResource("/lib").getFile());
		System.err.println(basedir);
		
		tree = new JTree();
		tree.setRootVisible(true);
		tree.addMouseListener(this);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.addTreeSelectionListener(this);
		((DefaultTreeModel)tree.getModel()).setRoot(new DefaultMutableTreeNode("Libs"));
		addNodes((DefaultMutableTreeNode)tree.getModel().getRoot(), basedir);
		((DefaultTreeModel)tree.getModel()).reload();
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
						.getPath().getLastPathComponent();
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(tree);
		add(scrollPane,BorderLayout.CENTER);
		setMinimumSize(new Dimension(200, 400));
		setPreferredSize(new Dimension(200,400));
	}

	private DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) {
		String curPath = dir.getPath();
		DefaultMutableTreeNode curDir = new DefaultMutableTreeNode(new File(curPath).getName());
		
		if(curTop != null) {
			curTop.add(curDir);
		}

		Vector<String> ol = new Vector<String>();
		String[] tmp = dir.list();
		
		for ( int i=0; i < tmp.length; i++ ) {
			ol.addElement( tmp[i] );
		}
		Collections.sort(ol,String.CASE_INSENSITIVE_ORDER);
		File f;
		Vector<String> files = new Vector<String>();
		for( int i = 0; i < ol.size(); i++ ) {
			String thisObject = ol.elementAt(i);
			String newPath ;
			if(curPath.equals(".")) {
				newPath = thisObject;
			}
			else {
				newPath = curPath + File.separator + thisObject;
			}
			if((f = new File(newPath)).isDirectory()) {
				curDir.setAllowsChildren(true);
				addNodes(curDir, f);
			}
			else {
				try {
					AudioSystem.getAudioFileFormat(new File(curPath + File.separator + thisObject));
					files.addElement(new SoundClip(curPath + File.separator + thisObject, thisObject).toString());
				} catch (UnsupportedAudioFileException e) {
					System.err.println("not a sound-file: " + thisObject);
					
				} catch (IOException e) {
					System.err.println("--- not a sound-file: " + thisObject);
				}
				
			}
		}
		
		for ( int fnum = 0; fnum < files.size(); fnum ++) {
//			System.out.println(curPath + System.getProperty("file.separator")+files.elementAt(fnum));
//			DefaultMutableTreeNode node1 = new DefaultMutableTreeNode();
//			node1.
			curDir.add(new DefaultMutableTreeNode(files.elementAt(fnum)));
		}
		return curDir;
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2) {
			System.out.println((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent());
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
			ScenePanel m = (ScenePanel) projectPane.getTabPane().getSelectedComponent();
			if (m != null) {
				System.out.println(m.getListContainer().add(new ClipPlayerPanel(new File(getClass().getResource("/lib/battle/magic1.wav").getFile()))));
				m.revalidate();
			}
			else {
				JOptionPane.showMessageDialog(this.getParent().getParent(), Localizer.getString("error.noActiveScene.txt"));
			}
			
			if(node.isLeaf()) {
				System.out.println("I'm a soundfile ???");
			}
			else {
				System.out.println("Do nothing");
			}
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		((JComponent) this.getParent()).setBorder(BorderFactory.createLineBorder(Color.GREEN,1));
		((JComponent) this.getParent()).revalidate();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		((JComponent) this.getParent()).setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		((JComponent) this.getParent()).revalidate();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
