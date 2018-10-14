/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;

import BusinessLayerPackage.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Jozehan
 */
public class catagoryHandler {
    //Catagory is used to define a simple catagory of a product
    //first the singleton pattern
    private static catagoryHandler instance = new catagoryHandler();
    private catagoryHandler() {}
    public static catagoryHandler getInstance(){
        return instance;
    }
    private static ResultSet categories;
    public  ResultSet getCatagories() throws SQLException{
//        if (catagories==null) {
//            
//        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/bcstationary?";
            Connection con = DriverManager.getConnection(url,"root","");
            Statement st = con.createStatement();
            String query = "Select CategoryID,Name,Description FROM category";
            categories =st.executeQuery(query);
            
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(catagoryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
      return categories;  
    }
    
}
