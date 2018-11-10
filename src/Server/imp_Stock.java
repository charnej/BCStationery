/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLayerPackage.IStock;
import BusinessLayerPackage.Stock;
import DataAccessLayerPackage.StockHandler;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tyrone
 */
public class imp_Stock extends UnicastRemoteObject implements IStock {

    public imp_Stock() throws RemoteException {
    }

    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    @Override
    public ArrayList<Stock> getStock() {
        //populate list with stock from db;
        StockHandler dbHandler = StockHandler.getInstance();
        return dbHandler.getStock();

    }

    // Get all the required Stock Item data ..
    @Override
    public Stock getStockItem(int stockID) {
        Stock stock = null;
        try {
            pst = StockHandler.getStockItem(stockID);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                stock = new Stock(rs.getInt("StockID"),
                        rs.getString("ProductName"),
                        rs.getString("Manufacturer"),
                        rs.getString("Name"));
            }
            return stock;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    // Get all the required Stock filtered Item data ..
    @Override
    public ArrayList<Stock> getStockByCategory(String categoryName) {
        ArrayList<Stock> stock = null;
        try {
            pst = StockHandler.getStockByCategory(categoryName);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                stock.add(new Stock(rs.getInt("StockID"),
                        rs.getString("ProductName"),
                        rs.getString("Manufacturer"),
                        rs.getString("Name"),
                        rs.getInt("Quantity")));
            }
            //
            return stock;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
}
