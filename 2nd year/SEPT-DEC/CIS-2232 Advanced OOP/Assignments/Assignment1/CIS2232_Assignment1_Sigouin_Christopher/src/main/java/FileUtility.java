/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 20-Sep-2015
 * PURPOSE: Topic 1 Assignment 1
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtility {

    private static Scanner input = new Scanner(System.in);

    public static Scanner getInput() {
        return input;
    }

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
     * This method will write to a file. Example obtained from:
     * http://stackoverflow.com/questions/26380744/which-is-the-best-way-to-create-file-and-write-to-it-in-java
     *
     * @param fileName
     * @param content
     *
     * @since 20150917
     * @author BJ MacLean
     */
    public static void write(String fileName, String content) {

        try {

            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(fileName, true);
            } catch (Exception e) {
                System.out.println("Error creating fileWriter in FileUtility.write(...)");
            }

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content);
            bufferedWriter.flush();

        } catch (IOException ex) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This version will add a line feed at the end of the content.
     *
     * @since 20150917
     * @author BJ MacLean
     *
     */
    public static void writeLine(String fileName, String content) {
        write(fileName, content + System.lineSeparator());

    }

    /**
     * Returns a BufferedWriter object to the calling class
     * 
     * @param fileName
     * @return 
     */
    public static BufferedWriter getBufferedWriter(String fileName) {

        //Will use FileWriter, BufferedWriter, and PrintWriter in this method.
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
        } catch (Exception e) {
            System.out.println("Error creating fileWriter in FileUtility.write(...)");
        }


        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        return bufferedWriter;

    }
    
    /**
     * This method will get a BufferedReader to be used.
     *
     * @since 20150917
     * @author BJ MacLean
     */
    public static BufferedReader getBufferedReader(String filePath) {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = Files.newBufferedReader(Paths.get(filePath), Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, "Error in readLine", ex);
        }
        return bufferedReader;
    }

    /**
     * This method will read a line from a file.
     *
     * @param filePath
     * @return
     */
    public static String readLine(String filePath) {

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath), Charset.defaultCharset());
            return bufferedReader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, "Error in readLine", ex);
        }
        return null;
    }

    /**
     * This method will read a line from a file.
     *
     * @param filePath
     * @return
     */
    public static String readLine(BufferedReader bufferedReader) {

        try {
            return bufferedReader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FileUtility.class.getName()).log(Level.SEVERE, "Error in readLine", ex);
            return null;
        }
    }

}
