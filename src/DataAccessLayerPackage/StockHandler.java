package DataAccessLayerPackage;

import BusinessLayerPackage.Category;
import BusinessLayerPackage.ICategory;
import BusinessLayerPackage.SingleRegistry;
import BusinessLayerPackage.Stock;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class StockHandler {

    private static StockHandler instance = new StockHandler();

    public static StockHandler getInstance() {
        return instance;
    }

    private StockHandler() {
    }

    //get users from db
    //hold users in resultset private to compare changes
    public ArrayList<Stock> getStock() {
        ArrayList<Stock> lsStock = new ArrayList<Stock>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            Statement st = (Statement) con.createStatement();
            String query
                    = "SELECT StockID,ProductName,Manufacturer,category.Name,Price,Quantity,EntryDate FROM Stock INNER JOIN category ON category.CategoryID = Stock.Category ";//WHERE StockID=1
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

    public static void removeStock(int stockID, int qty) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "UPDATE `stock` "
                    + "SET `Quantity` = ? WHERE `stock`.`StockID` = ?";
            //
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, qty);
            pst.setInt(2, stockID);
            pst.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }
    // Public variables
    private static Connection con = null;
    private static PreparedStatement pst = null;
    private static Statement st = null;

    //get Stock Item from db
    public static PreparedStatement getStockItem(int stockID) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "SELECT * FROM stock "
                    + "INNER JOIN category ON category.CategoryID = stock.Category "
                    + "WHERE StockID = ?";
            //
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, stockID);
            //
            return pst;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //
        return pst;
    }

    //used to filter by Category
    public static PreparedStatement getStockByCategory(String categoryName) {
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "SELECT StockID, ProductName, Manufacturer, category.Name, Quantity "
                    + "FROM Stock "
                    + "INNER JOIN category ON category.CategoryID = Stock.Category "
                    + "WHERE category.Name LIKE '%" + categoryName + "%'";
            //
            pst = (PreparedStatement) con.prepareStatement(sql);
            //
            return pst;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        //
        return pst;
    }

    //do insert Stock
    public boolean insertStock(Stock stock) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            String sql = "INSERT INTO `stock`( `ProductName`, `Manufacturer`, `Category`, `Price`, `Quantity`, `EntryDate`) "
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stock.getProductName());
            ps.setString(2, stock.getManufacturer());
            //
            ICategory categoryImp = (ICategory) SingleRegistry.getInstance().getRegistry().lookup("category");
            ArrayList<Category> cats = categoryImp.getCategories();
            int catChosen = 0;
            for (Category cat : cats) {
                if (cat.getName().equals(stock.getCategory())) {
                    catChosen = cat.getCategoryID();
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
        } catch (RemoteException ex) {
            Logger.getLogger(StockHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(StockHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    //do update Stock
    public boolean updateStock(Stock stock) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            String sql = "UPDATE `stock` "
                    + "SET`ProductName`= ?,`Manufacturer`= ? ,"
                    + "`Category`=?,`Price`=?,`Quantity`=?,"
                    + "`EntryDate`=? WHERE  `StockID`=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stock.getProductName());
            ps.setString(2, stock.getManufacturer());
            //
            ICategory categoryImp = (ICategory) SingleRegistry.getInstance().getRegistry().lookup("category");
            ArrayList<Category> cats = categoryImp.getCategories();
            int catChosen = 0;
            for (Category cat : cats) {
                if (cat.getName().equals(stock.getCategory())) {
                    catChosen = cat.getCategoryID();
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
        } catch (RemoteException ex) {
            Logger.getLogger(StockHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(StockHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    //do delete Stock
}
