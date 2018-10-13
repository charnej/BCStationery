/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//T
import java.sql.Date;

/**
 *
 * @author Jozehan
 */
public class StaffRequest {
    private int requestNr;
    private Date requestDate;
    private int staffID;//staff type staff
    private Stock stock;//Stock type stock
    private int quantity; 
    private boolean Complete;// neem aan boolean

    public StaffRequest(int requestNr, Date requestDate, int staffID, Stock stock, int quantity, boolean Complete) {
        this.requestNr = requestNr;
        this.requestDate = requestDate;
        this.staffID = staffID;
        this.stock = stock;
        this.quantity = quantity;
        this.Complete = Complete;
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isComplete() {
        return Complete;
    }

    public void setComplete(boolean Complete) {
        this.Complete = Complete;
    }
    
}
