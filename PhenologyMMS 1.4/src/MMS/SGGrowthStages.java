// SGGrowthStages.java

package MMS;

/**
 *  Title:       MMS Test2 
 *  Description: Started 9 Sept 2002 
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       January 2, 2003
 *@version       1.0
 *
 *added comment  Debbie Edmunds, March, 2005
 */

public class SGGrowthStages extends GrowthStages {

    /**
     *  Description of the Method
     *
     *@return    Description of the Return Value
     */
    public String toString() {
        StringBuffer myLine = new StringBuffer();
        myLine.append("Seeding to Emergence             = " + ROW1_Choice + "\n");
        myLine.append("E to First Tiller                = " + ROW2_Choice + "\n");
        //myLine.append("E to Internode Elong Starts      = " + ROW3_Choice + "\n");
        myLine.append("TI to Growing Pt Differentiation = " + ROW3_Choice + "\n");
        //myLine.append("IES to Jointing   = " + ROW4_Choice + "\n");
        myLine.append("GPD to Internode Elong Starts    = " + ROW4_Choice + "\n");
        //myLine.append("E to Growing Pt Dif                ferentiation  = " + ROW5_Choice + "\n");
        myLine.append("IES to Jointing                  = " + ROW5_Choice + "\n");
        //myLine.append("GPD to End Leaf Growth           = " + ROW6_Choice + "\n");
        myLine.append("J to End Leaf Growth             = " + ROW6_Choice + "\n");
        myLine.append("ELG to Anthesis Start            = " + ROW7_Choice + "\n");
        myLine.append("First Bloom(AS) to Half Bloom    = " + ROW8_Choice + "\n");
        myLine.append("HB to Full Bloom                 = " + ROW9_Choice + "\n");
        myLine.append("AS to Maturity                   = " + ROW10_Choice + "\n");
        myLine.append("M to Harvest Ready               = " + ROW11_Choice + "\n");
        myLine.append("ROW12                            = " + ROW12_Choice + "\n");
        myLine.append("ROW13                            = " + ROW13_Choice + "\n");
        myLine.append("ROW14                            = " + ROW14_Choice + "\n");
        myLine.append("ROW15                            = " + ROW15_Choice + "\n");
        myLine.append("ROW16                            = " + ROW16_Choice + "\n");
                

        return myLine.toString();
    }

}

