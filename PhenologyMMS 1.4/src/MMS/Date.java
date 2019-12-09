//Date.java
// Class to extract the month and day from the date entered by the user.  

package MMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
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
 *This class was added by Debbie Edmunds, May, 2005
 *
 */

public class Date {
    public String jMonth;
    public String jDay;
    public String jYear;
    public int month;
    public int day;
    public int year;
    public int dayOfYear = 0;
    
    StringTokenizer monthdayyear;      
    String plantingDate;    
    Parameters myParameters;
    
    //constructor requires the parameters passed in to access planting date
    public Date(Parameters myPar) {
        myParameters = myPar;
        
        // parse the planting date into its three parts
        monthDayYear(myParameters.plantingDate);//this results in the default planting date being used not the new date if one was entered.
        
    } // end of Date constructor
    
    // method to parse planting date into month and day
    public void monthDayYear(String mdy) {
        int tempMonth;
        int tempDay;
        int tempYear;

        monthdayyear = new StringTokenizer(mdy, "/");    
        
        while (monthdayyear.hasMoreTokens()){     
            jMonth = (monthdayyear.nextToken());
           
            if (monthdayyear.countTokens() > 0){
                jDay = (monthdayyear.nextToken());
                if (monthdayyear.countTokens() > 0){
                jYear = (monthdayyear.nextToken());
                }
            } // end of if
            
        } // end of while   
 
        // put new value of month and day in parameters
               myParameters.month = jMonth;
               myParameters.day = jDay;   
               myParameters.year = jYear;
        
        tempMonth = Integer.parseInt(jMonth);
        tempDay = Integer.parseInt(jDay);
        tempYear = Integer.parseInt(jYear);
        
        // call dayOfYear method to convert month/day/year to day of year
        dayOfYr(tempMonth, tempDay, tempYear);

    } // end of method monthDay
    
    //method to convert month/day/year to day of year.  
    public int dayOfYr(int m, int d, int y){
        month = m;
        day = d;
        year = y;
        
        int daysInMonth[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        
        // check for leap year and set daysInMonth[2] to 29 if is a leap year
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            daysInMonth[2] = 29;   
            //error checking on day
            if ((month == 2) && (day > 29)){
                day = 29;
            }
        }    
        else{ //not a leap year
            daysInMonth[2] = 28;
            //if day was entered as 29 or greater but not a leap year 
            //set day back to 28
            if((month == 2) && (day > 28)){
                day = 28;
            }
        }
        
        // error checking for day
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day >31)){
            day = 31;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && (day > 30)){
            day = 30;
        }
                
        // takes care of January
        if(month == 1){
            dayOfYear = day;
        }
        else if (month > 1 && month < 13){
            for(int i = 0; i < month; i++){
                dayOfYear = dayOfYear + daysInMonth[i];

            }  
            dayOfYear = (dayOfYear + day);
        }// end of else if
//        dayOfYear = (dayOfYear + day);
        
        myParameters.dayOfYear = Integer.toString(dayOfYear);
        
        return dayOfYear;
        
    } // end of DayOf Year method
    
} // end of class Date    



