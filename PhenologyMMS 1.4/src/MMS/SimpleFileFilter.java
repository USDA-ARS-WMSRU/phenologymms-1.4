// SimpleFileFilter.java

package MMS;

import javax.swing.filechooser.*;
import java.io.File;
/**
 *  Title:       MMS Test2 
 *  Description: This class is just used in the jFileChooser
 *               package to select which files are visible by the user. 
 *  Copyright:   Copyright (c) 2002
 *  Company:     USDA/ARS
 *
 *@author        Ben Riebau
 *@created       January 8, 2003
 *@version       1.0
 *
 *added, edited comments   Debbie Edmunds, March 2005
 */

public class SimpleFileFilter extends FileFilter {

    String[] extensions;
    String description;


    /**
     *  Constructor for the SimpleFileFilter object
     *
     *@param  ext  Description of the Parameter
     */
    public SimpleFileFilter(String ext) {
        this(new String[]{ext}, null);

    }


    /**
     *  Constructor for the SimpleFileFilter object
     *
     *@param  exts   Description of the Parameter
     *@param  descr  Description of the Parameter
     */
    public SimpleFileFilter(String[] exts, String descr) {
        // clone lower case extensions
        extensions = new String[exts.length];
        for (int i = exts.length -1; i >= 0; i--) {
            extensions[i] = exts[i].toLowerCase();
        }
        // make sure we have a valid (if simplistic) description
        description = (descr == null ? exts[0] + " files" : descr);
    }


    /**
     *  Description of the Method
     *
     *@param  f  Description of the Parameter
     *@return    Description of the Return Value
     */
    public boolean accept(File f) {
        // we always allow directories, regardless of their extensions
        if (f.isDirectory()) {
            return true;
        }

        // OK, it's a regular file so check the extension
        String name = f.getName().toLowerCase();
        for (int i = extensions.length - 1; i >= 0; i--) {
            if (name.endsWith(extensions[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     *  Gets the description attribute of the SimpleFileFilter object
     *
     *@return    The description value
     */
    public String getDescription() {
        return description;
    }
}


