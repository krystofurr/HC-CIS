package assignment2.chsig.deliverables.dao;

/*
 * ========= CIS 2232 Advanced Object Oriented Programming PWC ==========
 * NAME: Christopher Sigouin
 * DATE: 03-10-2015
 * PURPOSE: Topic 2 Assignment 2
 *
 */

import assignment2.chsig.deliverables.model.Deliverable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * Data access object that holds methods used for the deliverable database
 * 
 */
public class DeliverableDAO {


    /**
     * Loads all records from the database, stores them in an ArrayList and
     * returns the ArrayList to the calling method
     * 
     * @return
     * @throws Exception
     * @author Christopher Sigouin
     * @since 20151003
     */
    public static ArrayList<Deliverable> loadDeliverables() throws Exception {
    
        ArrayList<Deliverable> deliverables = new ArrayList();
        Deliverable deliverable = new Deliverable();
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */

        try {
            
            // Get a database connection
            conn = ConnectionUtils.getConnection();
            
            sql = "SELECT * from Deliverables";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Get each value
                String name = rs.getString(2);
                int weight = rs.getInt(3);

                // Add to the ArrayList
                deliverables.add(new Deliverable(name, weight));
 
            }
 
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            throw e;
        } finally {
            DbUtils.close(ps, conn);
        }
        
        return deliverables;
    }
    
    /**
     * Method either 'Inserts' or 'Updates' the database based on the user choice
     * argument that is passed.
     * 
     * 
     * @param deliverable
     * @param userChoice
     * @throws Exception 
     * @since 20151003
     * @author Christopher Sigouin
     */
    public static synchronized void update(Deliverable deliverable, char userChoice) throws Exception {

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */

        try {
            
            // Get a database connection
            conn = ConnectionUtils.getConnection();

            // Switch based on the users choice
            switch( userChoice ) {

                case 'I': // Insert 
                    System.out.println("Inserting into DB.....");
                    sql = "INSERT INTO `Deliverables`(`Deliv_Name`, `Deliv_Weight`) "
                     + "VALUES (?,?)";

                    ps = conn.prepareStatement(sql);
                    ps.setString(1, deliverable.getName());
                    ps.setInt(2, deliverable.getWeight());

                    break;
                    
                case 'U': // Update 
                    System.out.println("Updating DB.....");
                    sql = "UPDATE `Deliverables` SET `Deliv_Name`=?,`Deliv_Weight`=? WHERE Deliv_Name = ?";

                    ps = conn.prepareStatement(sql);
                    ps.setString(1, deliverable.getName());
                    ps.setInt(2, deliverable.getWeight());
                    ps.setString(3, deliverable.getName());
 
                    break;
                    
            } // END: switch

            ps.executeUpdate();
        
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            throw e;
        } finally {
            DbUtils.close(ps, conn);
        }
 
    } // END: update()   
    
} // END: DeliverableDAO class
