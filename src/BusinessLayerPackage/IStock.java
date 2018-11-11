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
public interface IStock extends Remote {

    public ArrayList<Stock> getStock() throws RemoteException;

    public Stock getStockItem(int stockID) throws RemoteException;

    public ArrayList<Stock> getStockByCategory(String categoryName) throws RemoteException;
}
