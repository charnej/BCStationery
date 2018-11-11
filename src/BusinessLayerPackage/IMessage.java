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
public interface IMessage extends Remote {

    public ArrayList<Messages> getMessages(int staffID) throws RemoteException;
}
