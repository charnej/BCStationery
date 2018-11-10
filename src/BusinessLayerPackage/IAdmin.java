/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public interface IAdmin extends Remote {

    public ArrayList<Admin> getAdmin() throws RemoteException;

    public void UpdateAdminLoggedIn(String userName, int loggedIn) throws RemoteException;
}
