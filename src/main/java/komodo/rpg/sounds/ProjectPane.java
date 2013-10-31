package komodo.rpg.sounds;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import komodo.rpg.sounds.model.Scene;
import komodo.rpg.sounds.ui.ScenePanel;
import lombok.Getter;

public class ProjectPane extends JPanel implements ChangeListener {

	@Getter
	private JTabbedPane tabPane;
	private ArrayList<Scene> sceneList;
	
	public ProjectPane() {
		setLayout(new BorderLayout());
		
		sceneList = new ArrayList<Scene>();
		
		tabPane = new JTabbedPane();
		tabPane.addChangeListener(this);
		add(tabPane,BorderLayout.CENTER);
	}
	
	public void addScene(String title) {
		Scene scene = new Scene();
		scene.setTitle(title);
		sceneList.add(scene);
		tabPane.addTab(title + " *", null, new ScenePanel(), title   );
		tabPane.setSelectedIndex(tabPane.getTabCount() - 1);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO: maybe needed
		System.out.println(e);
	}
}
