// OutputSaveFrame.java

package MMS;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.net.URL;
/**
 *  Title:       MMS Test2 
 *  Description: Started 9 Sept 2002 
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       January 7, 2003
 *@version       1.0
 *
 *revised        Debbie Edmunds, March, 2005
 */

// from the "Save OutPut..." button in the output frame
public class OutputSaveFrame extends JFrame {
    String myOutput;
    Calendar cal = Calendar.getInstance();
    
    // jMainPanel
    JPanel jMainPanel = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    
    // panels
    JPanel jNorthPanel = new JPanel();
    JPanel jSouthPanel = new JPanel();
    JPanel jWestPanel = new JPanel();
    JPanel jEastPanel = new JPanel();
    JPanel jCenterPanel = new JPanel();
    
    // title
    JLabel jTitleLabel = new JLabel();
    
    // jFileChooser1
    JFileChooser jFileChooser1 = new JFileChooser();


    /**
     *  Constructor for the OutputSaveFrame object
     */
    public OutputSaveFrame() {
        try {
            jbInit();
            this.setLocation(20, 40);
            this.setSize(650, 450);// was 600, 400 de changed 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *  Description of the Method
     *
     *@exception  Exception  Description of the Exception
     */
    private void jbInit() throws Exception {
        // panels
        jMainPanel.setLayout(borderLayout1);
        jNorthPanel.setBackground(SystemColor.info);
        jSouthPanel.setBackground(SystemColor.info);
        jWestPanel.setBackground(SystemColor.info);
        jEastPanel.setBackground(SystemColor.info);
        jCenterPanel.setBackground(SystemColor.info);
        
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        // title
        jTitleLabel.setFont(new java.awt.Font("Dialog", 1, 24));
        jTitleLabel.setText("Save Output From Current Run");     
        
        jFileChooser1.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jFileChooser1_actionPerformed(e);
                }
            });
        
            // panels
        this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
        // jNorthPanel and title
        jMainPanel.add(jNorthPanel, BorderLayout.NORTH);
        jNorthPanel.add(jTitleLabel, null);
        
        // other panels
        jMainPanel.add(jSouthPanel, BorderLayout.SOUTH);
        jMainPanel.add(jWestPanel, BorderLayout.WEST);
        jMainPanel.add(jEastPanel, BorderLayout.EAST);
        jMainPanel.add(jCenterPanel, BorderLayout.CENTER);
        
        // jFileChooser1 and add to jCenterPanel
        jFileChooser1.setCurrentDirectory(new File(getAppPath()));
        jFileChooser1.setApproveButtonText("Save");
        //debe changed file extensions to .dat
        //String[] txt = new String[]{".txt"};
        String[] txt = new String[]{".dat"};
        jFileChooser1.removeChoosableFileFilter(jFileChooser1.getAcceptAllFileFilter());
        //jFileChooser1.addChoosableFileFilter(new SimpleFileFilter(txt, "Text (*.txt)"));
        jFileChooser1.addChoosableFileFilter(new SimpleFileFilter(txt, "Text (*.dat)"));
       
        jCenterPanel.add(jFileChooser1, null);
        
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
                    
                 }
                 catch (Exception e) {
                   System.out.println("IOException: URL");
                 }
       return tmp;       
   }
    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jFileChooser1_actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("CancelSelection")) {
            this.setVisible(false);
        } else if (e.getActionCommand().equalsIgnoreCase("ApproveSelection")) {
            saveFile(jFileChooser1.getSelectedFile());
        }
    }


    /**
     *  Description of the Method
     *
     *@param  myFile  Description of the Parameter
     */
    private void saveFile(File myFile) {

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(myFile));
            out.write("File Name: " + myFile.getName() + "\tThis output created at: " + (cal.get(Calendar.MONTH) + 1));
            out.write("/" + cal.get(Calendar.DATE) + "/" + cal.get(Calendar.YEAR) + "\t");
            out.write(cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
            out.newLine();
            out.write("Path: " + myFile.getAbsolutePath());
            out.newLine();
            out.newLine();
            out.write(myOutput);
            out.close();
            this.setVisible(false);
        } catch (Exception ex) {
            System.out.println("no file");
            return;
        }

    }


    /**
     *  Sets the output attribute of the OutputSaveFrame object
     *
     *@param  s  The new outPut value
     */
    public void setOutPut(String s) {
        myOutput = s;
    }

}

