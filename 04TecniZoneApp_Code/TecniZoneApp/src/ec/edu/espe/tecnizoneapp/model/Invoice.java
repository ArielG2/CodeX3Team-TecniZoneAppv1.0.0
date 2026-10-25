package ec.edu.espe.tecnizoneapp.model;

import java.util.Date;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Invoice {
    String invoiceNumber;
    RepairOrder repairOrder;
    Date issueDate;
    double finalTotal;
    String paymentMethod;
}
