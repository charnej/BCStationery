/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayerPackage;

/**
 *
 * @author Tyrone
 */
public class Staff {

    private int staffID;
    private String firstName;
    private String lastName;
    private String email;
    private String cellphone;
    private String username;
    private int department;
    private int campusLocation;
    private int accepted;

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getCampusLocation() {
        return campusLocation;
    }

    public void setCampusLocation(int campusLocation) {
        this.campusLocation = campusLocation;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public Staff(String firstName, String lastName, String email, String cellphone, String username, int department, int campusLocation, int accepted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.username = username;
        this.department = department;
        this.campusLocation = campusLocation;
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "Staff{" + "staffID=" + staffID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", cellphone=" + cellphone + ", username=" + username + ", department=" + department + ", campusLocation=" + campusLocation + ", accepted=" + accepted + '}';
    }
    
}
