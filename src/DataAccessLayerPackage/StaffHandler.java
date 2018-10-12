/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tyrone
 */
public class StaffHandler {

    private static StaffHandler instance = new StaffHandler();
    private StaffHandler() {}
    public static StaffHandler getInstance(){
        return instance;
    }
    public static void openConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StaffHandler.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
            String url="jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
        try { 
            Connection cn = (Connection) DriverManager.getConnection(url,"root","");
        } catch (SQLException ex) {
            Logger.getLogger(StaffHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
