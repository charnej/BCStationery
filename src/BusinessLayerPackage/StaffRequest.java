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
    private int staffID;
    private int stockID;
    private int quantity;
    private int complete;

    public StaffRequest(int requestNr, Date requestDate, int staffID, int stockID, int quantity, int complete) {
        this.requestNr = requestNr;
        this.requestDate = requestDate;
        this.staffID = staffID;
        this.stockID = stockID;
        this.quantity = quantity;
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

    public int getStockID() {
        return stockID;
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

}
