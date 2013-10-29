package komodo.rpg.sounds.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Localizer {
	private static ResourceBundle bundle;
	
	private static void init() {
		if(bundle == null) {
			String baseName = "locale";
			try
		    {
		      bundle =   ResourceBundle.getBundle  ( baseName );
		    }
		    catch ( MissingResourceException e ) {
		      System.err.println( e );
		    }
		}
	}
	
	public static String getString(String key) {
		if(bundle == null) {
			init();
		}
		
		String s = "<undefined>";
		try {
			s = bundle.getString(key);
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return s;
	}
	
}
