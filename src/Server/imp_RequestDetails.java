/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLayerPackage.IRequestDetails;
import BusinessLayerPackage.RequestDetails;
import DataAccessLayerPackage.RequestDetailsHandler;
import DataAccessLayerPackage.StaffRequestHandler;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tyrone
 */
public class imp_RequestDetails extends UnicastRemoteObject implements IRequestDetails {

    public imp_RequestDetails() throws RemoteException {
    }

    //  -- database operations
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    // Static as this functionality is not bound to each object, but to the class
    // Get all the required request data ..
    @Override
    public ArrayList<RequestDetails> getRequestDetails(StaffRequestHandler.requestType requestType, int staffID, int requestNr) {
        ArrayList<RequestDetails> allRequests = new ArrayList<RequestDetails>();
        try {
            pst = RequestDetailsHandler.getRequestDetails(requestType, staffID, requestNr);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                allRequests.add(new RequestDetails(rs.getInt("RequestDetailsID"),
                        rs.getInt("Quantity"),
                        rs.getInt("Complete"),
                        rs.getDate("DateComplete"),
                        rs.getInt("requestdetails.StockID"),
                        rs.getString("ProductName"),
                        rs.getString("Manufacturer"),
                        rs.getString("Name")));
            }
            return allRequests;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    // get package items

    @Override
    public ArrayList<RequestDetails> getPackageItems(int requestNr) {
        ArrayList<RequestDetails> allRequests = new ArrayList<RequestDetails>();
        try {
            pst = RequestDetailsHandler.getPackageItems(requestNr);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                allRequests.add(new RequestDetails(rs.getInt("StockID"),
                        rs.getInt("Complete")));
            }
            return allRequests;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
}
