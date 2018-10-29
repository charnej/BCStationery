
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//t
import java.sql.Date;
import java.util.ArrayList;
import DataAccessLayerPackage.RequestDetailsHandler;
import DataAccessLayerPackage.StaffRequestHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RequestDetails extends Stock{

    // fields needed
    private int requestDetailsID;
    private int requestNr;
    //private int stockID;
    private int quantity;
    private int complete;
    private Date dateComplete;

    public RequestDetails() {
    }
    
    // constructor used to display Request Details 
    public RequestDetails(int requestDetailsID, int quantity, int complete, Date dateComplete, int stockID, String productName, String manufacturer, String category) {
        super(stockID, productName, manufacturer, category);
        //this.stockID=stockID;
        this.requestDetailsID = requestDetailsID;
        this.quantity = quantity;
        this.complete = complete;
        this.dateComplete = dateComplete;
    }
    
    // used to insert request details
    public RequestDetails(int requestDetailsID, int requestNr, int stockID, int quantity, int complete, Date dateComplete) {
        super(stockID);
        this.requestDetailsID = requestDetailsID;
        this.requestNr = requestNr;
        //this.stockID = stockID;
        this.quantity = quantity;
        this.complete = complete;
        this.dateComplete = dateComplete;
    }
        // used to check if package is complete 
    // OR if package contains specified item
    public RequestDetails(int stockID, int complete) {
        super(stockID);
        this.complete = complete;
    }

    public int getRequestDetailsID() {
        return requestDetailsID;
    }

    public void setRequestDetailsID(int requestDetailsID) {
        this.requestDetailsID = requestDetailsID;
    }

    public int getRequestNr() {
        return requestNr;
    }

    public void setRequestNr(int requestNr) {
        this.requestNr = requestNr;
    }
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public Date getDateComplete() {
        return dateComplete;
    }

    public void setDateComplete(Date dateComplete) {
        this.dateComplete = dateComplete;
    }

    //  -- database operations
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    // Static as this functionality is not bound to each object, but to the class
    // Get all the required request data ..
    public static ArrayList<RequestDetails> getRequestDetails(StaffRequestHandler.requestType requestType, int staffID, int requestNr) {
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
    public static ArrayList<RequestDetails> getPackageItems(int requestNr) {
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
    // set the state of the package
    public static boolean testPackageState(int requestNr){
        ArrayList<RequestDetails> allRequests = getPackageItems(requestNr);
        for (RequestDetails allRequest : allRequests) {
            if (allRequest.getComplete() == 0) {
                return false;
            }
        }
        //
        return true;
    }
    // test if package already contains item
    public static boolean testPackageItem(int requestNr, int stockID){
        ArrayList<RequestDetails> allRequests = getPackageItems(requestNr);
        for (RequestDetails allRequest : allRequests) {
            if (allRequest.getStockID()== stockID) {
                return false;
            }
        }
        //
        return true;
    }
    // delete operation
    public static void deleteRequest(int detailID){
        RequestDetailsHandler.deleteRequest(detailID);
    }
    
    // used to insert new request details
    public static void insertRequestDetails(int requestNr, int stockID, int Quantity) {
        RequestDetailsHandler.insertRequestDetails(requestNr, stockID, Quantity);
    }
    public static void CompleteTransaction(int requestDetailsID,int complete,Date dComplete){
        RequestDetailsHandler.CompleteTransaction(requestDetailsID,complete,dComplete);
       
    }
}


