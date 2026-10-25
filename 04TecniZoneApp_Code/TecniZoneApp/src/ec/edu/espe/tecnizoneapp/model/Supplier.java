/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class Supplier {
    private String supplierId;
    private String companyName;
    private String contactPhone;

    @Override
    public String toString() {
        return "Supplier{" + "supplierId=" + getSupplierId() + ", companyName=" + getCompanyName() + ", contactPhone=" + getContactPhone() + '}';
    }

    /**
     * @return the supplierId
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
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

    /**
     * @return the contactPhone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * @param contactPhone the contactPhone to set
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
    
    public Supplier(String supplierId, String companyName, String contactPhone) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.contactPhone = contactPhone;
    }
    
    public void orderParts(Part partNeeded, int quantity) {
        System.out.println("Solicitando " + quantity + " unidades de la pieza: " + 
                           partNeeded.getPartName() + " al proveedor " + this.companyName);
    }
}
