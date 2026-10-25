/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class Part {
    private String partId;
    private String partName;
    private int stockQuantity;
    private int minimumStock;
    private double unitPrice;

    @Override
    public String toString() {
        return "Part{" + "partId=" + getPartId() + ", partName=" + getPartName() + ", stockQuantity=" + getStockQuantity() + ", minimumStock=" + getMinimumStock() + ", unitPrice=" + getUnitPrice() + '}';
    }

    /**
     * @return the partId
     */
    public String getPartId() {
        return partId;
    }

    /**
     * @param partId the partId to set
     */
    public void setPartId(String partId) {
        this.partId = partId;
    }

    /**
     * @return the partName
     */
    public String getPartName() {
        return partName;
    }

    /**
     * @param partName the partName to set
     */
    public void setPartName(String partName) {
        this.partName = partName;
    }

    /**
     * @return the stockQuantity
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * @param stockQuantity the stockQuantity to set
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * @return the minimumStock
     */
    public int getMinimumStock() {
        return minimumStock;
    }

    /**
     * @param minimumStock the minimumStock to set
     */
    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Part(String partId, String partName, int stockQuantity, int minimumStock, double unitPrice) {
        this.partId = partId;
        this.partName = partName;
        this.stockQuantity = stockQuantity;
        this.minimumStock = minimumStock;
        this.unitPrice = unitPrice;
    }
    
    public void reduceStock(int quantityUsed) {
        if (this.stockQuantity >= quantityUsed) {
            this.stockQuantity -= quantityUsed;
        } else {
            System.out.println("Error: Stock insuficiente.");
        }
    }
    
    public void addStock(int quantityReceived) {
        this.stockQuantity += quantityReceived;
    }
    
    public StockAlert checkMinimumStock() {
        if (this.stockQuantity <= this.minimumStock) {
            return new StockAlert("ALERT-" + this.partId, this, new java.util.Date(), 
                                  "Stock bajo para la pieza: " + this.partName, false);
        }
        return null;
    }
    
    /*pendiente revisar
    public String getPartName() {
        return this.partName;
    }
    */
}
