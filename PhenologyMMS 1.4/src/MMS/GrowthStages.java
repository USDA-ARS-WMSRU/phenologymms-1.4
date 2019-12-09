// GrowthStages.java

package MMS;

/**
 *  Title:       MMS Test2 
 *  Description: Started 9 Sept 2002.  This is the superClass for all growth 
 *               stages. The fields declared in this class are set up so that 
 *               with a find and replace command an entire row in the growth 
 *               stage class can be renamed.  This is useful in defining a less
 *               general case.
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       December 27, 2002
 *@version       1.0 
 *
 *edited comments Debbie Edmunds, March, 2005
 */

 /* DE added code for 16 rows in the Growth Stages to accomodate Soybeans, 
    Oct, 2017 */

public class GrowthStages {

    public String myType;
    public String ROW1;
    public String ROW1_stress;
    public String ROW1_LVS;
    public String ROW1_LVS_stress;
    public String ROW1_ORG;
    public String ROW1_stress_ORG;
    public String ROW1_LVS_ORG;
    public String ROW1_LVS_stress_ORG;
    public String ROW1_Choice;
    public String ROW2;
    public String ROW2_stress;
    public String ROW2_LVS;
    public String ROW2_LVS_stress;
    public String ROW2_ORG;
    public String ROW2_stress_ORG;
    public String ROW2_LVS_ORG;
    public String ROW2_LVS_stress_ORG;
    public String ROW2_Choice;
    public String ROW3;
    public String ROW3_stress;
    public String ROW3_LVS;
    public String ROW3_LVS_stress;
    public String ROW3_ORG;
    public String ROW3_stress_ORG;
    public String ROW3_LVS_ORG;
    public String ROW3_LVS_stress_ORG;
    public String ROW3_Choice;
    public String ROW4;
    public String ROW4_stress;
    public String ROW4_LVS;
    public String ROW4_LVS_stress;
    public String ROW4_ORG;
    public String ROW4_stress_ORG;
    public String ROW4_LVS_ORG;
    public String ROW4_LVS_stress_ORG;
    public String ROW4_Choice;
    public String ROW5;
    public String ROW5_stress;
    public String ROW5_LVS;
    public String ROW5_LVS_stress;
    public String ROW5_ORG;
    public String ROW5_stress_ORG;
    public String ROW5_LVS_ORG;
    public String ROW5_LVS_stress_ORG;
    public String ROW5_Choice;
    public String ROW6;
    public String ROW6_stress;
    public String ROW6_LVS;
    public String ROW6_LVS_stress;
    public String ROW6_ORG;
    public String ROW6_stress_ORG;
    public String ROW6_LVS_ORG;
    public String ROW6_LVS_stress_ORG;
    public String ROW6_Choice;
    public String ROW7;
    public String ROW7_stress;
    public String ROW7_LVS;
    public String ROW7_LVS_stress;
    public String ROW7_ORG;
    public String ROW7_stress_ORG;
    public String ROW7_LVS_ORG;
    public String ROW7_LVS_stress_ORG;
    public String ROW7_Choice;
    public String ROW8;
    public String ROW8_stress;
    public String ROW8_LVS;
    public String ROW8_LVS_stress;
    public String ROW8_ORG;
    public String ROW8_stress_ORG;
    public String ROW8_LVS_ORG;
    public String ROW8_LVS_stress_ORG;
    public String ROW8_Choice;
    public String ROW9;
    public String ROW9_stress;
    public String ROW9_LVS;
    public String ROW9_LVS_stress;
    public String ROW9_ORG;
    public String ROW9_stress_ORG;
    public String ROW9_LVS_ORG;
    public String ROW9_LVS_stress_ORG;
    public String ROW9_Choice;
    public String ROW10;
    public String ROW10_stress;
    public String ROW10_LVS;
    public String ROW10_LVS_stress;
    public String ROW10_ORG;
    public String ROW10_stress_ORG;
    public String ROW10_LVS_ORG;
    public String ROW10_LVS_stress_ORG;
    public String ROW10_Choice;
    public String ROW11;
    public String ROW11_stress;
    public String ROW11_LVS;
    public String ROW11_LVS_stress;
    public String ROW11_ORG;
    public String ROW11_stress_ORG;
    public String ROW11_LVS_ORG;
    public String ROW11_LVS_stress_ORG;
    public String ROW11_Choice;
    public String ROW12;
    public String ROW12_stress;
    public String ROW12_LVS;
    public String ROW12_LVS_stress;
    public String ROW12_ORG;
    public String ROW12_stress_ORG;
    public String ROW12_LVS_ORG;
    public String ROW12_LVS_stress_ORG;
    public String ROW12_Choice;
    public String ROW13;
    public String ROW13_stress;
    public String ROW13_LVS;
    public String ROW13_LVS_stress;
    public String ROW13_ORG;
    public String ROW13_stress_ORG;
    public String ROW13_LVS_ORG;
    public String ROW13_LVS_stress_ORG;
    public String ROW13_Choice;
    public String ROW14;
    public String ROW14_stress;
    public String ROW14_LVS;
    public String ROW14_LVS_stress;
    public String ROW14_ORG;
    public String ROW14_stress_ORG;
    public String ROW14_LVS_ORG;
    public String ROW14_LVS_stress_ORG;
    public String ROW14_Choice;
    public String ROW15;
    public String ROW15_stress;
    public String ROW15_LVS;
    public String ROW15_LVS_stress;
    public String ROW15_ORG;
    public String ROW15_stress_ORG;
    public String ROW15_LVS_ORG;
    public String ROW15_LVS_stress_ORG;
    public String ROW15_Choice;
    public String ROW16;
    public String ROW16_stress;
    public String ROW16_LVS;
    public String ROW16_LVS_stress;
    public String ROW16_ORG;
    public String ROW16_stress_ORG;
    public String ROW16_LVS_ORG;
    public String ROW16_LVS_stress_ORG;
    public String ROW16_Choice;

    /**
     *  Constructor for the GrowthStages object
     */
    public GrowthStages() {
        this.setROW1_choice(1);
        this.setROW2_choice(1);
        this.setROW3_choice(1);
        this.setROW4_choice(1);
        this.setROW5_choice(1);
        this.setROW6_choice(1);
        this.setROW7_choice(1);
        this.setROW8_choice(1);
        this.setROW9_choice(1);
        this.setROW10_choice(1);
        this.setROW11_choice(1);
        this.setROW12_choice(1);
        this.setROW13_choice(1);
        this.setROW14_choice(1);
        this.setROW15_choice(1);
        this.setROW16_choice(1);
    }


    /**
     *  Sets the gDDStages attribute of the GrowthStages object
     *
     *@param  C1   The new gDDStages value
     *@param  C2   The new gDDStages value
     *@param  C3   The new gDDStages value
     *@param  C4   The new gDDStages value
     *@param  C5   The new gDDStages value
     *@param  C6   The new gDDStages value
     *@param  C7   The new gDDStages value
     *@param  C8   The new gDDStages value
     *@param  C9   The new gDDStages value
     *@param  C10  The new gDDStages value
     *@param  C11  The new gDDStages value
     *@param  C12  The new gDDStages value
     *@param  C13  The new gDDStages value
     *@param  C14  The new gDDStages value
     *@param  C15  The new gDDStages value
     *@param  C16  The new gDDStages value
     */
    public void setGDDStages(String C1, String C2, String C3,
            String C4, String C5, String C6, String C7, String C8, String C9,
            String C10, String C11, String C12, String C13, String C14, 
            String C15, String C16) {

        ROW1 = ROW1_ORG = C1;
        ROW2 = ROW2_ORG = C2;
        ROW3 = ROW3_ORG = C3;
        ROW4 = ROW4_ORG = C4;
        ROW5 = ROW5_ORG = C5;
        ROW6 = ROW6_ORG = C6;
        ROW7 = ROW7_ORG = C7;
        ROW8 = ROW8_ORG = C8;
        ROW9 = ROW9_ORG = C9;
        ROW10 = ROW10_ORG = C10;
        ROW11 = ROW11_ORG = C11;
        ROW12 = ROW12_ORG = C12;
        ROW13 = ROW13_ORG = C13;
        ROW14 = ROW14_ORG = C14;
        ROW15 = ROW15_ORG = C15;
        ROW16 = ROW16_ORG = C16;

//        this is put in here because the default is GDD no stress
        this.setROW1_choice(1);
        this.setROW2_choice(1);
        this.setROW3_choice(1);
        this.setROW4_choice(1);
        this.setROW5_choice(1);
        this.setROW6_choice(1);
        this.setROW7_choice(1);
        this.setROW8_choice(1);
        this.setROW9_choice(1);
        this.setROW10_choice(1);
        this.setROW11_choice(1);
        this.setROW12_choice(1);
        this.setROW13_choice(1);
        this.setROW14_choice(1);
        this.setROW15_choice(1);
        this.setROW16_choice(1);
    }


    /**
     *  Sets the gDDStressed attribute of the GrowthStages object
     *
     *@param  C17   The new gDDStressed value
     *@param  C18   The new gDDStressed value
     *@param  C19   The new gDDStressed value
     *@param  C20   The new gDDStressed value
     *@param  C21   The new gDDStressed value
     *@param  C22   The new gDDStressed value
     *@param  C23   The new gDDStressed value
     *@param  C24   The new gDDStressed value
     *@param  C25   The new gDDStressed value
     *@param  C26   The new gDDStressed value
     *@param  C27   The new gDDStressed value
     *@param  C28   The new gDDStressed value
     *@param  C29   The new gDDStressed value
     *@param  C30   The new gDDStressed value
     *@param  C31   The new gDDStressed value
     *@param  C32   The new gDDStressed value
     */
    public void setGDDStressed(String C17, String C18, String C19, String C20,
            String C21, String C22, String C23, String C24, String C25, 
            String C26, String C27, String C28, String C29, String C30,
            String C31, String C32) {

        ROW1_stress = ROW1_stress_ORG = C17;
        ROW2_stress = ROW2_stress_ORG = C18;
        ROW3_stress = ROW3_stress_ORG = C19;
        ROW4_stress = ROW4_stress_ORG = C20;
        ROW5_stress = ROW5_stress_ORG = C21;
        ROW6_stress = ROW6_stress_ORG = C22;
        ROW7_stress = ROW7_stress_ORG = C23;
        ROW8_stress = ROW8_stress_ORG = C24;
        ROW9_stress = ROW9_stress_ORG = C25;
        ROW10_stress = ROW10_stress_ORG = C26;
        ROW11_stress = ROW11_stress_ORG = C27;
        ROW12_stress = ROW12_stress_ORG = C28;
        ROW13_stress = ROW13_stress_ORG = C29;
        ROW14_stress = ROW14_stress_ORG = C30;
        ROW15_stress = ROW15_stress_ORG = C31;
        ROW16_stress = ROW16_stress_ORG = C32;
    }


    /**
     *  Sets the lVS attribute of the GrowthStages object
     *
     *@param  C33  The new lVS value
     *@param  C34  The new lVS value
     *@param  C35  The new lVS value
     *@param  C36  The new lVS value
     *@param  C37  The new lVS value
     *@param  C38  The new lVS value
     *@param  C39  The new lVS value
     *@param  C40  The new lVS value
     *@param  C41  The new lVS value
     *@param  C42  The new lVS value
     *@param  C43  The new lVS value
     *@param  C44  The new lVS value
     *@param  C45  The new lVS value
     *@param  C46  The new lVS value
     *@param  C47  The new lVS value
     *@param  C48  The new lVS value
     */
    public void setLVS(String C33, String C34, String C35, String C36, 
           String C37, String C38, String C39, String C40, String C41, 
           String C42, String C43, String C44, String C45, String C46, 
           String C47, String C48) {

        ROW1_LVS = ROW1_LVS_ORG = C33;
        ROW2_LVS = ROW2_LVS_ORG = C34;
        ROW3_LVS = ROW3_LVS_ORG = C35;
        ROW4_LVS = ROW4_LVS_ORG = C36;
        ROW5_LVS = ROW5_LVS_ORG = C37;
        ROW6_LVS = ROW6_LVS_ORG = C38;
        ROW7_LVS = ROW7_LVS_ORG = C39;
        ROW8_LVS = ROW8_LVS_ORG = C40;
        ROW9_LVS = ROW9_LVS_ORG = C41;
        ROW10_LVS = ROW10_LVS_ORG = C42;
        ROW11_LVS = ROW11_LVS_ORG = C43;
        ROW12_LVS = ROW12_LVS_ORG = C44;
        ROW13_LVS = ROW13_LVS_ORG = C45;
        ROW14_LVS = ROW14_LVS_ORG = C46;
        ROW15_LVS = ROW15_LVS_ORG = C47;
        ROW16_LVS = ROW16_LVS_ORG = C48;

    }


    /**
     *  Sets the lVSstressed attribute of the GrowthStages object
     *
     *@param  C49  The new lVSstressed value
     *@param  C50  The new lVSstressed value
     *@param  C51  The new lVSstressed value
     *@param  C52  The new lVSstressed value
     *@param  C53  The new lVSstressed value
     *@param  C54  The new lVSstressed value
     *@param  C55  The new lVSstressed value
     *@param  C56  The new lVSstressed value
     *@param  C57  The new lVSstressed value
     *@param  C58  The new lVSstressed value
     *@param  C59  The new lVSstressed value
     *@param  C60  The new lVSstressed value
     *@param  C61  The new lVSstressed value
     *@param  C62  The new lVSstressed value
     *@param  C63  The new lVSstressed value
     *@param  C64  The new lVSstressed value
     */
    public void setLVSstressed(String C49, String C50, String C51, String C52,
            String C53,String C54, String C55, String C56, String C57,  
            String C58, String C59, String C60, String C61, String C62,
            String C63, String C64) {

        ROW1_LVS_stress = ROW1_LVS_stress_ORG = C49;
        ROW2_LVS_stress = ROW2_LVS_stress_ORG = C50;
        ROW3_LVS_stress = ROW3_LVS_stress_ORG = C51;
        ROW4_LVS_stress = ROW4_LVS_stress_ORG = C52;
        ROW5_LVS_stress = ROW5_LVS_stress_ORG = C53;
        ROW6_LVS_stress = ROW6_LVS_stress_ORG = C54;
        ROW7_LVS_stress = ROW7_LVS_stress_ORG = C55;
        ROW8_LVS_stress = ROW8_LVS_stress_ORG = C56;
        ROW9_LVS_stress = ROW9_LVS_stress_ORG = C57;
        ROW10_LVS_stress = ROW10_LVS_stress_ORG = C58;
        ROW11_LVS_stress = ROW11_LVS_stress_ORG = C59;
        ROW12_LVS_stress = ROW12_LVS_stress_ORG = C60;
        ROW13_LVS_stress = ROW13_LVS_stress_ORG = C61;
        ROW14_LVS_stress = ROW14_LVS_stress_ORG = C62;
        ROW15_LVS_stress = ROW15_LVS_stress_ORG = C63;
        ROW16_LVS_stress = ROW16_LVS_stress_ORG = C64;

    }


    /**
     *  Sets the rOW1_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW1_choice value
     */
    public void setROW1_choice(int choice) {
        switch (choice) {
            case 2:
                ROW1_Choice = "GS " + ROW1_stress;
                break;
            case 3:
                ROW1_Choice = "LN " + ROW1_LVS;//de changed from LV to LN
                break;
            case 4:
                ROW1_Choice = "LS " + ROW1_LVS_stress;
                break;
            default:
                ROW1_Choice = "GN " + ROW1; // de changed from GD to GN
                break;
        }
    }


    /**
     *  Sets the rOW2_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW2_choice value
     */
    public void setROW2_choice(int choice) {
        switch (choice) {
            case 2:
                ROW2_Choice = "GS " + ROW2_stress;
                break;
            case 3:
                ROW2_Choice = "LN " + ROW2_LVS;
                break;
            case 4:
                ROW2_Choice = "LS " + ROW2_LVS_stress;
                break;
            default:
                ROW2_Choice = "GN " + ROW2;
                break;
        }

    }


    /**
     *  Sets the rOW3_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW3_choice value
     */
    public void setROW3_choice(int choice) {
        switch (choice) {
            case 2:
                ROW3_Choice = "GS " + ROW3_stress;
                break;
            case 3:
                ROW3_Choice = "LN " + ROW3_LVS;
                break;
            case 4:
                ROW3_Choice = "LS " + ROW3_LVS_stress;
                break;
            default:
                ROW3_Choice = "GN " + ROW3;
                break;
        }

    }


    /**
     *  Sets the rOW4_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW4_choice value
     */
    public void setROW4_choice(int choice) {
        switch (choice) {
            case 2:
                ROW4_Choice = "GS " + ROW4_stress;
                break;
            case 3:
                ROW4_Choice = "LN " + ROW4_LVS;
                break;
            case 4:
                ROW4_Choice = "LS " + ROW4_LVS_stress;
                break;
            default:
                ROW4_Choice = "GN " + ROW4;
                break;
        }

    }


    /**
     *  Sets the rOW5_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW5_choice value
     */
    public void setROW5_choice(int choice) {
        switch (choice) {
            case 2:
                ROW5_Choice = "GS " + ROW5_stress;
                break;
            case 3:
                ROW5_Choice = "LN " + ROW5_LVS;
                break;
            case 4:
                ROW5_Choice = "LS " + ROW5_LVS_stress;
                break;
            default:
                ROW5_Choice = "GN " + ROW5;
                break;
        }

    }


    /**
     *  Sets the rOW6_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW6_choice value
     */
    public void setROW6_choice(int choice) {
        switch (choice) {
            case 2:
                ROW6_Choice = "GS " + ROW6_stress;
                break;
            case 3:
                ROW6_Choice = "LN " + ROW6_LVS;
                break;
            case 4:
                ROW6_Choice = "LS " + ROW6_LVS_stress;
                break;
            default:
                ROW6_Choice = "GN " + ROW6;
                break;
        }

    }


    /**
     *  Sets the rOW7_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW7_choice value
     */
    public void setROW7_choice(int choice) {
        switch (choice) {
            case 2:
                ROW7_Choice = "GS " + ROW7_stress;
                break;
            case 3:
                ROW7_Choice = "LN " + ROW7_LVS;
                break;
            case 4:
                ROW7_Choice = "LS " + ROW7_LVS_stress;
                break;
            default:
                ROW7_Choice = "GN " + ROW7;
                break;
        }

    }


    /**
     *  Sets the rOW8_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW8_choice value
     */
    public void setROW8_choice(int choice) {
        switch (choice) {
            case 2:
                ROW8_Choice = "GS " + ROW8_stress;
                break;
            case 3:
                ROW8_Choice = "LN " + ROW8_LVS;
                break;
            case 4:
                ROW8_Choice = "LS " + ROW8_LVS_stress;
                break;
            default:
                ROW8_Choice = "GN " + ROW8;
                break;
        }

    }


    /**
     *  Sets the rOW9_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW9_choice value
     */
    public void setROW9_choice(int choice) {
        switch (choice) {
            case 2:
                ROW9_Choice = "GS " + ROW9_stress;
                break;
            case 3:
                ROW9_Choice = "LN " + ROW9_LVS;
                break;
            case 4:
                ROW9_Choice = "LS " + ROW9_LVS_stress;
                break;
            default:
                ROW9_Choice = "GN " + ROW9;
                break;
        }

    }


    /**
     *  Sets the rOW10_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW10_choice value
     */
    public void setROW10_choice(int choice) {
        switch (choice) {
            case 2:
                ROW10_Choice = "GS " + ROW10_stress;
                break;
            case 3:
                ROW10_Choice = "LN " + ROW10_LVS;
                break;
            case 4:
                ROW10_Choice = "LS " + ROW10_LVS_stress;
                break;
            default:
                ROW10_Choice = "GN " + ROW10;
                break;
        }

    }


    /**
     *  Sets the rOW11_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW11_choice value
     */
    public void setROW11_choice(int choice) {
        switch (choice) {
            case 2:
                ROW11_Choice = "GS " + ROW11_stress;
                break;
            case 3:
                ROW11_Choice = "LN " + ROW11_LVS;
                break;
            case 4:
                ROW11_Choice = "LS " + ROW11_LVS_stress;
                break;
            default:
                ROW11_Choice = "GN " + ROW11;
                break;
        }

    }


    /**
     *  Sets the rOW12_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW12_choice value
     */
    public void setROW12_choice(int choice) {
        switch (choice) {
            case 2:
                ROW12_Choice = "GS " + ROW12_stress;
                break;
            case 3:
                ROW12_Choice = "LN " + ROW12_LVS;
                break;
            case 4:
                ROW12_Choice = "LS " + ROW12_LVS_stress;
                break;
            default:
                ROW12_Choice = "GN " + ROW12;
                break;
        }

    }


    /**
     *  Sets the rOW13_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW13_choice value
     */
    public void setROW13_choice(int choice) {
        switch (choice) {
            case 2:
                ROW13_Choice = "GS " + ROW13_stress;
                break;
            case 3:
                ROW13_Choice = "LN " + ROW13_LVS;
                break;
            case 4:
                ROW13_Choice = "LS " + ROW13_LVS_stress;
                break;
            default:
                ROW13_Choice = "GN " + ROW13;
                break;
        }

    }


    /**
     *  Sets the rOW14_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW14_choice value
     */
    public void setROW14_choice(int choice) {
        switch (choice) {
            case 2:
                ROW14_Choice = "GS " + ROW14_stress;
                break;
            case 3:
                ROW14_Choice = "LN " + ROW14_LVS;
                break;
            case 4:
                ROW14_Choice = "LS " + ROW14_LVS_stress;
                break;
            default:
                ROW14_Choice = "GN " + ROW14;
                break;
        }

    }


    /**
     *  Sets the rOW15_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW15_choice value
     */
    public void setROW15_choice(int choice) {
        switch (choice) {
            case 2:
                ROW15_Choice = "GS " + ROW15_stress;
                break;
            case 3:
                ROW15_Choice = "LN " + ROW15_LVS;
                break;
            case 4:
                ROW15_Choice = "LS " + ROW15_LVS_stress;
                break;
            default:
                ROW15_Choice = "GN  " + ROW15;
                break;
                
        }

    }
    
    
    /**
     *  Sets the rOW16_choice attribute of the GrowthStages object
     *
     *@param  choice  The new rOW16_choice value
     */
    public void setROW16_choice(int choice) {
        switch (choice) {
            case 2:
                //ROW16_Choice = "GS " + ROW15_stress; DE Row 15 was used by mistake
                ROW16_Choice = "GS " + ROW16_stress;
                break;
            case 3:
                //ROW16_Choice = "LN " + ROW15_LVS;
                ROW16_Choice = "LN " + ROW16_LVS;
                break;
            case 4:
                //ROW16_Choice = "LS " + ROW15_LVS_stress;
                ROW16_Choice = "LS " + ROW16_LVS_stress;
                break;
            default:
                //ROW16_Choice = "GN  " + ROW15;
                ROW16_Choice = "GN  " + ROW16;
                break;
        }

    }



    /**
     *  Description of the Method
     *
     *@return    Description of the Return Value
     */
    public String toString() {
        StringBuffer myLine = new StringBuffer();

        myLine.append("ROW1 = " + ROW1_Choice + "\n");
        myLine.append("ROW2 = " + ROW2_Choice + "\n");
        myLine.append("ROW3 = " + ROW3_Choice + "\n");
        myLine.append("ROW4 = " + ROW4_Choice + "\n");
        myLine.append("ROW5 = " + ROW5_Choice + "\n");
        myLine.append("ROW6 = " + ROW6_Choice + "\n");
        myLine.append("ROW7 = " + ROW7_Choice + "\n");
        myLine.append("ROW8 = " + ROW8_Choice + "\n");
        myLine.append("ROW9 = " + ROW9_Choice + "\n");
        myLine.append("ROW10 = " + ROW10_Choice + "\n");
        myLine.append("ROW11 = " + ROW11_Choice + "\n");
        myLine.append("ROW12 = " + ROW12_Choice + "\n");
        myLine.append("ROW13 = " + ROW13_Choice + "\n");
        myLine.append("ROW14 = " + ROW14_Choice + "\n");
        myLine.append("ROW15 = " + ROW15_Choice + "\n");
        myLine.append("ROW16 = " + ROW16_Choice + "\n");
        return myLine.toString();

    }


    /**
     *  Gets the numberOfRows attribute of the GrowthStages object
     *
     *@return    The numberOfRows value
     */
    public int getNumberOfRows() {
        return 16;
    }

}

