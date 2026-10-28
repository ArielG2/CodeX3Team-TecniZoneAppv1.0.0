package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class StockAlert {

    private String alertId;
    private Part affectedPart;
    private String triggerDate;
    private String alertMessage;
    private boolean isResolved;

    public StockAlert(String alertId, Part affectedPart, String triggerDate, String alertMessage, boolean isResolved) {
        this.alertId = alertId;
        this.affectedPart = affectedPart;
        this.triggerDate = triggerDate;
        this.alertMessage = alertMessage;
        this.isResolved = isResolved;
    }

    @Override
    public String toString() {
        return "StockAlert{" + "alertId=" + getAlertId() + ", affectedPart=" + getAffectedPart() + ", triggerDate=" + getTriggerDate() + ", alertMessage=" + getAlertMessage() + ", isResolved=" + isIsResolved() + '}';
    }

    /**
     * @return the alertId
     */
    public String getAlertId() {
        return alertId;
    }

    /**
     * @param alertId the alertId to set
     */
    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    /**
     * @return the affectedPart
     */
    public Part getAffectedPart() {
        return affectedPart;
    }

    /**
     * @param affectedPart the affectedPart to set
     */
    public void setAffectedPart(Part affectedPart) {
        this.affectedPart = affectedPart;
    }

    /**
     * @return the triggerDate
     */
    public String getTriggerDate() {
        return triggerDate;
    }

    /**
     * @param triggerDate the triggerDate to set
     */
    public void setTriggerDate(String triggerDate) {
        this.triggerDate = triggerDate;
    }

    /**
     * @return the alertMessage
     */
    public String getAlertMessage() {
        return alertMessage;
    }

    /**
     * @param alertMessage the alertMessage to set
     */
    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    /**
     * @return the isResolved
     */
    public boolean isIsResolved() {
        return isResolved;
    }

    /**
     * @param isResolved the isResolved to set
     */
    public void setIsResolved(boolean isResolved) {
        this.isResolved = isResolved;
    }

    public void markAsResolved(SystemUser user) {
        this.isResolved = true;
        System.out.println("Stock alert resolved by: " + user);
    }
}