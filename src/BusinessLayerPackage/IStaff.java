/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import DataAccessLayerPackage.StaffHandler;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public interface IStaff extends Remote {

    public ArrayList<Staff> getStaff(StaffHandler.staffType staffType) throws RemoteException;

    public Staff getStaffMember(String username) throws RemoteException;

    public ArrayList<String> getCampusData() throws RemoteException;

    public ArrayList<String> getDepartmentData() throws RemoteException;

    public void updateStaffLoggedIn(String userName, int loggedIn) throws RemoteException;

}
