package komodo.rpg.sounds;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class Launcher
{
	
	public void launch() {
		String[] contextPaths = new String[] {"context/appcontext.xml"};
		new ClassPathXmlApplicationContext(contextPaths);
	}
	
    public static void main( String[] args )
    {
        Launcher launcher = new Launcher();
        launcher.launch();
    }
}
