/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evdosoft.stocktechsys.utilities;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author atlantis
 */
@Component
public class FileOperations {

    private static final Logger logger = LoggerFactory.getLogger(FileOperations.class);
    
    /**
     * Check if file exists. Does not check for integrity. Mainly used
     * to check if DBFile exists
     * @param filename
     * @return True if database exists
     */
    public boolean checkFileExist (String filename) {
        File f = new File(filename);

      if(f.exists()){
          return true;
      }else{
          return false; 
      }                
    }
    
    /**
     * Deletes file
     * @param filename 
     * @return True if successful.
     */
    public boolean deleteFile (String filename) {
        boolean bool;
        File f = new File(filename);
        bool = f.delete();
        if (!bool) {
            logger.error("deleteFile - Could not delete {}.",filename);
        }
        return bool;                
    }

}
