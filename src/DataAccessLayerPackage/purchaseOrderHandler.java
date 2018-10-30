/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;

import BusinessLayerPackage.purchaseOrder;
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

/**
 *
 * @author Jozehan
 */
public class purchaseOrderHandler {

    public ArrayList<purchaseOrder> getPurchaseOrders() {
        ArrayList<purchaseOrder> pOrders = new ArrayList<purchaseOrder>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `purchaseOrders`");
            while (rs.next()) {
                pOrders.add(new purchaseOrder(rs.getInt("OrderNr"), rs.getInt("Quantity"), rs.getInt("StockID")));
            }
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return pOrders;
    }

    public void update(int pOrderID, int stockID, int quantity) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
            Connection con = (Connection) DriverManager.getConnection(url, "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE `purchaseorders` "
                    + "SET `StockID` = ?, `Quantity` = ? WHERE `purchaseorders`.`OrderNr` = ? ");//continue when db done
            ps.setInt(1, stockID);
            ps.setInt(2, quantity);
            ps.setInt(3, pOrderID);
            ps.executeUpdate();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(purchaseOrderHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(purchaseOrderHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
