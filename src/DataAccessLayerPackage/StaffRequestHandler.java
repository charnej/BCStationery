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
    public static PreparedStatement getStaffRequests(String requestType) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "";
            if (requestType == "All") {
                sql = "SELECT * FROM  "
                        + "INNER JOIN  ON  =  "
                        + "INNER JOIN  ON  =  ";
            } else if (requestType == "Selected") {
                sql = "SELECT * FROM  "
                        + "INNER JOIN  ON  =  "
                        + "INNER JOIN  ON  =  "
                        + "WHERE ";
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
