package info.hccis.admin.util;

/*

========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 ____            _           _     ____            _    __       _ _       
|  _ \ _ __ ___ (_) ___  ___| |_  |  _ \ ___  _ __| |_ / _| ___ | (_) ___  
| |_) | '__/ _ \| |/ _ \/ __| __| | |_) / _ \| '__| __| |_ / _ \| | |/ _ \ 
|  __/| | | (_) | |  __/ (__| |_  |  __/ (_) | |  | |_|  _| (_) | | | (_) |
|_|   |_|  \___// |\___|\___|\__| |_|   \___/|_|   \__|_|  \___/|_|_|\___/ 
              |__/                                                         

Project Members: Christopher Sigouin & Matthew Hutchinson

Date: November, 29 2015
Purpose: Final Project

*/

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;

/**
 * 
 * @author krystofurr
 */
public class ErrorLogUtility {
    
    
    // The file path
    /* /media/krystofurr/SCHOOL_DRIVE/2ndYEAR/SEPT-DEC/AdvancedOOP/apache-tomcat-8.0.27/bin/logs */
    
    public final static String FILE_PATH = "logs/hcProjectPortfolio_Error.log";
    // Holds the path to the file being used
    private static FileHandler fh;
    // Logger object
    private static Logger logger = Logger.getLogger("Error Log");
    // SimpleFormatter object
    private static SimpleFormatter formatter = new SimpleFormatter();

    /**
     * http://stackoverflow.com/questions/15758685
     * /how-to-write-logs-in-text-file-when-using-java-util-logging-logger
     * 
     * @param ex
     * @param level
     * @param msg 
     */
    
    public static void createFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);

        Files.createDirectories(path.getParent());

        try {
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
            System.err.println("File Exists: " + fileName);
        }
    }
    
    /**
     * 
     * Parameters:
     *  Exception ex
     *  String level -> Level.SEVERE, Level.WARNING, Level.INFO, Level.CONFIG,
     *                  Level.FINE, Level.FINER, Level.FINEST
     *  String msg -> Your custom error message here
     * 
     * @param ex
     * @param level
     * @param msg 
     */
    public static void log(Exception ex, Level level, String msg){
  
        try {
            // Create a log file if one does not exist
            createFile(FILE_PATH);
            // FileHandler boolean value defines appending to the file
            fh = new FileHandler(FILE_PATH,true);
            // Formats the LogRecord object ( used with Logger object ) into a human readable format
            fh.setFormatter(formatter);
            // Add the handler to the Logger object
            logger.addHandler(fh);
            
            switch (level.toString()) {    
                case "SEVERE":
                    logger.log(Level.SEVERE, msg, ex);
                    if(!msg.equals(""))
                        JOptionPane.showMessageDialog(null,msg,
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case "warning":
                    logger.log(Level.WARNING, msg, ex);
                    if(!msg.equals(""))
                        JOptionPane.showMessageDialog(null,msg,
                            "Warning", JOptionPane.WARNING_MESSAGE);
                    break;
                case "info":
                    logger.log(Level.INFO, msg, ex);
                    if(!msg.equals(""))
                        JOptionPane.showMessageDialog(null,msg,
                            "Info", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "config":
                    logger.log(Level.CONFIG, msg, ex);
                    break;
                case "fine":
                    logger.log(Level.FINE, msg, ex);
                    break;
                case "finer":
                    logger.log(Level.FINER, msg, ex);
                    break;
                case "finest":
                    logger.log(Level.FINEST, msg, ex);
                    break;
                default:
                    logger.log(Level.CONFIG, msg, ex);
                    break;
            }
        } catch (IOException | SecurityException ex1) {
            logger.log(Level.SEVERE, null, ex1);
        } finally{
            if(fh!=null)fh.close();
        }
    }
    
    
    
}
