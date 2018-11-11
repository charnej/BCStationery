/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Tyrone
 */
public class SingleRegistry {

    private static SingleRegistry instance = new SingleRegistry();

    private SingleRegistry() {
    }

    public static SingleRegistry getInstance() {
        return instance;
    }

    public Registry getRegistry() throws RemoteException {
        return LocateRegistry.getRegistry("localhost", 1099);
    }

}
