/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//t

import DataAccessLayerPackage.StaffRequestHandler;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jozehan
 */
public class StaffRequest {

    private int requestNr;
    private Date requestDate;
    private int staffID;
    private int complete;
    //
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public StaffRequest() {
    }
    
    // used to read staff request data
    public StaffRequest(int requestNr, Date requestDate) {
        this.requestNr = requestNr;
        this.requestDate = requestDate;
    }

    // used to insert new Staff request
    public StaffRequest(int requestNr, Date requestDate, int staffID, int complete) {
        this.requestNr = requestNr;
        this.requestDate = requestDate;
        this.staffID = staffID;
        this.complete = complete;
    }

    public int getRequestNr() {
        return requestNr;
    }

    public void setRequestNr(int requestNr) {
        this.requestNr = requestNr;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    //  -- database operations
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    // Static as this functionality is not bound to each object, but to the class
    // Get all the required Staff request data ..
    public static ArrayList<StaffRequest> getStaffRequests(StaffRequestHandler.requestType requestType, int staffID) {
        ArrayList<StaffRequest> allRequests = new ArrayList<StaffRequest>();
        try {
            pst = StaffRequestHandler.getStaffRequests(requestType, staffID);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                allRequests.add(new StaffRequest(rs.getInt("RequestNr"),
                        rs.getDate("RequestDate"),rs.getInt("StaffID"),rs.getInt("Complete")));
            }
            return allRequests;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    // used to insert new Staff request
    public static void insertStaffRequest(Date requestDate, int staffID) {
        StaffRequestHandler.insertStaffRequest(sdf.format(requestDate), staffID);
    }

    // check to see if package exists
    public static int isPackage(Date d, int staffID) {
        ArrayList<StaffRequest> staffRequests = StaffRequest.getStaffRequests(StaffRequestHandler.requestType.All, staffID);
        String df = sdf.format(d); // ensure that date format remains constant
        for (StaffRequest staffRequest : staffRequests) {
            String staffDate = staffRequest.getRequestDate().toString();
            if (staffDate.equals(df)) {
                return staffRequest.getRequestNr();
            }
        }
        //
        return -1;
    }

}
