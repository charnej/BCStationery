/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;
//t

import java.sql.Connection;
import java.sql.Date;
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

    public static enum requestType {
        All, Complete, Incomplete
    }

    //get Requests from db
    public static PreparedStatement getStaffRequests(requestType requestType, int staffID) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "";
            if (staffID != 0) {
                 switch (requestType) {
                    case All:
                        sql = "SELECT * FROM staffrequest "
                                + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                                + "WHERE staffrequest.StaffID = " + staffID + " ";
                        break;
                    case Complete:
                        sql = "SELECT * FROM staffrequest "
                                + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                                + "WHERE staffrequest.StaffID = " + staffID + " "
                                + "AND staffrequest.Complete = 1";
                        break;
                    case Incomplete:
                        sql = "SELECT * FROM staffrequest "
                                + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                                + "WHERE staffrequest.StaffID = " + staffID + " "
                                + "AND staffrequest.Complete = 0";
                        break;
                    default:
                        break;
                }
            }else{
                 switch (requestType) {
                    case All:
                        sql = "SELECT * FROM staffrequest "
                                + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID ";
                        break;
                    case Complete:
                        sql = "SELECT * FROM staffrequest "
                                + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                                + "WHERE staffrequest.Complete = 1";
                        break;
                    case Incomplete:
                        sql = "SELECT * FROM staffrequest "
                                + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                                + "WHERE staffrequest.Complete = 0";
                        break;
                    default:
                        break;
                }
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

    // used to insert new Staff request
    public static void insertStaffRequest(String requestDate, int staffID) {
        try {
            con = JavaConnectDB.ConnectDB();
            //
            st = con.createStatement();
            st.executeUpdate("insert into staffrequest "
                    + "(RequestDate, StaffID, Complete) "
                    + "values ('" + requestDate + "', " + staffID + ", 0)");
            //
            JOptionPane.showMessageDialog(null, "Staff Request sent");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
