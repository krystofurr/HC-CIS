package info.hccis.admin.dao;

/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 03-10-2015
 * PURPOSE: Topic 2 Assignment 2
 *
 */

import info.hccis.admin.dao.util.ConnectionUtils;
import info.hccis.admin.data.springdatajpa.DeliverableRepository;
import info.hccis.admin.model.DatabaseConnection;
import info.hccis.admin.model.jpa.Deliverable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Data access object that holds methods used for the deliverable database
 * 
 */
public class DeliverableDAO {



    /**
     * DELETE ALL RECORDS FROM DATABASE
     * 
     * 
     * @param databaseConnection 
     */
    public static void purgeDeliverables(DatabaseConnection databaseConnection) {
        
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        
        try {
            
            // Get a database connection
            conn = ConnectionUtils.getConnection(databaseConnection);
            
            sql = "DELETE from Deliverables";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
 
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            
        } finally {
            DbUtils.close(ps, conn);
        }
    }
    /**
     * Loads all records from the database, stores them in an ArrayList and
     * returns the ArrayList to the calling method
     * 
     * @return
     * @throws Exception
     * @author Christopher Sigouin
     * @since 20151003
     */
//    public static ArrayList<Deliverable> loadDeliverables() {
//    
//        return (ArrayList<Deliverable>) deliverableRepository.findAll();
//    }
//    
    /**
     * UPDATE / EDIT DELIVERABLE
     * 
     * 
     * @param deliverable
     * @since 20151003
     * @author Christopher Sigouin
     */
    public static synchronized void editDeliverable(DatabaseConnection databaseConnection, Deliverable deliverable) {

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        try {
            
            // Get a database connection
            conn = ConnectionUtils.getConnection(databaseConnection);

            System.out.println("Updating DB.....");
            sql = "UPDATE `Deliverables` SET `name`=?,`weight`=? WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1, deliverable.getName());
            ps.setInt(2, deliverable.getWeight());
            ps.setString(3, "" + deliverable.getId());

            ps.executeUpdate();
        
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();

        } finally {
            DbUtils.close(ps, conn);
        }
 
    } // END: updateDeliverable()  
    
    /**
     * 
     * INSERT DELIVERABLE
     * 
     * 
     * @param databaseConnection
     * @param deliverable 
     */
    public static synchronized void insertDeliverable(DatabaseConnection databaseConnection, Deliverable deliverable) {

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        try {
            
            // Get a database connection
            conn = ConnectionUtils.getConnection(databaseConnection);

            System.out.println("Inserting into DB.....");
            sql = "INSERT INTO `Deliverables`(`name`, `weight`) VALUES (?,?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, deliverable.getName());
            ps.setInt(2, deliverable.getWeight());

            ps.executeUpdate();
        
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();

        } finally {
            DbUtils.close(ps, conn);
        }
 
    } // END: insertDeliverable()
    
        
//    public static synchronized void deleteDeliverable(DatabaseConnection databaseConnection, Deliverable deliverable) {
//         
//        PreparedStatement ps = null;
//        String sql = null;
//        Connection conn = null;
//
//        try {
//            
//            // Get a database connection
//            conn = ConnectionUtils.getConnection(databaseConnection);
//            
//            sql = "DELETE from Deliverables WHERE `id`=?";
//
//            ps = conn.prepareStatement(sql);
//            ps.setString(1, deliverable.getId());
// 
//            ps.executeUpdate();
//            
//        } catch(Exception e) {
//            String errorMessage = e.getMessage();
//            e.printStackTrace();
//        } finally {
//            DbUtils.close(ps, conn);
//        }
//    }
    
    
} // END: DeliverableDAO class
