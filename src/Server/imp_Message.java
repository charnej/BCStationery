/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import BusinessLayerPackage.IMessage;
import BusinessLayerPackage.Messages;
import DataAccessLayerPackage.MessageHandler;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public class imp_Message extends UnicastRemoteObject implements IMessage {

    public imp_Message() throws RemoteException {
    }

    @Override
    public ArrayList<Messages> getMessages(int staffID) {
        ArrayList<Messages> messageList = MessageHandler.getMessages(staffID);
        return messageList;
    }
}
