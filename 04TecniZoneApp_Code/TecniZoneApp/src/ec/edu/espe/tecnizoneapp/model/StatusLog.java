package ec.edu.espe.tecnizoneapp.model;

import java.time.LocalDateTime;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class StatusLog {

    private String logId;
    private RepairOrder order;
    private String statusChangedTo;
    private LocalDateTime changeTimestamp;
    private SystemUser changedByUser;

    public StatusLog(String logId, RepairOrder order,
            String statusChangedTo, LocalDateTime changeTimestamp,
            SystemUser changedByUser) {
        this.logId = logId;
        this.order = order;
        this.statusChangedTo = statusChangedTo;
        this.changeTimestamp = changeTimestamp;
        this.changedByUser = changedByUser;
    }

    public void recordChangeTimestamp() {
        this.changeTimestamp = LocalDateTime.now();
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public RepairOrder getOrder() {
        return order;
    }

    public void setOrder(RepairOrder order) {
        this.order = order;
    }

    public String getStatusChangedTo() {
        return statusChangedTo;
    }

    public void setStatusChangedTo(String statusChangedTo) {
        this.statusChangedTo = statusChangedTo;
    }

    public LocalDateTime getChangeTimestamp() {
        return changeTimestamp;
    }

    public void setChangeTimestamp(LocalDateTime changeTimestamp) {
        this.changeTimestamp = changeTimestamp;
    }

    public SystemUser getChangedByUser() {
        return changedByUser;
    }

    public void setChangedByUser(SystemUser changedByUser) {
        this.changedByUser = changedByUser;
    }

    @Override
    public String toString() {
        return "StatusLog{" + "logId=" + logId
                + ", order=" + order
                + ", statusChangedTo=" + statusChangedTo
                + ", changeTimestamp=" + changeTimestamp
                + ", changedByUser=" + changedByUser + '}';
    }
}
