/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

import java.io.Serializable;

/**
 *
 * @author Tyrone
 */
public abstract class User implements Serializable {

    public User() {
    }

    public User(int userID, String firstName, String lastName, String username, String password) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    protected int userID;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        boolean isValid = true;
        //
        if (username.length() < 5 || username.length() > 50) {
            isValid = false;
        }
        //
        if (isValid) {
            this.username = username;
        } else {
            this.username = "error";
        }
    }

    public String getPasswordEncrypt() {
        // encrypt password
        String encryption = "";
        for (int i = 0; i < password.length(); i++) {
            encryption += "*";
        }
        password = encryption;

        return password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        boolean isValid = true;
        //
        if (password.length() < 5 || password.length() > 50) {
            isValid = false;
        }
        //
        if (isValid) {
            this.password = password;
        } else {
            this.password = "error";
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        boolean isValid = true;
        //
        if (firstName.length() < 1 || firstName.length() > 50) {
            isValid = false;
        }
        //
        for (int i = 0; i < firstName.length(); i++) {
            if (!(Character.isAlphabetic(firstName.charAt(i)) || Character.isSpaceChar(firstName.charAt(i)))) {
                isValid = false;
            }
        }
        //
        if (isValid) {
            this.firstName = firstName;
        } else {
            this.firstName = "error";
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        boolean isValid = true;
        //
        if (lastName.length() < 1 || lastName.length() > 50) {
            isValid = false;
        }
        //
        for (int i = 0; i < lastName.length(); i++) {
            if (!(Character.isAlphabetic(lastName.charAt(i)) || Character.isSpaceChar(lastName.charAt(i)))) {
                isValid = false;
            }
        }
        //
        if (isValid) {
            this.lastName = lastName;
        } else {
            this.lastName = "error";
        }
    }
}
