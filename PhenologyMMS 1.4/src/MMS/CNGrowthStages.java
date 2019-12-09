// CNGrowthStages.java

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
 *added comments, Debbie Edmunds, March, 2005
 */

public class CNGrowthStages extends GrowthStages {


    public String toString() {
        StringBuffer myLine = new StringBuffer();

        myLine.append("Seeding to Emergence                    = " + ROW1_Choice + "\n");
        myLine.append("Emergence to Leaf 4 (V4)                = " + ROW2_Choice + "\n");
        myLine.append("Leaf 4 to Tassel Initiation             = " + ROW3_Choice + "\n");
        myLine.append("Leaf 4 to Ear Initiation                = " + ROW4_Choice + "\n");
        myLine.append("Leaf 4 to Internode Elongation Begins   = " + ROW5_Choice + "\n");        
        myLine.append("Leaf 4 to Leaf 12 (V12)                 = " + ROW6_Choice + "\n");
        myLine.append("Leaf 12 to Tasseling                    = " + ROW7_Choice + "\n");
        myLine.append("Leaf 12 to Silking (R1)                 = " + ROW8_Choice + "\n");
        myLine.append("Reproductive Leaf 1 to Blister (R2)     = " + ROW9_Choice + "\n");
        myLine.append("Reproductive Leaf 2 to Milk (R3)        = " + ROW10_Choice + "\n");
        myLine.append("Reproductive Leaf 3 to Dough (R4)       = " + ROW11_Choice + "\n");
        myLine.append("Reproductive Leaf 4 to Dent (R5)        = " + ROW12_Choice + "\n");
        myLine.append("Reproductive Leaf 5 to Maturity (R6)    = " + ROW13_Choice + "\n");
        myLine.append("Reproductive Leaf 6 to Harvest Ready    = " + ROW14_Choice + "\n");
        myLine.append("ROW15                                   = " + ROW15_Choice + "\n");
        myLine.append("ROW16                                   = " + ROW16_Choice + "\n");
                
        return myLine.toString();
    }

}

