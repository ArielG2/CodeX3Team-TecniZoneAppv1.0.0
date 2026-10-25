/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class Client {
    private String clientId;
    private String fullName; 
    private String phoneNumber;
    private String companyName;

    @Override
    public String toString() {
        return "Client{" + "clientId=" + getClientId() + ", fullName=" + getFullName() + ", phoneNumber=" + getPhoneNumber() + ", companyName=" + getCompanyName() + '}';
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public Client(String clientId, String fullName, String phoneNumber, String companyName) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
    }
    
    public void updateContactInfo(String newPhone) {
        this.phoneNumber = newPhone;
    }
    
    public Equipment registerEquipment(String deviceDetails) {
        // Se puede registrar un equipo asociado a este cliente con datos por defecto
        return new Equipment("SN-DEFAULT", deviceDetails, "Desconocida", "Desconocido", "Sin fallas reportadas", this);
    }
    
}
