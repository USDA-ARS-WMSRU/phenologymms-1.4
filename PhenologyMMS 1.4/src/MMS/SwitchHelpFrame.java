// SwitchHelpFrame.java

package MMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // de added
import java.io.*; // de added
import java.util.*; // de added
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
 *revised        Debbie Edmunds, February, 2005
 *
 */

public class SwitchHelpFrame extends JFrame {
    Run myRun;
    Parameters myPar;    
    String helpOutput = "";

  // declare fields
   
   GridBagLayout jGridBagLayout = new GridBagLayout(); // DE added
   GridBagConstraints cn = new GridBagConstraints();  // DE added
    
  JPanel jMainPanel = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  
  // panels
  JPanel jCenterPanel = new JPanel();
  JPanel jNorthPanel = new JPanel();
  JPanel jSouthPanel = new JPanel();
  JPanel jEastPanel = new JPanel();
  JPanel jWestPanel = new JPanel();
  
  // jTitle
  JLabel jTitle = new JLabel();
  
  //panes
   JScrollPane jSPHelp = new JScrollPane();
   JTextPane jTPHelp = new JTextPane();
   
  // de added Close button
  JButton jBClose = new JButton();
  
  public SwitchHelpFrame() {
    try {
        this.setSize(600,550); //(width, height)
        this.setLocation(120,10);
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  private void jbInit() throws Exception {
    // set jMainPanel
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
    
    // set jTitle
    jTitle.setFont(new java.awt.Font("Dialog", 1, 20));
    jTitle.setText("Help For Setting Up The Run");
     
    jSPHelp.setVerticalScrollBarPolicy
            (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    jSPHelp.setHorizontalScrollBarPolicy
            (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//de added
    jSPHelp.setPreferredSize(new Dimension(500, 400));
    
    //textpane
    jTPHelp.setFont(new java.awt.Font("DialogInput", 1, 12));

 
    readFile(new File(getAppPath() + "/SetupHelp.txt"));
     jTPHelp.setText(helpOutput);
    
    // add panels
    this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
    jMainPanel.add(jNorthPanel,  BorderLayout.NORTH);
    jMainPanel.add(jSouthPanel,  BorderLayout.SOUTH);
    jMainPanel.add(jEastPanel, BorderLayout.EAST);
    jMainPanel.add(jWestPanel,  BorderLayout.WEST);
    jMainPanel.add(jCenterPanel, BorderLayout.CENTER);
    jCenterPanel.add(new JScrollPane(jTPHelp)); //de added      
    
     // add title to jNorthPanel
        addItem(jTitle, 0, 1, 1, 1, "jNorthPanel");
        
        // add items to jSouthPanel
        addItem(jBClose, 0, 1, 1, 1, "jSouthPanel");
              
        //add ScrollPane to jCenterPanel
        addItem(jSPHelp, 0, 0, 1, 1,  "jCenterPanel");
        jSPHelp.getViewport().add(jTPHelp, null);
  
    // de added for Exit button   
    jBClose.setText("Close");
    
        jBClose.addActionListener(
            new ActionListener() {  
                public void actionPerformed(ActionEvent e) {
                    jBClose_actionPerformed(e);
		    }
            });
    
  } // end of jbInit method
  
      public void readFile(File aFile){  //String
        StringBuffer buffer = new StringBuffer();        
        
        try{
            BufferedReader in= new BufferedReader(new FileReader(aFile));            
            String newLine;
            
            while((newLine = in.readLine())!= null){
                buffer.append(newLine + "\n");            
                helpOutput = buffer.toString();
            }  
            
            in.close();
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }            

        setOutput(helpOutput);
    }  
    
    public void setOutput(String fortOutput){
        helpOutput = fortOutput;
    }
    
    public String getOutput() {
        return helpOutput;
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
    
} // end of class SwitchHelpFrame
