/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 03-10-2015
 * PURPOSE: Topic 2 Assignment 2
 */

package assignment2.chsig.deliverables.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtils {

    private final static Logger LOGGER = Logger.getLogger(ConnectionUtils.class.getName());
    private static String USER_NAME_DB = "";
    private static String USER_PASSWORD_DB = "";
    private static String DB_NAME = "";
    private static String HOST_NAME = "";

    static {
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
        }
    }

    public static Connection getConnection() throws Exception {
        return getDBConnection();
    }

    public static Connection getDBConnection() throws Exception {

        if (USER_NAME_DB.equals("")) {
            String propFileName = "data-access";
            ResourceBundle rb = ResourceBundle.getBundle(propFileName);

            USER_NAME_DB = rb.getString("jdbc.username");
            USER_PASSWORD_DB = rb.getString("jdbc.password");
            DB_NAME = rb.getString("jdbc.dbname");
            HOST_NAME = rb.getString("jdbc.host");
        }

        Connection conn = null;
        String URL = "jdbc:mysql://" + HOST_NAME + ":3306/" + DB_NAME;

        try {
            conn = DriverManager.getConnection(URL, USER_NAME_DB, USER_PASSWORD_DB);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
