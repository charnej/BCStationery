/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLayerPackage.Admin;
import BusinessLayerPackage.IAdmin;
import DataAccessLayerPackage.AdminHandler;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public class imp_Admin extends UnicastRemoteObject implements IAdmin {

    public imp_Admin() throws RemoteException {
    }

    @Override
    public ArrayList<Admin> getAdmin() {
        ArrayList<Admin> allAdmin = new ArrayList<Admin>();
        AdminHandler inst = AdminHandler.getInstance();
        allAdmin = inst.getUsers();
        return allAdmin;
    }

    @Override
    public void UpdateAdminLoggedIn(String userName, int loggedIn) {
        AdminHandler.updateAdminLoggedIn(loggedIn, userName);
    }
}
