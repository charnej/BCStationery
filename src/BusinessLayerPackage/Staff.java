
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import DataAccessLayerPackage.StaffHandler;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tyrone
 */
public class Staff {

    public Staff() {
        staffID=0;
    }

    
    public Staff(int staffID, String firstName, String lastName, String email, String cellphone, String username, String password, int department, int campusLocation, int accepted) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.username = username;
        this.password = password;
        this.department = department;
        this.campusLocation = campusLocation;
        this.accepted = accepted;
    }

    private final int staffID;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private String username;
    private String password;
    private int department;
    private int campusLocation;
    private int accepted;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getStaffID() {
        return staffID;
    }
    //Dont need to set ID 
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getCampusLocation() {
        return campusLocation;
    }

    public void setCampusLocation(int campusLocation) {
        this.campusLocation = campusLocation;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

   
    @Override
    public String toString() {
        return "Staff{" + "staffID=" + staffID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", cellphone=" + cellphone + ", username=" + username + ", department=" + department + ", campusLocation=" + campusLocation + ", accepted=" + accepted + '}';
    }
    public ArrayList<Staff> getStaff(){
        ArrayList<Staff> allStaff = new ArrayList<Staff>();
        StaffHandler inst =StaffHandler.getInstance();
        ResultSet staffUsers =inst.getUser();
        try {
            while (staffUsers.next()) {
                allStaff.add(new Staff(staffUsers.getInt("StaffID"),
                                        staffUsers.getString("FirstName"),
                                        staffUsers.getString("LastName"),
                                        staffUsers.getString("Email"),
                                        staffUsers.getString("Cellphone"),
                                        staffUsers.getString("Username"),
                                        staffUsers.getString("Password"),
                                        staffUsers.getInt("Department"),
                                        staffUsers.getInt("CampusLocation"),
                                        staffUsers.getInt("Accepted")));
            }
            return allStaff;
        } catch (SQLException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

