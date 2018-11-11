/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLayerPackage.Category;
import BusinessLayerPackage.ICategory;
import DataAccessLayerPackage.catagoryHandler;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public class imp_Category extends UnicastRemoteObject implements ICategory {

    public imp_Category() throws RemoteException {
    }

    @Override
    public ArrayList<Category> getCategories() {
        //get categories, populate them and send them. 
        catagoryHandler dbHandler = catagoryHandler.getInstance();
        return dbHandler.getCatagories();
    }
}
