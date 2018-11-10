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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Jozehan
 */
public class catagoryHandler {

    //Catagory is used to define a simple catagory of a product
    private static catagoryHandler instance = new catagoryHandler();

    public static catagoryHandler getInstance() {
        return instance;
    }

    private catagoryHandler() {
    }

    public ArrayList<Category> getCatagories() {
        ArrayList<Category> cats = new ArrayList<Category>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `category`");
            while (rs.next()) {
                cats.add(new Category(rs.getInt("CategoryID"), rs.getString("Name")));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(catagoryHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cats;
    }

}
