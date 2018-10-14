
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import DataAccessLayerPackage.StaffHandler;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tyrone
 */
public class Staff {

    public Staff() {
        staffID = 0;
    }

    // this constructor is used to show information to users
    public Staff(int staffID, String firstName, String lastName, String email, String cellphone, String username, String password, String departmentName, String campusName, int accepted) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.username = username;
        this.password = password;
        this.departmentName = departmentName;
        this.campusName = campusName;
        this.accepted = accepted;
    }
    
    // this constructor is used to insert, update and delete information from staff table
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
    private String departmentName;
    private String campusName;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
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
    
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    // Static as this functionality is not bound to each object, but to the class
    // Get all the Staff members data ..
    public static ArrayList<Staff> getStaff() {
        ArrayList<Staff> allStaff = new ArrayList<Staff>();
        try {
            pst = StaffHandler.getStaff();
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                allStaff.add(new Staff(rs.getInt("StaffID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Cellphone"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("DepartmentName"),
                        rs.getString("CampusName"),
                        rs.getInt("Accepted")));
            }
            return allStaff;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    // Get all the Pending Staff member data ..
    public static ArrayList<Staff> getPendingStaff() {
        ArrayList<Staff> pendingStaff = new ArrayList<Staff>();
        try {
            pst = StaffHandler.getPendingStaff();
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                pendingStaff.add(new Staff(rs.getInt("StaffID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Cellphone"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("DepartmentName"),
                        rs.getString("CampusName"),
                        rs.getInt("Accepted")));
            }
            return pendingStaff;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    //accept a pending staff member
    public static void acceptPendingStaff(String name, int id) {
        StaffHandler.acceptPendingStaff(name, id);
    }
}
