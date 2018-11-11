/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;
//T

import DataAccessLayerPackage.AdminHandler;
import DataAccessLayerPackage.StaffHandler;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jozehan
 */
public class Admin extends User implements Serializable {

    int loggedIn;

    public Admin() {
    }

    public Admin(int userID, String firstName, String lastName, String username, String password, int loggedIn) {
        super(userID, firstName, lastName, username, password);
        this.loggedIn = loggedIn;
    }

    public int getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(int loggedIn) {
        this.loggedIn = loggedIn;
    }

}
