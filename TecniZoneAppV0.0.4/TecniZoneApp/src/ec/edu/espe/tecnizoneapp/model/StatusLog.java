package ec.edu.espe.tecnizoneapp.model;

import java.util.Date;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class StatusLog {
    private String logId;
    private RepairOrder order;
    private String statusChangedTo;
    private Date changeTimestamp;
    private SystemUser changedByUser;

    public StatusLog(String logId, RepairOrder order, String statusChangedTo, Date changeTimestamp, SystemUser changedByUser) {
        this.logId = logId;
        this.order = order;
        this.statusChangedTo = statusChangedTo;
        this.changeTimestamp = changeTimestamp;
        this.changedByUser = changedByUser;
    }
    
    public void recordChangeTimestamp() {
        this.changeTimestamp = new Date();
        System.out.println("Fecha y hora del registro actualizadas a: " + this.changeTimestamp);
    }

    public String getLogId() {
        return logId;
    }

    public RepairOrder getOrder() {
        return order;
    }

    public String getStatusChangedTo() {
        return statusChangedTo;
    }

    public Date getChangeTimestamp() {
        return changeTimestamp;
    }

    public SystemUser getChangedByUser() {
        return changedByUser;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public void setOrder(RepairOrder order) {
        this.order = order;
    }

    public void setStatusChangedTo(String statusChangedTo) {
        this.statusChangedTo = statusChangedTo;
    }

    public void setChangeTimestamp(Date changeTimestamp) {
        this.changeTimestamp = changeTimestamp;
    }

    public void setChangedByUser(SystemUser changedByUser) {
        this.changedByUser = changedByUser;
    }
    
    
}
