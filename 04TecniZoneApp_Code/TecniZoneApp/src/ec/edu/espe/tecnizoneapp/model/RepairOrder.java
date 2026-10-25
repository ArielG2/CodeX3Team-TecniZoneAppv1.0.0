package ec.edu.espe.tecnizoneapp.model;

import java.util.Date;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class RepairOrder {
    String orderNumber;
    Client customer;
    Equipment device;
    Technician assignedTech;
    String currentStatus;
    Date estimatedDeliveryDate;
    double laborCost;
    double partsCost;
    double totalAmount;
}
