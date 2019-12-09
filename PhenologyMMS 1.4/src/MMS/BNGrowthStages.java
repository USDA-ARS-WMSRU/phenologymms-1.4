// BNGrowthStages.java/*
 
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

public class BNGrowthStages extends GrowthStages {
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
        myLine.append("V4 to Bloom (R1)                  = " + ROW7_Choice + "\n");
        myLine.append("R1 to Mid-Full Flower (R2)        = " + ROW8_Choice + "\n");
        myLine.append("R2 to Early Pod Set (R3)          = " + ROW9_Choice + "\n");
        myLine.append("R3 to Mid Pod Set (R4)            = " + ROW10_Choice + "\n");
        myLine.append("R4 to Early Seed Fill (R5)        = " + ROW11_Choice + "\n");
        myLine.append("R5 to Mid Seed Fill (R6)          = " + ROW12_Choice + "\n");
        myLine.append("R6 to Physiological Maturity (R7) = " + ROW13_Choice + "\n");
        myLine.append("R7 to Harvest Ready (R8)          = " + ROW14_Choice + "\n");
        myLine.append("ROW15                             = " + ROW15_Choice + "\n");
        myLine.append("ROW16                             = " + ROW16_Choice + "\n");
                
        return myLine.toString();
    }

           // myLine.append("V4 to nth Trifoliolate Lf (Vn)   = " + ROW7_Choice + "\n");

}