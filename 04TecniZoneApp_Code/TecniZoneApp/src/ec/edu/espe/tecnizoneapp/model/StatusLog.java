package ec.edu.espe.tecnizoneapp.model;

import java.util.Date;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class StatusLog {
    String logId;
    RepairOrder order;
    String statusChangedTo;
    Date changeTimestamp;
    SystemUser changedByUser;
    
}
