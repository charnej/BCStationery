package DataAccessLayerPackage;

import BusinessLayerPackage.Category;
import BusinessLayerPackage.Stock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
                String query = 
"SELECT StockID,ProductName,Manufacturer,category.Name,Price,Quantity,EntryDate FROM Stock INNER JOIN category ON category.CategoryID = Stock.Category ";//WHERE StockID=1
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {                    
                    lsStock.add(new Stock(rs.getInt("StockID"),
                            rs.getString("ProductName"), 
                            rs.getString("Manufacturer"), 
                            rs.getString("Name"),
                            rs.getDouble("Price"),
                            rs.getInt("Quantity"),
                            rs.getDate("EntryDate")));
                }
                
                con.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return lsStock;
        
    }
    //do insert Stock
    public boolean insertStock(Stock stock){
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
                Connection con =(Connection) DriverManager.getConnection(url,"root","");
                String sql ="INSERT INTO `stock`( `ProductName`, `Manufacturer`, `Category`, `Price`, `Quantity`, `EntryDate`) "
                        + " VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, stock.getProductName());
                ps.setString(2, stock.getManufacturer());
                ArrayList<Category> cats= new Category().getCategories();
                int catChosen=0;
                for (Category cat : cats) {
                   if(cat.getName().equals(stock.getCategory())){
                       catChosen= cat.getCategoryID();
                   }
                }
                ps.setInt(3, catChosen);
                ps.setDouble(4, stock.getPrice());
                ps.setInt(5, stock.getQuantity());
                ps.setDate(6, stock.getEntryDate());
                ps.executeUpdate();
                con.close();
                return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(StockHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    //do update Stock
    public boolean updateStock(Stock stock){
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
                Connection con =(Connection) DriverManager.getConnection(url,"root","");
                String sql ="UPDATE `stock` "
                        + "SET`ProductName`= ?,`Manufacturer`= ? ,"
                        + "`Category`=?,`Price`=?,`Quantity`=?,"
                        + "`EntryDate`=? WHERE  `StockID`=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, stock.getProductName());
                ps.setString(2, stock.getManufacturer());
                ArrayList<Category> cats= new Category().getCategories();
                int catChosen=0;
                for (Category cat : cats) {
                   if(cat.getName().equals(stock.getCategory())){
                       catChosen= cat.getCategoryID();
                   }
                }
                ps.setInt(3, catChosen);
                ps.setDouble(4, stock.getPrice());
                ps.setInt(5, stock.getQuantity());
                ps.setDate(6, stock.getEntryDate());
                ps.setInt(7, stock.getStockID());
                ps.executeUpdate();
                con.close();
                return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StockHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(StockHandler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    //do delete Stock
}
