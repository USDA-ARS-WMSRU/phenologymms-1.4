// WelcomeFrame.java

package MMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.beans.*;
import java.net.URL;

/**
 * Title:        MMS Test2
 * Description:  Started 9 Sept 2002
 * Copyright:    Copyright (c) 2002
 * Company:      USDA/ARS
 *
 * @author       Ben Riebau
 * @version      1.0
 * 
 *revised        Debbie Edmunds, February, 2005
 *
 */

public class WelcomeFrame extends JFrame {
  JPanel jMainPanel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jCenterPanel = new JPanel();
  
  //bcv added
  ImageIcon slpsh = new ImageIcon(getAppPath() + "/visuals/splashScreen.jpg");
  
  JLabel jLabel1 = new JLabel();

//constructor  
  public WelcomeFrame() {
    try {
      jbInit();
      this.setSize(540,485); //de changed to this
      this.setLocation(30,10);//de changed to this
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  } // end of constructor

  private void jbInit() throws Exception {
    jMainPanel.setLayout(borderLayout1);
    jCenterPanel.setBackground(Color.white);
    jLabel1.setIcon(slpsh);
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setEnabled(false);
    this.setResizable(false);
    this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
    jMainPanel.add(jCenterPanel, BorderLayout.CENTER);
    jCenterPanel.add(jLabel1, null);
  } // end of method jbInit
  
  
  // bcv added path find
  public String getAppPath(){
       String tmp, c1;
       tmp = "";
       int indx, mm;
                try {                        
                    URL url = new URL("jar", "", -1, "file:" + new File("").getAbsolutePath());
                    tmp = url.toString();
                    c1 = url.getPath();     
                    indx = c1.indexOf(":");
                    mm = c1.length();            
                    tmp = c1.substring(indx + 1, mm);  
                    
                 }
                 catch (Exception e) {
                   System.out.println("IOException: URL");
                 }
       return tmp;       
   }

} // end of class WelcomeFrame


