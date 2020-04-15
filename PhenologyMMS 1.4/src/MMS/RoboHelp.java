
package MMS;

import java.awt.Desktop;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RoboHelp {
	private static final File helpDirectory = new File("WebHelp_Pro");
        //private static final File helpDirectory = new File("WebHelp");
	private static final boolean helpAvailable = helpDirectory.exists();
	private static final String baseUrl = helpDirectory.toURI().toString();
	
	public static boolean openHelpPage(String topic) {
		if(!helpAvailable) {
			return false;
		}
		
		String url = baseUrl + topic;
		return openWebPage(url);
	}
	
	private static boolean openWebPage(String url) {
		try {
			return openWebPage(new URL(url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static boolean openWebPage(URL url) {
		try {
			return openWebPage(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private static boolean openWebPage(URI uri) {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
