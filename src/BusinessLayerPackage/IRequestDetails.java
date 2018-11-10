/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import DataAccessLayerPackage.StaffRequestHandler;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public interface IRequestDetails extends Remote {

    public ArrayList<RequestDetails> getRequestDetails(StaffRequestHandler.requestType requestType, int staffID, int requestNr) throws RemoteException;

    public ArrayList<RequestDetails> getPackageItems(int requestNr) throws RemoteException;
}
