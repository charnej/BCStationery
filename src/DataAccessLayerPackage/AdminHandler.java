/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;
//T
import BusinessLayerPackage.Admin;
import BusinessLayerPackage.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jozehan
 */
public class AdminHandler {
   
    private static AdminHandler instance = new AdminHandler();
    public static AdminHandler getInstance(){
        return instance;
    }
    private AdminHandler() {}

    //get users from db
    //hold users in resultset private to compare changes
    
    public  ArrayList<Admin> getUsers(){
            ArrayList<Admin> rsUsers= new ArrayList<>();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
                Connection con =(Connection) DriverManager.getConnection(url,"root","");
                Statement st = (Statement) con.createStatement();
                String query = "SELECT * FROM admin";
                ResultSet staffUsers = st.executeQuery(query);
                while (staffUsers.next()) {
                rsUsers.add(new Admin(staffUsers.getInt(1),//("AdminID"),
                                        staffUsers.getString(2),//("FirstName"),
                                        staffUsers.getString(3),//("LastName"),
                                        staffUsers.getString(4),//("Username"),
                                        staffUsers.getString(5),//("Password")));
                                        staffUsers.getInt(6)));
            }
             con.close();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
                //Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                //Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
             return rsUsers;
    }
   
    public static void updateAdminLoggedIn(int LoggedIn, String UserName){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
            Connection con =(Connection) DriverManager.getConnection(url,"root","");
            Statement st = (Statement) con.createStatement();
            String query = "UPDATE admin SET LoggedIn = '"+LoggedIn+"' WHERE Username = '"+UserName+"'";
            st.executeUpdate(query);
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    //do update user
    //do delete user 
}
