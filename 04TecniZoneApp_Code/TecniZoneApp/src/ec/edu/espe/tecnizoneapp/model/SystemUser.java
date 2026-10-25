/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class SystemUser {
    private String username;
    private String password;
    private String userRole;

    @Override
    public String toString() {
        return "SystemUser{" + "username=" + getUsername() + ", password=" + getPassword() + ", userRole=" + getUserRole() + '}';
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    
    public SystemUser(String username, String password, String userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
    
    public boolean login(String passwordEntered) {
        return this.password.equals(passwordEntered);
    }
    
    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }
    
    
}
