/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import DataAccessLayerPackage.MessageHandler;
import DataAccessLayerPackage.StaffHandler;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author User
 */
public class Messages implements Serializable {

    int messageID;
    int staffID;
    String subject;
    String message;
    Date date;

    public Messages(int messageID, int staffID, String subject, String message, Date date) {
        this.messageID = messageID;
        this.staffID = staffID;
        this.subject = subject;
        this.message = message;
        this.date = date;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static void DeleteStaffMessages(int messageID) {
        MessageHandler.DeleteMessage(messageID);
    }

//     public static void InsertStaffMessages(int staffID, String subject, String message){
//        MessageHandler.InsertMessage(staffID, subject, message);
//    }
    public static void InsertStaffMessages(MessageHandler.Message msgTypes, String username) throws RemoteException, NotBoundException {
        IStaff staffImp = (IStaff) SingleRegistry.getInstance().getRegistry().lookup("staff");
        ArrayList<Staff> staffList = staffImp.getStaff(StaffHandler.staffType.All);
        int staffID = 0;
        for (Staff staff : staffList) {
            if (staff.username.equals(username)) {
                staffID = staff.getUserID();
            }

        }
        MessageHandler.InsertMessage(staffID, msgTypes);
    }

}
