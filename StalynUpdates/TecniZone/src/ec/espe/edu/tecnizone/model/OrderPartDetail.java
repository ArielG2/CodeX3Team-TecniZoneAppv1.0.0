/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.tecnizone.model;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class OrderPartDetail {
    private String detailId;
    private RepairOrder order;
    private Part usedPart;
    private int quantityUsed;
    private double subtotal;

    public OrderPartDetail(String detailId, RepairOrder order, Part usedPart, int quantityUsed, double subtotal) {
        this.detailId = detailId;
        this.order = order;
        this.usedPart = usedPart;
        this.quantityUsed = quantityUsed;
        this.subtotal = subtotal;
    }

    public double calculateSubtotal() {
        if (this.usedPart != null) {
            this.subtotal = this.quantityUsed * this.usedPart.getUnitPrice();
        } else {
            this.subtotal = 0.0;
        }
        return this.subtotal;
    }

    public String getDetailId() {
        return detailId;
    }

    public RepairOrder getOrder() {
        return order;
    }

    public Part getUsedPart() {
        return usedPart;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public void setOrder(RepairOrder order) {
        this.order = order;
    }

    public void setUsedPart(Part usedPart) {
        this.usedPart = usedPart;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
}