/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Tyrone
 */
public class JavaConnectDB {
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/bcstationery?zeroDateTimeBehavior=convertToNull";
            Connection con =(Connection) DriverManager.getConnection(url,"root","");
            return con;
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
