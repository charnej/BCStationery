/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLayerPackage.IOrder;
import BusinessLayerPackage.purchaseOrder;
import DataAccessLayerPackage.purchaseOrderHandler;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public class imp_Order extends UnicastRemoteObject implements IOrder {

    public imp_Order() throws RemoteException {
    }

    @Override
    public ArrayList<purchaseOrder> getPurchaseOrders() {
        purchaseOrderHandler dbHandler = new purchaseOrderHandler();
        return dbHandler.getPurchaseOrders();
    }
}
