/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayerPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import BusinessLayerPackage.RequestDetails;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class RequestDetailsHandler {
//wou net kyk of mens dit kan in ntext area in lees as n lys. en ja mens kan
    private static Connection con = null;
    private static PreparedStatement pst = null;
    private static Statement st = null;

    public static ArrayList<RequestDetails> getRequestDetails() {
        ArrayList<RequestDetails> requestDetails = new ArrayList<>();
        try {
            con = JavaConnectDB.ConnectDB();
            st = con.createStatement();
            String sql = "select staffrequest.RequestNr, stock.ProductName, requestdetails.Quantity,RequestDate, staff.FirstName, staff.LastName, Complete\n"
                    + "from staffrequest\n"
                    + "inner join requestdetails on staffrequest.RequestNr = requestdetails.RequestNr\n"
                    + "inner join stock on requestdetails.StockID = stock.StockID\n"
                    + "inner join staff on staffrequest.StaffID = staff.StaffID";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                requestDetails.add(new RequestDetails(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            return requestDetails;

        } catch (SQLException ex) {
            Logger.getLogger(RequestDetailsHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
