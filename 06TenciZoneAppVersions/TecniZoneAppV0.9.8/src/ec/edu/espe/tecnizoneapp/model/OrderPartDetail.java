package ec.edu.espe.tecnizoneapp.model;

import ec.edu.espe.tecnizoneapp.utils.JsonSerializable;
import org.json.JSONObject;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class OrderPartDetail implements JsonSerializable {
    private String detailId;
    private RepairOrder order;
    private Part usedPart;
    private int quantityUsed;
    private double subtotal;

    public OrderPartDetail(String detailId, RepairOrder order, Part usedPart, int quantityUsed) {
        this.detailId = detailId;
        this.order = order;
        this.usedPart = usedPart;
        this.quantityUsed = quantityUsed;
        this.subtotal = (usedPart != null) ? quantityUsed * usedPart.getPrice() : 0.0;
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("detailId", this.detailId);
        json.put("quantityUsed", this.quantityUsed);
        json.put("subtotal", this.subtotal);
        if (this.order != null) {
            json.put("orderNumber", this.order.getOrderNumber());
        }
        if (this.usedPart != null) {
            json.put("usedPartInfo", this.usedPart.toString());
        }
        return json;
    }
}