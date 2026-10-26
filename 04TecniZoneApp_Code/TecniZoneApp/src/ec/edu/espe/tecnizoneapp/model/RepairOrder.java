package ec.edu.espe.tecnizoneapp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class RepairOrder {

    private String orderNumber;
    private Client customer;
    private Equipment device;
    private Technician assignedTech;
    private String currentStatus;
    private LocalDate estimatedDeliveryDate;
    private double laborCost;
    private double partsCost;
    private double totalAmount;

    private List<OrderPartDetail> partsUsed = new ArrayList<>();

    public RepairOrder(String orderNumber, Client customer, Equipment device,
            Technician assignedTech, String currentStatus,
            LocalDate estimatedDeliveryDate, double laborCost,
            double partsCost, double totalAmount) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.device = device;
        this.assignedTech = assignedTech;
        this.currentStatus = currentStatus;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.laborCost = laborCost;
        this.partsCost = partsCost;
        this.totalAmount = totalAmount;
    }

    public void assignTechnician(Technician tech) {
        this.assignedTech = tech;
    }

    public OrderPartDetail addPartToOrder(Part part, int quantity) {
        if (part == null || quantity <= 0) {
            throw new IllegalArgumentException(
                    "Part must exist and quantity must be positive.");
        }

        OrderPartDetail detail = new OrderPartDetail(
                java.util.UUID.randomUUID().toString(),
                this, part, quantity, 0.0);

        detail.calculateSubtotal();
        partsUsed.add(detail);

        partsCost += detail.getSubtotal();
        calculateTotalCost();

        return detail;
    }

    public StatusLog changeStatus(String newStatus, SystemUser user) {
        if (newStatus == null || newStatus.trim().isEmpty()) {
            throw new IllegalArgumentException("Status cannot be empty.");
        }

        this.currentStatus = newStatus;

        StatusLog log = new StatusLog(
                java.util.UUID.randomUUID().toString(),
                this, newStatus, null, user);

        log.recordChangeTimestamp();
        return log;
    }

    public void calculateTotalCost() {
        this.totalAmount = laborCost + partsCost;
    }

    public Invoice generateInvoice() {
        calculateTotalCost();

        return new Invoice(
                java.util.UUID.randomUUID().toString(),
                this, null, totalAmount, "Pending");
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Client getCustomer() {
        return customer;
    }

    public void setCustomer(Client customer) {
        this.customer = customer;
    }

    public Equipment getDevice() {
        return device;
    }

    public void setDevice(Equipment device) {
        this.device = device;
    }

    public Technician getAssignedTech() {
        return assignedTech;
    }

    public void setAssignedTech(Technician assignedTech) {
        this.assignedTech = assignedTech;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDate estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
        calculateTotalCost();
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
        calculateTotalCost();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<OrderPartDetail> getPartsUsed() {
        return new ArrayList<>(partsUsed);
    }

    @Override
    public String toString() {
        return "RepairOrder{" + "orderNumber=" + orderNumber
                + ", customer=" + customer
                + ", device=" + device
                + ", assignedTech=" + assignedTech
                + ", currentStatus=" + currentStatus
                + ", estimatedDeliveryDate=" + estimatedDeliveryDate
                + ", laborCost=" + laborCost
                + ", partsCost=" + partsCost
                + ", totalAmount=" + totalAmount + '}';
    }
}
