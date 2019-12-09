// FilterFiles.java

package MMS;
import java.io.*;
/**
 *  Title:       MMS Test2 
 *  Description: This class helps with sorting the files to be used.
 *      It is called in GiveFiles.
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       September 20, 2002
 *@version       1.0
 *
 *edited comments, Debbie Edmunds, February, 2005
 */

public class FilterFiles implements FilenameFilter{
    String extOfFile;

    /**
     *  Constructor for the FilterFiles object
     *
     *@param  ext = extension part of the file name
     */
    public FilterFiles(String ext) {
        extOfFile = ext;
    }


    /**
     *  Description of the Method
     *
     *@param  dir   the directory where the file is found
     *@param  name  name of the file
     *@return       extension part of the file name
     */
    public boolean accept(File dir, String name) {
        return name.endsWith(extOfFile);
    }

    
}



