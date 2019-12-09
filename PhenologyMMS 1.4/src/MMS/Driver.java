// Driver.java

package MMS;

/**
 *  Title:       MMS Test2 
 *  Description: Started 9 Sept 2002 
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 
 *@author        Ben Riebau
 *@created       September 16, 2002
 *@version       1.0
 *
 *edited comments and organization, Debbie Edmunds, February, 2005
 *
 */

public class Driver {

    /**
     *  Constructor for the Driver object
     */
    public Driver() { }


    /**
     *  This is the main program, and basically handles all the calls to all the
     *  frames organizing the order in which things occur in the program. 
     *  The Frames called are: 
     *      WelcomeFrame =  a splash screen welcoming the user 
     *      SwitchboardFrame = where the basic run information is entered 
     *
     *@param  args  The command line arguments
     */

    public static void main(String[] args) {
//        this is where variables and classes are declared
        Parameters myParameters = new Parameters();
        Thread myThread = Thread.currentThread();
        

//        this is where the splash screen and the beginning screen 
            //frames are created 
        WelcomeFrame WFM = new WelcomeFrame(); // splash screen
        SwitchboardFrame SBF = new SwitchboardFrame  // Begin Setup screen
            (new SwitchHelpFrame(), new OutPutFrame(myParameters), 
             myParameters, new DisclaimerFrame());

//        Show splash screen
        WFM.setVisible(true);
        try {
//        this is in milliseconds
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println("problem with sleeping main thread: " + ex);
        }
        WFM.setVisible(false);

//        show the switchboard and set up run
        SBF.setVisible(true);
    }
    
    
}

