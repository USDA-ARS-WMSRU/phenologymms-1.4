// SYGrowthStages.java/*
 
package MMS;

/**
 * Title:        MMS Test2
 * Description:  Started 9 Sept 2002
 * Copyright:    Copyright (c) 2002
 * Company:      USDA/ARS
 *
 * @author debbieedmundsa March, 2010
 * @version      1.0
 *
 */

public class SYGrowthStages extends GrowthStages {
     // soybean variety name/maturity group 
    public String mg;
    
  // critical photoperiod
    public String photocrit;

  // photoperiod sensitivity
    public String ppsen;
    
  // sensitivity to photoperiod. Adjusts the critical photoperiod
    public String photosen;
    /**
     *  Description of the Method
     *  We only need to override this method for each class so that the output
     *  will be correct for this crop type.
     *
     *@return    Description of the Return Value
     */
    public String toString() {
        StringBuffer myLine = new StringBuffer();

        myLine.append("Seeding to Emergence              = " + ROW1_Choice + "\n");
        myLine.append("E to Cotyledonary Lvs (VC)        = " + ROW2_Choice + "\n");
        myLine.append("VC to 1st Trifoliolate Lf (V1)    = " + ROW3_Choice + "\n");
        myLine.append("V1 to 2nd Trifoliolate Lf (V2)    = " + ROW4_Choice + "\n");
        myLine.append("V2 to 3rd Trifoliolate Lf (V3)    = " + ROW5_Choice + "\n");
        myLine.append("V3 to 4th Trifoliolate Lf (V4)    = " + ROW6_Choice + "\n");
        myLine.append("V4 to 5th Trifoliolate Lf (V5)    = " + ROW7_Choice + "\n");
        myLine.append("V5 to Beginning Bloom (R1)        = " + ROW8_Choice + "\n");
        myLine.append("R1 to Full Bloom (R2)             = " + ROW9_Choice + "\n");
        myLine.append("R2 to Beginning Pod (R3)          = " + ROW10_Choice + "\n");
        myLine.append("R3 to Full Pod (R4)               = " + ROW11_Choice + "\n");
        myLine.append("R4 to Beginning Seed (R5)         = " + ROW12_Choice + "\n");
        myLine.append("R5 to Full Seed (R6)              = " + ROW13_Choice + "\n");
        myLine.append("R6 to Beginning Maturity (R7)     = " + ROW14_Choice + "\n");
        myLine.append("R7 to Full Maurity (R8)           = " + ROW15_Choice + "\n");
        myLine.append("R8 to Harvest Ready (HR)          = " + ROW16_Choice + "\n");
        return myLine.toString();
    }
}