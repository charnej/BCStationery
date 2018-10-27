/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import java.sql.Date;
import java.util.ArrayList;
import DataAccessLayerPackage.RequestDetailsHandler;

/**
 *
 * @author User
 */
public class RequestDetails {    
    private int requestNr;
    private String productName;    
    private int quantity;
    private Date requestDate;
    String firstName;
    String lastName;
    private int complete;

    public RequestDetails(int requestNr, String productName, int quantity, Date requestDate, String firstName, String lastName, int complete) {
        this.requestNr = requestNr;
        this.productName = productName;
        this.quantity = quantity;
        this.requestDate = requestDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.complete = complete;
    }

    public int getRequestNr() {
        return requestNr;
    }

    public void setRequestNr(int requestNr) {
        this.requestNr = requestNr;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public static ArrayList<RequestDetails> selectRequestDetails(){
        ArrayList<RequestDetails> requestDetailsList = RequestDetailsHandler.getRequestDetails();
        return requestDetailsList;
    }
    
    public static RequestDetails[] toArray() {
        RequestDetails[] it = new RequestDetails[selectRequestDetails().size()];
        for (int i = 0; i < selectRequestDetails().size(); i++) {
            it[i] = selectRequestDetails().get(i);
        }
        return it;

    }

    @Override
    public String toString() {
        //return requestNr + " " + productName + " " + quantity + " " + requestDate + " " + firstName + " " + lastName + " " + complete;
        return String.format("%-5d %-5s\t %-10s %-20s %-10s %-10s %-10s", requestNr, productName, quantity, requestDate, firstName, lastName, complete);
    }
  
}
