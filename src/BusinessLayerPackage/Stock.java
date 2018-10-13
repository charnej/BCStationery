/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import java.sql.Date;

/**
 *
 * @author Jozehan
 */
public class Stock {
    private final int stockID;
    private String productName;
    private String manufacturer;
    private Category category;
    private double price;
    private int Quantity;
    private Date entryDate;
    
    
    public Stock() {
        this.stockID = 0;
    }
    
}
