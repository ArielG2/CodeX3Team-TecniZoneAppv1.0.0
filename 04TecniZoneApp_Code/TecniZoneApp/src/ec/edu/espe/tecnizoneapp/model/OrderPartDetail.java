package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class OrderPartDetail {

    private String detailId;
    private RepairOrder order;
    private Part usedPart;
    private int quantityUsed;
    private double subtotal;

    public OrderPartDetail(String detailId, RepairOrder order,
            Part usedPart, int quantityUsed, double subtotal) {
        this.detailId = detailId;
        this.order = order;
        this.usedPart = usedPart;
        this.quantityUsed = quantityUsed;
        this.subtotal = subtotal;
    }

    public double calculateSubtotal() {
        if (usedPart == null || quantityUsed <= 0) {
            throw new IllegalStateException(
                    "A valid part and quantity are required.");
        }

        this.subtotal = usedPart.getUnitPrice() * quantityUsed;
        return subtotal;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public RepairOrder getOrder() {
        return order;
    }

    public void setOrder(RepairOrder order) {
        this.order = order;
    }

    public Part getUsedPart() {
        return usedPart;
    }

    public void setUsedPart(Part usedPart) {
        this.usedPart = usedPart;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return "OrderPartDetail{" + "detailId=" + detailId
                + ", order=" + order
                + ", usedPart=" + usedPart
                + ", quantityUsed=" + quantityUsed
                + ", subtotal=" + subtotal + '}';
    }
}
