/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class Technician {
    private String technicianId;
    private String fullName;
    private String specialty;

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
    
    public Technician(String technicianId, String fullName, String specialty) {
        this.technicianId = technicianId;
        this.fullName = fullName;
        this.specialty = specialty;
    }
    
    public void updateSpecialty(String newSpecialty) {
        this.specialty = newSpecialty;
    }
    
    public void assignToOrder(Object order) {
        // Lógica para asignar el técnico a una orden de reparación
        System.out.println("Técnico " + this.fullName + " asignado a la orden.");
    }
}
