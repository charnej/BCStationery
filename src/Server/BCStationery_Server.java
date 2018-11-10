/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Tyrone
 */
public class BCStationery_Server {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry reg = LocateRegistry.createRegistry(1099);
        // implementation classes
        imp_Staff staff = new imp_Staff();
        imp_Admin admin = new imp_Admin();
        imp_Category category = new imp_Category();
        imp_Message message = new imp_Message();
        imp_RequestDetails rDetails = new imp_RequestDetails();
        imp_StaffRequest request = new imp_StaffRequest();
        imp_Stock stock = new imp_Stock();
        imp_Order order = new imp_Order();
        // bind classes
        reg.bind("staff", staff);
        reg.bind("admin", admin);
        reg.bind("category", category);
        reg.bind("message", message);
        reg.bind("rDetails", rDetails);
        reg.bind("request", request);
        reg.bind("stock", stock);
        reg.bind("order", order);
        //
        System.out.println("Server Started ...");
    }

}
