package ec.edu.espe.tecnizoneapp.model;

import java.time.LocalDateTime;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Invoice {

    private String invoiceNumber;
    private RepairOrder repairOrder;
    private LocalDateTime issueDate;
    private double finalTotal;
    private String paymentMethod;

    public Invoice(String invoiceNumber, RepairOrder repairOrder,
            LocalDateTime issueDate, double finalTotal,
            String paymentMethod) {
        this.invoiceNumber = invoiceNumber;
        this.repairOrder = repairOrder;
        this.issueDate = issueDate;
        this.finalTotal = finalTotal;
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(String paymentMethod) {
        if (paymentMethod == null || paymentMethod.trim().isEmpty()
                || paymentMethod.equalsIgnoreCase("Pending")) {
            throw new IllegalArgumentException(
                    "A valid payment method is required.");
        }

        this.paymentMethod = paymentMethod;
        this.issueDate = LocalDateTime.now();
    }

    public void printReceipt() {
        System.out.println("========== INVOICE ==========");
        System.out.println("Invoice number: " + invoiceNumber);
        System.out.println("Issue date: " + issueDate);
        System.out.println("Repair order: " + repairOrder);
        System.out.println("Total amount: $" + finalTotal);
        System.out.println("Payment method: " + paymentMethod);
        System.out.println("=============================");
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public RepairOrder getRepairOrder() {
        return repairOrder;
    }

    public void setRepairOrder(RepairOrder repairOrder) {
        this.repairOrder = repairOrder;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceNumber=" + invoiceNumber
                + ", repairOrder=" + repairOrder
                + ", issueDate=" + issueDate
                + ", finalTotal=" + finalTotal
                + ", paymentMethod=" + paymentMethod + '}';
    }
}
