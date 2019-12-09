// SFGrowthStages.java

package MMS;

/**
 *  Title:        MMS Test2 
 *  Description: Started 9 Sept 2002 
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       January 2, 2003
 *@version       1.0
 *
 *This class was added by Debbie Edmunds, July 7, 2005
 */

public class SFGrowthStages extends GrowthStages {


    public String toString() {
        StringBuffer myLine = new StringBuffer();

        myLine.append("Seeding to Emergence              = " + ROW1_Choice + "\n");
        myLine.append("E to 4th Leaf (V4)                = " + ROW2_Choice + "\n");
        myLine.append("V4 to 8th Leaf (V8)               = " + ROW3_Choice + "\n");
        myLine.append("V8 to 12th Leaf (v12)             = " + ROW4_Choice + "\n");
        myLine.append("V12 to Inflorescence Visible (R1) = " + ROW5_Choice + "\n");
        myLine.append("R1 to Internode Elongation (R2)   = " + ROW6_Choice + "\n");
        myLine.append("R2 to Internode Elong > 2 (R3)    = " + ROW7_Choice + "\n");
        myLine.append("R3 to Inflorenscence Opens (R4)   = " + ROW8_Choice + "\n");
        myLine.append("R4 to Anthesis Starts (R5)        = " + ROW9_Choice + "\n");
        myLine.append("R5 to Antehsis Ends (R6)          = " + ROW10_Choice + "\n");
        myLine.append("R6 to Inflorescence Yellow (R7)   = " + ROW11_Choice + "\n");
        myLine.append("R7 to Inflorescence Brown (R8)    = " + ROW12_Choice + "\n");
        myLine.append("R8 to Maturity (R9)               = " + ROW13_Choice + "\n");
        myLine.append("R9 to Harvest Ready               = " + ROW14_Choice + "\n");
        myLine.append("ROW15                             = " + ROW15_Choice + "\n");
        myLine.append("ROW16                             = " + ROW16_Choice + "\n");
        
        return myLine.toString();
    }

}

