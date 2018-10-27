/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Tyrone
 */
public class StaffRequestHandler {

    // Public variables
    private static Connection con = null;
    private static PreparedStatement pst = null;
    private static Statement st = null;

    //get Requests from db
    public static PreparedStatement getStaffRequests(String requestType, int staffID) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "";
            if (requestType == "All") {
                sql = "SELECT * FROM staffrequest "
                        + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                        + "WHERE staffrequest.StaffID = " + staffID + " ";
            } else if (requestType == "Complete") {
                sql = "SELECT * FROM staffrequest "
                        + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                        + "WHERE staffrequest.StaffID = " + staffID + " "
                        + "AND staffrequest.Complete = 1";
            } else if (requestType == "Incomplete") {
                sql = "SELECT * FROM staffrequest "
                        + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                        + "WHERE staffrequest.StaffID = " + staffID + " "
                        + "AND staffrequest.Complete = 0";
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
}
