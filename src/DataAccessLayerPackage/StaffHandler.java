/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;
//T

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Tyrone
 */
public class StaffHandler {

    // Public variables
    private static Connection con = null;
    private static PreparedStatement pst = null;
    private static Statement st = null;
    
    //get Staff from db
    public static PreparedStatement getStaff() {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "SELECT * FROM staff "
                    + "INNER JOIN department ON staff.Department = department.DepartmentID "
                    + "INNER JOIN campuslocation ON staff.CampusLocation = campuslocation.CampusID "
                    + "WHERE Accepted = 1";
            pst = (PreparedStatement) con.prepareStatement(sql);
            //
            return pst;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return pst;
    }

    //get Pending Staff from db
    public static PreparedStatement getPendingStaff() {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "SELECT * FROM staff "
                    + "INNER JOIN department ON staff.Department = department.DepartmentID "
                    + "INNER JOIN campuslocation ON staff.CampusLocation = campuslocation.CampusID "
                    + "WHERE Accepted = 0";
            pst = (PreparedStatement) con.prepareStatement(sql);
            //
            return pst;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return pst;
    }

    //accept a pending staff member
    public static void acceptPendingStaff(String name, int id) {
        try {
            con = JavaConnectDB.ConnectDB();
            try {
                st = con.createStatement();
                st.executeUpdate("UPDATE staff SET Accepted=1 WHERE StaffID="+id);
                JOptionPane.showMessageDialog(null, String.format("Successfully Added,\nMember: %s", name));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
