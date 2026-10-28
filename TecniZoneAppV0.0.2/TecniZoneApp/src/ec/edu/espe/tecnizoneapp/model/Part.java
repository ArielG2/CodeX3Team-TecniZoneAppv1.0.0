package ec.edu.espe.tecnizoneapp.model;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class Part {
    private String code;
    private String name;
    private int currentStock;
    private int minStock;
    private double price;

    public Part(String code, String name, int currentStock, int minStock, double price) {
        this.code = code;
        this.name = name;
        this.currentStock = currentStock;
        this.minStock = minStock;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Part{" + "code=" + getCode() + ", name=" + getName() + ", currentStock=" + getCurrentStock() + ", minStock=" + getMinStock() + ", price=" + getPrice() + '}';
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the name
     */
    public String getPartName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the currentStock
     */
    public int getCurrentStock() {
        return currentStock;
    }

    /**
     * @param currentStock the currentStock to set
     */
    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    /**
     * @return the minStock
     */
    public int getMinStock() {
        return minStock;
    }

    /**
     * @param minStock the minStock to set
     */
    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public void decreaseStock(int qty) {
        if (qty > 0 && this.currentStock >= qty) {
            this.currentStock -= qty;
        }
    }

    public void increaseStock(int qty) {
        if (qty > 0) {
            this.currentStock += qty;
        }
    }

    public StockAlert verifyLowStock() {
        if (this.currentStock <= this.minStock) {
            String alertCode = "ALT-" + System.currentTimeMillis();
            return new StockAlert(alertCode, this, "Actual", "Stock bajo para: " + this.name, true);
        }
        return null;
    }
    
    public double getUnitPrice() {
        return price;
    }
}