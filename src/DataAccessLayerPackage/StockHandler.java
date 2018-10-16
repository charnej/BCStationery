package DataAccessLayerPackage;

import BusinessLayerPackage.Stock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockHandler {
       
    public StockHandler() {}
    
    //get users from db
    //hold users in resultset private to compare changes
    
    public  ArrayList<Stock> getStock(){
            ArrayList<Stock> lsStock = new ArrayList<Stock>();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
                Connection con =(Connection) DriverManager.getConnection(url,"root","");
                Statement st = (Statement) con.createStatement();
                String query = "SELECT * FROM tblStaff";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {                    
//                    lsStock.add(new Stock(rs.getInt("StockID"),
//                            rs.getString("ProductName"), 
//                            rs.getString("Manufacturer"), 
//                            rs.getString("Category"), 0, 0, entryDate))
                }
                con.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return lsStock;
        
    }
    //do update user
    //do delete user
}
