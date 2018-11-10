
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import DataAccessLayerPackage.CampusHandler;
import DataAccessLayerPackage.DepartmentHandler;
import DataAccessLayerPackage.StaffHandler;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tyrone
 */
public class Staff extends User implements Serializable {

    public Staff() {

    }

    // this constructor is used to show information to users
    public Staff(int userID, String firstName, String lastName, String email, String cellphone, String username, String password, String departmentName, String campusName, int accepted, int loggedIn) {
        super(userID, firstName, lastName, username, password);
        this.email = email;
        this.cellphone = cellphone;
        this.departmentName = departmentName;
        this.campusName = campusName;
        this.accepted = accepted;
        this.loggedIn = loggedIn;
    }

    // this constructor is used to insert, update and delete information from staff table
    public Staff(int userID, String firstName, String lastName, String email, String cellphone, String username, String password, int department, int campusLocation, int accepted) {
        super(userID, firstName, lastName, username, password);
        this.email = email;
        this.cellphone = cellphone;
        this.department = department;
        this.campusLocation = campusLocation;
        this.accepted = accepted;
    }

    private String email;
    private String cellphone;
    private String departmentName;
    private String campusName;
    private int department;
    private int campusLocation;
    private int accepted;
    private int loggedIn;

    public int getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(int loggedIn) {
        this.loggedIn = loggedIn;
    }

    public int getUserID() {
        return userID;
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
        return "Staff{" + "staffID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", cellphone=" + cellphone + ", username=" + username + ", department=" + department + ", campusLocation=" + campusLocation + ", accepted=" + accepted + '}';
    }

    public static boolean isUniqueUsername(String usernameInput) {
        //
        boolean isUnique = true;
        try {
            IStaff staffImp = (IStaff) SingleRegistry.getInstance().getRegistry().lookup("staff");
            ArrayList<Staff> allStaff = staffImp.getStaff(StaffHandler.staffType.All);
            //
            for (Staff staff : allStaff) {
                if (staff.getUsername().equals(usernameInput)) {
                    isUnique = false;
                }
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
        //
        return isUnique;
    }

    //accept a pending staff member
    public static void acceptPendingStaff(String name, int id) {
        StaffHandler.acceptPendingStaff(name, id);
    }

    // insert staff
    public static void insertStaff(Staff s) {
        StaffHandler.insertStaff(s.firstName, s.lastName, s.email, s.cellphone, s.username, s.password, s.department, s.campusLocation);
    }

    // update staff
    public static void updateStaff(Staff s) {
        StaffHandler.updateStaff(s.userID, s.firstName, s.lastName, s.email, s.cellphone, s.username, s.password, s.department, s.campusLocation);
    }

}
