package info.hccis.admin.model;

import info.hccis.admin.dao.util.ConnectionUtils;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bjmaclean
 */
public class DatabaseConnection {

    private String databaseName;
    private String userName;
    private String password;

    public DatabaseConnection(String databaseName, String userName, String password) {
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
    }

    public DatabaseConnection(){
        try {
            String propFileName = "spring.data-access";
            ResourceBundle rb = ResourceBundle.getBundle(propFileName);
            userName = rb.getString("jdbc.username");
            password = rb.getString("jdbc.password");
            databaseName = rb.getString("jdbc.dbname");
            System.out.println("BJM-Set the database to "+databaseName);
           
        } catch (Exception ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, "Unable to get default database information");
        }
    }
    
    @Override
    public String toString() {
        return "DatabaseConnection{" + "databaseName=" + databaseName + ", userName=" + userName + ", password=" + password + '}';
    }

    
    
    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
            
    
}
