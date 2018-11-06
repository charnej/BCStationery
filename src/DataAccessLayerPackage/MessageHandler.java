/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import BusinessLayerPackage.Messages;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author User
 */
public class MessageHandler {

    private static Connection con = null;
    private static PreparedStatement pst = null;
    private static Statement st = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    Date date = new Date();

    public static enum Message {
        registered, accepted, requestComplete, inventory
    }

    public static ArrayList<Messages> getMessages(int StaffID) {
        ArrayList<Messages> messageList = new ArrayList<>();
        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "Select * from messages where StaffID = '" + StaffID + "'";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                messageList.add(new Messages(rs.getInt("MessageID"), rs.getInt("StaffID"), rs.getString("Subject"), rs.getString("Message"), rs.getDate("Date")));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messageList;
    }

    public static void InsertMessage(int staffID, Message msgType) {
        try {
            con = JavaConnectDB.ConnectDB();
            if (msgType == msgType.accepted) {
                String sql = "insert into messages (StaffID, Subject, Message, Date) values (?, ?, ?, ?)";
                pst = con.prepareStatement(sql);
                pst.setInt(1, staffID);
                pst.setString(2, "Welcome");
                pst.setString(3, "Welcome to BC Stationery. You have been accepted and start sending request for stationery items.");
                pst.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                pst.addBatch();
            }else if (msgType == msgType.registered) {
                String sql = "insert into messages (StaffID, Subject, Message, Date) values (?, ?, ?, ?)";
                pst = con.prepareStatement(sql);
                pst.setInt(1, staffID);
                pst.setString(2, "Registration Received");
                pst.setString(3, "Your registration has been received by admin. Once you're accepted, we'll let you know.");
                pst.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                pst.addBatch();
            }else if (msgType == msgType.requestComplete) {
                String sql = "insert into messages (StaffID, Subject, Message, Date) values (?, ?, ?, ?)";
                pst = con.prepareStatement(sql);
                pst.setInt(1, staffID);
                pst.setString(2, "Request Complete");
                pst.setString(3, "Your request has been complete.");
                pst.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                pst.addBatch();
            }else if (msgType == msgType.inventory) {
                String sql = "insert into messages (StaffID, Subject, Message, Date) values (?, ?, ?, ?)";
                pst = con.prepareStatement(sql);
                pst.setInt(1, staffID);
                pst.setString(2, "Out of stock");
                pst.setString(3, "An item you have requested is out of stock. We will let you know when your request is complete.");
                pst.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                pst.addBatch();
            }
            pst.executeBatch();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void DeleteMessage(int messageID) {

        try {
            con = JavaConnectDB.ConnectDB();
            String sql = "delete from messages where MessageID = '" + messageID + "'";
            st = con.createStatement();
            st.executeUpdate(sql);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
