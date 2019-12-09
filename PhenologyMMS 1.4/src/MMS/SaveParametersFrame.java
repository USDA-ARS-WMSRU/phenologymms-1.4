// SaveParametersFrame.java

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
 *revised     Debbie Edmunds, March, 2005
 */

// for the "SaveScenario..." button in the output frame
public class SaveParametersFrame extends JFrame {
    Parameters myParameters;
    Calendar cal = Calendar.getInstance();
    //String myOutput;
    
    // jMainPanel
    JPanel jMainPanel = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    
    // panels added to jMainPanel
    JPanel jNorthPanel = new JPanel();
    JPanel jSouthPanel = new JPanel();
    JPanel jWestPanel = new JPanel();
    JPanel jEastPanel = new JPanel();
    JPanel jCenterPanel = new JPanel();
    
    // jTitleLabel title for the screen which appears in jNorthPanel
    JLabel jTitleLabel = new JLabel();
    
    JFileChooser jFileChooser1 = new JFileChooser();


    /**
     *  Constructor for the OutputSaveFrame object
     */
    public SaveParametersFrame() {
        try {
            jbInit();
            this.setLocation(20, 40);
            this.setSize(650, 450);// (width, height)
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
        jMainPanel.setLayout(borderLayout1);
        
        // panels in jMainPanel
        jNorthPanel.setBackground(SystemColor.info);
        jSouthPanel.setBackground(SystemColor.info);
        jWestPanel.setBackground(SystemColor.info);
        jEastPanel.setBackground(SystemColor.info);
        jCenterPanel.setBackground(SystemColor.info);
        
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        // title in jNorthPanel
        jTitleLabel.setFont(new java.awt.Font("Dialog", 1, 24));
        jTitleLabel.setText("Save Current Scenario");
        
        jFileChooser1.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jFileChooser1_actionPerformed(e);
                }
            });
            
        this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
        
        // add panels to jMainPanel
        jMainPanel.add(jNorthPanel, BorderLayout.NORTH);
        jMainPanel.add(jSouthPanel, BorderLayout.SOUTH);
        jMainPanel.add(jWestPanel, BorderLayout.WEST);
        jMainPanel.add(jEastPanel, BorderLayout.EAST);
        jMainPanel.add(jCenterPanel, BorderLayout.CENTER);
        
        // add title to jNorthPanel
        jNorthPanel.add(jTitleLabel, null);
        
        // jFileChooser1
        jFileChooser1.setCurrentDirectory(new File(getAppPath() + "\\saves"));
        jFileChooser1.setApproveButtonText("Save");
        //debe chagned file extension to .dat
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
     *@param  myFile  this is the file we are saving to
     */
    private void saveFile(File myFile) {
        int rowNumber;        
        // holds the number of rows which is variable by crop

        //debe chagned file extensions to .dat
        //this writes out the .dat file from saving a scenario
        try {
//        open up the file for writing; if it already exists we overwrite it
            BufferedWriter out = new BufferedWriter(new FileWriter(myFile));
            // put some header information in so you know where it is located 
            // and when it was created
            out.write("File Name: " + myFile.getName() + "\tDate: " + (cal.get(Calendar.MONTH) + 1));
            out.write("/" + cal.get(Calendar.DATE) + "/" + cal.get(Calendar.YEAR) + "\t");
            out.write(cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
            out.newLine();
            out.write("Path: " + myFile.getAbsolutePath());
            out.newLine();
            out.newLine();
            out.write("The Format is as follows:");
            out.newLine();
            out.write("Crop Type, Crop Variety, Climate, Planting Day, " +
                "Planting Month, Planting Year, ");
            out.newLine();            
            out.write("Day of Year, Planting Depth," +
                "Planting Rate, Soil Moisture, Latitude, ");
            out.newLine();
            out.write("GDD Method, Base Temperature, Lower Optimum Temperature, Upper Optimum Temperature, " +
                "Upper Temperature, Phyllochron Value, Canopy Height");
            out.newLine();
            out.write("Row1,Row2,Row3,..., RowN");
            out.newLine();
            
//          when we read this back in we will use this line to tell where the data begins
            out.write("**** do not edit below this line !****");
            out.newLine();
            out.write(myParameters.cropType + ", " + myParameters.varietyType + ", ");
            out.write(myParameters.location + ", " + myParameters.day + ", " + myParameters.month + ", ");
            out.write(myParameters.year + ", " + myParameters.dayOfYear + ", "); 
            out.write(myParameters.plantingDepth + ", " + myParameters.plantingRate + ", ");
            out.write(myParameters.soilMoisturePlanting + ", " + myParameters.latitude + ", ");
            out.write(myParameters.GDDMethod + ", ");
            out.write(myParameters.baseTemp + ", " + myParameters.optimumTempLow + ", ");
            out.write(myParameters.optimumTempUp + ", ");
            out.write(myParameters.upperTemp + ", ");
            out.write(myParameters.phyllochronValue + ", " + myParameters.canopyHt);// + ", " + myParameters.userDefinedPhyllochron);
            out.newLine();

            // Ok so here we parse the stages, throw away the label and write 
            // the value to the file
            StringTokenizer st = new StringTokenizer(myParameters.myStages.toString(), "=,\n");
            while (st.hasMoreTokens()) {
//            throw away label
                st.nextToken();
                out.write(st.nextToken());
                if (st.hasMoreTokens()) {
                    out.write(", ");
                }
            }
            out.newLine();
//            clean up
            out.flush();
            out.close();
            this.setVisible(false);
        } catch (Exception ex) {
            System.out.println("no file: " + ex.toString());
            return;
        }

    }


    /**
     *  Sets the parameters attribute of the SaveParametersFrame object
     *
     *@param  pa  The new parameters value
     */
    public void setParameters(Parameters pa) {
        myParameters = pa;
    }
    
}



