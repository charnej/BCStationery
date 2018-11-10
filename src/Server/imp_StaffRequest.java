/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLayerPackage.IStaffRequest;
import BusinessLayerPackage.StaffRequest;
import DataAccessLayerPackage.StaffRequestHandler;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tyrone
 */
public class imp_StaffRequest extends UnicastRemoteObject implements IStaffRequest {

    public imp_StaffRequest() throws RemoteException {
    }

    //  -- database operations
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    // Static as this functionality is not bound to each object, but to the class
    // Get all the required Staff request data ..
    @Override
    public ArrayList<StaffRequest> getStaffRequests(StaffRequestHandler.requestType requestType, int staffID) {
        ArrayList<StaffRequest> allRequests = new ArrayList<StaffRequest>();
        try {
            pst = StaffRequestHandler.getStaffRequests(requestType, staffID);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                allRequests.add(new StaffRequest(rs.getInt("RequestNr"),
                        rs.getDate("RequestDate"), rs.getInt("StaffID"), rs.getInt("Complete")));
            }
            return allRequests;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
}
