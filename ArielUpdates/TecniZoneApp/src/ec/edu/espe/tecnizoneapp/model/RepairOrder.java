package ec.edu.espe.tecnizoneapp.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class RepairOrder {
    private String orderNumber;
    private Client customer;
    private Equipment device;
    private Technician assignedTech;
    private String currentStatus;
    private Date estimatedDeliveryDate;
    private double laborCost;
    private double partsCost;
    private double totalAmount;
    
    public RepairOrder(String orderNumber, Client customer, Equipment device, Date estimatedDeliveryDate) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.device = device;
        this.assignedTech = null;
        this.currentStatus = "Registrada";
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.laborCost = 0.0;
        this.partsCost = 0.0;
        this.totalAmount = 0.0;
    }

    public void assignTechnician(Technician tech) {
        this.assignedTech = tech;
        System.out.println("Técnico " + tech + " asignado a la orden " + this.orderNumber);
    }

    public OrderPartDetail addPartToOrder(Part part, int quantity) {
        OrderPartDetail detail = new OrderPartDetail("DETAIL-" + this.orderNumber, this, part, quantity);
 
        this.partsCost += detail.getSubtotal();
       
        part.decreaseStock(quantity);
        
        System.out.println("Pieza " + quantity + " agregada a la orden. Subtotal: $" + detail.getSubtotal());
        return detail;
    }

    public StatusLog changeStatus(String newStatus, SystemUser user) {
        this.currentStatus = newStatus;
        System.out.println("El estado de la orden cambió a: " + newStatus);
        
        return new StatusLog("LOG-" + System.currentTimeMillis(), this, newStatus, new Date(), user);
    }

    public double calculateTotalCost() {
        this.totalAmount = this.laborCost + this.partsCost;
        return this.totalAmount;
    }

    public Invoice generateInvoice() {
        calculateTotalCost();
        System.out.println("Generando factura para la orden " + this.orderNumber + " por un total de $" + this.totalAmount);

        return new Invoice("INV-" + this.orderNumber, this, LocalDateTime.now(), this.totalAmount, "Pendiente");
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Client getCustomer() {
        return customer;
    }

    public Equipment getDevice() {
        return device;
    }

    public Technician getAssignedTech() {
        return assignedTech;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setCustomer(Client customer) {
        this.customer = customer;
    }

    public void setDevice(Equipment device) {
        this.device = device;
    }

    public void setAssignedTech(Technician assignedTech) {
        this.assignedTech = assignedTech;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
