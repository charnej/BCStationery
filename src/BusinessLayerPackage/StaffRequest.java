
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//t

import DataAccessLayerPackage.StaffRequestHandler;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jozehan
 */
public class StaffRequest implements Serializable {

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

    // used to insert new Staff request
    public static void insertStaffRequest(Date requestDate, int staffID) {
        StaffRequestHandler.insertStaffRequest(sdf.format(requestDate), staffID);
    }

    // check to see if package exists
    public static int isPackage(Date d, int staffID) {
        try {
            IStaffRequest requestImp = (IStaffRequest) SingleRegistry.getInstance().getRegistry().lookup("request");
            ArrayList<StaffRequest> staffRequests = requestImp.getStaffRequests(StaffRequestHandler.requestType.All, staffID);
            String df = sdf.format(d); // ensure that date format remains constant
            for (StaffRequest staffRequest : staffRequests) {
                String staffDate = staffRequest.getRequestDate().toString();
                if (staffDate.equals(df)) {
                    return staffRequest.getRequestNr();
                }
            }
            //
            return -1;
        } catch (NotBoundException ex) {
            Logger.getLogger(StaffRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(StaffRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        return -1;
    }

    // change completion state of package
    public static void updateState(StaffRequestHandler.stateType stateType, int requestNr) {
        StaffRequestHandler.updateState(stateType, requestNr);
    }

}
