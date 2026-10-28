package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class DirectSale {

    private String saleId;
    private String saleDate;
    private double totalAmount;
    private Client client;

    public DirectSale(String saleId, String saleDate, double totalAmount) {
        this.saleId = saleId;
        this.saleDate = saleDate;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "DirectSale{" + "saleId=" + getSaleId() + ", saleDate=" + getSaleDate() + ", totalAmount=" + getTotalAmount() + ", client=" + getClient() + '}';
    }

    /**
     * @return the saleId
     */
    public String getSaleId() {
        return saleId;
    }

    /**
     * @param saleId the saleId to set
     */
    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    /**
     * @return the saleDate
     */
    public String getSaleDate() {
        return saleDate;
    }

    /**
     * @param saleDate the saleDate to set
     */
    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    public void sellPart(Part part, int quantity) {
        if (part != null && quantity > 0 && part.getCurrentStock() >= quantity) {
            part.decreaseStock(quantity);
            double subtotal = part.getPrice() * quantity;
            this.totalAmount += subtotal;
        }
    }
}