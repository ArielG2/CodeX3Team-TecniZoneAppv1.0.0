package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class WarrantyChecklist {
    
    private String checklistId;
    private Equipment relatedEquipment;
    private boolean hasPhysicalDamage;
    private boolean includesAccessories;
    private boolean isWarrantyValid;

    public WarrantyChecklist(String checklistId, Equipment relatedEquipment, boolean hasPhysicalDamage, boolean includesAccessories, boolean isWarrantyValid) {
        this.checklistId = checklistId;
        this.relatedEquipment = relatedEquipment;
        this.hasPhysicalDamage = hasPhysicalDamage;
        this.includesAccessories = includesAccessories;
        this.isWarrantyValid = isWarrantyValid;
    }

    @Override
    public String toString() {
        return "WarrantyChecklist{" + "checklistId=" + getChecklistId() + ", relatedEquipment=" + getRelatedEquipment() + ", hasPhysicalDamage=" + isHasPhysicalDamage() + ", includesAccessories=" + isIncludesAccessories() + ", isWarrantyValid=" + isIsWarrantyValid() + '}';
    }

    /**
     * @return the checklistId
     */
    public String getChecklistId() {
        return checklistId;
    }

    /**
     * @param checklistId the checklistId to set
     */
    public void setChecklistId(String checklistId) {
        this.checklistId = checklistId;
    }

    /**
     * @return the relatedEquipment
     */
    public Equipment getRelatedEquipment() {
        return relatedEquipment;
    }

    /**
     * @param relatedEquipment the relatedEquipment to set
     */
    public void setRelatedEquipment(Equipment relatedEquipment) {
        this.relatedEquipment = relatedEquipment;
    }

    /**
     * @return the hasPhysicalDamage
     */
    public boolean isHasPhysicalDamage() {
        return hasPhysicalDamage;
    }

    /**
     * @param hasPhysicalDamage the hasPhysicalDamage to set
     */
    public void setHasPhysicalDamage(boolean hasPhysicalDamage) {
        this.hasPhysicalDamage = hasPhysicalDamage;
    }

    /**
     * @return the includesAccessories
     */
    public boolean isIncludesAccessories() {
        return includesAccessories;
    }

    /**
     * @param includesAccessories the includesAccessories to set
     */
    public void setIncludesAccessories(boolean includesAccessories) {
        this.includesAccessories = includesAccessories;
    }

    /**
     * @return the isWarrantyValid
     */
    public boolean isIsWarrantyValid() {
        return isWarrantyValid;
    }

    /**
     * @param isWarrantyValid the isWarrantyValid to set
     */
    public void setIsWarrantyValid(boolean isWarrantyValid) {
        this.isWarrantyValid = isWarrantyValid;
    }
    
    public void markPhysicalDamage(String description){
        this.hasPhysicalDamage = true;
        if (this.relatedEquipment != null){
            this.relatedEquipment.updateReportFault(description);
        }
    }
    
    public boolean validateWarrantyStatus(){
        this.isWarrantyValid = !this.hasPhysicalDamage;
        return this.isWarrantyValid;
    }
}
