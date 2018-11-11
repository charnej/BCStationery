
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//T

import DataAccessLayerPackage.StockHandler;
import java.awt.List;
import java.io.Serializable;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jozehan
 */
public class Stock implements Serializable {

    public Stock() {
    }

    public Stock(int stockID) {
        this.stockID = stockID;
    }

    // constructor used in Request Details
    public Stock(int stockID, String productName, String manufacturer, String category) {
        this.stockID = stockID;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    // constructor used in Request Details
    public Stock(int stockID, String productName, String manufacturer, String category, int quantity) {
        this.stockID = stockID;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.category = category;
        this.Quantity = quantity;
    }

    public Stock(int stockID, String productName, String manufacturer, String category, double price, int Quantity, Date entryDate) {
        this.stockID = stockID;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.category = category;
        this.price = price;
        this.Quantity = Quantity;
        this.entryDate = entryDate;
    }

    private int stockID;
    private String productName;
    private String manufacturer;
    private String category;
    private double price;
    private int Quantity;
    private Date entryDate;

    @Override
    public String toString() {
        return String.format("|%5d|%21s|%13s|%21s|%10s|%8d|%10s|",
                stockID,
                ((productName.length() > 20) ? productName.substring(0, 19) : productName),
                ((manufacturer.length() > 13) ? manufacturer.substring(0, 12) : manufacturer),
                ((category.length() > 20) ? category.substring(0, 19) : category),
                Currency.getInstance(Locale.getDefault()).getSymbol() + price, Quantity, entryDate);
        //return "|" + stockID + "|" + productName + "|" + manufacturer + "|" + category + "|=" + price + "|" + Quantity + "|" + entryDate + "|";
    }

    public boolean addStock(Stock stock) {
        StockHandler dbHandler = StockHandler.getInstance();
        //new stock to db
        //get instance of dbHandler
        //insert new record
        return dbHandler.insertStock(stock);

    }

    public boolean updateStock(Stock stock) {
        StockHandler dbHandler = StockHandler.getInstance();
        //alter stock to db
        //get instance of dbHandler
        //update record
        return dbHandler.updateStock(stock);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public int getStockID() {
        return stockID;
    }

    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    public static void removeStock(int stockID, int qty) {
        try {
            //get current inventory
            IStock stockImp = (IStock) SingleRegistry.getInstance().getRegistry().lookup("stock");
            ArrayList<Stock> AllStock = stockImp.getStock();
            for (Stock stock : AllStock) {
                if (stock.getStockID() == stockID) {
                    StockHandler.removeStock(stockID, (stock.getQuantity() - qty));
                }
            }
            System.out.println("Stock Quantity update complete");
        } catch (RemoteException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
