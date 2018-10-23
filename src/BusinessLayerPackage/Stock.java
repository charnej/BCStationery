/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//T

import DataAccessLayerPackage.StockHandler;
import java.awt.List;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Jozehan
 */
public class Stock {

    public Stock(int stockID, String productName, String manufacturer, String category, double price, int Quantity, Date entryDate) {
        this.stockID = stockID;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.category = category;
        this.price = price;
        this.Quantity = Quantity;
        this.entryDate = entryDate;
    }
    
    private final int stockID;
    private String productName;
    private String manufacturer;
    private String category;
    private double price;
    private int Quantity;
    private Date entryDate;

    public ArrayList<Stock> getStock() {
        //populate list with stock from db;
        StockHandler dbHandler = new StockHandler();
        return dbHandler.getStock();

    }

    public boolean addStock(Stock stock) {
        StockHandler dbHandler = new StockHandler();
        //new stock to db
        //get instance of dbHandler
        //insert new record
        return dbHandler.insertStock(stock);

    }

    public boolean updateStock(Stock stock) {
        StockHandler dbHandler = new StockHandler();
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

    public Stock() {
        this.stockID = 0;
    }

}
