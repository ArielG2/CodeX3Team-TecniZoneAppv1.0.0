package ec.edu.espe.tecnizoneapp.model;
import ec.edu.espe.tecnizoneapp.utils.InvoiceJsonManager;
import java.time.LocalDateTime;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class Invoice {
    private String invoiceNumber;
    private RepairOrder repairOrder;
    private LocalDateTime issueDate;
    private double finalTotal;
    private String paymentMethod;

    public Invoice(String invoiceNumber, RepairOrder repairOrder, LocalDateTime issueDate, double finalTotal, String paymentMethod) {
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
    
    public void saveToJson() {
        InvoiceJsonManager.save(this);
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public RepairOrder getRepairOrder() {
        return repairOrder;
    }

    public LocalDateTime getIssueDate() {
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

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }
    
    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    } 
}
