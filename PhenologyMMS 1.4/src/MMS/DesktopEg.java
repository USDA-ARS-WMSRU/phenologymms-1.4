/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MMS;

import java.awt.Desktop;
import java.io.File;
import java. io.IOException;


/**
 *
 * @author DebbieEdmundsA
 */
public class DesktopEg {
   
    //constructor
    public DesktopEg() {
        
    }
    
    public static void main (String[] args) throws IOException{
    //public static void DesktopEg (String[] args) throws IOException{
    //public DesktopEg (String[] args) throws IOException{    
        System.out.println("In desktop class before desktop variable");
        Desktop desktop = Desktop.getDesktop();
        System.out.println("In desktop class");
        if (!desktop.isSupported(Desktop.Action.OPEN)) {
            System.out.println("Sorry.  Open is not supported here.");
            System.exit(0);
        }
        
        try {
            desktop.open(new File
                    ("C:/PhenologyMMS/Help System/PhenologyMMS1_1/!SSL!/Microsoft_HTML_Help/PhenologyMMSHelp1_1.chm"));
        }catch(IOException ioe) {
            System.err.println("No application associated with .chm?");
            ioe.printStackTrace();
            System.exit(1);
        }
        
        System.out.println("Help file opened.");
    }

}
