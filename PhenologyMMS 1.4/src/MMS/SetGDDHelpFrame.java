// SetGDDHelpFrame.java
// Template for help screen display from customize run screen
package MMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // de added
import java.io.*; // de added
//import java.util.*; // de added
import java.net.URL; // de added

/**
 * Title:        MMS Test2
 * Description:  Started 9 Sept 2002
 * Copyright:    Copyright (c) 2002
 * Company:      USDA/ARS
 *
 * @author       Ben Riebau
 * @version      1.0
 *
 *added comments and edited organization, Debbie Edmunds, March, 2005
 */

public class SetGDDHelpFrame extends JFrame {
  GridBagLayout jGridBagLayout = new GridBagLayout(); // DE added
  GridBagConstraints cn = new GridBagConstraints();  // DE added
    
  JPanel jMainPanel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  
  String helpCustRun = "";
  
  // panels
  JPanel jNorthPanel = new JPanel();
  JPanel jCenterPanel = new JPanel();
  JPanel jEastPanel = new JPanel();
  JPanel jWestPanel = new JPanel();
  JPanel jSouthPanel = new JPanel();
  
  // title for the screen
  JLabel jTitleLabel = new JLabel();

  //panes
  JScrollPane jSPGDDHelp = new JScrollPane();
  JTextPane jTPGDDHelp= new JTextPane();  
  
  // de added Close button
  JButton jBClose = new JButton();
    
  // constructor
  public SetGDDHelpFrame() {
    try {
      this.setSize(600,550); //(width, height)
      this.setLocation(120,10);
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  } // end of constructor
  
  private void jbInit() throws Exception {
    // jMainPanel
    jMainPanel.setLayout(borderLayout1);
    
    // jNorthPanel
    jNorthPanel.setBackground(SystemColor.info);
    jNorthPanel.setPreferredSize(new Dimension(10, 40));
    jNorthPanel.setLayout(jGridBagLayout);//de changed to jGridBagLayout
    
    // jCenterPanel
    jCenterPanel.setBackground(SystemColor.info);
    jCenterPanel.setSize(500,300);
    
    // jEastPanel
    jEastPanel.setBackground(SystemColor.info);
    jEastPanel.setPreferredSize(new Dimension(40, 10));
    
    // jWestPanel
    jWestPanel.setBackground(SystemColor.info);
    jWestPanel.setPreferredSize(new Dimension(40, 10));
    
    // jSouthPanel
    jSouthPanel.setBackground(SystemColor.info);
    jSouthPanel.setPreferredSize(new Dimension(10, 40));
    jSouthPanel.setLayout(jGridBagLayout);//de changed to jGridBagLayout
    
    // jTitleLabel
    jTitleLabel.setFont(new java.awt.Font("Dialog", 1, 16));
    jTitleLabel.setText("Help For Custominzing the Run");
        
    // de added for Exit button   
    jBClose.setText("Close");
    
    //scrollpane
        jSPGDDHelp.setVerticalScrollBarPolicy
            (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jSPGDDHelp.setHorizontalScrollBarPolicy
            (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//de added
        jSPGDDHelp.setPreferredSize(new Dimension(500, 400)); 
        
        //textpane
        jTPGDDHelp.setFont(new java.awt.Font("DialogInput", 1, 12));
        
        readFile(new File(getAppPath() + "/CustomizeRunHelp.txt"));
        jTPGDDHelp.setText(helpCustRun);
        
        // add panels
        this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
        jMainPanel.add(jNorthPanel, BorderLayout.NORTH);
        jMainPanel.add(jSouthPanel, BorderLayout.SOUTH);
        jMainPanel.add(jEastPanel, BorderLayout.EAST);
        jMainPanel.add(jWestPanel, BorderLayout.WEST);
        jMainPanel.add(jCenterPanel, BorderLayout.CENTER);
        
        // add title to jNorthPanel
        addItem(jTitleLabel, 0, 1, 1, 1, "jNorthPanel");
        
        // add items to jSouthPanel
        addItem(jBClose, 0, 1, 1, 1, "jSouthPanel");
              
        //add ScrollPane to jCenterPanel
        addItem(jSPGDDHelp, 0, 0, 1, 1,  "jCenterPanel");
        jSPGDDHelp.getViewport().add(jTPGDDHelp, null);              

                   
        jBClose.addActionListener(
            new ActionListener() {  
                public void actionPerformed(ActionEvent e) {
                    jBClose_actionPerformed(e);
		    }
            });
    
  } // end of jbInit
  
       public void readFile(File aFile){  //String
        StringBuffer buffer = new StringBuffer();        
        
        try{
            BufferedReader in= new BufferedReader(new FileReader(aFile));            
            String newLine;
            
            while((newLine = in.readLine())!= null){
                buffer.append(newLine + "\n");            
                helpCustRun = buffer.toString();
            }  
            
            in.close();
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }            

        setOutput(helpCustRun);
    }  
    
    public void setOutput(String fortOutput){
        helpCustRun = fortOutput;
    }
    
    public String getOutput() {
        return helpCustRun;
    }
    
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
                   // System.out.println("tmp = " +tmp);
                 }
                 catch (Exception e) {
                   System.out.println("IOException: URL");
                 }
       return tmp;       
   }
  
  void jBClose_actionPerformed(ActionEvent e) {
        this.setVisible(false);
   } // end of jBClose_actionPerformed method
  
  //DE added this method
    void addItem(Component item, int row, int column, 
                          int width, int height, String panelName){
                         
    // set constraints for items added to panels with GridBagLayout
        cn.gridx = column;
        cn.gridy = row;
        cn.gridwidth = width;
        cn.gridheight = height;
        cn.weightx = 1;
        cn.weighty = 1;
        cn.ipadx = 0;
        cn.ipady = 0;
        
        if(panelName.equals("jNorthPanel")) {
            jGridBagLayout.setConstraints(item, cn);
            jNorthPanel.add(item);
        } 
        else if(panelName.equals("jCenterPanel")) {
            jGridBagLayout.setConstraints(item, cn);
            jCenterPanel.add(item);
        }
        else if(panelName.equals("jSouthPanel")) {
            jGridBagLayout.setConstraints(item, cn);
            jSouthPanel.add(item);
        }    
        
    } // end of AddItem method
    

} // end of SetGDDHelpFrame class
