// SwitchboardFrame.java
// screen titled "Begin Setup"

package MMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
//bcv added
import java.net.URL;

//import java.lang.*;
/**
 *  Title:       MMS Test2 
 *  Description: Started 9 Sept 2002
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       September 16, 2002
 *@version       1.0
 *
 *revised        Debbie Edmunds, February, 2005; July, 2011
 *
 */

public class SwitchboardFrame extends JFrame {
// set up pointers to frames*********
    Frame myHelpFrame;
    Frame customizeFrame; // DE changed spelling in all places this occurs.
    Frame myInputHelpFrame;
    OutPutFrame myOutputFrame;
    Frame myDisclaimerFrame; // de added
    GiveFiles locSaveFiles;
    Frame InputFrame;
    Frame TempSettingsFrame;
    Frame TempSettingsHelpFrame;
    
    Run myRun;  // de added   
    DesktopEg myDesktopEg;  // de added
    
//    this will hold the growth stage data for a load scenario
    StringTokenizer gData;
    
    boolean loadNotPressed;
    boolean helpOn = true;
    boolean inputOn = true;
    boolean disclaimerOn = true; // DE added for Disclaimer
    Parameters myParameters;
    String myOutput; // de added
    int cropCount = 0;
//    this is used to control whether we are creating from a load or not    
    //bcv added
    ImageIcon wallPaper = new ImageIcon(
        getAppPath() + "/visuals/switchBoard.jpg");
    
    GridBagLayout jGridBagLayout = new GridBagLayout(); // DE added
    GridBagConstraints cn = new GridBagConstraints();  // DE added
    
    JPanel jMainPanel = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jNorthPanel = new JPanel();//DE added jGridBagLayout
    JPanel jCenterPanel = new JPanel();
    JPanel jWestPanel1 = new JPanel();
    JPanel jEastPanel = new JPanel();
    JPanel jSouthPanel = new JPanel();
    
    JLabel jLTitle = new JLabel(); // title of the screen
    JComboBox jCBCrop = new JComboBox(); // choose a crop combo box
    JLabel jLCrop = new JLabel();
    JButton jBCustomize = new JButton(); // Customize Run button 
         //changed label to Set Growth Stages on Customize Run button 10/18/07
    JComboBox jCBLocation = new JComboBox(); // choose site combo box
    JLabel jLSite = new JLabel();
    JButton jBInputs = new JButton(); // Set Inputs button
    JComboBox jCBScenarios = new JComboBox(); // Load Scenario combo box
    JButton jBHelp = new JButton(); // Help button
    JButton jBRun = new JButton(); // Run button
    JButton jBLoad = new JButton(); // Load Scenario button
    JButton jBDisclaimer = new JButton(); //Show USD-ARS Disclaimer
    JLabel jLBakGround = new JLabel();
    
    /**
     *  Constructor for the SwitchboardFrame object
     *
     *@param  SHF     Description of the Parameter
     *@param  OPF     Description of the Parameter
     *@param  myPara  Description of the Parameter
     */
    public SwitchboardFrame(Frame SHF, OutPutFrame OPF, 
            Parameters myPara, DisclaimerFrame DSF) {
        loadNotPressed = true;
        myParameters = myPara;
        myHelpFrame = SHF;
        myOutputFrame = OPF;
        myDisclaimerFrame = DSF;
        
        try {
            jbInit();
            this.setSize (500, 400); //(600, 575); //(width, height)de changed then changed back to 500, 400
            this.setLocation(10, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setupWindow();
    }  // end of constructor
    

    /**
     *  Description of the Method
     *
     *@exception  Exception  Description of the Exception
     */
    private void jbInit() throws Exception {
        jMainPanel.setLayout(borderLayout1);                       
        
        jNorthPanel.setBackground(SystemColor.info);
        jNorthPanel.setPreferredSize(new Dimension(10, 40));
        jNorthPanel.setLayout(jGridBagLayout);//de changed to jGridBagLayout
        
        jCenterPanel.setBackground(SystemColor.info);
        jCenterPanel.setLayout(jGridBagLayout);//de changed to jGridBagLayout
      //jCenterPanel.setPreferredSize(new Dimension(40, 40));//de added made no difference
                
        jWestPanel1.setBackground(SystemColor.info);
        jWestPanel1.setPreferredSize(new Dimension(40, 10));
        
        jEastPanel.setBackground(SystemColor.info);
        jEastPanel.setPreferredSize(new Dimension(40, 10));
        
        jSouthPanel.setBackground(SystemColor.info);
        jSouthPanel.setMinimumSize(new Dimension(10, 40));
        jSouthPanel.setPreferredSize(new Dimension(10, 40));
        jSouthPanel.setLayout(jGridBagLayout); //de changed to jGridBagLayout
        
        jLTitle.setFont(new java.awt.Font("Dialog", 1, 22));
        jLTitle.setForeground(SystemColor.menuText);
        jLTitle.setText("Begin Setup");
               
        jLCrop.setBackground(SystemColor.info);
        jLCrop.setFont(new java.awt.Font("Dialog", 1, 18));
        jLCrop.setForeground(UIManager.getColor("TextArea.background"));
        jLCrop.setText("Choose Crop:");
        
        jBCustomize.setText("Set Growth Stages...");
        jBCustomize.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBCustomize_actionPerformed(e);
                }
            });
        jLSite.setFont(new java.awt.Font("Dialog", 1, 18));
        jLSite.setForeground(UIManager.getColor("TextArea.background"));
        jLSite.setText("Select Location/Weather File:");
        
        jBInputs.setText("Set Inputs...");
        jBInputs.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBInputs_actionPerformed(e);
                }
            });
            
        this.setDefaultCloseOperation(3);
        this.setForeground(Color.white);
        
        jBHelp.setText("Help...");
        jBHelp.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBHelp_actionPerformed(e);
                }
            });
        jBRun.setText("Run...");
        jBRun.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBRun_actionPerformed(e);
                }
            });
     //DE added to implement the 'Disclaimer...' button
        jBDisclaimer.setText("Disclaimer...");
        jBDisclaimer.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBDisclaimer_actionPerformed(e);
                }
            });
        jCBCrop.addItemListener(
            new java.awt.event.ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    jCBCrop_itemStateChanged(e);
                }
            });
        jCBLocation.addItemListener(
            new java.awt.event.ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    jCBLocation_itemStateChanged(e);
                }
            });
        jCBScenarios.setBackground(SystemColor.info);
        jCBLocation.setBackground(SystemColor.info);
        jCBCrop.setBackground(SystemColor.info);

        
        jBLoad.setText("Load Saved Scenario");//debe changed text
        jBLoad.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBLoad_actionPerformed(e);
                }
            });
        jLBakGround.setBackground(SystemColor.info);
        jLBakGround.setForeground(SystemColor.info);
        jLBakGround.setMaximumSize(new Dimension(400, 400));
        jLBakGround.setMinimumSize(new Dimension(400, 400));
        jLBakGround.setOpaque(true);
        jLBakGround.setPreferredSize(new Dimension(400, 400));
        jLBakGround.setRequestFocusEnabled(false);
        jLBakGround.setIcon(wallPaper);
        jLBakGround.setIconTextGap(0);
        jLBakGround.setText("b");
        jLBakGround.setVerticalAlignment(SwingConstants.TOP);
        jLBakGround.setVerticalTextPosition(SwingConstants.TOP);
        
        this.getContentPane().add(jMainPanel, BorderLayout.CENTER);
 
        // add panels to the main container which has a BorderLayout manager
        jMainPanel.add(jNorthPanel, BorderLayout.NORTH);
        jMainPanel.add(jWestPanel1, BorderLayout.WEST);
        jMainPanel.add(jEastPanel, BorderLayout.EAST);
        jMainPanel.add(jSouthPanel, BorderLayout.SOUTH);                
        jMainPanel.add(jCenterPanel, BorderLayout.CENTER);//de moved code to here
        
//      Add components to various panels
        
//      jNorthPanel
        addItem(jLTitle, 0, 0, 1, 1, "jNorthPanel");    
        
//      jSouthPanel
//      addItem(jBHelp, 0, 0, 1, 1, "jSouthPanel");//move to center panel
        addItem(jBInputs, 0, 0, 1, 1, "jSouthPanel");//moved from center panel  
        addItem(jBCustomize, 0, 1, 1, 1, "jSouthPanel"); 
        addItem(jBRun, 0, 2, 1, 1, "jSouthPanel");
//        addItem(jBDisclaimer, 0, 3, 1, 1, "jSouthPanel");//move to center panel
      

//      jCenterPanel
        cn.anchor = GridBagConstraints.CENTER;
        addItem(jLCrop, 0, 0, 1, 1, "jCenterPanel"); 

        cn.anchor = GridBagConstraints.CENTER;
        addItem(jLSite, 1, 0, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.CENTER;
        addItem(jBLoad, 2, 0, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.CENTER;    
        addItem(jBHelp, 4, 0, 1, 1, "jCenterPanel");//moved from south panel
        
        cn.anchor = GridBagConstraints.WEST;
        addItem(jCBCrop, 0, 1, 1, 1, "jCenterPanel");

        cn.anchor = GridBagConstraints.WEST;
        addItem(jCBLocation, 1, 1, 1, 1, "jCenterPanel");

        cn.anchor = GridBagConstraints.WEST;
        addItem(jCBScenarios, 2, 1, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.WEST;
        addItem(jBDisclaimer, 4, 1, 1, 1, "jCenterPanel");//moved from south panel

//      add background to center panel
        cn.fill = GridBagConstraints.BOTH;
        addItem(jLBakGround, 0, 0, 3, 5, "jCenterPanel"); 
      }// end of jbInit method
   

    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */

    void jBCustomize_actionPerformed(ActionEvent e) {
        myParameters.cropType = jCBCrop.getSelectedItem().toString();
        myParameters.location = jCBLocation.getSelectedItem().toString();
        myHelpFrame.setVisible(false);
        this.setVisible(false);
        customizeFrame.setVisible(true);

    }


    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */

 
//    //old way of accessing help text files
    void jBHelp_actionPerformed(ActionEvent e) {
		//if(RoboHelp.openHelpPage("Setup/Begin_Setup.htm")) {
                if(RoboHelp.openHelpPage("Begin_Setup.htm")) {    
			return;
		}
		
        if (helpOn == true) {
			myHelpFrame.setVisible(true);
            helpOn = false;
        } else {
            myHelpFrame.setVisible(false);
            helpOn = true;
        }
    }
 
    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jBInputs_actionPerformed(ActionEvent e) {
       InputFrame IPF = new InputFrame(new InputHelpFrame(), new TempSettingsFrame(TempSettingsHelpFrame, myParameters), myParameters);      
        if (inputOn == true) {
            IPF.setSwitchBoardReff(this);
            IPF.setVisible(true);
        }   
        else {
            IPF.setVisible(false);
            inputOn = true;
        }
    } // end of method jBInputs_actionPerformed


    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jBRun_actionPerformed(ActionEvent e) {
        myRun = new Run(myParameters); // loadNotPressed);
        this.setVisible(false);
        
        myOutputFrame.setBackRefference(this);
        myOutputFrame.setParameters(myParameters);
        myOutputFrame.setVisible(true);
        
        myOutputFrame.writeText(myRun.getOutput());
        
    }          
    // DE added for the Disclaimer button
        void jBDisclaimer_actionPerformed(ActionEvent e) {
        if (disclaimerOn == true) {
            myDisclaimerFrame.setVisible(true);
            disclaimerOn = false;
        } else {
            myDisclaimerFrame.setVisible(false);
            disclaimerOn = true;
        }
    }

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
        
    }// end of addItem method


    /**
     *  Description of the Method
     */
    private void setupWindow() {
//    **************  set up for crop type******************
        String[] myVarFiles;
        String varDir = "\\VarTypes";
        // bcv added
        String varPath = getAppPath();
        
        //GiveFiles varFiles = new GiveFiles(varPath, varDir, "txt");
        //debe changed extension to "dat"
        GiveFiles varFiles = new GiveFiles(varPath, varDir, "dat");
        myVarFiles = varFiles.getFileList();

        for (int i = 0; i < myVarFiles.length; i++) {
            jCBCrop.addItem(myVarFiles[i].substring(0, myVarFiles[i].indexOf(".")));
            if (myVarFiles[i].substring(0, myVarFiles[i].indexOf("."))
             .equalsIgnoreCase("Winter Wheat")) {
                jCBCrop.setSelectedIndex(i);
               }
            }
                    // pass number of crops in the list 
        jCBCrop.setMaximumRowCount(myVarFiles.length);

//      *************** set up for location**********************
        String[] myLocationFiles;
        String locDir = "\\MMSWeather";
        //bcv added
        String path = getAppPath();
       // GiveFiles locFiles = new GiveFiles(path, locDir, "txt");
        //debe change file extension to .dat
        GiveFiles locFiles = new GiveFiles(path, locDir, "dat");
        myLocationFiles = locFiles.getFileList();

        for (int i = 0; i < myLocationFiles.length; i++) {
            jCBLocation.addItem(myLocationFiles[i].substring(0, myLocationFiles[i].indexOf(".")));
            //set default location
            if (myLocationFiles[i].substring(0, myLocationFiles[i].indexOf(".")).equalsIgnoreCase("Akron_CO_1808")) {
                jCBLocation.setSelectedIndex(i);
            }
        }

//        *************** set up for saved scenarios*************
        String[] mySaveFiles;
        String locDirSaves = "\\saves";
        //bcv added
        String pathSaves = getAppPath();
        //locSaveFiles = new GiveFiles(pathSaves, locDirSaves, "txt");
        //debe changed file extension to .dat
        locSaveFiles = new GiveFiles(pathSaves, locDirSaves, "dat");
        mySaveFiles = locSaveFiles.getFileList();

        for (int i = 0; i < mySaveFiles.length; i++) {
            jCBScenarios.addItem(mySaveFiles[i].
                substring(0, mySaveFiles[i].indexOf(".")));
        }

            
    }// end of setupWindow method

    /**
     *  Description of the Method
     *
     *@param  e  Choose which customize frame is needed
     */
    void jCBCrop_itemStateChanged(ItemEvent e) {
       //these are the default values by crop that get loaded in the input frame
        //de added for dry beans. //need parameters for dry beans!
        //debbie changed values for parameters for dry beans. Still need true parameter values.
            myParameters.cropType = jCBCrop.getSelectedItem().toString().trim();
        if (myParameters.cropType.equalsIgnoreCase("corn")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "05/11/2009"; //"04/25/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "4.5";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "8"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "2"; 
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "35.0";                
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "10";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "25";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "30";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "260"; //190.0";

            myParameters.myStages = new GrowthStages();         
        }else if (myParameters.cropType.equalsIgnoreCase("dry beans")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "06/09/2009"; //"06/01/2004";
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "5.0";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "18";
            myParameters.latitude = myParameters.latitude_ORG = "40.165";
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "2";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "32.0";
            //de added
            myParameters.baseTemp = myParameters.baseTemp_ORG = "10";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "24";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "30";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "35";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "40.0";

            myParameters.myStages = new GrowthStages();
        }else if (myParameters.cropType.equalsIgnoreCase("winter barley")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "10/02/2009"; //09/09/2004";     
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "4";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "128"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";            
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";            
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "1";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "105.0";
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "0";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "18";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "22";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "90.0";
            
            myParameters.myStages = new GrowthStages();
        }else if (myParameters.cropType.equalsIgnoreCase("spring barley")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "04/28/2009"; //04/05/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "4";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "241"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";        
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "1";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "69"; //80.0";
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "0";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "18";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "22";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";               
            myParameters.canopyHt = myParameters.canopyHt_ORG = "90.0";

            myParameters.myStages = new GrowthStages();
        }else if (myParameters.cropType.equalsIgnoreCase("winter wheat")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "10/02/2009"; //09/15/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "5";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "133"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";                     
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "1";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "105.0";       
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "0";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "18";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "22";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "110.0"; //"90";
                   
            myParameters.myStages = new GrowthStages();
        }else if (myParameters.cropType.equalsIgnoreCase("spring wheat")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "04/28/2009"; //"03/23/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "4";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "200"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";          
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "1";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "80.0";           
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "0";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "18";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "22";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "100.0";

            myParameters.myStages = new GrowthStages();
        }else if (myParameters.cropType.equalsIgnoreCase("proso millet")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "05/20/2009"; //06/07/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "2";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "257"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";            
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "1";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "34.0"; //105.0"; 
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "10"; //0";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "25"; //20";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "30"; //24";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "90.0";
   
            myParameters.myStages = new GrowthStages();
        }else if (myParameters.cropType.equalsIgnoreCase("hay millet")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "05/20/2009"; //06/07/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "2";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "435"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";            
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "1";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "34.0"; //105.0"; 
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "10"; //0";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "25"; //20";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "30"; //24";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "90.0";

            myParameters.myStages = new GrowthStages();
        }else if (myParameters.cropType.equalsIgnoreCase("sorghum")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "06/12/2009"; //05/28/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "5";// was 2
            myParameters.plantingRate = myParameters.plantingRate_ORG = "19"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";            
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";            
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "2";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "45.0"; //was57
            //de added           
            myParameters.baseTemp = myParameters.baseTemp_ORG = "7"; //"10";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "25";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "30";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "150.0";
            
            myParameters.myStages = new GrowthStages();
        }else if (myParameters.cropType.equalsIgnoreCase("sunflower")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "06/19/2009"; //06/01/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "5";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "7"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";        
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";            
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "2";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "30.0"; 
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "7";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "24";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "30";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "190.0";
            
            myParameters.myStages = new GrowthStages();
            }else if (myParameters.cropType.equalsIgnoreCase("soybean")) {
            myParameters.plantingDate = myParameters.plantingDate_ORG = "05/31/2009"; //05/20/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "3";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "27";  
            myParameters.latitude = myParameters.latitude_ORG = "40.165";        
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";            
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "2";
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "54.0"; 
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "10";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "22";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "30";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "90"; //120.0";
            
            myParameters.myStages = new GrowthStages();
        //    myParameters.cropType = jCBCrop.getSelectedItem().toString().trim();
        }else{
            myParameters.plantingDate = myParameters.plantingDate_ORG = "10/02/2009"; //09/15/2004"; 
            myParameters.plantingDepth = myParameters.plantingDepth_ORG = "5";
            myParameters.plantingRate = myParameters.plantingRate_ORG = "133"; 
            myParameters.latitude = myParameters.latitude_ORG = "40.165";
            myParameters.soilMoisturePlanting = myParameters.soilMoisturePlanting_ORG = "Optimum";            
            myParameters.GDDMethod = myParameters.GDDMethod_ORG = "1";            
            myParameters.phyllochronValue = myParameters.phyllochronValue_ORG = "105.0"; 
            //de added          
            myParameters.baseTemp = myParameters.baseTemp_ORG = "0";
            myParameters.optimumTempLow = myParameters.optimumTempLow_ORG = "18";
            myParameters.optimumTempUp = myParameters.optimumTempUp_ORG = "22"; //18";
            myParameters.upperTemp = myParameters.upperTemp_ORG = "40";
            myParameters.canopyHt = myParameters.canopyHt_ORG = "110"; //90.0";
        }

//        we don't want to run setCustomizeFrame from here if we are loading a 
//        scenario
        if (loadNotPressed) {// if load button has not been pressed 
                            //(i.e. loadNotPressed = true, don't use scenario 
                           //data for growth stages screen
            this.setCustomizeFrame(false);
        } else {
            loadNotPressed = true;
        }

    } //end of jCBCrop_itemStateChanged

    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jCBLocation_itemStateChanged(ItemEvent e) {
        myParameters.location = jCBLocation.getSelectedItem().toString();
    }


    /**
     *  Sets the parameters attribute of the SwitchboardFrame object
     *
     *@param  myPara  The new parameters value
     */
    public void setParameters(Parameters myPara) {
        myParameters = myPara;
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
    // loads a scenario chosen from the scenario combo box
    void jBLoad_actionPerformed(ActionEvent e) {
        File myFiles[] = locSaveFiles.getFiles();
        File f1 = null;
        String myLine;
        String tmpFilename;
        String tmp;
        StringTokenizer stLineone = null;
        //String seeking = (jCBScenarios.getSelectedItem().toString() + ".txt");
        //debe changed extension to .dat
        String seeking = (jCBScenarios.getSelectedItem().toString() + ".dat");
        boolean found = false;
        loadNotPressed = false;
        
        for (int i = 0; i < myFiles.length; i++) {
            if (seeking.equalsIgnoreCase(myFiles[i].getName())) {
                f1 = myFiles[i];
            }
        }

        try {
            FileReader fin = new FileReader(f1);
            BufferedReader in = new BufferedReader(fin);
            while ((myLine = in.readLine()).indexOf("**") == -1) {               
            }

//          this is where we read in from file
            stLineone = new StringTokenizer(in.readLine(), ",");
            gData = new StringTokenizer(in.readLine(), ",");
            in.close();
        } catch (Exception ex) {
            System.out.println("File Error: " + ex.toString());
        }
// set crop
        tmp = stLineone.nextToken().trim();
        for (int i = 0; i < jCBCrop.getItemCount(); i++) {
            if (jCBCrop.getItemAt(i).toString().equalsIgnoreCase(tmp)) {
                jCBCrop.setSelectedItem(jCBCrop.getItemAt(i));

            }
        }

//        set variety type
        myParameters.myStages.myType = stLineone.nextToken();
//        set location
        myParameters.location = tmp = stLineone.nextToken().trim();
        for (int i = 0; i < jCBLocation.getItemCount(); i++) {
            if (jCBLocation.getItemAt(i).toString().trim().equalsIgnoreCase(tmp)) {
                jCBLocation.setSelectedItem(jCBLocation.getItemAt(i));
            }
        }

//        set planting day
        myParameters.day = stLineone.nextToken().trim();
//        set planting month
        myParameters.month = stLineone.nextToken().trim();
//        set planting year
        myParameters.year = stLineone.nextToken().trim();
//        put day, month and year together to overwrite the default planting date.        
        myParameters.plantingDate = (myParameters.month + "/" + myParameters.day + "/" + myParameters.year);
//        set dayOfYear
        myParameters.dayOfYear = stLineone.nextToken();
//        set planting depth
        myParameters.plantingDepth = stLineone.nextToken();
//        set planting rate
        myParameters.plantingRate = stLineone.nextToken();
//        set soil moisture
        myParameters.soilMoisturePlanting = stLineone.nextToken();
//        set latitude
        myParameters.latitude = stLineone.nextToken();
//        set GDD method
        myParameters.GDDMethod = stLineone.nextToken();
//        set base temperature
        myParameters.baseTemp = stLineone.nextToken();
//        set optimum temperature
        myParameters.optimumTempLow = stLineone.nextToken();
//        set optimum temperature
        myParameters.optimumTempUp = stLineone.nextToken();
//        set upper temperature
        myParameters.upperTemp = stLineone.nextToken();   
//        set phyllochron value            
        myParameters.phyllochronValue = stLineone.nextToken();        
//        set maximum canopy height method
        myParameters.canopyHt = stLineone.nextToken();

        this.setCustomizeFrame(true);
    } // end of jBLoad_actionPerformed method


    /**
     *  Sets the customizeFrame attribute of the SwitchboardFrame object
     *
     *@param  fromLoad  The new customizeFrame value
     */
    private void setCustomizeFrame(boolean fromLoad) {
        if (myParameters.cropType.equalsIgnoreCase("Winter Wheat")) {
            if (fromLoad) {
                customizeFrame = new WWSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new WWSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            WWSetGDDFrame tmp = (WWSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
            //de added for dry beans
        } else if (myParameters.cropType.equalsIgnoreCase("Dry Beans")) {
            if (fromLoad) {
                customizeFrame = new BNSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(),
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new BNSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(),
                new OutPutFrame(myParameters), myParameters);
            }
            BNSetGDDFrame tmp = (BNSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        //end of that added for dry beans    de
        } else if (myParameters.cropType.equalsIgnoreCase("Corn")) {
            if (fromLoad) {
                customizeFrame = new CNSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new CNSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            CNSetGDDFrame tmp = (CNSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        } else if (myParameters.cropType.equalsIgnoreCase("Spring Wheat")) {
            if (fromLoad) {
                customizeFrame = new SWSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new SWSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            SWSetGDDFrame tmp = (SWSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        } else if (myParameters.cropType.equalsIgnoreCase("Proso Millet")) {
            if (fromLoad) {
                customizeFrame = new PMSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                 customizeFrame = new PMSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            PMSetGDDFrame tmp = (PMSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        } else if (myParameters.cropType.equalsIgnoreCase("Hay Millet")) {
            if (fromLoad) {
                customizeFrame = new HMSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new HMSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            HMSetGDDFrame tmp = (HMSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        } else if (myParameters.cropType.equalsIgnoreCase("Winter Barley")) {
            if (fromLoad) {
                customizeFrame = new WBSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new WBSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            WBSetGDDFrame tmp = (WBSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        } else if (myParameters.cropType.equalsIgnoreCase("Spring Barley")) {
            if (fromLoad) {
                customizeFrame = new SBSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new SBSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            SBSetGDDFrame tmp = (SBSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        } else if (myParameters.cropType.equalsIgnoreCase("Sorghum")) {
            if (fromLoad) {
                customizeFrame = new SGSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new SGSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            SGSetGDDFrame tmp = (SGSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        } else if (myParameters.cropType.equalsIgnoreCase("Sunflower")) {
            if (fromLoad) {
                customizeFrame = new SFSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new SFSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            SFSetGDDFrame tmp = (SFSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        } else if (myParameters.cropType.equalsIgnoreCase("Soybean")) {
            if (fromLoad) {
                customizeFrame = new SYSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters, gData);
            } else {
                customizeFrame = new SYSetGDDFrame(new SetGDDHelpFrame(), //new SwitchHelpFrame(), 
                new OutPutFrame(myParameters), myParameters);
            }
            SYSetGDDFrame tmp = (SYSetGDDFrame) customizeFrame;
            tmp.setBackReferance(this);
        }
        
    }  // end method setCustomizeFrame

} // end class SwitchboardFrame


