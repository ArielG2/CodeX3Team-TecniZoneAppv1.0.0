package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class WarrantyChecklist {
    String checklistId;
    Equipment relatedEquipment;
    boolean hasPhysicalDamage;
    boolean includesAccessories;
    boolean isWarrantyValid;
    
    public WarrantyChecklist(String checklistId, Equipment relatedEquipment,
            boolean hasPhysicalDamage, boolean includesAccessories,
            boolean isWarrantyValid) {
        this.checklistId = checklistId;
        this.relatedEquipment = relatedEquipment;
        this.hasPhysicalDamage = hasPhysicalDamage;
        this.includesAccessories = includesAccessories;
        this.isWarrantyValid = isWarrantyValid;
    }

    public void markPhysicalDamage(String description) {
        this.hasPhysicalDamage = true;
        System.out.println("Physical damage recorded: " + description);
    }

    public boolean validateWarrantyStatus() {
        return isWarrantyValid && !hasPhysicalDamage;
    }

    public String getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(String checklistId) {
        this.checklistId = checklistId;
    }

    public Equipment getRelatedEquipment() {
        return relatedEquipment;
    }

    public void setRelatedEquipment(Equipment relatedEquipment) {
        this.relatedEquipment = relatedEquipment;
    }

    public boolean getHasPhysicalDamage() {
        return hasPhysicalDamage;
    }

    public void setHasPhysicalDamage(boolean hasPhysicalDamage) {
        this.hasPhysicalDamage = hasPhysicalDamage;
    }

    public boolean getIncludesAccessories() {
        return includesAccessories;
    }

    public void setIncludesAccessories(boolean includesAccessories) {
        this.includesAccessories = includesAccessories;
    }

    public boolean getIsWarrantyValid() {
        return isWarrantyValid;
    }

    public void setIsWarrantyValid(boolean isWarrantyValid) {
        this.isWarrantyValid = isWarrantyValid;
    }

    @Override
    public String toString() {
        return "WarrantyChecklist{" + "checklistId=" + checklistId
                + ", relatedEquipment=" + relatedEquipment
                + ", hasPhysicalDamage=" + hasPhysicalDamage
                + ", includesAccessories=" + includesAccessories
                + ", isWarrantyValid=" + isWarrantyValid + '}';
    }
}
