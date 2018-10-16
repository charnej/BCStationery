/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//T
import DataAccessLayerPackage.AdminHandler;
import DataAccessLayerPackage.StaffHandler;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jozehan
 */
public class Admin {
    private final int AdminID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public int getAdminID() {
        return AdminID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Admin() {
        AdminID=0;
    }
    
    public Admin(int AdminID, String firstName, String lastName, String username, String password) {
        this.AdminID = AdminID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    public ArrayList<Admin> getAdmin(){
        ArrayList<Admin> allAdmin = new ArrayList<Admin>();
        AdminHandler inst =new AdminHandler();
        allAdmin=inst.getUsers();
        return allAdmin;
    }
    
}
