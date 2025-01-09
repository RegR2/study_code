package evgenii_mentoring.session4;

public class SalesEntry {
    String productName;
    String category;
    int quantitySold;
    double pricePerUnit;

    SalesEntry(String productName, String category, int quantitySold, double pricePerUnit) {
        this.productName = productName;
        this.category = category;
        this.quantitySold = quantitySold;
        this.pricePerUnit = pricePerUnit;
    }
    double getTotalRevenue() {
        return quantitySold * pricePerUnit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
