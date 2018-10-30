/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import DataAccessLayerPackage.purchaseOrderHandler;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Jozehan
 */
public class purchaseOrder {
    private int orderID;
    private int stockID;
    private int quantity;
    //for a new purchase order
    public purchaseOrder(int stockID, int quantity) {
        this.stockID = stockID;
        this.quantity = quantity;
    }
    
    public purchaseOrder() {
    }

    public purchaseOrder(int orderID, int stockID, int quantity) {
        this.orderID = orderID;
        this.stockID = stockID;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String showPurchaseOrder(Stock s){
        return String.format("|%5d|%21s|%13s|%10s|%8d|%15d|\n" ,
                s.getStockID(), 
                ((s.getProductName().length()>20)?s.getProductName().substring(0, 19):s.getProductName()),
                ((s.getManufacturer().length()>13)?s.getManufacturer().substring(0, 12):s.getManufacturer()),
                Currency.getInstance(Locale.getDefault()).getSymbol()+s.getPrice(),
                s.getQuantity(),
                this.quantity);
    }
    public ArrayList<purchaseOrder> getPurchaseOrders(){
        purchaseOrderHandler dbHandler = new purchaseOrderHandler();
        return dbHandler.getPurchaseOrders();
    }
    public void insert(int quantity){
        purchaseOrderHandler dbHandler = new purchaseOrderHandler();
        ArrayList<purchaseOrder> orders =getPurchaseOrders();
        for (purchaseOrder o : orders) {
            if (o.stockID==this.stockID) {
                //increase stock
                dbHandler.update(o.getOrderID(), stockID, o.getQuantity()+quantity);
            }
        }
    }
}
