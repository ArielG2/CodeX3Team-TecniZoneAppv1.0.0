package ec.edu.espe.tecnizoneapp.model;

import ec.edu.espe.tecnizoneapp.utils.JsonSerializable;
import org.json.JSONObject;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Technician implements JsonSerializable {
    
    private String technicianId;
    private String fullName;
    private String specialty;

    public Technician(String technicianId, String fullName, String specialty) {
        this.technicianId = technicianId;
        this.fullName = fullName;
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Technician{" + "technicianId=" + getTechnicianId() + ", fullName=" + getFullName() + ", specialty=" + getSpecialty() + '}';
    }

    /**
     * @return the technicianId
     */
    public String getTechnicianId() {
        return technicianId;
    }

    /**
     * @param technicianId the technicianId to set
     */
    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
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
     * @return the specialty
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * @param specialty the specialty to set
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    public void updateSpecialty(String newSpecialty){
        this.specialty = newSpecialty;
    }
    
    public void assignToOrder(RepairOrder order){
        
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("technicianId", this.technicianId);
        json.put("fullName", this.fullName);
        json.put("specialty", this.specialty);
        return json;
    }
}
