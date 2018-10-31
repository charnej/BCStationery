/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;
//T

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public static enum staffType{
    All,Accepted,Pending
}
    //get Staff from db
    public static PreparedStatement getStaff(staffType staffType) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "";
            if (staffType == staffType.All) {
                sql = "SELECT * FROM staff "
                        + "INNER JOIN department ON staff.Department = department.DepartmentID "
                        + "INNER JOIN campuslocation ON staff.CampusLocation = campuslocation.CampusID ";
            } else if (staffType == staffType.Accepted) {
                sql = "SELECT * FROM staff "
                        + "INNER JOIN department ON staff.Department = department.DepartmentID "
                        + "INNER JOIN campuslocation ON staff.CampusLocation = campuslocation.CampusID "
                        + "WHERE Accepted = 1";
            } else if (staffType == staffType.Pending) {
                sql = "SELECT * FROM staff "
                        + "INNER JOIN department ON staff.Department = department.DepartmentID "
                        + "INNER JOIN campuslocation ON staff.CampusLocation = campuslocation.CampusID "
                        + "WHERE Accepted = 0";
            }
            //
            pst = (PreparedStatement) con.prepareStatement(sql);
            //
            return pst;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return pst;
    }

    //get Staff member from db
    public static PreparedStatement getStaffMember(String username) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "SELECT * FROM staff "
                    + "INNER JOIN department ON staff.Department = department.DepartmentID "
                    + "INNER JOIN campuslocation ON staff.CampusLocation = campuslocation.CampusID "
                    + "WHERE Username = ?";
            //
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, username);
            //
            return pst;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //
        return pst;
    }

    //accept a pending staff member
    public static void acceptPendingStaff(String name, int id) {
        try {
            con = JavaConnectDB.ConnectDB();
            try {
                st = con.createStatement();
                st.executeUpdate("UPDATE staff SET Accepted=1 WHERE StaffID=" + id);
                JOptionPane.showMessageDialog(null, String.format("Successfully Added,\nMember: %s", name));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    // Insert Statement
    public static void insertStaff(String FirstName, String LastName, String Email, String Cellphone, String Username, String Password, int DepartmentName, int CampusName) {
        try {
            con = JavaConnectDB.ConnectDB();
            //
            st = con.createStatement();
            st.executeUpdate("insert into staff "
                    + "(FirstName, LastName, Email, Cellphone, Username, Password, Department, CampusLocation, Accepted) "
                    + "values ('" + FirstName + "', '" + LastName + "', '" + Email + "', '" + Cellphone + "', '" + Username + "', '" + Password + "', " + DepartmentName + ", " + CampusName + ", 0)");
            //
            JOptionPane.showMessageDialog(null, "Member Request sent,\nUsername: " + Username);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Update Statement
    public static void updateStaff(int StaffID, String FirstName, String LastName, String Email, String Cellphone, String Username, String Password, int DepartmentName, int CampusName) {
        try {
            con = JavaConnectDB.ConnectDB();
            //
            st = con.createStatement();
            st.executeUpdate("UPDATE staff "
                    + "SET FirstName = '" + FirstName + "', LastName = '" + LastName + "', Email = '" + Email + "', Cellphone = '" + Cellphone + "', "
                    + "Username = '" + Username + "', Password = '" + Password + "', Department = " + DepartmentName + ", CampusLocation = " + CampusName + " "
                    + "WHERE StaffID = " + StaffID + "");
            //
            JOptionPane.showMessageDialog(null, "Member Profile, Updated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void updateStaffLoggedIN(String UserName, int LoggedIn) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "UPDATE staff SET LoggedIn = '"+LoggedIn+"' WHERE Username = '"+UserName+"'";
            st = con.createStatement();
            st.executeUpdate(sql);
            //
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
