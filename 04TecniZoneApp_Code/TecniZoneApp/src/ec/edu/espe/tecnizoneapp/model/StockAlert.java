package ec.edu.espe.tecnizoneapp.model;

import java.util.Date;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class StockAlert {
    String alertId;
    Part affectedPart;
    Date triggerDate;
    String alertMessage;
    boolean isResolved;
}
