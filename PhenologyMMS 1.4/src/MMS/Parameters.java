// Parameters.java

package MMS;
//import java.util.*;
/**
 *  Title:       MMS Test2 
 *  Description: This class holds all the parameters set by the user or 
 *               the default values if not set by the user.
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS 
 *
 *@author        Ben Riebau
 *@created       September 19, 2002
 *@version       1.0
 *
 *added comments Debbie Edmunds, February, 2005
 */

public class Parameters {
    
    Date myDate;

//      The name of the crop being simulated.
    public String cropType;
    
//      The variety being simulated or the type of the current crop, for example
//      oil or confectionary sunflower.  It might also be number of days to 
//      maturity as in corn or actual variety names as in winter wheat.
    public String varietyType;
    
//      The name of the weather file used in the simulation.
    public String location;
    
//      How deep the crop is planted, in cm.
    public String plantingDepth;
    
//      Number of seeds being planted in number per meter squared (#/m^2).
    public String plantingRate;

//      The latitude of the site from where the climate was obtained.
    public String latitude;

//      The number of the method being used to calculate GDD. Currently, method 2
//      should be selected for corn, sorghum, dry bean, soybean and sunflower 
//      and all other crops should select method 1.
    public String GDDMethod;
    
    // de added temperatures and canopy height
//      The temperature below which the process of interest does not progress.
//      This can vary between crops.
    public String baseTemp;

//      The lower end of the temperature range for maximum plant growth.
    public String optimumTempLow;

//     The higher end of the temperature range for maximum plant growth.
    public String optimumTempUp;

//      The temperature above which the process of interest does not progress.   
    public String upperTemp;
           
//      The amount of the phyllochron which is the amount of GDD required for each 
//      leaf. The Phyllochron is the appeareance rate.
    public String phyllochronValue;
    
//     This is a descriptive term and indicates a level of soil moisture 
//     when the crop is planted.  It gets converted to an integer value which
//     used in determining if there is enough moisture to support emergence.      
    public String soilMoisturePlanting;
    
//    The date of planting in month/day/year/    
    public String plantingDate;
    
    // de added
//    Month in the date.     
    public String month;
       
//    Day in the date.    
    public String day;

//    Year in the date.    
    public String year;
    
//    Julian date for a given month/day/year date. (1 - 366)    
    public String dayOfYear;

//    The usual height the selected crop canopy will attain.    
    public String canopyHt;
    
    // new arrays for parameters for emergence prediction. DE added
//    Array to hold the seedbed condition descriptions    
    public String soilMoistureArray[] = new String[4];

//    Array to hold the lower percentage value of water-filled pore space 
//    in the seeedbed.
    public String waterFilledLowerArray[] = new String[4];
    
//    Array to hold the upper percentage value of water-filled pore space 
//    in the seeedbed.
    public String waterFilledUpperArray[] = new String[4];

//    Array to hold the germination time in GDD.    
    public String germGDDArray[] = new String[4];

//    Array to hold the elongation rate of the seedling in mm per GDD.
    public String elongRateGDDArray[] = new String[4];
        
    // Create a new instance of the growthStages object.
    GrowthStages myStages = new GrowthStages();

    //Number of vernalization days required for the crop to be fully vernalized. DE added
    public String vernalDays;

    //Base temperature below which no vernalization is accomplished. DE added
    public String vernalTbase;

    //Lower optimum temperature for vernalization. DE added
    public String vernalToptlo;

    //Upper optimum temperature for vernalization. DE added
    public String vernalToptup;

    //Upper temperature above which no vernalization is accomplished. DE added
    public String vernalTupper;

   //Temperature above which de-vernalization can occur. DE added
    public String vernalDevern;
    
  //phase 1 maximum canopy height
    public String ecanht;
    
  // soybean variety name/maturity group 
    public String mg;
    
  // critical photoperiod
    public String photocrit;

  // photoperiod sensitivity
    public String ppsen;
    
  // sensitivity to photoperiod. Adjusts the critical photoperiod
    public String photosen;
    
//    All of the following variables have the same definition as above.  
//    The _ORG variables below are used in the resetWindow method to reset the 
//    screen back to the original, default values.
    public String cropType_ORG;

    public String varietyType_ORG;

    public String location_ORG;

    public String plantingDepth_ORG;

    public String plantingRate_ORG;

    public String latitude_ORG;

    public String GDDMethod_ORG;
    
    // de added
    public String baseTemp_ORG;
    
    public String optimumTempLow_ORG;
    
    public String optimumTempUp_ORG;
    
    public String upperTemp_ORG;
    
    public String month_ORG;
    
    public String day_ORG;
    
    public String year_ORG;
    
    public String dayOfYear_ORG;
    
    public String canopyHt_ORG;
    
    public String phyllochronValue_ORG;
    
    public String soilMoisturePlanting_ORG;

    public String plantingDate_ORG;

   // public String vernalizArray_ORG;
     
    public String mg_ORG;
   
    public String photocrit_ORG;

    public String ppsen_ORG;
    
    public String photosen_ORG;


    
    /**
     *  Constructor for the Parameters object
     */
    public Parameters() { // sets default values
        cropType_ORG = cropType = "Winter Wheat";
        varietyType_ORG = varietyType = "Generic";
        GDDMethod_ORG = GDDMethod = "1";
        latitude_ORG = latitude = "40.165";
        phyllochronValue_ORG = phyllochronValue = "105.0";
        plantingDate_ORG = plantingDate = "09/15/2004";
        plantingDepth_ORG = plantingDepth = "5";
        plantingRate_ORG = plantingRate = "125";
        soilMoisturePlanting_ORG = soilMoisturePlanting = "Optimum";
        baseTemp_ORG = baseTemp = "5.0";
        optimumTempLow_ORG = optimumTempLow = "20.0";
        optimumTempUp_ORG = optimumTempUp = "20.0";
        upperTemp_ORG = upperTemp = "35.0";
        location_ORG = location = "ARDEC00_01"; 
        month_ORG = month = "09";
        day_ORG = day = "15";
        year_ORG = year = "2004";
        dayOfYear_ORG = dayOfYear = "259";
        canopyHt_ORG = canopyHt = "90.0";  
        mg_ORG = mg= "";
        photocrit_ORG = photocrit = "";
        ppsen_ORG = ppsen = "";
        photosen_ORG = photosen = "";

        myStages = new GrowthStages();
    } // end of constructor
   
//   Sets the GrowthStages attribute of the Parameters object
    public void setGrowthStages(GrowthStages GS) {
        myStages = GS;
    }


    /**
     *  Description of the Method
     *
     *@return    Description of the Return Value
     */
    public String toString() { // writes the information in the OutPut screen
        StringBuffer myString = new StringBuffer();
        myString.append("Crop:                                     " + cropType + "\n");
        myString.append("Variety:                                  " + varietyType + "\n");
        myString.append("Location/ Weather File:                   " + location + "\n");
        myString.append("Planting Date Month (mm):                 " + month + "\n");//de added
        myString.append("Planting Date Day (dd):                   " + day + "\n");//de added       
        myString.append("Planting Date Year (yyyy):                " + year + "\n");//de added
        myString.append("Day of Year:                              " + dayOfYear + "\n"); //de added
        myString.append("Planting Depth (cm):                      " + plantingDepth + "\n");
        myString.append("Planting Rate (plants/m^2):               " + plantingRate + "\n");
        myString.append("Initial Soil Moisture Conditions:         " + soilMoisturePlanting + "\n");
        myString.append("Latitude (degrees):                       " + latitude + "\n");
        myString.append("GDD Method:                               " + GDDMethod + "\n");
        myString.append("Base Temperature (C):                     " + baseTemp + "\n");//de added
        myString.append("Lower Optimum Temperature (C):            " + optimumTempLow + "\n");//de added
        myString.append("Upper Optimum Temperature (C):            " + optimumTempUp + "\n");//de added
        myString.append("Upper/Maximum Temperature (C):            " + upperTemp + "\n");//de added        
        myString.append("Maximum Canopy Height (cm):               " + canopyHt + "\n");// de added    
        myString.append("Phyllochron Value:                        " + phyllochronValue + "\n");
        myString.append("--------------------------------------------------\n\n");
        myString.append(myStages.toString());

        return myString.toString();
    }

}

