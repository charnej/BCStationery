/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLayerPackage.IStaff;
import BusinessLayerPackage.Staff;
import DataAccessLayerPackage.CampusHandler;
import DataAccessLayerPackage.DepartmentHandler;
import DataAccessLayerPackage.StaffHandler;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Tyrone
 */
public class imp_Staff extends UnicastRemoteObject implements IStaff {

    public imp_Staff() throws RemoteException {
    }

    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    // Static as this functionality is not bound to each object, but to the class
    // Get all the required Staff members data ..
    @Override
    public ArrayList<Staff> getStaff(StaffHandler.staffType staffType) {
        ArrayList<Staff> allStaff = new ArrayList<Staff>();
        try {
            pst = StaffHandler.getStaff(staffType);
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
                        rs.getInt("Accepted"),
                        rs.getInt("LoggedIn")));
            }
            return allStaff;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    // Get all the required Staff member data ..
    @Override
    public Staff getStaffMember(String username) {
        Staff staff = null;
        try {
            pst = StaffHandler.getStaffMember(username);
            rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                staff = new Staff(rs.getInt("StaffID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getString("Cellphone"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("DepartmentName"),
                        rs.getString("CampusName"),
                        rs.getInt("Accepted"),
                        rs.getInt("LoggedIn"));
            }
            return staff;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

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

    @Override
    public void updateStaffLoggedIn(String userName, int loggedIn) {
        StaffHandler.updateStaffLoggedIN(userName, loggedIn);
    }

}
