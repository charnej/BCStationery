/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;
//T
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
public class AdminHandler {
   
    private static AdminHandler instance = new AdminHandler();
    private AdminHandler() {}
    public static AdminHandler getInstance(){
        return instance;
    }
    //get users from db
    //hold users in resultset private to compare changes
    private  ResultSet rsUsers;
    public  ResultSet getUsers(){
        if (rsUsers==null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/bcstationary?";
                Connection con =(Connection) DriverManager.getConnection(url,"root","");
                Statement st = (Statement) con.createStatement();
                String query = "SELECT * FROM admin";
                ResultSet rs = st.executeQuery(query);
                con.close();
                return rs;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else return rsUsers;
        return null;
    }
    //do update user
    //do delete user 
}