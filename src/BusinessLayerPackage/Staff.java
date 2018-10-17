
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import DataAccessLayerPackage.CampusHandler;
import DataAccessLayerPackage.DepartmentHandler;
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
public class Staff implements CampusLocation, Department {

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

    public String getPasswordEncrypt() {
        // encrypt password
        String encryption = "";
        for (int i = 0; i < password.length(); i++) {
            encryption += "*";
        }
        password = encryption;

        return password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        boolean isValid = true;
        //
        if (password.length() < 5 || password.length() > 50) {
            isValid = false;
        }
        //
        if (isValid) {
            this.password = password;
        } else {
            this.password = "error";
        }
    }

    public int getStaffID() {
        return staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        boolean isValid = true;
        //
        if (firstName.length() < 1 || firstName.length() > 50) {
            isValid = false;
        }
        //
        for (int i = 0; i < firstName.length(); i++) {
            if (!(Character.isAlphabetic(firstName.charAt(i)) || Character.isSpaceChar(firstName.charAt(i)))) {
                isValid = false;
            }
        }
        //
        if (isValid) {
            this.firstName = firstName;
        } else {
            this.firstName = "error";
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        boolean isValid = true;
        //
        if (lastName.length() < 1 || lastName.length() > 50) {
            isValid = false;
        }
        //
        for (int i = 0; i < lastName.length(); i++) {
            if (!(Character.isAlphabetic(lastName.charAt(i)) || Character.isSpaceChar(lastName.charAt(i)))) {
                isValid = false;
            }
        }
        //
        if (isValid) {
            this.lastName = lastName;
        } else {
            this.lastName = "error";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        boolean isValid = true;
        //
        if (email.length() < 5 || email.length() > 50) {
            isValid = false;
        }
        //
        int sign = 0;
        int period = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                sign++;
            } else if (email.charAt(i) == '.') {
                period++;
            }
        }
        //
        if (sign != 1) {
            isValid = false;
        }
        //
        if (period < 1) {
            isValid = false;
        }
        //
        if (isValid) {
            this.email = email;
        } else {
            this.email = "error";
        }
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        boolean isValid = true;
        //
        if (cellphone.length() != 10) {
            isValid = false;
        }
        //
        if (cellphone.length() > 0) {
            if (cellphone.charAt(0) != '0') {
                isValid = false;
            }
        }
        //
        for (int i = 0; i < cellphone.length(); i++) {
            if (!(Character.isDigit(cellphone.charAt(i)))) {
                isValid = false;
            }
        }
        //
        if (isValid) {
            this.cellphone = cellphone;
        } else {
            this.cellphone = "error";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        boolean isValid = true;
        //
        if (username.length() < 5 || username.length() > 50) {
            isValid = false;
        }
        //
        if (isValid) {
            this.username = username;
        } else {
            this.username = "error";
        }
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

    public static boolean isUniqueUsername(String usernameInput) {
        ArrayList<Staff> allStaff = getStaff();
        //
        boolean isUnique = true;
        //
        for (Staff staff : allStaff) {
            if (staff.username == usernameInput) {
                isUnique = false;
            }
        }
        //
        return isUnique;
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

    // interface implementation
    @Override
    public ArrayList<String> getCampusData() {
        ArrayList<String> campusList = new ArrayList<String>();
        try {
            pst = CampusHandler.getCampusData();
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                campusList.add(rs.getInt("CampusID") + ". " + rs.getString("CampusName"));
            }
            return campusList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<String> getDepartmentData() {
        ArrayList<String> campusList = new ArrayList<String>();
        try {
            pst = DepartmentHandler.getDepartmentData();
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                campusList.add(rs.getInt("DepartmentID") + ". " + rs.getString("DepartmentName"));
            }
            return campusList;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    // insert staff
    public static void insertStaff(Staff s) {
        StaffHandler.insertStaff(s.firstName, s.lastName, s.email, s.cellphone, s.username, s.password, s.department, s.campusLocation);
    }

}
