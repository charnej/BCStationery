/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//T
import java.awt.List;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Jozehan
 */
public class Stock {

    public Stock(int stockID, String productName, String manufacturer, Category category, double price, int Quantity, Date entryDate) {
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
    private Category category;
    private double price;
    private int Quantity;
    private Date entryDate;
    public ArrayList<Stock> getStock(){
       //populate list with stock from db;
       ArrayList<Stock> dummyData = new ArrayList<>();
       dummyData.add(new Stock(1, "Prod1", "man1", (new Category(1)), 150, 200, Date.valueOf("2018-10-13")));
       dummyData.add(new Stock(2, "Prod2", "man2", (new Category(2)), 200, 50, Date.valueOf("2018-10-13")));
       dummyData.add(new Stock(3, "Prod3", "man3", (new Category(3)), 250, 1000, Date.valueOf("2018-10-13")));
       dummyData.add(new Stock(4, "Prod4", "man4", (new Category(4)), 300, 15, Date.valueOf("2018-10-13")));
      return dummyData;
    }
    public boolean addStock()
    {
        //new stock to db
        //get instance of dbHandler
        //insert new record
        if (true) {
           return true; 
        }else{
            return false;
        }
    }
    public boolean updateStock()
    {
        //alter stock to db
        //get instance of dbHandler
        //update record
        if (true) {
           return true; 
        }else{
           return false;
        }
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
