/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import DataAccessLayerPackage.StaffRequestHandler;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public interface IStaffRequest extends Remote {

    public ArrayList<StaffRequest> getStaffRequests(StaffRequestHandler.requestType requestType, int staffID) throws RemoteException;
}
