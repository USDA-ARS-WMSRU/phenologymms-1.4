// InputFrame.java

package MMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
//import java.lang.*;
import java.io.*;
import java.net.URL;
/**
 *  Title:       MMS Test2 
 *  Description: Started 9 Sept 2002 
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       September 19, 2002
 *@version       1.0
 *
 *revised        Debbie Edmunds, February, 2005
 *
 */

// Set Inputs screen
public class InputFrame extends JFrame {
    //declarations
    Parameters myParameters;
    SwitchboardFrame mySwitchBoard;
    Frame IHF;
    InputHelpFrame myInputHelpFrame; // de added
    OutPutFrame myOutputFrame; // de added
    Frame TSF;
    TempSettingsFrame myTempSettingsFrame;
    TempSettingsHelpFrame myTempSettingsHelpFrame;
    StringTokenizer stGDDMethod;
    
    Run myRun;  // de added
    Date myDate; // de added
    int myMonth; // de added
    int myDay; // de added
    boolean helpOn = true;
    boolean tempSettingsOn = true;
   
    
    // panels
    JPanel jMainPanel = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    
    JPanel jSouthPanel = new JPanel();
    JPanel jNorthPanel = new JPanel();
    JPanel jCenterPanel = new JPanel();   
    
    // declare GridBagLayout manager and constraints
    GridBagLayout jGridBagLayout = new GridBagLayout(); // DE added
    GridBagConstraints cn = new GridBagConstraints();  // DE added
    
    // components in each container. de changed spelling where needed.
    JLabel jTitleLabel = new JLabel(); 
    
    JLabel jPlantLabel = new JLabel();
    
    // planting date
    JLabel jPlantingLabel = new JLabel();
    JTextField jTFPlantingDate = new JTextField();// a 7 was in ()
    
    // planting rate
    JLabel jPlantingRateLabel = new JLabel();
    JTextField jTFPlantingRate = new JTextField();
    
    // soil moisture
    JLabel jSoilMoistureLabel = new JLabel();
    JComboBox jCBSoilMoisture = new JComboBox();
    
    // planting depth
    JLabel jPlantingDepthLabel = new JLabel();
    JTextField jTFPlantingDepth = new JTextField();
    
    // latitude
    JLabel jLatitudeLabel = new JLabel();
    JTextField jTFLatitude = new JTextField();
      
    // Maximum Canopy Height
    JLabel jCanopyHtLabel = new JLabel();
    JTextField jTFCanopyHt = new JTextField();
     
    // buttons to "close and save", "reset" or "run" and for "help". 
    JButton jBHelp = new JButton();
    JButton jBClose = new JButton();
    JButton jBReset = new JButton();
    JButton jBRun = new JButton();
    //button to access the temp settings secreen.
    JButton jBTempSettings = new JButton();
    
    // background
    //bcv added
    ImageIcon slpsh = new ImageIcon  // de added full pathname
        (getAppPath() + "/visuals/InputScreen.jpg"); 
    JLabel jLbkgrnd = new JLabel();
    
    // button group for radio buttons
   // ButtonGroup phyGroup = new ButtonGroup();//Is this needed?


    /**
     *  Constructor for the InputFrame object
     *
     *@param  myPara  Description of the Parameter
     */
    public InputFrame (Frame IHF, Frame TSF, Parameters myPara){ 
        myParameters = myPara;
        myInputHelpFrame = (InputHelpFrame) IHF; 
        myTempSettingsFrame = (TempSettingsFrame) TSF;
        try {
            this.setSize(600, 575); //(width, height)
            this.setLocation(10, 3); 
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
               //de added next line for debugging
        //    System.out.println("location = " + myParameters.location);
            
        try { //de added to fill latitude based on the climate location
            getLatitudeData(myParameters.location); // call method to read 
                                                          // latitude data file
     
        } catch (Exception ex) {
            System.out.println("Can't open latitude file: " + ex);
            ex.printStackTrace();
        }

        setWindow();
    } // end constructor

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
     *@exception  Exception  Description of the Exception
     */
    private void jbInit() throws Exception {
//      set characteristics of the panels and items in the panels       
        // jMainPanel
        jMainPanel.setLayout(borderLayout1);
        jMainPanel.setMinimumSize(new Dimension(700, 550));  
        // jSouthPanel
        jSouthPanel.setBackground(SystemColor.info);
        jSouthPanel.setPreferredSize(new Dimension(10, 40));
        jSouthPanel.setSize(new Dimension(10, 40)); // de added
        jSouthPanel.setLayout(jGridBagLayout);//de changed to jGridBagLayout
        
        // jNorthPanel
        jNorthPanel.setBackground(SystemColor.info);
        jNorthPanel.setPreferredSize(new Dimension(10, 40));
        jNorthPanel.setSize(new Dimension(10, 40 ));// de added
        jNorthPanel.setLayout(jGridBagLayout);//de changed to jGridBagLayout
                
        // jCenterPanel
        jCenterPanel.setBackground(SystemColor.info);
        jCenterPanel.setLayout(jGridBagLayout);//de added
        jCenterPanel.setPreferredSize(new Dimension(700, 470));
        jCenterPanel.setSize(700, 470); //de added to enlarge screen
              
        // screen label which appears in jNorthPanel
        jTitleLabel.setFont(new java.awt.Font("Dialog", 1, 24));
        jTitleLabel.setText("Set Inputs");
        
        // label for planting items
        jPlantLabel.setFont(new java.awt.Font("Dialog", 1, 20));//1,14
        jPlantLabel.setForeground(SystemColor.textHighlightText);
        jPlantLabel.setText("Planting Information");//de changed from "Planting"
        
        // planting date
        jPlantingLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jPlantingLabel.setForeground(SystemColor.textHighlightText);
        jPlantingLabel.setText("Date (mm/dd/yyyy):");
        
        jTFPlantingDate.setBackground(SystemColor.info);
        jTFPlantingDate.setHorizontalAlignment(SwingConstants.CENTER);
        
        // planting rate
        jPlantingRateLabel.setBackground(Color.lightGray);
        jPlantingRateLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jPlantingRateLabel.setForeground(SystemColor.textHighlightText);
        jPlantingRateLabel.setText("Rate (#/m^2):");
        
        jTFPlantingRate.setBackground(SystemColor.info);
        jTFPlantingRate.setHorizontalAlignment(SwingConstants.CENTER);
        
        // set up soil moisture combo box
        jSoilMoistureLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jSoilMoistureLabel.setForeground(SystemColor.textHighlightText);
        jSoilMoistureLabel.setText("Soil Moisture:");        
        
        jCBSoilMoisture.insertItemAt("Optimum", 0);
        jCBSoilMoisture.insertItemAt("Medium", 1);
        jCBSoilMoisture.insertItemAt("Dry", 2);
        jCBSoilMoisture.insertItemAt("Planted in dust", 3);
        jCBSoilMoisture.setBackground(SystemColor.info);
        jCBSoilMoisture.addItemListener(
            new java.awt.event.ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    jCBSoilMoisture_itemStateChanged(e);
                }
            });
              
        // planting depth
        jPlantingDepthLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jPlantingDepthLabel.setForeground(SystemColor.textHighlightText);
        jPlantingDepthLabel.setText("Depth (cm):");
        
        jTFPlantingDepth.setBackground(SystemColor.info);
        jTFPlantingDepth.setHorizontalAlignment(SwingConstants.CENTER);
        
        // latitude
        jLatitudeLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jLatitudeLabel.setForeground(SystemColor.textHighlightText);
        jLatitudeLabel.setText("Latitude (degrees):");
        
        jTFLatitude.setBackground(SystemColor.info);
        jTFLatitude.setHorizontalAlignment(SwingConstants.CENTER);
                 
        // Maximum Canopy Height
        jCanopyHtLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jCanopyHtLabel.setForeground(SystemColor.textHighlightText);
        jCanopyHtLabel.setText("Max. Canopy Ht. (cm):");
        
        jTFCanopyHt.setBackground(SystemColor.info);
        jTFCanopyHt.setHorizontalAlignment(SwingConstants.CENTER);
        
        // set buttons
        jBHelp.setText("Help...");
        jBHelp.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBHelp_actionPerformed(e);
                }
            });
            
        jBClose.setText("Close and Save");
        jBClose.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBClose_actionPerformed(e);
                }
            });
            
        jBReset.setText("Reset");
        jBReset.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBReset_actionPerformed(e);
                }
            });
        
        jBRun.setText("Run...");
        jBRun.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBRun_actionPerformed(e);
                }
            });
        jBTempSettings.setText("Temperatures");
        jBTempSettings.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBTempSettings_actionPerformed(e);
                }
            });           
            
        // create the background for the screen
        jLbkgrnd.setBackground(SystemColor.info);
        jLbkgrnd.setForeground(SystemColor.info);
        jLbkgrnd.setSize(600, 575); // de added
        jLbkgrnd.setPreferredSize(new Dimension(600, 575));//was(370, 340) de 
        jLbkgrnd.setMaximumSize(new Dimension(600, 575));//was(370, 340) de 
        jLbkgrnd.setMinimumSize(new Dimension(600, 575));//was(370, 340) de
        
        jLbkgrnd.setRequestFocusEnabled(false); // de added
        jLbkgrnd.setIcon(slpsh);
        jLbkgrnd.setIconTextGap(0);
        jLbkgrnd.setVerticalAlignment(SwingConstants.TOP);
        
//      add the jMainPanel and the panels to the borders in jMainPanel        
        this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
        
        jMainPanel.add(jSouthPanel, BorderLayout.SOUTH);
        jMainPanel.add(jNorthPanel, BorderLayout.NORTH); 
        jMainPanel.add(jCenterPanel, BorderLayout.CENTER);// de changed to this
        
        // jNorthPanel
        addItem(jTitleLabel, 0, 0, 1, 1, "jNorthPanel");
        
        // jSouthPanel
        addItem(jBHelp, 0, 0, 1, 1, "jSouthPanel"); // de added
        addItem(jBClose, 0, 1, 1, 1, "jSouthPanel");
        addItem(jBReset, 0, 2, 1, 1, "jSouthPanel");        
        addItem(jBRun, 0, 3, 1, 1, "jSouthPanel"); // de added
        addItem(jBTempSettings, 0, 4, 1, 1, "jSouthPanel"); // de added
               
        //Planting Information label
        cn.anchor = GridBagConstraints.CENTER;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jPlantLabel, 0, 0, 2, 1, "jCenterPanel");// the 2 centered it across the middle
        
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jPlantingLabel, 1, 0, 1, 1, "jCenterPanel");// was jWestPanel
        
        cn.anchor = GridBagConstraints.CENTER;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFPlantingDate, 2, 0, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jSoilMoistureLabel, 1, 1, 1, 1, "jCenterPanel");
      
        cn.anchor = GridBagConstraints.CENTER;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jCBSoilMoisture, 2, 1, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jPlantingDepthLabel, 3, 0, 1, 1, "jCenterPanel"); 
        
        cn.anchor = GridBagConstraints.CENTER;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFPlantingDepth, 4, 0, 1, 1, "jCenterPanel"); 

        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jPlantingRateLabel, 3, 1, 1, 1, "jCenterPanel");//was 5,0,1,1
        
        cn.anchor = GridBagConstraints.CENTER;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFPlantingRate, 4, 1, 1, 1, "jCenterPanel");
               
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jLatitudeLabel, 7, 0, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.WEST;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFLatitude, 8, 0, 1, 1, "jCenterPanel");        
              
           // maximum canopy height
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jCanopyHtLabel, 7, 1, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.WEST;//SOUTH is too far down
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFCanopyHt, 8, 1, 1, 1, "jCenterPanel");
        
        cn.fill = GridBagConstraints.BOTH;
        addItem(jLbkgrnd, 0, 0, GridBagConstraints.REMAINDER, 25, "jCenterPanel");
                
    } // end of jbInit method

 
 //Adding the Buttons section   
    
    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jBHelp_actionPerformed(ActionEvent e) {
		if(RoboHelp.openHelpPage("Setup/Set_Inputs.htm")) {
			return;
		}
		
        if (helpOn == true) {
            myInputHelpFrame.setVisible(true);
            helpOn = false;
        } else {
            myInputHelpFrame.setVisible(false);
            helpOn = true;
        }
    }
    
    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jBClose_actionPerformed(ActionEvent e) {
        saveInput();
        //copy from jBRun_actionPerformed method:       
        this.setParameters(myParameters);
           // current stuff in this class
        this.setVisible(false);      
    }


    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jBReset_actionPerformed(ActionEvent e) {
        resetWindow();
    } // end of method jBReset_actionPerformed

    
    // de added the following method
    // calls the Run class from the Run button and saves the input
    void jBRun_actionPerformed(ActionEvent e) {       
        saveInput();        
        this.setParameters(myParameters);
           // current stuff in this class
        myRun = new Run(myParameters);
        this.setVisible(false);
        
        myOutputFrame = new OutPutFrame(myParameters);    
        myOutputFrame.setParameters(myParameters);
        myOutputFrame.setVisible(true);                    
        myOutputFrame.setBackRefference(this); 
        myOutputFrame.writeText(myRun.getOutput());        
        OutPutFrame tmp = (OutPutFrame) myOutputFrame;
        tmp.setBackRefference(this);    
    }          
   
    //debe added this to call the TempSettingsFrame 7/6/11
    void jBTempSettings_actionPerformed(ActionEvent e) {
        TempSettingsFrame TSF = new TempSettingsFrame(new TempSettingsHelpFrame(), myParameters);      
        if (tempSettingsOn == true) {
            TSF.setInputFrameReff(this);
            TSF.setVisible(true);
        }   
        else {
            TSF.setVisible(false);
            tempSettingsOn = true;
        }
    } // end of method jBTempSettings_actionPerformed
            
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
        else if(panelName.equals("jCenterPanel")){
            jGridBagLayout.setConstraints(item, cn);
            jCenterPanel.add(item);
        }
        else if(panelName.equals("jSouthPanel")) {
            jGridBagLayout.setConstraints(item, cn);
            jSouthPanel.add(item);
        }    
        
    } // end of AddItem method
    
    
 
            
            // Read in data value for latitude based on the chosen climate location
    // in the input screen.   
     private void getLatitudeData(String smp) throws IOException { 
//    get latitude data based on chosen climate location
        File[] myVarFiles;
        File myFile;
        BufferedReader input = null;
        //String smLat = "";//temp variable for latitude read into fileLine
        //int compSmp;
              
        String varDir = "\\MMSWeather";
        String fileLine;
        String path = getAppPath();
        File file = new File(path + varDir + "\\" + myParameters.location+".dat");
        try {
            BufferedReader br = new BufferedReader (new FileReader(file));
            fileLine = br.readLine();
            fileLine = br.readLine();
            String[] tkn = fileLine.split(" ");
            if(tkn.length>0){
                if(tkn[0].contains("Latitude")){
                    myParameters.latitude = tkn[0].split("=")[1];
                } else {
                    myParameters.latitude = "-99";
                }
              
            }
            br.close();
            
        } catch(FileNotFoundException e){
            
        } catch(IOException e){
            
        }
        
//        //debe changed file extensions to .dat
//        //GiveFiles varFiles = new GiveFiles(path, varDir, "txt");
//        GiveFiles varFiles = new GiveFiles(path, varDir, "dat");
//
//        myVarFiles = varFiles.getFiles();
//        for (int i = 0; i < myVarFiles.length; i++) {
//            if (myVarFiles[i].getName().equalsIgnoreCase("latitude.dat")) {
//                myFile = myVarFiles[i];
//                try {
//                    input = new BufferedReader(new FileReader(myFile));
//                } catch (IOException ex) {
//                    System.out.println("Can't open latitude file: " + ex);
//                    ex.printStackTrace();
//                }
////             **************** step through header stuff
//                do {
//                    fileLine = input.readLine();
//                } while (!fileLine.equalsIgnoreCase("****"));
////             **************** end of header stuff 
//                
//                do { //get the chosen climate location
//                    fileLine = input.readLine();
//                } while (!fileLine.equalsIgnoreCase(myParameters.location));
//                           
//                    //for (int r = 0; r < 1; r++){
//                       fileLine = input.readLine();//read the next line
//                       StringTokenizer chew = new StringTokenizer(fileLine, ",");
//                         myParameters.latitude = chew.nextToken().trim();          
//                       
////                       myParameters.latitude //[r] = 
////                                chew.nextToken().trim();
////                        myParameters.waterFilledLowerArray[r] = 
////                                chew.nextToken().trim();
////                        myParameters.waterFilledUpperArray[r] = 
////                                chew.nextToken().trim();
////                        myParameters.germGDDArray[r] = 
////                                chew.nextToken().trim();
////                        myParameters.elongRateGDDArray[r] = 
////                                chew.nextToken().trim();
//                       // } // end of for
//            }// end of if loop to get the latitude.dat file  
//        } // end of for loop to get the latitude.dat file       
//    
     } // end of method getLatitudeData  
    
    
    
    
    /**
     *  Description of the Method
     */
    private void setWindow() {       
        jTFLatitude.setText(myParameters.latitude);
        jTFPlantingDate.setText(myParameters.plantingDate);
        jTFPlantingDepth.setText(myParameters.plantingDepth);
        jTFPlantingRate.setText(myParameters.plantingRate);       
        jTFCanopyHt.setText(myParameters.canopyHt);

        //        set soil moisture
        for (int i = 0; i < jCBSoilMoisture.getItemCount(); i++) {
            if (jCBSoilMoisture.getItemAt(i).toString().trim().equalsIgnoreCase
                (myParameters.soilMoisturePlanting.trim())) {
                jCBSoilMoisture.setSelectedItem(jCBSoilMoisture.getItemAt(i));
            }
        }
      
    } // end of setWindow method
    
    
    // de added
    private void saveInput() {
        //JRadioButton tmpButton = null;
        //Enumeration e1 = phyGroup.getElements();

        myParameters.latitude = jTFLatitude.getText();
        myParameters.plantingDate = jTFPlantingDate.getText();
        
        // Call Date class to parse date into month and day and write to 
        //  Parameters class.     
        // This next line must be here to update month and day correctly
        myDate = new Date(myParameters);//send plantingDate to Date
 
        myParameters.plantingDepth = jTFPlantingDepth.getText();
        myParameters.plantingRate = jTFPlantingRate.getText();        
        myParameters.canopyHt = jTFCanopyHt.getText();

       mySwitchBoard.setParameters(myParameters);
        
    } // end of saveInput method
        
    /**
     *  Description of the Method
     */
    private void resetWindow() {
        jTFLatitude.setText(myParameters.latitude_ORG);
        jTFPlantingDate.setText(myParameters.plantingDate_ORG);
        jTFPlantingDepth.setText(myParameters.plantingDepth_ORG);
        jTFPlantingRate.setText(myParameters.plantingRate_ORG);
        jCBSoilMoisture.setSelectedIndex(0);
        jTFCanopyHt.setText(myParameters.canopyHt_ORG);
     } // end of resetWindow method


    /**
     *  Sets the parameters attribute of the InputFrame object
     *
     *@param  myPara  The new parameters value
     */
    public void setParameters(Parameters myPara) {
        myParameters = myPara; 
        
    } // end of method setParameters
    
    /**
     *  Sets the switchBoardReff attribute of the InputFrame object
     *
     *@param  mySBF  The new switchBoardReff value
     */
    public void setSwitchBoardReff(SwitchboardFrame mySBF) {
        mySwitchBoard = mySBF;
    }

    
   /**
     *  Description of the Method: This is where soil moisture is saved in the
     *  parameters list.
     *
     *@param  e  Description of the Parameter
     */    
    
     void jCBSoilMoisture_itemStateChanged(ItemEvent e) {
        myParameters.soilMoisturePlanting = (String) jCBSoilMoisture.getSelectedItem();
     }    
     
} // end of class InputFrame

