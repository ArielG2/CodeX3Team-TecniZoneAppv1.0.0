package ec.edu.espe.tecnizoneapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class DirectSale {

    private String saleId;
    private LocalDateTime saleDate;
    private double totalAmount;

    public DirectSale(String saleId, LocalDateTime saleDate,
            double totalAmount) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    public void sellPart(Part part, int quantity) {
        if (part == null || quantity <= 0) {
            throw new IllegalArgumentException(
                    "Part must exist and quantity must be positive.");
        }

        double subtotal = part.getUnitPrice() * quantity;

        this.totalAmount += subtotal;
        this.saleDate = LocalDateTime.now();

        System.out.println("Part sold: " + part
                + ", quantity: " + quantity
                + ", subtotal: " + subtotal);
    }

    public Invoice generateInvoice() {
        return new Invoice(
                UUID.randomUUID().toString(),
                null,
                LocalDateTime.now(),
                totalAmount,
                "Pending");
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "DirectSale{" + "saleId=" + saleId
                + ", saleDate=" + saleDate
                + ", totalAmount=" + totalAmount + '}';
    }

    void setClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setClient(Client client) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getClient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getClient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getClient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
