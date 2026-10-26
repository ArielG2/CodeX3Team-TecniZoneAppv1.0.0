package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class ServiceCatalog {
    private String serviceCode;
    private String serviceName;
    private double fixedLaborCost;

    @Override
    public String toString() {
        return "ServiceCatalog{" + "serviceCode=" + getServiceCode() + ", serviceName=" + getServiceName() + ", fixedLaborCost=" + getFixedLaborCost() + '}';
    }

    /**
     * @return the serviceCode
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * @param serviceCode the serviceCode to set
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the fixedLaborCost
     */
    public double getFixedLaborCost() {
        return fixedLaborCost;
    }

    /**
     * @param fixedLaborCost the fixedLaborCost to set
     */
    public void setFixedLaborCost(double fixedLaborCost) {
        this.fixedLaborCost = fixedLaborCost;
    }
    
    public ServiceCatalog(String serviceCode, String serviceName, double fixedLaborCost) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.fixedLaborCost = fixedLaborCost;
    }
    
    public void updateCost(double newCost) {
        this.fixedLaborCost = newCost;
    }
    
}
