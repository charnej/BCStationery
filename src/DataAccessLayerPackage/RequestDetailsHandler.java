/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import BusinessLayerPackage.RequestDetails;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RequestDetailsHandler {

    // Public variables
    private static Connection con = null;
    private static PreparedStatement pst = null;
    private static Statement st = null;
    //set Request as Done
    public static void CompleteTransaction(int requestDetailsID,int complete,Date dComplete){
        try {
            con = JavaConnectDB.ConnectDB();
            //
            pst = con.prepareStatement("UPDATE `requestdetails` "
                    + "SET `Complete` = ?,"
                    + " `DateComplete` = ? "
                    + "WHERE `requestdetails`.`RequestDetailsID` = ?");
            pst.setInt(1, complete);
            pst.setDate(2, dComplete);
            pst.setInt(3, requestDetailsID);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Request Complete");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    //get Request Details from db
    public static PreparedStatement getRequestDetails(StaffRequestHandler.requestType requestType, int staffID, int requestNr) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "";
            if (requestType == StaffRequestHandler.requestType.All) {
                sql = "SELECT requestdetails.RequestDetailsID, requestdetails.Quantity, requestdetails.Complete, requestdetails.DateComplete, requestdetails.StockID, ProductName, Manufacturer, category.Name FROM staffrequest "
                        + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                        + "INNER JOIN requestdetails ON staffrequest.RequestNr = requestdetails.RequestNr "
                        + "INNER JOIN stock ON requestdetails.StockID = stock.StockID "
                        + "INNER JOIN category ON stock.Category = category.CategoryID "
                        + "WHERE staffrequest.StaffID = " + staffID + " "
                        + "AND requestdetails.RequestNr = " + requestNr + " ";
            } else if (requestType == StaffRequestHandler.requestType.Complete) {
                sql = "SELECT requestdetails.RequestDetailsID, requestdetails.Quantity, requestdetails.Complete, requestdetails.DateComplete, requestdetails.StockID, ProductName, Manufacturer, category.Name FROM staffrequest "
                        + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                        + "INNER JOIN requestdetails ON staffrequest.RequestNr = requestdetails.RequestNr "
                        + "INNER JOIN stock ON requestdetails.StockID = stock.StockID "
                        + "INNER JOIN category ON stock.Category = category.CategoryID "
                        + "WHERE staffrequest.StaffID = " + staffID + " "
                        + "AND requestdetails.RequestNr = " + requestNr + " "
                        + "AND requestdetails.Complete = 1";
            } else if (requestType == StaffRequestHandler.requestType.Incomplete) {
                sql = "SELECT requestdetails.RequestDetailsID, requestdetails.Quantity, requestdetails.Complete, requestdetails.DateComplete, requestdetails.StockID, ProductName, Manufacturer, category.Name FROM staffrequest "
                        + "INNER JOIN staff ON staffrequest.StaffID = staff.StaffID "
                        + "INNER JOIN requestdetails ON staffrequest.RequestNr = requestdetails.RequestNr "
                        + "INNER JOIN stock ON requestdetails.StockID = stock.StockID "
                        + "INNER JOIN category ON stock.Category = category.CategoryID "
                        + "WHERE staffrequest.StaffID = " + staffID + " "
                        + "AND requestdetails.RequestNr = " + requestNr + " "
                        + "AND requestdetails.Complete = 0";
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

    // delete operation
    public static void deleteRequest(int detailID) {
        try {
            con = JavaConnectDB.ConnectDB();
            st = con.createStatement();
            st.executeUpdate("DELETE FROM requestdetails "
                    + "WHERE RequestDetailsID = " + detailID + "");
            con.close();
            JOptionPane.showMessageDialog(null, "Delete Successfull");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e.getMessage());
        }
    }
        // select package items
    public static PreparedStatement getPackageItems(int requestNr) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "SELECT requestdetails.Complete, requestdetails.StockID FROM staffrequest "
                    + "INNER JOIN requestdetails ON staffrequest.RequestNr = requestdetails.RequestNr "
                    + "WHERE requestdetails.RequestNr = " + requestNr + " ";
            //
            pst = (PreparedStatement) con.prepareStatement(sql);
            //
            return pst;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        return pst;
    }
    // used to insert new Request Details
    public static void insertRequestDetails(int requestNr, int stockID, int Quantity) {
        try {
            con = JavaConnectDB.ConnectDB();
            //
            st = con.createStatement();
            st.executeUpdate("insert into requestdetails "
                    + "(RequestNr, StockID, Quantity, Complete, DateComplete) "
                    + "values (" + requestNr + ", " + stockID + ", " + Quantity + ", 0, " + null + ")");
            st.executeUpdate("UPDATE `staffrequest` SET `Complete` = '0' WHERE `staffrequest`.`RequestNr` = "+requestNr+"");
            //
            JOptionPane.showMessageDialog(null, "Request Details Sent");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}



