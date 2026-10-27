/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.tecnizone.model;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class Invoice {
    private String invoiceNumber;
    private RepairOrder repairOrder;
    private DateTime issueDate;
    private double finalTotal;
    private String paymentMethod;

    public Invoice(String invoiceNumber, RepairOrder repairOrder, DateTime issueDate, double finalTotal, String paymentMethod) {
        this.invoiceNumber = invoiceNumber;
        this.repairOrder = repairOrder;
        this.issueDate = issueDate;
        this.finalTotal = finalTotal;
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        System.out.println("Pago procesado con éxito mediante: " + this.paymentMethod);
    }
    
    public void printReceipt() {
        System.out.println("===== RECIBO DE PAGO =====");
        System.out.println("Nro. Factura: " + this.invoiceNumber);
        System.out.println("Fecha de emisión: " + this.issueDate);
        System.out.println("Total final: $" + this.finalTotal);
        System.out.println("Método de pago: " + this.paymentMethod);
        System.out.println("==========================");
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public RepairOrder getRepairOrder() {
        return repairOrder;
    }

    public DateTime getIssueDate() {
        return issueDate;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setRepairOrder(RepairOrder repairOrder) {
        this.repairOrder = repairOrder;
    }

    public void setIssueDate(DateTime issueDate) {
        this.issueDate = issueDate;
    }

    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    
}
