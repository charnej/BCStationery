/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jozehan
 */
public class StockHandler {
       private static StockHandler instance = new StockHandler();
    private StockHandler() {}
    public static StockHandler getInstance(){
        return instance;
    }
    //get users from db
    //hold users in resultset private to compare changes
    private  ResultSet rsStock;
    public  ResultSet getUser(){
        if (rsStock==null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
                Connection con =(Connection) DriverManager.getConnection(url,"root","");
                Statement st = (Statement) con.createStatement();
                String query = "SELECT * FROM tblStaff";
                rsStock = st.executeQuery(query);
                con.close();
                return rsStock;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else return rsStock;
        return null;
    }
    //do update user
    //do delete user
}
