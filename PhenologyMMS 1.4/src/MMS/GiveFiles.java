// GiveFiles.java

package MMS;
import java.io.*;

import java.lang.*;
/**
 *  Title:       MMS Test2 
 *  Description: Started 9 Sept 2002 
 *  Copyright:   Copyright (c) 2002 
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       September 20, 2002
 *@version       1.0
 *
 *revised        Debbie Edmunds, February, 2005
 *
 */

public class GiveFiles {
    private String dir;
    private String ext;
    private String path;  // D. Edmunds added
    private File f1;
    private String fileList[];
    FilenameFilter only;


    /**
     *  Constructor for the GiveFiles object
     *
     *@param  directory  directory where the file is found
     *@param  extOfFile  extension part of the file name
     *@param  pathname   the path to the file
     */
    public GiveFiles(String pathname, String directory, String extOfFile) {
        dir = directory;
        ext = extOfFile;
        path = pathname;
        f1 = new File(path, dir); //DE changed to include the full pathname
        only = new FilterFiles(ext);
        
    }


    /**
     *  Gets the fileList attribute of the GiveFiles object
     *
     *@return    the files as an array of strings
     */

    public String[] getFileList() {
        return f1.list(only);
    }


    /**
     *  Gets the files attribute of the GiveFiles object
     *
     *@return    The files as a list of files
     */
    public File[] getFiles() {
        return f1.listFiles(only);
    }
}
