// OutPutFrame.java

package MMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.io.*;
//import java.util.*;

/**
 *  Title:       MMS Test2 
 *  Description: Started 9 Sept 2002 
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       October 15, 2002
 *@version       1.0
 *
 *revised        Debbie Edmunds, February, 2005
 *
 */

public class OutPutFrame extends JFrame {
    // declarations
    Parameters myParameters;
    Frame BackRef;
    
    // layout managers and constraints
    BorderLayout borderLayout1 = new BorderLayout();
    GridBagLayout jGridBagLayout = new GridBagLayout();// DE added
    GridBagConstraints cn = new GridBagConstraints();  // DE added
    
    // panels
    JPanel jMainPanel = new JPanel();    
    JPanel jNorthPanel = new JPanel();
    JPanel jSouthPanel = new JPanel();
    JPanel jEastPanel = new JPanel();
    JPanel jWestPanel = new JPanel();
    JPanel jCenterPanel = new JPanel();
    
    //title
    JLabel jTitleLabel = new JLabel();
    
    //buttons
    JButton jBack = new JButton();
    JButton jBSaveOut = new JButton();
    JButton jExit = new JButton();
    JButton jBsaveScn = new JButton();
    
    //panes
    JScrollPane jSPOutPut = new JScrollPane();
    JTextPane jTPOutPut = new JTextPane();    
    
    String newLine;
    Run myRun;


    /**
     *  Constructor for the OutPutFrame object
     *
     *@param  myPara  Description of the Parameter
     */
    public OutPutFrame(Parameters myPara){
        myParameters = myPara;
        this.setSize(900, 560);//(width, height)
        this.setLocation(1,10);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // end of constructor


    /**
     *  Description of the Method
     *
     *@exception  Exception  Description of the Exception
     */
    private void jbInit() throws Exception {
        //set characteristics for components
        
        //jMainPanel
        jMainPanel.setLayout(borderLayout1);
        
        //jNorthPanel
        jNorthPanel.setBackground(SystemColor.info);
        jNorthPanel.setPreferredSize(new Dimension(10, 40));
        jNorthPanel.setLayout(jGridBagLayout);//de changed to jGridBagLayout
        
        //jSouthPanel
        jSouthPanel.setBackground(SystemColor.info);
        jSouthPanel.setPreferredSize(new Dimension(10, 40));
        jSouthPanel.setLayout(jGridBagLayout);//de changed to jGridBagLayout
        
        //jEastPanel
        jEastPanel.setBackground(SystemColor.info);
        
        //jWestPanel
        jWestPanel.setBackground(SystemColor.info);
        
        //jCenterPanel    
        jCenterPanel.setBackground(SystemColor.info);
        jCenterPanel.setSize(870, 500);//800, 420
        
        //jTitleLabel
        jTitleLabel.setFont(new java.awt.Font("Dialog", 1, 24));
        jTitleLabel.setText("Output From Phenology MMS");
        
        
        //buttons functionality
        this.setDefaultCloseOperation(3);
        jBack.setText("Back...");
        jBack.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBack_actionPerformed(e);
                }
            });
            
        jBSaveOut.setText("Save Output...");
        jBSaveOut.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBSaveOut_actionPerformed(e);
                }
            });
            
        jExit.setText("Exit");
        jExit.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jExit_actionPerformed(e);
                }
            });
        
        jBsaveScn.setText("Save Scenario...");
        jBsaveScn.addActionListener(
            new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jBsaveScn_actionPerformed(e);
                }
            });      
        
        //scrollpane
        jSPOutPut.setVerticalScrollBarPolicy
            (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jSPOutPut.setHorizontalScrollBarPolicy
            (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//de added
        jSPOutPut.setPreferredSize(new Dimension(780, 460)); 
        
        //textpane
        jTPOutPut.setFont(new java.awt.Font("DialogInput", 1, 12));
        
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
        addItem(jBack, 0, 0, 1, 1, "jSouthPanel");
        addItem(jBSaveOut, 0, 1, 1, 1, "jSouthPanel");
        addItem(jBsaveScn, 0, 2, 1, 1, "jSouthPanel");
        addItem(jExit, 0, 3, 1, 1, "jSouthPanel");
        
        //add ScrollPane to jCenterPanel
        addItem(jSPOutPut, 0, 0, 1, 1,  "jCenterPanel");
        jSPOutPut.getViewport().add(jTPOutPut, null);
    }//end of jbInit method


    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jExit_actionPerformed(ActionEvent e) {
        System.exit(0);
    }


    /**
     *  Sets the backRefference attribute of the OutPutFrame object
     *
     *@param  BKFM  The new backRefference value
     */
    public void setBackRefference(Frame BKFM) {
        BackRef = BKFM;
    }

    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jBack_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        BackRef.setVisible(true);
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
     *  Sets the parameters attribute of the OutPutFrame object
     *
     *@param  myPara  The new parameters value
     */
    // this is called from setUpTemplate
    public void setParameters(Parameters myPara) {
        myParameters = myPara;
        setUpWindow();
        
    }  
    
    /**
     *  Sets the upWindow attribute of the OutPutFrame object
     */
    private void setUpWindow() {
        jTPOutPut.setText(myParameters.toString());
       
    }
    
    // This method adds the output from the Fortran run to the input parameters 
    // already on the output screen.  It is called from the 
    // jRunButton_actionPerformed method in each cropSetGDDFrame class.
    public void writeText(String t){
        String outText;
        String tempText;
        String line;        
        
        line = "-----------------------------------------------------------";
        
        //t = myRun.getOutput i.e., contents from the Fortran file run.
        // tempText holds what is already written to the output screen.
        tempText = jTPOutPut.getText();

        outText = "These are the inputs provided to execute PhenologyMMS:" + 
            "\n\n" + tempText + "\n" + line + "\n" +
            line + "\n" + "Path: " + t; //myFile.getAbsolutePath() + t;
        jTPOutPut.setText(outText);   
        
       //out.write("Path: " + myFile.getAbsolutePath());
        
    } // end of method writeText
    
        //Run myRun = new Run();
        //myRun = Run.getOutput();
        
    /**
     *  Description of the Method
     *
     *@param  e  Description of the Parameter
     */
    void jBSaveOut_actionPerformed(ActionEvent e) {
        String newText;
        
        OutputSaveFrame OPS = new OutputSaveFrame();
        
        //newText includes myParameters.toString and the output from the Fortran run.
        newText = jTPOutPut.getText();
        OPS.setOutPut(newText);
        
        OPS.setVisible(true);
    }

    // for Save Scenario button
  void jBsaveScn_actionPerformed(ActionEvent e) {
      SaveParametersFrame SPF = new SaveParametersFrame();
      SPF.setParameters(myParameters);
      SPF.setVisible(true);

  }
}

