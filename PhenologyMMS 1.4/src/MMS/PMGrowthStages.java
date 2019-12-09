// PMGrowthStages.java

package MMS;

/**
*  Title:       MMS Test2 
 *  Description: Started 9 Sept 2002
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@created       Ben Riebau
 *@created       September 16, 2002
 *@version       1.0
 *
 *This class was added by Debbie Edmunds, July 7, 2005
 *
 *
 */

public class PMGrowthStages extends GrowthStages {

    /**
     *  Description of the Method:
     *
     *@return    Description of the Return Value
     */
    public String toString() {
        StringBuffer myLine = new StringBuffer();
        myLine.append("Seeding to Emergence                     = " + ROW1_Choice + "\n");
        myLine.append("Emergence to First Tiller                = " + ROW2_Choice + "\n");
        myLine.append("First Tiller to Single Ridge                = " + ROW3_Choice + "\n");
        myLine.append("Single Ridge to Double Ridge             = " + ROW4_Choice + "\n");
        myLine.append("Double Ridge to End Spikelet Initiation  = " + ROW5_Choice + "\n");
        myLine.append("End Spikelet Initiation to Jointing      = " + ROW6_Choice + "\n");
        myLine.append("Jointing to Flag Leaf Complete           = " + ROW7_Choice + "\n");
        myLine.append("Flag Leaf Complete to Heading            = " + ROW8_Choice + "\n");
        myLine.append("Heading to Anthesis Start                = " + ROW9_Choice + "\n");
        myLine.append("Anthesis Start to Maturity               = " + ROW10_Choice + "\n");
        myLine.append("Maturity to Harvest Ready                = " + ROW11_Choice + "\n");
        myLine.append("ROW12                                    = " + ROW12_Choice + "\n");
        myLine.append("ROW13                                    = " + ROW13_Choice + "\n");
        myLine.append("ROW14                                    = " + ROW14_Choice + "\n");
        myLine.append("ROW15                                    = " + ROW15_Choice + "\n"); 
        myLine.append("ROW16                                    = " + ROW16_Choice + "\n");
        
        return myLine.toString();
    }


}

