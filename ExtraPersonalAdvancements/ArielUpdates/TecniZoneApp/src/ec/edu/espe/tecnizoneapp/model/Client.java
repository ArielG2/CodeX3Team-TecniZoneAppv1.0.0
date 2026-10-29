package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Client {
    
    private String clientId;
    private String fullName;
    private String phoneNumber;

    public Client(String clientId, String fullName, String phoneNumber) {
        this.clientId = clientId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + getClientId() + ", fullName=" + getFullName() + ", phoneNumber=" + getPhoneNumber() + '}';
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
    
    public void updateContactInfo(String newPhone){
        this.phoneNumber = newPhone;
    }
    
    public Equipment registerEquipment(String deviceDetails){
        String serialNumber = "SN-" + System.currentTimeMillis();
        
        String deviceType = deviceDetails;
        String brand = "Generica";
        String model = "Estandar";
        String reportedFaults = "Ninguna";
        
        Equipment newEquipment = new Equipment(serialNumber, deviceType, brand, model, reportedFaults, this);
        
        return newEquipment;
    }
}
