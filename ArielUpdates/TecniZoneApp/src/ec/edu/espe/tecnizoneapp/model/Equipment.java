package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Equipment {
    
    private String serialNumber;
    private String deviceType;
    private String brand;
    private String model;
    private String reportedFaults;
    private Client ownerClient;

    public Equipment(String serialNumber, String deviceType, String brand, String model, String reportedFaults, Client ownerClient) {
        this.serialNumber = serialNumber;
        this.deviceType = deviceType;
        this.brand = brand;
        this.model = model;
        this.reportedFaults = reportedFaults;
        this.ownerClient = ownerClient;
    }

    @Override
    public String toString() {
        return "Equipment{" + "serialNumber=" + getSerialNumber() + ", deviceType=" + getDeviceType() + ", brand=" + getBrand() + ", reportedFaults=" + getReportedFaults() + ", ownerClient=" + getOwnerClient() + '}';
    }

    /**
     * @return the serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * @return the deviceType
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * @param deviceType the deviceType to set
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /**
     * @return the reportedFaults
     */
    public String getReportedFaults() {
        return reportedFaults;
    }

    /**
     * @param reportedFaults the reportedFaults to set
     */
    public void setReportedFaults(String reportedFaults) {
        this.reportedFaults = reportedFaults;
    }

    /**
     * @return the ownerClient
     */
    public Client getOwnerClient() {
        return ownerClient;
    }

    /**
     * @param ownerClient the ownerClient to set
     */
    public void setOwnerClient(Client ownerClient) {
        this.ownerClient = ownerClient;
    }
    
    public void updateReportFault(String newFault){
        this.reportedFaults = newFault;
    }
    
    public WarrantyChecklist createWarrantyCheck(){
        String checklistId = "CHK-" + System.currentTimeMillis();
        
        boolean hasPhysicalDamage = false;
        boolean includesAccessories = true;
        boolean isWarrantyValid = true;
        
        return new WarrantyChecklist(checklistId, this, hasPhysicalDamage, includesAccessories, isWarrantyValid);
    }
}
