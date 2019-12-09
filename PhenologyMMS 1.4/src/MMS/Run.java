// Run.java
// Accessed from the Run button on several screens
// This class should simply take the input provided by the user and write it
// to a text file.
// It should then call the Fortran phenology model that will use this text file
// as input.  It then reads the output file from the Fortran run.

package MMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.net.URL;
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

public class Run {
    Parameters myParameters;
    Date myDate;
        
    OutPutFrame myOutputFrame;
    
 //   StringTokenizer stGDDMethod;
    
    StringBuffer buffer;
    String output = "";
    String headerOne = "";
    String fl1 = "";
    boolean runFortran = true;
    
    
    /**
     *  Constructor for the Run object
     *
     *@param  myPar  Description of the Parameter
     */
    public Run(Parameters myPar){ 
        //get the data ready for writing to the ascii file
        myParameters = myPar;        
        myDate = new Date(myParameters);//send plantingDate to Date 
        
        try {
           getEmergeData(myParameters.soilMoisturePlanting); // call method to read 
                                                          // emergence data file
            }
            catch (Exception ex)
            {
                System.out.println("Can't open emerge file: " + ex);
                ex.printStackTrace();
            }

        try {
           getVernalData(); // call method to read vernaliz data file
            }
            catch (Exception ex)
            {
                System.out.println("Can't open vernal file: " + ex);
                ex.printStackTrace();
            }
        
        try {
            getCanopyHtData();
            }
            catch (Exception ex)
            {   
                System.out.println("Can't open canopyht file: " + ex);
                ex.printStackTrace();
            }
 
//de added reading in of photoperiod parameters 11/17        
//        try {
//           getPhotoData(); // call method to read photoperiod parameter file
//            }
//            catch (Exception ex)
//            {
//                System.out.println("Can't open photo file: " + ex);
//                ex.printStackTrace();
//           }
        
//         try { //de added to fill latitude based on the climate location
//           getLatitudeData(myParameters.location); // call method to read 
//                                                          // latitude data file
//            }
//            catch (Exception ex)
//            {
//                System.out.println("Can't open latitude file: " + ex);
//                ex.printStackTrace();
//            }

           
    
   // }


        // Write myParameters(inputs) to an ascii file named below
        // This is used in the Fortran Phenology MMS model
        //bcv added
        //saveFile(new File(getAppPath() + "/tinputs.txt"));
        //debe changed file extension to .dat to enable using the same input
        //files in PhenologyMMS as in UPGM
        saveFile(new File(getAppPath() + "/tinputs.dat"));
        // launch the PhenologyMMS Fortran program 
            // create a file object where the fortran .exe is stored
        // bcv added
        File f = new File(getAppPath());
            
        if(runFortran){            
            try {
            // process tells it to execute the fortran program
                // bcv added
                // JOptionPane is used to display a message box to show the path
                fl1 = "\""+ getAppPath() + "\\PhenologyMMS.exe" + "\"";
                //JOptionPane.showMessageDialog(null,fl1,"\"\"",JOptionPane.WARNING_MESSAGE);
                
                Process p = Runtime.getRuntime().exec(fl1, null, f);
                
                // Ian added to drain the buffer.  This was causing the program
                // to not be able to return from the execution of the Fortran
                // program.               
                Thread err = new Thread(new StreamGobbler(p.getErrorStream()));
                Thread out = new Thread(new StreamGobbler(p.getInputStream()));
                err.start();
                out.start();
                
                int r = p.waitFor();

                System.out.println("r = " + r); //if r = 0 it completed successfully
               // System.out.println("Path to PhenologyMMS.exe " + fl1); //DE added
            }
            catch(InterruptedException ie){
            // this is left blank - no exception to be caught
              JOptionPane.showMessageDialog(null,"interrupted exception","",JOptionPane.WARNING_MESSAGE);  
            }
            catch (IOException i){
                i.printStackTrace();
                JOptionPane.showMessageDialog(null,"IOexception","",JOptionPane.WARNING_MESSAGE); 
            }
        }
        
        // read in the contents of the output file from the Fortran program
        // bcv added
        // JOptionPane is used to display a message box to show the path
        //JOptionPane.showMessageDialog(null,getAppPath()+ "\\results\\phenol.out","",JOptionPane.WARNING_MESSAGE);
        readFile(new File(getAppPath() + "\\results\\phenol.out"));   
        
        
        // try to list the contents of the jar file
        //jar tf "C:\PhenologyMMS\Interface\Working\NetBeans_projects\dist";

            System.out.println("Path to phenol.out " + getAppPath()); //DE added
            //System.out.println("output variable = " + output);
        }  // end of constructor
    
    // bcv added path find
    public String getAppPath(){
       String tmp, c1;
       tmp = "";
       int indx, mm;
                try {                        
                    URL url = new URL("jar", "", -1, "file:" + new File("").getAbsolutePath());
                    tmp = url.toString();
                    c1 = url.getPath();     
                    indx = c1.indexOf(":");
                    mm = c1.length();            
                    tmp = c1.substring(indx + 1, mm);  
                   // System.out.println("tmp = " +tmp);                   
                 }
                 catch (Exception e) {
                   System.out.println("IOException: URL");
                 }
    
       return tmp;       
       
   }

    // Read in data values for germination and elongation rate
    // based on soil moisture chosen in the input screen. That selection is
    // used to select the proper germination and elongation rate data values.   
     private void getEmergeData(String smp) throws IOException { 
//    get emergence data based on crop type and soil moisture condition
        File[] myVarFiles;
        File myFile;
        BufferedReader input = null;
        String smTemp = "";//temp variable for soil moisture read into fileLine
        int compSmp;
              
        String varDir = "\\EmergeTypes";
        String fileLine;
        String path = getAppPath();
        //debe changed file extensions to .dat
        //GiveFiles varFiles = new GiveFiles(path, varDir, "txt");
        GiveFiles varFiles = new GiveFiles(path, varDir, "dat");

        myVarFiles = varFiles.getFiles();
        for (int i = 0; i < myVarFiles.length; i++) {
            if (myVarFiles[i].getName().equalsIgnoreCase("Emerge.dat")) {
                myFile = myVarFiles[i];
                try {
                    input = new BufferedReader(new FileReader(myFile));
                } catch (IOException ex) {
                    System.out.println("Can't open emerge file: " + ex);
                    ex.printStackTrace();
                }
//             **************** step through header stuff
                do {
                    fileLine = input.readLine();
                } while (!fileLine.equalsIgnoreCase("****"));
//             **************** end of header stuff 
                
                do { //get the chosen crop name
                    fileLine = input.readLine();
                } while (!fileLine.equalsIgnoreCase(myParameters.cropType));
                           
                    for (int r = 0; r < 4; r++){
                       fileLine = input.readLine();//read the next line
                       StringTokenizer chew = new StringTokenizer(fileLine, ",");
                        myParameters.soilMoistureArray[r] = 
                                chew.nextToken().trim();
                        myParameters.waterFilledLowerArray[r] = 
                                chew.nextToken().trim();
                        myParameters.waterFilledUpperArray[r] = 
                                chew.nextToken().trim();
                        myParameters.germGDDArray[r] = 
                                chew.nextToken().trim();
                        myParameters.elongRateGDDArray[r] = 
                                chew.nextToken().trim();
                        } // end of for
            }// end of if loop to get the emerge.dat file  
        } // end of for loop to get the emerge.dat file       
    
     } // end of method getEmergeData   


    // Read in data values for vernalization based on the crop type.

     private void getVernalData() throws IOException {
//    get vernalization data based on crop type
        File[] myVarFiles;
        File myFile;
        BufferedReader input = null;
//        String smTemp = "";//temp variable for crop type read into fileLine
//        int compSmp;

        String varDir = "\\VernalTypes";
        String fileLine;
        String path = getAppPath();
        //debe changed extensions to .dat
        //GiveFiles varFiles = new GiveFiles(path, varDir, "txt");
        GiveFiles varFiles = new GiveFiles(path, varDir, "dat");

        myVarFiles = varFiles.getFiles();
        for (int i = 0; i < myVarFiles.length; i++) {
            //if (myVarFiles[i].getName().equalsIgnoreCase("vernal.txt")) {
            if (myVarFiles[i].getName().equalsIgnoreCase("vernal.dat")) {
                myFile = myVarFiles[i];
                try {
                    input = new BufferedReader(new FileReader(myFile));
                } catch (IOException ex) {
                    System.out.println("Can't open vernal file: " + ex);
                    ex.printStackTrace();
                }
//             **************** step through header stuff
                do {
                    fileLine = input.readLine();
                } while (!fileLine.equalsIgnoreCase("****"));
//             **************** end of header stuff

                do { //get the chosen crop name
                    fileLine = input.readLine();
                } while (!fileLine.equalsIgnoreCase(myParameters.cropType));

                  //  for (int r = 0; r < 6; r++){
                       fileLine = input.readLine();//read the next line

                       StringTokenizer chew = new StringTokenizer(fileLine, ",");
                       // myParameters.vernalizArray[r] =
                         //       chew.nextToken().trim();
         //     System.out.println("vernalizArray[r] = " + myParameters.vernalizArray[r]);
                        myParameters.vernalDays =
                                chew.nextToken().trim();
                        myParameters.vernalTbase =
                                chew.nextToken().trim();
                        myParameters.vernalToptlo =
                                chew.nextToken().trim();
                        myParameters.vernalToptup =
                                chew.nextToken().trim();
                        myParameters.vernalTupper =
                                chew.nextToken().trim();
                        myParameters.vernalDevern =
                                chew.nextToken().trim();
                  //      } // end of for
            }// end of if loop to get the vernal.dat file
        } // end of for loop to get the vernal.dat file

     } // end of method getVernalData

   
     //debe added code to read in phase one canopy height values from a text file 6/7/11
    // Read in data values for phase one canopy height based on the crop type.

     private void getCanopyHtData() throws IOException {
//    get phase one maximum canopy height data based on crop type
        File[] myVarFiles;
        File myFile;
        BufferedReader input = null;
//        String smTemp = "";//temp variable for crop type read into fileLine
//        int compSmp;

        String varDir = "\\CanopyHt1Types";
        String fileLine;
        String path = getAppPath();
        //debe changed extensions to .dat
        //GiveFiles varFiles = new GiveFiles(path, varDir, "txt");
        GiveFiles varFiles = new GiveFiles(path, varDir, "dat");

        myVarFiles = varFiles.getFiles();
        for (int i = 0; i < myVarFiles.length; i++) {
            //if (myVarFiles[i].getName().equalsIgnoreCase("canopyht.txt")) {
            if (myVarFiles[i].getName().equalsIgnoreCase("canopyht.dat")) {
                myFile = myVarFiles[i];
                try {
                    input = new BufferedReader(new FileReader(myFile));
                } catch (IOException ex) {
                    System.out.println("Can't open canopy height file: " + ex);
                    ex.printStackTrace();
                }
//             **************** step through header stuff
                do {
                    fileLine = input.readLine();
                } while (!fileLine.equalsIgnoreCase("****"));
//             **************** end of header stuff

                do { //get the chosen crop name
                    fileLine = input.readLine();
                } while (!fileLine.equalsIgnoreCase(myParameters.cropType));
                                   fileLine = input.readLine();//read the next line
                       StringTokenizer chew = new StringTokenizer(fileLine, ",");
        
                        myParameters.ecanht =
                                chew.nextToken().trim();                  
            }// end of if loop to get the canopyht.dat file
        } // end of for loop to get the canopyht.dat file

     } // end of method getCanopyHtData

     
//          private void getPhotoData() throws IOException {
////    get photoperiod data based on crop Variety. Currently, only soybean is
////    implemented
//        File[] myVarFiles;
//        File myFile;
//        BufferedReader input = null;
//
//        String varDir = "\\PhotoTypes";
//        String fileLine;
//        String path = getAppPath();
//        //debe changed extensions to .dat
//        //GiveFiles varFiles = new GiveFiles(path, varDir, "txt");
//        GiveFiles varFiles = new GiveFiles(path, varDir, "dat");
//
//        myVarFiles = varFiles.getFiles();
//        for (int i = 0; i < myVarFiles.length; i++) {
//            if (myVarFiles[i].getName().equalsIgnoreCase("syphoto.dat")) {
//                myFile = myVarFiles[i];
//                try {
//                    input = new BufferedReader(new FileReader(myFile));
//                } catch (IOException ex) {
//                    System.out.println("Can't open soybean photoperiod file: " + ex);
//                    ex.printStackTrace();
//                }
////             **************** step through header stuff
//                do {
//                    fileLine = input.readLine();
//                } while (!fileLine.equalsIgnoreCase("****"));
////             **************** end of header stuff
//
//                do { //get the chosen variety name for soybean
//                    fileLine = input.readLine();
//                } while (!fileLine.equalsIgnoreCase(myParameters.varietyType));
//
//                  //  for (int r = 0; r < 6; r++){
//                       fileLine = input.readLine();//read the next line
//
//                       StringTokenizer chew = new StringTokenizer(fileLine, ",");                 
//         //     System.out.println("vernalizArray[r] = " + myParameters.vernalizArray[r]);
//                        myParameters.mg =
//                                chew.nextToken().trim();
//                        myParameters.photocrit =
//                                chew.nextToken().trim();
//                        myParameters.ppsen =
//                                chew.nextToken().trim();
//                        myParameters.photosen =
//                                chew.nextToken().trim();
//            }// end of if loop to get the syphoto.dat file
//        } // end of for loop to get the syphoto.dat file
//
//     } // end of method getPhotoData
          
          
//   // Read in data value for latitude based on the chosen climate location
//    // in the input screen.   
//     private void getLatitudeData(String smp) throws IOException { 
////    get latitude data based on chosen climate location
//        File[] myVarFiles;
//        File myFile;
//        BufferedReader input = null;
//        //String smLat = "";//temp variable for latitude read into fileLine
//        //int compSmp;
//              
//        String varDir = "\\LatitudeTypes";
//        String fileLine;
//        String path = getAppPath();
//        //debe changed file extensions to .dat
//        //GiveFiles varFiles = new GiveFiles(path, varDir, "txt");
//        GiveFiles varFiles = new GiveFiles(path, varDir, "dat");
//
//        myVarFiles = varFiles.getFiles();
//        for (int i = 0; i < myVarFiles.length; i++) {
//            if (myVarFiles[i].getName().equalsIgnoreCase("latitude.dat")) {
//                myFile = myVarFiles[i];
//                try {
//                    input = new BufferedReader(new FileReader(myFile));
//                } catch (IOException ex) {
//                    System.out.println("Can't open latitude file: " + ex);
//                    ex.printStackTrace();
//                }
////             **************** step through header stuff
//                do {
//                    fileLine = input.readLine();
//                } while (!fileLine.equalsIgnoreCase("****"));
////             **************** end of header stuff 
//                
//                do { //get the chosen climate location
//                    fileLine = input.readLine();
//                } while (!fileLine.equalsIgnoreCase(myParameters.location));
//                           
//                    //for (int r = 0; r < 1; r++){
//                       fileLine = input.readLine();//read the next line
//                       StringTokenizer chew = new StringTokenizer(fileLine, ",");
//                         myParameters.latitude = chew.nextToken().trim();          
//                       
////                       myParameters.latitude //[r] = 
////                                chew.nextToken().trim();
////                        myParameters.waterFilledLowerArray[r] = 
////                                chew.nextToken().trim();
////                        myParameters.waterFilledUpperArray[r] = 
////                                chew.nextToken().trim();
////                        myParameters.germGDDArray[r] = 
////                                chew.nextToken().trim();
////                        myParameters.elongRateGDDArray[r] = 
////                                chew.nextToken().trim();
//                       // } // end of for
//            }// end of if loop to get the latitude.dat file  
//        } // end of for loop to get the latitude.dat file       
//    
//     } // end of method getLatitudeData   


     /*  Description of the Method
     *
     *@param  myFile  Description of the Parameter
     */
    public void saveFile(File myFile) {//this writes to the "tinputs.dat" file
        try {
            // open up the file for writing; if it already exists overwrite it
            BufferedWriter out = new BufferedWriter(new FileWriter(myFile));
            out.write((myParameters.cropType).trim());
            out.newLine();
            out.write((myParameters.varietyType).trim());
            out.newLine();
            out.write((myParameters.location).trim());
            //debe changed file extensions to .dat
            //out.write(".txt");
            out.write(".dat");
            out.newLine();
            out.write((myParameters.month).trim());
            out.newLine();
            out.write((myParameters.day).trim());
            out.newLine();
            out.write((myParameters.year).trim()); 
            out.newLine();     
            out.write((myParameters.dayOfYear).trim());
            out.newLine();
            out.write((myParameters.plantingDepth).trim());
            out.newLine();
            out.write((myParameters.plantingRate).trim());
            out.newLine();
            out.write((myParameters.soilMoisturePlanting).trim());          
            out.newLine();
            
            // write out array elements for emergence parameters
            for(int k=0; k<4; k++){
                out.write((myParameters.soilMoistureArray[k]).trim());
                out.newLine();
                out.write((myParameters.waterFilledLowerArray[k]).trim());
                out.newLine();
                out.write((myParameters.waterFilledUpperArray[k]).trim());
                out.newLine();
                out.write((myParameters.germGDDArray[k]).trim());
                out.newLine();
                out.write((myParameters.elongRateGDDArray[k]).trim());
                out.newLine();
            }
            out.write((myParameters.latitude).trim());
            out.newLine();
            out.write((myParameters.GDDMethod).trim());
            out.newLine();
            out.write((myParameters.baseTemp).trim());
            out.newLine();
            out.write((myParameters.optimumTempLow).trim());
            out.newLine();
            out.write((myParameters.optimumTempUp).trim());
            out.newLine();
            out.write((myParameters.upperTemp).trim());
            out.newLine();
            out.write((myParameters.phyllochronValue).trim());
            out.newLine();
            out.write((myParameters.canopyHt).trim());//max canopy ht
            out.newLine();

            // write out array elements for vernalize parameters
                out.write((myParameters.vernalDays).trim());
                out.newLine();
                out.write((myParameters.vernalTbase).trim());
                out.newLine();
                out.write((myParameters.vernalToptlo).trim());
                out.newLine();
                out.write((myParameters.vernalToptup).trim());
                out.newLine();
                out.write((myParameters.vernalTupper).trim());
                out.newLine();
                out.write((myParameters.vernalDevern).trim());
                out.newLine();
            //write out the photoperiod parameters for soybeans 
            
            if (myParameters.mg.length()!=0){
                out.write((myParameters.mg).trim());
                out.newLine();               
                out.write((myParameters.photocrit).trim());
                out.newLine();               
                out.write((myParameters.ppsen).trim());
                out.newLine();               
                out.write((myParameters.photosen).trim());
                out.newLine();
            }
            
            //write out the maximum canopy height for phase 1 growth
                out.write((myParameters.ecanht).trim());
                out.newLine();  
            
           
            // Parse stages, discard label, write value to the file
            StringTokenizer st = new StringTokenizer(
                myParameters.myStages.toString(), "=,\n");
                       
            while (st.hasMoreTokens()) {
                // throw away label
                st.nextToken(); 
            // de added .trim() to get rid of white space in front of 
            // growth stage value    
                out.write(st.nextToken().trim());
                out.newLine();
            } // end of while
            out.newLine();
            // clean up
            out.flush();
            out.close();
        } // end of try
        catch (IOException ex) {
            ex.printStackTrace();
        } // end of catch
        
    } // end of saveFile method   

   // }
   
    public void readFile(File aFile){  //String
        StringBuffer buffer = new StringBuffer();        
        
        try{
            BufferedReader in= new BufferedReader(new FileReader(aFile));            
            String newLine;
            
            while((newLine = in.readLine())!= null){
                buffer.append(newLine + "\n");            
                output = buffer.toString();
            }  
            
            in.close();
            
        }
        catch(IOException ex){
            ex.printStackTrace();
        }            

        setOutput(output);
    }  
    
    public void setOutput(String fortOutput){
        String outputPath;
        outputPath = getAppPath();
        
        output = (outputPath + "" + fortOutput + "\n");
    }
    
    public String getOutput() {
        return output;
    }
    
    static class StreamGobbler implements Runnable {
        BufferedReader reader;
        public StreamGobbler(InputStream in) throws IOException {
            this.reader = new BufferedReader(new InputStreamReader(in));
        }
        
        public void run() {
            try {
                String line = null;
                while ( (line = reader.readLine()) != null) {
                    ;//do nothing
                }
            } catch (IOException ioe) {
                System.out.println("error gobbling stream");
                ioe.printStackTrace();
            }
        }
        
    }
    
}  // end of class Run