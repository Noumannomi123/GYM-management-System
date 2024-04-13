package utils;

import javax.swing.UIManager;

public class Look {
	public static void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	        } catch (Exception e) {
	          System.out.println("NimbusLookAndFeel failed to initialize");
	        }
	}
}
