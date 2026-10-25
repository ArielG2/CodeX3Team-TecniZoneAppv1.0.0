package ec.edu.espe.tecnizoneapp.model;

import java.time.LocalDateTime;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class StockAlert {

    private String alertId;
    private Part affectedPart;
    private LocalDateTime triggerDate;
    private String alertMessage;
    private boolean isResolved;

    public StockAlert(String alertId, Part affectedPart,
            LocalDateTime triggerDate, String alertMessage,
            boolean isResolved) {
        this.alertId = alertId;
        this.affectedPart = affectedPart;
        this.triggerDate = triggerDate;
        this.alertMessage = alertMessage;
        this.isResolved = isResolved;
    }

    public void markAsResolved(SystemUser user) {
        this.isResolved = true;
        System.out.println("Stock alert resolved by: " + user);
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public Part getAffectedPart() {
        return affectedPart;
    }

    public void setAffectedPart(Part affectedPart) {
        this.affectedPart = affectedPart;
    }

    public LocalDateTime getTriggerDate() {
        return triggerDate;
    }

    public void setTriggerDate(LocalDateTime triggerDate) {
        this.triggerDate = triggerDate;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public boolean getIsResolved() {
        return isResolved;
    }

    public void setIsResolved(boolean isResolved) {
        this.isResolved = isResolved;
    }

    @Override
    public String toString() {
        return "StockAlert{" + "alertId=" + alertId
                + ", affectedPart=" + affectedPart
                + ", triggerDate=" + triggerDate
                + ", alertMessage=" + alertMessage
                + ", isResolved=" + isResolved + '}';
    }
}
