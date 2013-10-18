package komodo.rpg.sounds.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import komodo.rpg.sounds.SoundClip;

public class LibTree extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8389735641162835378L;
	
	private File basedir = new File(getClass().getClassLoader().getResource("./lib").getFile());

	public LibTree() {
		setLayout(new BorderLayout());
		System.out.println(basedir);
		JTree tree = new JTree(addNodes(null, basedir));
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e
						.getPath().getLastPathComponent();
				System.out.println("You selected : "+node);
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
				addNodes(curDir, f);
			}
			else {
				try {
					AudioSystem.getAudioFileFormat(new File(curPath + File.separator + thisObject));
					files.addElement(new SoundClip(curPath + File.separator + thisObject, thisObject).toString());
				} catch (UnsupportedAudioFileException e) {
					System.err.println("not a sound-file: " + thisObject);
					
				} catch (IOException e) {
					System.err.println("not a sound-file: " + thisObject);
				}
			}
		}
		
		for ( int fnum = 0; fnum < files.size(); fnum ++) {
			curDir.add(new DefaultMutableTreeNode(files.elementAt(fnum)));
		}
		return curDir;
	}
	
	public static void main(String[] args) {
		new LibTree();
	}
}
