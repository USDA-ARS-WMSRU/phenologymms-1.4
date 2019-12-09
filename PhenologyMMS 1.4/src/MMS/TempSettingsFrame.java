// TempSettingsFrame.java
 
package MMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.URL;

/**
 *  Title:       PhenologyMMS  
 *  Description: Started July 1, 2011
 *  Copyright:   Copyright (c) 2011 
 *  Company:     USDA/ARS
 *
 * @author debbie.edmunds; Ben Riebau provided the base for this class
 * @created       July 1, 2011
 * @version       1.0
 *
 *revised        
 */

//following is copied from Set Inputs screen. Delete what is to be left in Set Inputs
//Change code as needed for this new screen.

// Temp Settings screen
public class TempSettingsFrame extends JFrame{
    //declarations
    Parameters myParameters;
    InputFrame myInputFrame;
    Frame TSHF;
    TempSettingsHelpFrame myTempSettingsHelpFrame; // de added
    OutPutFrame myOutputFrame; // de added
    StringTokenizer stGDDMethod; 
      
    Run myRun;  // de added
    Date myDate; // de added
    int myMonth; // de added
    int myDay; // de added
    boolean helpOn = true;

    // panels
    JPanel jMainPanel = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    
    JPanel jSouthPanel = new JPanel();
    JPanel jNorthPanel = new JPanel();
    JPanel jCenterPanel = new JPanel();   
    
    // declare GridBagLayout manager and constraints
    GridBagLayout jGridBagLayout = new GridBagLayout(); 
    GridBagConstraints cn = new GridBagConstraints(); 
    
    // components in each container. 
    JLabel jTitleLabel = new JLabel(); 
        
    // phyllochron method
   //take out phyllochron equations choice and combobox. DE 03/20/07
    JLabel jPhyllochronLabel = new JLabel();
    JTextField jTFPhyDeff = new JTextField();
   
    // GDD method
    JLabel jGDDCalcLabel = new JLabel();
    JComboBox jCBGDDmethod = new JComboBox();
     
    // Temperatures
    JLabel jTemperaturesLabel = new JLabel();
    JLabel jBaseLabel = new JLabel();
    JTextField jTFBase = new JTextField();
    JLabel jOptimumLabelLow = new JLabel();
    JLabel jOptimumLabelUp = new JLabel();
    JTextField jTFOptimumLow = new JTextField();
    JTextField jTFOptimumUp = new JTextField();
    JLabel jUpperLabel = new JLabel();
    JTextField jTFUpper = new JTextField();
    
    //Caution label
    JLabel jCautionLabel = new JLabel();
      
    // buttons to "close and save", "reset" or "run" and for "help"
    JButton jBHelp = new JButton();
    JButton jBClose = new JButton();
    JButton jBReset = new JButton();
    JButton jBRun = new JButton();
    
    // background
    //bcv added
    ImageIcon slpsh = new ImageIcon  // de added full pathname
      //  (getAppPath() + "/visuals/InputScreen.jpg");//use same image to tie it to Inputs screen 
        (getAppPath() + "/visuals/TemperatureScreen-small-medium.jpg");
    JLabel jLbkgrnd = new JLabel();
    
    // button group for radio buttons
    ButtonGroup phyGroup = new ButtonGroup();
     //what is this for?

    /**
     *  Constructor for the TempSettingsFrame object
     *
     *@param  myPara  Description of the Parameter
     */
    public TempSettingsFrame (Frame TSHF, Parameters myPara){ 
        myParameters = myPara;
        myTempSettingsHelpFrame = (TempSettingsHelpFrame) TSHF; 
        try {
            this.setSize(600, 575); //(width, height)
            this.setLocation(10, 3); 
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
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
        jTitleLabel.setText("Temperatures (C)");
               
        // phyllochron method
        jPhyllochronLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jPhyllochronLabel.setForeground(Color.white);
        jPhyllochronLabel.setText("Growing Degree-Days Per Leaf:");
        
        jTFPhyDeff.setBackground(SystemColor.info);
        jTFPhyDeff.setHorizontalAlignment(SwingConstants.CENTER);
                
        // set up GDD Method combo box
        jGDDCalcLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jGDDCalcLabel.setForeground(SystemColor.textHighlightText);
        jGDDCalcLabel.setText("GDD Method:");
        
        jCBGDDmethod.setBackground(SystemColor.info);                
        jCBGDDmethod.addItem("1");
        jCBGDDmethod.addItem("2");
        jCBGDDmethod.addItem("3");
        jCBGDDmethod.addItem("4");//debe added method 4
          
        jCBGDDmethod.addItemListener(  //de added 052107
            new java.awt.event.ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    jCBGDDmethod_itemStateChanged(e);
                }
            });
        
        //Caution 
        jCautionLabel.setFont(new java.awt.Font("Dialog", 1, 24));
        jCautionLabel.setForeground(Color.ORANGE);
        jCautionLabel.setText("CAUTION - DO NOT CHANGE!");
        
        // Temperatures
        jTemperaturesLabel.setFont(new java.awt.Font("Dialog", 1, 22));
        jTemperaturesLabel.setForeground(Color.YELLOW); //SystemColor.textHighlightText);
        jTemperaturesLabel.setText("Temperatures (C):");
        
        jBaseLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jBaseLabel.setForeground(SystemColor.YELLOW);
        jBaseLabel.setText("Base:");
        
        jOptimumLabelLow.setFont(new java.awt.Font("Dialog", 1, 14));
        jOptimumLabelLow.setForeground(SystemColor.YELLOW);
        jOptimumLabelLow.setText("Lower Optimum:");
        
        jOptimumLabelUp.setFont(new java.awt.Font("Dialog", 1, 14));
        jOptimumLabelUp.setForeground(SystemColor.YELLOW);
        jOptimumLabelUp.setText("Upper Optimum:");
        
        jUpperLabel.setFont(new java.awt.Font("Dialog", 1, 14));
        jUpperLabel.setForeground(SystemColor.YELLOW);
        jUpperLabel.setText("Upper/Maximum:");
        
        jTFBase.setBackground(SystemColor.info);
        jTFBase.setHorizontalAlignment(SwingConstants.CENTER);      
        jTFOptimumLow.setBackground(SystemColor.info);
        jTFOptimumLow.setHorizontalAlignment(SwingConstants.CENTER);
        jTFOptimumUp.setBackground(SystemColor.info);
        jTFOptimumUp.setHorizontalAlignment(SwingConstants.CENTER);
        
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
                       
        //Center Panel        
          //Caution Label
        cn.anchor = GridBagConstraints.CENTER;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jCautionLabel, 0, 0, 2, 1, "jCenterPanel");
        
        //Temperatures
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jBaseLabel, 1, 0, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.BASELINE;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFBase, 2, 0, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jOptimumLabelLow, 1, 1, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.BASELINE;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFOptimumLow, 2, 1, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jOptimumLabelUp, 3, 0, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.BASELINE;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFOptimumUp, 4, 0, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jUpperLabel, 3, 1, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.BASELINE;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFUpper, 4, 1, 1, 1, "jCenterPanel");
         
        //GDD Calc Method
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jGDDCalcLabel, 7, 0, 1, 1, "jCenterPanel");
        
        cn.anchor = GridBagConstraints.BASELINE;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jCBGDDmethod, 8, 0, 1, 1, "jCenterPanel");
        
        //Phyllochron
        cn.anchor = GridBagConstraints.SOUTH;
        cn.fill = GridBagConstraints.CENTER;
        addItem(jPhyllochronLabel, 7, 1, 1, 1, "jCenterPanel");
       
        cn.anchor = GridBagConstraints.BASELINE;
        cn.fill = GridBagConstraints.HORIZONTAL;
        addItem(jTFPhyDeff, 8, 1, 1, 1, "jCenterPanel");       

        cn.fill = GridBagConstraints.BOTH;
        addItem(jLbkgrnd, 0, 0, GridBagConstraints.REMAINDER, 25, "jCenterPanel");
                
    } // end of jbInit method

 /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jBHelp_actionPerformed(ActionEvent e) {
		if(RoboHelp.openHelpPage("Temperatures/Temperatures.htm")) { 
			return;
		}
		
        if (helpOn == true) {
            myTempSettingsHelpFrame.setVisible(true);
            helpOn = false;
        } else {
            myTempSettingsHelpFrame.setVisible(false);
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
    
    /**
     *  Description of the Method
     */
    private void setWindow() {       
        // de added
        jTFPhyDeff.setText(myParameters.phyllochronValue);
        
        jTFBase.setText(myParameters.baseTemp);
        jTFOptimumLow.setText(myParameters.optimumTempLow);
        jTFOptimumUp.setText(myParameters.optimumTempUp);
        jTFUpper.setText(myParameters.upperTemp);        
        
//       set GDD method
        for (int i = 0; i < jCBGDDmethod.getItemCount(); i++) {
             jCBGDDmethod.setSelectedItem(myParameters.GDDMethod.trim());            
        }  // end of for loop
     
    } // end of setWindow method
    
    
    // de added
    private void saveInput() {
        JRadioButton tmpButton = null;//are these 2 lines needed?
        Enumeration e1 = phyGroup.getElements();

        myParameters.phyllochronValue = jTFPhyDeff.getText().trim();
        myParameters.GDDMethod = (String) jCBGDDmethod.getSelectedItem();

       // save temperature values
       myParameters.baseTemp = jTFBase.getText();
       myParameters.optimumTempLow = jTFOptimumLow.getText();
       myParameters.optimumTempUp = jTFOptimumUp.getText();
       myParameters.upperTemp = jTFUpper.getText();
       
       myInputFrame.setParameters(myParameters);
        
    } // end of saveInput method
        
    /**
     *  Description of the Method
     */
    private void resetWindow() {
             
        if (myParameters.cropType.equals("Corn")) 
            jCBGDDmethod.setSelectedIndex(1);//these use method 2
        else if (myParameters.cropType.equals("Dry Beans"))
            jCBGDDmethod.setSelectedIndex(1);
        else if (myParameters.cropType.equals("Sorghum"))
            jCBGDDmethod.setSelectedIndex(1);       
        else if (myParameters.cropType.equals("Sunflower"))
            jCBGDDmethod.setSelectedIndex(1);
        else jCBGDDmethod.setSelectedIndex(0);//these use method 1

        //de added
        jTFBase.setText(myParameters.baseTemp_ORG);
        jTFOptimumLow.setText(myParameters.optimumTempLow_ORG);
        jTFOptimumUp.setText(myParameters.optimumTempUp_ORG);
        jTFUpper.setText(myParameters.upperTemp_ORG);
                      
        jTFPhyDeff.setText(myParameters.phyllochronValue);
    } // end of resetWindow method


    /**
     *  Sets the parameters attribute of the TempSettingsFrame object
     *
     *@param  myPara  The new parameters value
     */
    public void setParameters(Parameters myPara) {
        myParameters = myPara; 
        
    } // end of method setParameters
    
    /**
     *  Sets the InputFrame attribute of the TempSettingsFrame object
     *
     *@param  myIF  The new InputFrameReff value
     */
    public void setInputFrameReff(InputFrame myIF) {
        myInputFrame = myIF;
    }

    
   /**
     *  Description of the Method: This is where soil moisture is saved in the
     *  parameters list.
     *
     *@param  e  Description of the Parameter
     */    
    
    // to save the GDDMethod value if it is changed
     void jCBGDDmethod_itemStateChanged(ItemEvent e) {
        myParameters.GDDMethod = (String) jCBGDDmethod.getSelectedItem();
     }
} // end of class TempSettingsFrame



